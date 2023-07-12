package food.delivery.domain;

import food.delivery.RiderApplication;
import food.delivery.domain.ConfirmationButtonTapped;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)

    private String orderId;

    private String status;

    @PostPersist
    public void onPostPersist() {
        ConfirmationButtonTapped confirmationButtonTapped = new ConfirmationButtonTapped(
            this
        );
        confirmationButtonTapped.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static OrderRepository repository() {
        OrderRepository orderRepository = RiderApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public void startDelivery() {
        //implement business logic here:

        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        deliveryStarted.publishAfterCommit();
    }

    public void notifyDelivery() {
        //implement business logic here:

        DeliveryNotified deliveryNotified = new DeliveryNotified(this);
        deliveryNotified.publishAfterCommit();
    }

    public void completeDelivery() {
        //implement business logic here:

        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(this);
        deliveryCompleted.publishAfterCommit();
    }
}
