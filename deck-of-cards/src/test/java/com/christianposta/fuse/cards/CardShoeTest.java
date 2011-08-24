package com.christianposta.fuse.cards;

import com.christianposta.fuse.cards.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

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

        // deal until all cards have been exhausted
        try {
            while (true) {
                Card card = shoe.dealCard();
                System.out.println(card);
                numCardsInShoe++;
            }
        } catch (EmptyCardShoeException e) {
            assertEquals(52, numCardsInShoe);
        }
    }

    @Test
    public void testNonShuffledDeck() throws EmptyCardShoeException {
        CardShoe shoe = new CardShoe();
        shoe.addNewDefaultDeck();

        List<Card> first13Cards = dealFirst13Cards(shoe);

        // assert that the cards are in some kind of order, which they would be using a default deck
        // and not having been shuffled. note, we only test up to card number 12 since we're looking
        // ahead in the list
        assertEquals(13, first13Cards.size());
        assertTrue(allCardsSameSuit(first13Cards));
        Card firstCard, secondCard;
        for (int i = 0; i < 12; ++i) {
            firstCard = first13Cards.get(i);
            secondCard = first13Cards.get(i + 1);
            assertTrue(cardsAreInSequence(firstCard, secondCard));
        }

    }

    @Test
    public void testShuffledDeck() throws EmptyCardShoeException {
        CardShoe shoe = new CardShoe();
        shoe.addNewDefaultDeck();

        // exercise unit
        shoe.shuffle();

        List<Card> first13Cards = dealFirst13Cards(shoe);
        assertEquals(13, first13Cards.size());
        assertFalse(allCardsSameSuit(first13Cards));

    }

    @Test(expected = EmptyCardShoeException.class)
    public void test52Cards() throws EmptyCardShoeException {
        CardShoe shoe = new CardShoe();
        shoe.addNewDefaultDeck();

        // deal all 52 cards
        for (int i = 0; i < 52; ++i) {
            shoe.dealCard();
        }

        // try to deal the 53rd card, which will not exist
        shoe.dealCard();
        fail("This cannot happen, there should not be 53 cards!");

    }

    private boolean allCardsSameSuit(List<Card> first13Cards) {
        Suit suit = first13Cards.get(0).getSuit();
        Card currentCard;
        for (int i = 1; i < 13; ++i) {
            currentCard = first13Cards.get(i);
            if (currentCard.getSuit() != suit) {
                return false;
            }
        }

        return true;
    }

    /*
     * Test that the cards are in sequence where the first card is of a higher value
     * than the second
     */
    private boolean cardsAreInSequence(Card firstCard, Card secondCard) {
        return (firstCard.getValue() - 1) == secondCard.getValue();
    }


    private List<Card> dealFirst13Cards(CardShoe shoe) throws EmptyCardShoeException {
        ArrayList<Card> cards = new ArrayList<Card>();
        for (int i = 0; i < 13; ++i) {
            cards.add(shoe.dealCard());
        }
        return cards;
    }
}
