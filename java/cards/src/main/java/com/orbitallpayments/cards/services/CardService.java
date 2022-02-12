package com.orbitallpayments.cards.services;

import com.orbitallpayments.cards.domains.Card;
import com.orbitallpayments.cards.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public Card save(Card card) {
        return cardRepository.save(card);
    }

    public List<Card> findALl() {
        List<Card> cards = new ArrayList<>();
        cardRepository.findAll().forEach(cards::add);
        return cards;
    }

    public Optional<Card> findById(Long id) {
        return cardRepository.findById(id);
    }

    public Card update(Card card) {
        Card existingCard = cardRepository.findById(card.getId()).orElse(card);

        existingCard.setCardNumber(card.getCardNumber());
        existingCard.setEmbossName(card.getEmbossName());
        existingCard.setCustomerName(card.getCustomerName());
        existingCard.setDocumentNumber(card.getDocumentNumber());
        existingCard.setMotherName((card.getMotherName()));
        existingCard.setAddress(card.getAddress());
        existingCard.setCity(card.getCity());
        return cardRepository.save(existingCard);
    }


    public void delete(Card card) {
        cardRepository.delete(card);
    }

}
