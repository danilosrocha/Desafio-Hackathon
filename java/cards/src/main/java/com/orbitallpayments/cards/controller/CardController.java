package com.orbitallpayments.cards.controller;

import com.orbitallpayments.cards.domains.Card;
import com.orbitallpayments.cards.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cards")
public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping
    public ResponseEntity<Card> save(@RequestBody Card card) {
        Card savedCard = cardService.save(card);

        return new ResponseEntity<>(savedCard, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Card>> findAll() {
        List<Card> cards = cardService.findALl();
        return ResponseEntity.ok(cards);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> findById(@PathVariable Long id) {
        Optional<Card> fetchedCard = cardService.findById(id);
        if (!fetchedCard.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.ok(fetchedCard.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Card> update(@PathVariable (value = "id") Long id, @RequestBody Card card) {
        Optional<Card> fetchedCard = cardService.findById(id);
        Card updateCard = cardService.update(card);
        return new ResponseEntity<>(updateCard, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Card> delete(@PathVariable (value = "id") Long id) {

        Optional<Card> fetchedCard = cardService.findById(id);
        cardService.delete(fetchedCard.get());
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
