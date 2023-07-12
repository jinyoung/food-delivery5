package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderStatusChecked extends AbstractEvent {

    public OrderStatusChecked(Order aggregate) {
        super(aggregate);
    }

    public OrderStatusChecked() {
        super();
    }
}
