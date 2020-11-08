package sayant.springframeworkguru.sfgurubeerservice.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import sayant.springframeworkguru.sfgurubeerservice.domain.Beer;
import sayant.springframeworkguru.sfgurubeerservice.model.BeerDto;
import sayant.springframeworkguru.sfgurubeerservice.service.BeerInventoryService;

/**
 * Created by sayantjm on 7/11/20
 */
public abstract class BeerMapperDecorator implements BeerMapper {
    private BeerInventoryService beerInventoryService;
    private BeerMapper mapper;

    @Autowired
    public void setBeerInventoryService(BeerInventoryService beerInventoryService) {
        this.beerInventoryService = beerInventoryService;
    }

    @Autowired
    public void setMapper(BeerMapper beerMapper) {
        this.mapper = beerMapper;
    }

    @Override
    public BeerDto beerToBeerDto(Beer beer) {
        return mapper.beerToBeerDto(beer);
    }

    @Override
    public BeerDto beerToBeerDtoWithInventory(Beer beer) {
        BeerDto dto = mapper.beerToBeerDto(beer);
        dto.setQuantityOnHand(beerInventoryService.getOnhandInventory(beer.getId()));
        return dto;
    }

    @Override
    public Beer beerDtoToBeer(BeerDto beerDto) {
        return mapper.beerDtoToBeer(beerDto);
    }
}
