package dev.vini.openfeign_example.client;

import dev.vini.openfeign_example.controller.dto.BeerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(
        name = "OpenBreweryClient",
        url = "https://api.openbrewerydb.org/v1/breweries"
)
public interface BeerClient {

    @GetMapping
    List<BeerResponse> getAllBeers();

}
