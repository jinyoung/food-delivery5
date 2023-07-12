package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DeliveryNotified extends AbstractEvent {

    public DeliveryNotified(Order aggregate) {
        super(aggregate);
    }

    public DeliveryNotified() {
        super();
    }
}
