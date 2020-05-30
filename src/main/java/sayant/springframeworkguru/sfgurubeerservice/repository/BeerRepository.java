package sayant.springframeworkguru.sfgurubeerservice.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import sayant.springframeworkguru.sfgurubeerservice.domain.Beer;

import java.util.UUID;

/**
 * Created by sayantjm on 30/5/20
 */
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {

}
