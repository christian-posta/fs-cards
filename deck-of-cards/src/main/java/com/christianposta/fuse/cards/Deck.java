package com.christianposta.fuse.cards;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ceposta
 * Date: 8/17/11
 * Time: 6:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class Deck {

    private List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();
        populateCards();

    }

    private void populateCards() {
        for (Suit suit : Suit.values()) {
            this.cards.addAll(Card.createCardSetForSuit(suit));
        }
    }

    public int numberOfCards() {
        return this.cards.size();
    }

    public List<Card> getCards() {
        return cards;
    }
}
