package com.christianposta.fuse.cards.shuffle;

import com.christianposta.fuse.cards.Card;

import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ceposta
 * Date: 8/17/11
 * Time: 8:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class DefaultShuffleAlgorithm implements ShuffleAlgorithm {


    public List<Card> shuffleCards(List<Card> cards) {
        Collections.shuffle(cards);
        return cards;
    }
}
