package dev.vini.openfeign_example.client;

import dev.vini.openfeign_example.controller.dto.BeerResponse;
import dev.vini.openfeign_example.controller.dto.MetaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "OpenBreweryClient",
        url = "https://api.openbrewerydb.org/v1/breweries"
)
public interface BeerClient {

    @GetMapping
    List<BeerResponse> getAllBeers();

    @GetMapping("?by_country={country}")
    List<BeerResponse> getBeerByCountry(@PathVariable("country") String country);

    @GetMapping("/random")
    List<BeerResponse> getRandomBeer();

    @GetMapping("/meta")
    MetaResponse getMeta();

    @GetMapping("{id}")
    BeerResponse getBeerById(@PathVariable("id") String id);

}
