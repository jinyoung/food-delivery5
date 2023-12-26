package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class MenuManaged extends AbstractEvent {

    private String menuId;
    private String menuName;
    private Money price;
    private String stockStatus;
    private String availability;

    public MenuManaged(Menu aggregate) {
        super(aggregate);
    }

    public MenuManaged() {
        super();
    }
}
//>>> DDD / Domain Event
