package sayant.springframeworkguru.sfgurubeerservice.service.inventory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sayant.springframeworkguru.sfgurubeerservice.bootstrap.BeerLoader;
import sayant.springframeworkguru.sfgurubeerservice.service.BeerInventoryService;

/**
 * Created by sayantjm on 7/11/20
 */
@Disabled // utility for manual testing
@SpringBootTest
public class BeerInventoryServiceRestTemplateImplTest {

    @Autowired
    BeerInventoryService beerInventoryService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void getOnHandInventory() {
        //todo evolve to use UPC
        //Integer goh = beerInventoryService.getOnhandInventory(BeerLoader.BEER_1_UUID);

        //System.out.println(goh);
    }

}
