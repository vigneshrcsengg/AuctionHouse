package com.vlr.tech.tm.auction;

/**
 *
 * @author Vignesh
 */
public class Auction {

    final double price;

    public Auction(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("{ price: %s}", price);
    }
}
