package sayant.springframeworkguru.sfgurubeerservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import sayant.springframeworkguru.sfgurubeerservice.service.BeerInventoryServiceFailoverFeignClient;
import sayant.springframeworkguru.sfgurubeerservice.service.BeerInventoryServiceFeignClient;
import sayant.springframeworkguru.sfgurubeerservice.service.model.BeerInventoryDto;

import java.util.List;
import java.util.UUID;

/**
 * Created by sayantjm on 7/3/21
 */
@RequiredArgsConstructor
@Component
public class BeerInventoryServiceFailoverFeignClientImpl implements BeerInventoryServiceFeignClient {

    private final BeerInventoryServiceFailoverFeignClient inventoryServiceFailoverFeignClient;

    @Override
    public ResponseEntity<List<BeerInventoryDto>> getOnHandInventory(UUID beerId) {
        return inventoryServiceFailoverFeignClient.getOnHandInventory();
    }
}
