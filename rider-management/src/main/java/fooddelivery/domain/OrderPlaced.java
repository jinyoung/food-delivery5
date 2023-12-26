package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private String orderId;
    private String foodSelection;
    private Integer quantity;
    private String specialRequest;
    private Object deliveryAddress;
    private String paymentMethod;
    private Object orderAmount;
}
