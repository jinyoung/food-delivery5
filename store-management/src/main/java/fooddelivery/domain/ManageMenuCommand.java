package fooddelivery.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ManageMenuCommand {

    private String menuName;
    private Money price;
    private String stockStatus;
    private String availability;
}
