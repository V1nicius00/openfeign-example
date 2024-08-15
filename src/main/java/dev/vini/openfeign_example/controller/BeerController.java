package dev.vini.openfeign_example.controller;

import dev.vini.openfeign_example.client.BeerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beer")
public class BeerController {

    private final BeerClient beerClient;

    public BeerController(BeerClient beerClient) {
        this.beerClient = beerClient;
    }

    @GetMapping
    public ResponseEntity getAllBeers(@RequestParam(required = false)String country){
        if(country != null){
            return ResponseEntity.ok(beerClient.getBeerByCountry(country));
        }
        return ResponseEntity.ok(beerClient.getAllBeers());
    }

    @GetMapping("/random")
    public ResponseEntity getRandomBeer(){
        return ResponseEntity.ok(beerClient.getRandomBeer());
    }

    @GetMapping("/meta")
    public ResponseEntity getMeta(){
        return ResponseEntity.ok(beerClient.getMeta());
    }

    @GetMapping("{id}")
    public ResponseEntity getBeerById(@PathVariable("id") String id){
        return ResponseEntity.ok(beerClient.getBeerById(id));
    }
}
