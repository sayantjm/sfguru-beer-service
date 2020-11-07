package sayant.springframeworkguru.sfgurubeerservice.service;

import org.springframework.data.domain.PageRequest;
import sayant.springframeworkguru.sfgurubeerservice.model.BeerDto;
import sayant.springframeworkguru.sfgurubeerservice.model.BeerPagedList;
import sayant.springframeworkguru.sfgurubeerservice.model.BeerStyleEnum;

import java.util.UUID;

/**
 * Created by sayantjm on 27/6/20
 */
public interface BeerService {
    BeerDto getById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest);
}
