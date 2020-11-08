package sayant.springframeworkguru.sfgurubeerservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import sayant.springframeworkguru.sfgurubeerservice.domain.Beer;
import sayant.springframeworkguru.sfgurubeerservice.model.BeerStyleEnum;

import java.util.UUID;

/**
 * Created by sayantjm on 30/5/20
 */
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
    Page<Beer> findAllByBeerName(String beerName, Pageable pageable);

    Page<Beer> findAllByBeerStyle(BeerStyleEnum beerStyle, Pageable pageable);

    Page<Beer> findAllByBeerNameAndBeerStyle(String beerName, BeerStyleEnum beerStyle, Pageable pageable);

    Beer findByUpc(String upc);
}
