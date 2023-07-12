package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookingStarted extends AbstractEvent {

    public CookingStarted(Order aggregate) {
        super(aggregate);
    }

    public CookingStarted() {
        super();
    }
}
