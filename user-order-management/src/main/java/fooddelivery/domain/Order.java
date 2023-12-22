package fooddelivery.domain;

import fooddelivery.UserOrderManagementApplication;
import fooddelivery.domain.OrderCancelled;
import fooddelivery.domain.OrderPlaced;
import fooddelivery.domain.PreviousOrdersChecked;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Order_table")
@Data
//<<< DDD / Aggregate Root
public class Order {

    @Id
    private String orderId;

    private String foodSelection;

    private Integer quantity;

    private String specialRequest;

    private Address deliveryAddress;

    private String paymentMethod;

    private paymentMethodType paymentMethodType;

    private Money orderAmount;

    private String orderStatus;

    private String estimatedDeliveryTime;

    @PostPersist
    public void onPostPersist() {
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

        OrderCancelled orderCancelled = new OrderCancelled(this);
        orderCancelled.publishAfterCommit();

        PreviousOrdersChecked previousOrdersChecked = new PreviousOrdersChecked(
            this
        );
        previousOrdersChecked.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static OrderRepository repository() {
        OrderRepository orderRepository = UserOrderManagementApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }
}
//>>> DDD / Aggregate Root
