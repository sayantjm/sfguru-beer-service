package sayant.springframeworkguru.sfgurubeerservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sayant.springframeworkguru.sfgurubeerservice.service.impl.BeerInventoryServiceRestTemplateImpl;
import sayant.springframeworkguru.sfgurubeerservice.service.model.BeerInventoryDto;

import java.util.List;
import java.util.UUID;

/**
 * Created by sayantjm on 6/3/21
 */
@FeignClient(name="inventory-service")
public interface BeerInventoryServiceFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = BeerInventoryServiceRestTemplateImpl.INVENTORY_PATH)
    ResponseEntity<List<BeerInventoryDto>> getOnHandInventory(@PathVariable UUID beerId);
}
