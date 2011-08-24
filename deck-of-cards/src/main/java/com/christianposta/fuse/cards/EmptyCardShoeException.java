package com.christianposta.fuse.cards;

/**
 * Created by IntelliJ IDEA.
 * User: ceposta
 * Date: 8/17/11
 * Time: 8:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class EmptyCardShoeException extends Exception{
    public EmptyCardShoeException(String message) {
        super(message);
    }

    public EmptyCardShoeException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
