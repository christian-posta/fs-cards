package com.christianposta.fuse;

import com.christianposta.fuse.cards.Card;

/**
 * Created by IntelliJ IDEA.
 * User: ceposta
 * Date: 8/24/11
 * Time: 8:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class Player {

    private String name;
    private Hand playerHand;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void acceptCard(Card card) {
        this.playerHand.acceptCard(card);
    }
}
