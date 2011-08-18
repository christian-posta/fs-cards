package com.christianposta.fuse;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: ceposta
 * Date: 8/17/11
 * Time: 8:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class DeckTest {

    private Deck deck;

    @Before
    public void setUp(){
        deck = new Deck();
    }

    @Test
    public void testSizeOfDefaultDeck() {
        assertEquals(52, deck.numberOfCards());
    }

    @Test
    public void testValuesOfDefaultDeck() {

        List<Card> cards = deck.getCards();
        for (CardType type : CardType.values()) {
            for (Suit suit : Suit.values()) {
                assertTrue(cards.contains(new Card(type, suit)));
            }
        }

    }
}
