package sayant.springframeworkguru.sfgurubeerservice.events;

import sayant.springframeworkguru.sfgurubeerservice.model.BeerDto;

/**
 * Created by sayantjm on 23/1/21
 */

public class BrewBeerEvent extends BeerEvent {

    public BrewBeerEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
