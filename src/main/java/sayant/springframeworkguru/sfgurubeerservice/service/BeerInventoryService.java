package sayant.springframeworkguru.sfgurubeerservice.service;

import java.util.UUID;

/**
 * Created by sayantjm on 7/11/20
 */
public interface BeerInventoryService {

    Integer getOnhandInventory(UUID beerId);

}
