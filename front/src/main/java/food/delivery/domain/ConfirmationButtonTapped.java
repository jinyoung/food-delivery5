package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ConfirmationButtonTapped extends AbstractEvent {

    public ConfirmationButtonTapped(Order aggregate) {
        super(aggregate);
    }

    public ConfirmationButtonTapped() {
        super();
    }
}
