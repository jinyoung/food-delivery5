package food.delivery.domain;

import food.delivery.FrontApplication;
import food.delivery.domain.ConfirmationButtonTapped;
import food.delivery.domain.CookingCompleted;
import food.delivery.domain.CookingStarted;
import food.delivery.domain.DeliveryAvailabilityChecked;
import food.delivery.domain.DeliveryCompleted;
import food.delivery.domain.DeliveryNotified;
import food.delivery.domain.DeliveryStarted;
import food.delivery.domain.MenuSelected;
import food.delivery.domain.NotificationSent;
import food.delivery.domain.OrderAccepted;
import food.delivery.domain.OrderCancelled;
import food.delivery.domain.OrderPlaced;
import food.delivery.domain.OrderReceived;
import food.delivery.domain.OrderRejected;
import food.delivery.domain.OrderStatusChecked;
import food.delivery.domain.PaymentCompleted;
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

    private String menu;

    private Payment payment;

    private String status;

    @PostPersist
    public void onPostPersist() {
        MenuSelected menuSelected = new MenuSelected(this);
        menuSelected.publishAfterCommit();

        PaymentCompleted paymentCompleted = new PaymentCompleted(this);
        paymentCompleted.publishAfterCommit();

        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

        OrderReceived orderReceived = new OrderReceived(this);
        orderReceived.publishAfterCommit();

        OrderAccepted orderAccepted = new OrderAccepted(this);
        orderAccepted.publishAfterCommit();

        OrderRejected orderRejected = new OrderRejected(this);
        orderRejected.publishAfterCommit();

        CookingStarted cookingStarted = new CookingStarted(this);
        cookingStarted.publishAfterCommit();

        CookingCompleted cookingCompleted = new CookingCompleted(this);
        cookingCompleted.publishAfterCommit();

        OrderCancelled orderCancelled = new OrderCancelled(this);
        orderCancelled.publishAfterCommit();

        DeliveryAvailabilityChecked deliveryAvailabilityChecked = new DeliveryAvailabilityChecked(
            this
        );
        deliveryAvailabilityChecked.publishAfterCommit();

        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        deliveryStarted.publishAfterCommit();

        DeliveryNotified deliveryNotified = new DeliveryNotified(this);
        deliveryNotified.publishAfterCommit();

        OrderStatusChecked orderStatusChecked = new OrderStatusChecked(this);
        orderStatusChecked.publishAfterCommit();

        NotificationSent notificationSent = new NotificationSent(this);
        notificationSent.publishAfterCommit();

        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(this);
        deliveryCompleted.publishAfterCommit();

        ConfirmationButtonTapped confirmationButtonTapped = new ConfirmationButtonTapped(
            this
        );
        confirmationButtonTapped.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static OrderRepository repository() {
        OrderRepository orderRepository = FrontApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }
}
