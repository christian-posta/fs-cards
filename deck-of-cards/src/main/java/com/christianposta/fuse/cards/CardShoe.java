package com.christianposta.fuse.cards;

import com.christianposta.fuse.cards.shuffle.DefaultShuffleAlgorithm;
import com.christianposta.fuse.cards.shuffle.ShuffleAlgorithm;
import org.apache.commons.lang.Validate;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: ceposta
 * Date: 8/17/11
 * Time: 8:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class CardShoe {

    private Stack<Card> cards;
    private ShuffleAlgorithm shuffleAlgorithm;

    public CardShoe() {
        this(new DefaultShuffleAlgorithm());
    }

    public CardShoe(ShuffleAlgorithm shuffleAlgorithm) {
        Validate.notNull(shuffleAlgorithm, "Cannot use a null shuffle algorithm. Please check how you're creating the CardShoe");
        this.shuffleAlgorithm = shuffleAlgorithm;
        this.cards = new Stack();

    }

    public static CardShoe createShoeWithDefaultCards() {
        CardShoe shoe = new CardShoe();
        shoe.addNewDefaultDeck();
        return shoe;

    }

    /**
     * Adds a new deck to the shoe. This must be called at least one time, or there will be no cards in the shoe
     *
     * @param deck
     */
    public void addDeck(Deck deck) {
        Validate.notNull(deck, "Cannot add a null deck. Please check how you're creating the deck and passing to CardShoe");
        for (Card c : deck.getCards()) {
            this.cards.push(c);
        }
    }

    /**
     * Add a default {@link Deck} of cards
     */
    public void addNewDefaultDeck(){
        Deck deck = new Deck();
        addDeck(deck);
    }

    /**
     * Shuffle the cards within this shoe. This method is recommended to be called before dealing any cards, but can
     * be called at anytime there are cards in the shoe.
     *
     */
    public void shuffle() {
        if (this.cards == null) {
            throw new IllegalStateException("Cannot shuffle cards when none exist. Please add a deck to shoe before shuffling");
        }
        this.shuffleAlgorithm.shuffleCards(this.cards);

    }

    /**
     * Deals the next card from the shoe. Note, you'll want to call shuffle before dealing if you'd like
     * the cards to come out in a shuffled order. If there are no cards left in this shoe, an EmptyCardShoeException
     * will be thrown. This is a checked exception and must be caught by the caller. The reason this exception is
     * checked is because it's a recoverable exception, however it indicates that a card cannot be dealt.
     *
     * @return the next card from the shoe if a card exists
     * @throws EmptyCardShoeException when you attempt to deal a card and there are no cards in the shoe
     */
    public Card dealCard() throws EmptyCardShoeException {
        try {
            return this.cards.pop();
        } catch (EmptyStackException e) {
            throw new EmptyCardShoeException("There are no cards in this shoe. Try adding a new deck");
        }
    }


    public boolean cardsExist() {
        return this.cards.size() > 0;
    }
}
