package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class NotificationSent extends AbstractEvent {

    public NotificationSent(Order aggregate) {
        super(aggregate);
    }

    public NotificationSent() {
        super();
    }
}
