package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderAccepted extends AbstractEvent {

    public OrderAccepted(Order aggregate) {
        super(aggregate);
    }

    public OrderAccepted() {
        super();
    }
}
