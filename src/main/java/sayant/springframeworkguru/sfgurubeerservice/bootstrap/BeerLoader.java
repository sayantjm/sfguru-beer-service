package sayant.springframeworkguru.sfgurubeerservice.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sayant.springframeworkguru.sfgurubeerservice.domain.Beer;
import sayant.springframeworkguru.sfgurubeerservice.repository.BeerRepository;

import java.math.BigDecimal;

/**
 * Created by sayantjm on 30/5/20
 */
@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(72527273070L)
                    .price(new BigDecimal("6.50"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(72527273071L)
                    .price(new BigDecimal("7.50"))
                    .build());
        }
    }
}
