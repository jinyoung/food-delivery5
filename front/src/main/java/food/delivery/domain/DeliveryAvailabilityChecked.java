package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DeliveryAvailabilityChecked extends AbstractEvent {

    public DeliveryAvailabilityChecked(Order aggregate) {
        super(aggregate);
    }

    public DeliveryAvailabilityChecked() {
        super();
    }
}
