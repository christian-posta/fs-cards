package com.christianposta.fuse;

import com.christianposta.fuse.cards.CardShoe;
import com.christianposta.fuse.cards.EmptyCardShoeException;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ceposta
 * Date: 8/24/11
 * Time: 11:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class Dealer {
    public static final int DEFAULT_NUM_CARDS_TO_DEAL = 5;

    private CardShoe shoe;
    private int numCardsToDeal;

    public Dealer() {
        this(CardShoe.createShoeWithDefaultCards());
    }

    public Dealer(CardShoe shoe) {
        this.shoe = shoe;
        this.shoe.shuffle();
        this.numCardsToDeal = DEFAULT_NUM_CARDS_TO_DEAL;
    }

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
