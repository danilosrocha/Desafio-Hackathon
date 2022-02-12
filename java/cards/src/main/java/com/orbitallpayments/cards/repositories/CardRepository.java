package com.orbitallpayments.cards.repositories;

import com.orbitallpayments.cards.domains.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<Card, Long> {

}
