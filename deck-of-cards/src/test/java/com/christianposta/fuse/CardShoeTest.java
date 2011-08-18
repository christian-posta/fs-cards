package com.christianposta.fuse;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: ceposta
 * Date: 8/17/11
 * Time: 8:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class CardShoeTest {

    @Test
    public void testNumberOfCards() {
        Deck deck = new Deck();
        CardShoe shoe = new CardShoe();
        shoe.addDeck(deck);

        int numCardsInShoe = 0;
        try {
            while (true) {
                shoe.dealCard();
                numCardsInShoe++;
            }
        } catch (Exception e) {
            assertEquals(52, numCardsInShoe);
        }
    }
}
