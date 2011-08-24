package com.christianposta.fuse;

import com.christianposta.fuse.cards.Card;
import org.apache.commons.lang.Validate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ceposta
 * Date: 8/24/11
 * Time: 8:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class Hand {

    private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<Card>();
    }

    public void acceptCard(Card card) {
        Validate.notNull(card, "I cannot accept a null Card. There is no such thing as a null card.");
        this.cards.add(card);
    }

    public int getNumberOfCards() {
        return this.cards.size();
    }

}
