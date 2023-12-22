package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PreviousOrdersChecked extends AbstractEvent {

    public PreviousOrdersChecked(Order aggregate) {
        super(aggregate);
    }

    public PreviousOrdersChecked() {
        super();
    }
}
//>>> DDD / Domain Event
