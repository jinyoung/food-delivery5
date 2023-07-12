package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DeliveryCompleted extends AbstractEvent {

    public DeliveryCompleted(Order aggregate) {
        super(aggregate);
    }

    public DeliveryCompleted() {
        super();
    }
}
