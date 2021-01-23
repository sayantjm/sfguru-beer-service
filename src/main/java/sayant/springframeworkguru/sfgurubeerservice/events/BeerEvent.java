package sayant.springframeworkguru.sfgurubeerservice.events;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import sayant.springframeworkguru.sfgurubeerservice.model.BeerDto;

/**
 * Created by sayantjm on 23/1/21
 */
@Data
@RequiredArgsConstructor
@Builder
public class BeerEvent {

     static final long serialVersionUID = 6796250213368943508L;

    private final BeerDto beerDto;
}
