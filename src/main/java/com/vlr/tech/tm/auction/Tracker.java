/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vlr.tech.tm.auction;

/**
 *
 * @author Vignesh
 */
public class Tracker {

    int closeTime;
    String itemId;
    String userId;
    String status;
    double offerPrice;
    double paidPrice;
    int totalBidCount;
    double highestBidPrice;
    double lowestBidPrice;

    public Tracker(int closeTime, String itemId, String userId, String status, double offerPrice, double paidPrice, int totalBidCount, double highestBidPrice, double lowestBidPrice) {
        this.closeTime = closeTime;
        this.itemId = itemId;
        this.userId = userId;
        this.status = status;
        this.offerPrice = offerPrice;
        this.paidPrice = paidPrice;
        this.totalBidCount = totalBidCount;
        this.highestBidPrice = highestBidPrice;
        this.lowestBidPrice = lowestBidPrice;
    }

    public int getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(int closeTime) {
        this.closeTime = closeTime;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(double offerPrice) {
        this.offerPrice = offerPrice;
    }

    public double getPaidPrice() {
        return paidPrice;
    }

    public void setPaidPrice(double paidPrice) {
        this.paidPrice = paidPrice;
    }

    public int getTotalBidCount() {
        return totalBidCount;
    }

    public void setTotalBidCount(int totalBidCount) {
        this.totalBidCount = totalBidCount;
    }

    public double getHighestBidPrice() {
        return highestBidPrice;
    }

    public void setHighestBidPrice(double highestBidPrice) {
        this.highestBidPrice = highestBidPrice;
    }

    public double getLowestBidPrice() {
        return lowestBidPrice;
    }

    public void setLowestBidPrice(double lowestBidPrice) {
        this.lowestBidPrice = lowestBidPrice;
    }
}
