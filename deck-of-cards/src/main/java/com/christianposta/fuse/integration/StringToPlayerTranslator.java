package com.christianposta.fuse.integration;

import com.christianposta.fuse.Player;

/**
 * Created by IntelliJ IDEA.
 * User: ceposta
 * Date: 8/24/11
 * Time: 1:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringToPlayerTranslator {

    public Player createPlayerFromName(String playerName) {
        Player player = new Player(playerName);
        return player;
    }
}
