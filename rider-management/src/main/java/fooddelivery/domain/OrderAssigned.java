package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderAssigned extends AbstractEvent {

    private String orderId;
    private String riderId;

    public OrderAssigned(Rider aggregate) {
        super(aggregate);
    }

    public OrderAssigned() {
        super();
    }
}
//>>> DDD / Domain Event
