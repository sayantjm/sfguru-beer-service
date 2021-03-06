package sayant.springframeworkguru.brewery.model.events;

import lombok.NoArgsConstructor;
import sayant.springframeworkguru.brewery.model.BeerDto;

/**
 * Created by sayantjm on 23/1/21
 */
@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent {

    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
