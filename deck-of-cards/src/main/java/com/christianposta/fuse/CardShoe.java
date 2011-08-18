package com.christianposta.fuse;

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
        this.shuffleAlgorithm = shuffleAlgorithm;
        this.cards = new Stack();

    }

    public void addDeck(Deck deck) {
        for (Card c : deck.getCards()) {
            this.cards.push(c);
        }
    }

    public void shuffle() {
        this.shuffleAlgorithm.shuffleCards(this.cards);

    }

    public Card dealCard() {
        try {
            return this.cards.pop();
        } catch (EmptyStackException e) {
            throw new EmptyCardShoeException("There are no more cards. Try adding a new deck");
        }
    }


}
