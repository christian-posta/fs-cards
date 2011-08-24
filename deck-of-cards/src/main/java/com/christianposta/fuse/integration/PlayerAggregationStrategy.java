package com.christianposta.fuse.integration;

import com.christianposta.fuse.Player;
import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: ceposta
 * Date: 8/24/11
 * Time: 1:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlayerAggregationStrategy implements AggregationStrategy{

    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        Player player = newExchange.getIn().getBody(Player.class);
        ArrayList<Player> playerArrayList = null;
        if (oldExchange == null) {
            playerArrayList = new ArrayList<Player>();
            playerArrayList.add(player);
            newExchange.getIn().setBody(playerArrayList);
            return newExchange;
        } else {
            playerArrayList = oldExchange.getIn().getBody(ArrayList.class);
            playerArrayList.add(player);
            return oldExchange;
        }
    }
}
