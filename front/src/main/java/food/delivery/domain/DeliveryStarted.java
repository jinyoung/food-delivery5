package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DeliveryStarted extends AbstractEvent {

    public DeliveryStarted(Order aggregate) {
        super(aggregate);
    }

    public DeliveryStarted() {
        super();
    }
}
