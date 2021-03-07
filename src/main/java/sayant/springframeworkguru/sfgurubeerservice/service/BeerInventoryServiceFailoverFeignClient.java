package sayant.springframeworkguru.sfgurubeerservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sayant.springframeworkguru.sfgurubeerservice.service.model.BeerInventoryDto;

import java.util.List;

/**
 * Created by sayantjm on 7/3/21
 */
@FeignClient(name="inventory-failover")
public interface BeerInventoryServiceFailoverFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/inventory-failover")
    ResponseEntity<List<BeerInventoryDto>> getOnHandInventory();
}
