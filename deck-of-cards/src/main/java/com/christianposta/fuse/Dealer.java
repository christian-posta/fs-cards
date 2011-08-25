package com.christianposta.fuse;

import com.christianposta.fuse.cards.CardShoe;
import com.christianposta.fuse.cards.EmptyCardShoeException;

import java.util.List;

/**
 * Main abstraction for 'dealing' cards to players
 */
public class Dealer {
    public static final int DEFAULT_NUM_CARDS_TO_DEAL = 5;

    private CardShoe shoe;
    private int numCardsToDeal;

    /**
     * Create a dealer with a default number of decks with the default
     * shuffle algorithm
     */
    public Dealer() {
        this(CardShoe.createShoeWithDefaultCards());
    }

    /**
     * Allows more control over how the card shuffling happens, how many card decks, etc.
     * @param shoe
     */
    public Dealer(CardShoe shoe) {
        this.shoe = shoe;
        this.shoe.shuffle();
        this.numCardsToDeal = DEFAULT_NUM_CARDS_TO_DEAL;
    }

    /**
     * Deals cards to a list of players. The number of cards that are dealt can be specified
     * by the numCardsToDeal property
     *
     * @param players list of players to which cards will be dealt
     */
    public void dealCardsToPlayers(List<Player> players) {
        int numberOfDealRounds = 0;

        while (shouldDealCards(numberOfDealRounds)) {
            for (Player player : players) {
                try {
                    player.acceptCard(this.shoe.dealCard());
                } catch (EmptyCardShoeException e) {
                    e.printStackTrace();
                    // get out of the for loop, there are no
                    break;
                }
            }

            numberOfDealRounds++;
        }

    }

    private boolean shouldDealCards(int numberOfDealRounds) {
        return numberOfDealRounds != numCardsToDeal && this.shoe.cardsExist();
    }

    public int getNumCardsToDeal() {
        return numCardsToDeal;
    }

    public void setNumCardsToDeal(int numCardsToDeal) {
        this.numCardsToDeal = numCardsToDeal;
    }
}
