package fooddelivery.infra;

import fooddelivery.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/riders")
@Transactional
public class RiderController {

    @Autowired
    RiderRepository riderRepository;

    @RequestMapping(
        value = "riders/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Rider markDeliveryCompleted(
        @PathVariable(value = "id") String id,
        @RequestBody MarkDeliveryCompletedCommand markDeliveryCompletedCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /rider/markDeliveryCompleted  called #####");
        Optional<Rider> optionalRider = riderRepository.findById(id);

        optionalRider.orElseThrow(() -> new Exception("No Entity Found"));
        Rider rider = optionalRider.get();
        rider.markDeliveryCompleted(markDeliveryCompletedCommand);

        riderRepository.save(rider);
        return rider;
    }
}
//>>> Clean Arch / Inbound Adaptor
