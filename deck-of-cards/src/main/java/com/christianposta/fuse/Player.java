package com.christianposta.fuse;

import com.christianposta.fuse.cards.Card;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by IntelliJ IDEA.
 * User: ceposta
 * Date: 8/24/11
 * Time: 8:03 AM
 * To change this template use File | Settings | File Templates.
 */
@XStreamAlias("player")
public class Player {

    private String name;
    private Hand playerHand;

    public Player(String name) {
        this.name = name;
        this.playerHand = new Hand();
    }

    public String getName() {
        return name;
    }

    public void acceptCard(Card card) {
        this.playerHand.acceptCard(card);
    }

    @Override
    public String toString() {
        return "Player name: " + this.name;
    }

    public int getTotalNumCards() {
        return playerHand.getNumberOfCards();
    }
}
