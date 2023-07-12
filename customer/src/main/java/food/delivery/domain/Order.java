package food.delivery.domain;

import food.delivery.CustomerApplication;
import food.delivery.domain.OrderCancelled;
import food.delivery.domain.OrderStatusChecked;
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
        OrderCancelled orderCancelled = new OrderCancelled(this);
        orderCancelled.publishAfterCommit();

        OrderStatusChecked orderStatusChecked = new OrderStatusChecked(this);
        orderStatusChecked.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static OrderRepository repository() {
        OrderRepository orderRepository = CustomerApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }
}
