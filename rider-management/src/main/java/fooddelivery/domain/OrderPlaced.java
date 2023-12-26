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
    private String deliveryAddress;
    private String paymentMethod;
    private String orderAmount;
    private String riderId;

    public String getOrderId() {
        return orderId;
    }

    public String getRiderId() {
        return riderId;
    }
    // 추후 필요한 get, set 메소드들 추가
}
