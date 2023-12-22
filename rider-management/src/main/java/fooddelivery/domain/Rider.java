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
//<<< DDD / Aggregate Root
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

    //<<< Clean Arch / Port Method
    public void markDeliveryCompleted(
        MarkDeliveryCompletedCommand markDeliveryCompletedCommand
    ) {
        //implement business logic here:

        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(this);
        deliveryCompleted.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
