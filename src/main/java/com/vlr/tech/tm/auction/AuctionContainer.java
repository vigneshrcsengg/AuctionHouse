/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vlr.tech.tm.auction;

import com.vlr.tech.tm.model.Item;
import com.vlr.tech.tm.model.User;

/**
 *
 * @author Vignesh
 */
public class AuctionContainer {

    private static final AuctionContainer INSTANCE = new AuctionContainer();

    int timeStamp;
    int closeTime;

    Auction auction;
    User user;
    Item item;

    public static AuctionContainer getInstance() {
        return INSTANCE;
    }

    public AuctionContainer(int timeStamp, int closeTime, User user, Auction auction, Item item) {
        this.timeStamp = timeStamp;
        this.closeTime = closeTime;
        this.user = user;
        this.auction = auction;
        this.item = item;
    }

    public AuctionContainer() {
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public int getCloseTime() {
        return closeTime;
    }

    public Auction getAuction() {
        return auction;
    }

    public User getUser() {
        return user;
    }

    public Item getItem() {
        return item;
    }
}
