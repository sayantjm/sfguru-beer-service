package sayant.springframeworkguru.sfgurubeerservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sayant.springframeworkguru.sfgurubeerservice.service.BeerInventoryService;
import sayant.springframeworkguru.sfgurubeerservice.service.BeerInventoryServiceFeignClient;
import sayant.springframeworkguru.sfgurubeerservice.service.model.BeerInventoryDto;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by sayantjm on 6/3/21
 */
@Slf4j
@RequiredArgsConstructor
@Profile("local-discovery")
@Service
public class BeerInventoryServiceFeignClientImpl implements BeerInventoryService {

    private final BeerInventoryServiceFeignClient inventoryServiceFeignClient;

    @Override
    public Integer getOnhandInventory(UUID beerId) {
        log.debug("Calling Inventory Service using FeignClient - BeerId: {}", beerId);

        ResponseEntity<List<BeerInventoryDto>> responseEntity = inventoryServiceFeignClient.getOnHandInventory(beerId);
        Integer onHand = Objects.requireNonNull(responseEntity.getBody())
                .stream()
                .mapToInt(BeerInventoryDto::getQuantityOnHand)
                .sum();

        log.debug("BeerId: {} On Hand Is: {}", beerId, onHand);

        return onHand;
    }
}
