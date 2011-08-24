package com.christianposta.fuse;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: ceposta
 * Date: 8/24/11
 * Time: 1:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class DealerTest {

    @Test
    public void testDefaultCardsDealt() {
        Dealer dealer = new Dealer();

        List<Player> players = createNumberOfPlayers(5);

        dealer.dealCardsToPlayers(players);

        for (Player player : players) {
            assertEquals(5, player.getTotalNumCards());
        }
    }

    @Test
    public void testSpecifiedNumCardsDealt() {
        Dealer dealer = new Dealer();
        dealer.setNumCardsToDeal(7);
        List<Player> players = createNumberOfPlayers(5);

        dealer.dealCardsToPlayers(players);

        for (Player player : players) {
            assertEquals(7, player.getTotalNumCards());
        }

    }

    private List<Player> createNumberOfPlayers(int numPlayersToCreate) {
        String playerName = "playerNum-";
        ArrayList<Player> players = new ArrayList<Player>();
        for (int i = 0; i < numPlayersToCreate; ++i) {
            players.add(new Player(playerName + i));
        }
        return players;
    }
}
