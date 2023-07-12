package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class PaymentCompleted extends AbstractEvent {

    public PaymentCompleted(Order aggregate) {
        super(aggregate);
    }

    public PaymentCompleted() {
        super();
    }
}
