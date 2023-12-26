package fooddelivery.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import fooddelivery.config.kafka.KafkaProcessor;
import fooddelivery.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    RiderRepository riderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderPlaced_OrderPlacedPolicy(
        @Payload OrderPlaced orderPlaced
    ) {
        OrderPlaced event = orderPlaced;
        System.out.println(
            "\n\n##### listener OrderPlacedPolicy : " + orderPlaced + "\n\n"
        );

        Rider rider = riderRepository.findById("1").get();
        rider.setRiderId(event.getOrderId());
        riderRepository.save(rider);
    }
}
