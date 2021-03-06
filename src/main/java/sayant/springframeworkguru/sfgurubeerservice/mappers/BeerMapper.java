package sayant.springframeworkguru.sfgurubeerservice.mappers;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import sayant.springframeworkguru.sfgurubeerservice.domain.Beer;
import sayant.springframeworkguru.brewery.model.BeerDto;

/**
 * Created by sayantjm on 31/5/20
 */
@Mapper(uses = DateMapper.class)
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);

    BeerDto beerToBeerDtoWithInventory(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
