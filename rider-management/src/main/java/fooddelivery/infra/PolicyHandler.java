{
package fooddelivery.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import fooddelivery.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import fooddelivery.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler{
    @Autowired RiderRepository riderRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderPlaced'")
    public void wheneverOrderPlaced_OrderPlacedPolicy(@Payload OrderPlaced orderPlaced){

        OrderPlaced event = orderPlaced;
        System.out.println("\n\n##### listener OrderPlacedPolicy : " + orderPlaced + "\n\n");


        // Sample Logic //
        Rider rider = new Rider();
        rider.setRiderId("1");
        rider.setRiderName("Rider1");
        rider.setRiderStatus("Ready");
        riderRepository.save(rider);

        OrderAssigned orderAssigned = new OrderAssigned();
        orderAssigned.setRiderId(rider.getRiderId());
        orderAssigned.setOrderId(event.getOrderId());
        orderAssigned.publishAfterCommit();
    }

}

//>>> Clean Arch / Inbound Adaptor

}