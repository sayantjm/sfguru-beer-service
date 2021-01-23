package sayant.springframeworkguru.sfgurubeerservice.events;

import sayant.springframeworkguru.sfgurubeerservice.model.BeerDto;

/**
 * Created by sayantjm on 23/1/21
 */
public class NewInventoryEvent extends BeerEvent {

    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
