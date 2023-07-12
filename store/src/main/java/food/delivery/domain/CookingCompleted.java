package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookingCompleted extends AbstractEvent {

    public CookingCompleted(Order aggregate) {
        super(aggregate);
    }

    public CookingCompleted() {
        super();
    }
}
