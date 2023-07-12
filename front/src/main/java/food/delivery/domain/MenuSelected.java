package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class MenuSelected extends AbstractEvent {

    public MenuSelected(Order aggregate) {
        super(aggregate);
    }

    public MenuSelected() {
        super();
    }
}
