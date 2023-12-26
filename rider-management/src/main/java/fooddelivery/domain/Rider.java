package fooddelivery.domain;

import fooddelivery.RiderManagementApplication;
import fooddelivery.domain.OrderAssigned;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Rider_table")
@Data
public class Rider {

    @Id
    private String riderId;

    private String riderName;

    private String riderStatus;

    @PostPersist
    public void onPostPersist() {
        OrderAssigned orderAssigned = new OrderAssigned(this);
        orderAssigned.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static RiderRepository repository() {
        RiderRepository riderRepository = RiderManagementApplication.applicationContext.getBean(
            RiderRepository.class
        );
        return riderRepository;
    }

    public void handleOrderPlaced(OrderPlaced orderPlaced) {
        // 여기에 OrderPlaced 이벤트 처리 로직을 추가합니다.
    }

    public void markDeliveryCompleted(
        MarkDeliveryCompletedCommand markDeliveryCompletedCommand
    ) {
        //implement business logic here:

        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(this);
        deliveryCompleted.publishAfterCommit();
    }
}
