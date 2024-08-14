package dev.vini.openfeign_example.controller;

import dev.vini.openfeign_example.client.BeerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/beer")
public class BeerController {

    private final BeerClient beerClient;

    public BeerController(BeerClient beerClient) {
        this.beerClient = beerClient;
    }

    @GetMapping
    public ResponseEntity getAllBeers(){
        return ResponseEntity.ok(beerClient.getAllBeers());
    }
}
