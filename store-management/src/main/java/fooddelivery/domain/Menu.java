package fooddelivery.domain;

import fooddelivery.StoreManagementApplication;
import fooddelivery.domain.MenuManaged;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Menu_table")
@Data
//<<< DDD / Aggregate Root
public class Menu {

    @Id
    private String menuId;

    private String menuName;

    private Money price;

    private String stockStatus;

    private String availability;

    @PostPersist
    public void onPostPersist() {
        MenuManaged menuManaged = new MenuManaged(this);
        menuManaged.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static MenuRepository repository() {
        MenuRepository menuRepository = StoreManagementApplication.applicationContext.getBean(
            MenuRepository.class
        );
        return menuRepository;
    }

    //<<< Clean Arch / Port Method
    public void confirmOrder(ConfirmOrderCommand confirmOrderCommand) {
        //implement business logic here:

        OrderConfirmed orderConfirmed = new OrderConfirmed(this);
        orderConfirmed.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
