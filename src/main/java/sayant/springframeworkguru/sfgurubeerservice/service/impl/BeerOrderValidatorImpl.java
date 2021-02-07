package sayant.springframeworkguru.sfgurubeerservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import sayant.springframeworkguru.brewery.model.BeerOrderDto;
import sayant.springframeworkguru.sfgurubeerservice.repository.BeerRepository;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by sayantjm on 7/2/21
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class BeerOrderValidatorImpl {

    private final BeerRepository beerRepository;

    public Boolean validateOrder(BeerOrderDto beerOrderDto) {
        AtomicInteger beersNotFound = new AtomicInteger();

        beerOrderDto.getBeerOrderLines().forEach(beerOrderLineDto -> {
            if(beerRepository.findByUpc(beerOrderLineDto.getUpc()) == null) {
                beersNotFound.incrementAndGet();
            }
        });

        return beersNotFound.get() == 0;
    }

}
