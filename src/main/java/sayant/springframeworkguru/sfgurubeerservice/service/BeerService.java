package sayant.springframeworkguru.sfgurubeerservice.service;

import sayant.springframeworkguru.sfgurubeerservice.model.BeerDto;

import java.util.UUID;

/**
 * Created by sayantjm on 27/6/20
 */
public interface BeerService {
    BeerDto getById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);
}
