package sayant.springframeworkguru.sfgurubeerservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import sayant.springframeworkguru.sfgurubeerservice.config.JmsConfig;
import sayant.springframeworkguru.sfgurubeerservice.domain.Beer;
import sayant.springframeworkguru.sfgurubeerservice.events.BrewBeerEvent;
import sayant.springframeworkguru.sfgurubeerservice.events.NewInventoryEvent;
import sayant.springframeworkguru.sfgurubeerservice.model.BeerDto;
import sayant.springframeworkguru.sfgurubeerservice.repository.BeerRepository;

import javax.transaction.Transactional;

/**
 * Created by sayantjm on 23/1/21
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class BrewBeerListener {

    private final BeerRepository beerRepository;
    private final JmsTemplate jmsTemplate;

    @Transactional
    @JmsListener(destination = JmsConfig.BREWING_REQUEST_QUEUE)
    public void listen(BrewBeerEvent event) {
        BeerDto beerDto = event.getBeerDto();

        Beer beer = beerRepository.getOne(beerDto.getId());

        beerDto.setQuantityOnHand(beer.getQuantityToBrew());

        NewInventoryEvent newInventoryEvent = new NewInventoryEvent(beerDto);
        log.debug("Brewed beer {} :QOH={}", beer.getMinOnHand(), beerDto.getQuantityOnHand());
        jmsTemplate.convertAndSend(JmsConfig.NEW_INVENTORY_QUEUE, newInventoryEvent);
    }
}
