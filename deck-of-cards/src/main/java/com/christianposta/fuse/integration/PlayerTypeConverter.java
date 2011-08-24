package com.christianposta.fuse.integration;

import com.christianposta.fuse.Player;
import org.apache.camel.Converter;

/**
 * Created by IntelliJ IDEA.
 * User: ceposta
 * Date: 8/24/11
 * Time: 11:13 AM
 * To change this template use File | Settings | File Templates.
 */
@Converter
public class PlayerTypeConverter {

    @Converter
    public static Player toPlayer(String playerName) {
        Player player = new Player(playerName);
        return player;
    }
}
