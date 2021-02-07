package sayant.springframeworkguru.sfgurubeerservice.service;

import sayant.springframeworkguru.brewery.model.events.ValidateOrderRequest;

/**
 * Created by sayantjm on 7/2/21
 */
public interface BeerOrderValidationListener {
    void listen(ValidateOrderRequest validateOrderRequest);
}
