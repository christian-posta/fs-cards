package com.christianposta.fuse;

import org.apache.commons.lang.builder.EqualsBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Model of a single card which can have a value. Modeled this way just
 * in case the game changes to BlackJack and the ACE (or any card) can
 * have multiple values
 */
public class Card {

    private CardType type;
    private Suit suit;

    public Card(CardType type, Suit suit) {
        this.type = type;
        this.suit = suit;
    }

    public static List<Card> createCardSetForSuit(Suit suit) {

        ArrayList<Card> cards = new ArrayList();
        for (CardType type : CardType.values()) {
            cards.add(new Card(type, suit));
        }
        return cards;
    }


    public CardType getType() {
        return type;
    }

    public int getValue() {
        return this.type.ordinal();
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.type);
        builder.append(" of ");
        builder.append(this.suit);
        return builder.toString();
    }
}
