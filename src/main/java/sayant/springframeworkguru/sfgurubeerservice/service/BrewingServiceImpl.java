package sayant.springframeworkguru.sfgurubeerservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import sayant.springframeworkguru.sfgurubeerservice.config.JmsConfig;
import sayant.springframeworkguru.sfgurubeerservice.domain.Beer;
import sayant.springframeworkguru.sfgurubeerservice.events.BrewBeerEvent;
import sayant.springframeworkguru.sfgurubeerservice.mappers.BeerMapper;
import sayant.springframeworkguru.sfgurubeerservice.repository.BeerRepository;

import java.util.List;

/**
 * Created by sayantjm on 23/1/21
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BrewingServiceImpl implements BrewingService {
    private final BeerRepository beerRepository;
    private final BeerInventoryService beerInventoryService;
    private final JmsTemplate jmsTemplate;
    private final BeerMapper beerMapper;

    @Override
    @Scheduled(fixedRate = 5000)  //every 5 seconds
    public void checkForLowInventory() {
        List<Beer> beerList = beerRepository.findAll();

        beerList.forEach(beer -> {
            Integer onhandInventory = beerInventoryService.getOnhandInventory(beer.getId());
            log.debug("Min Onhand is: {}", beer.getMinOnHand());
            log.debug("Inventory is: {}", onhandInventory);

            if (beer.getMinOnHand() >= onhandInventory) {
                jmsTemplate.convertAndSend(JmsConfig.BREWING_REQUEST_QUEUE, new BrewBeerEvent(beerMapper.beerToBeerDto(beer)));
            }
        });
    }
}
