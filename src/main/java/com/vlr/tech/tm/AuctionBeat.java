/*
 * AuctionBeat - Read the input file to place the sell items and bid on it
 */
package com.vlr.tech.tm;

import com.vlr.tech.tm.auction.AuctionContainer;
import com.vlr.tech.tm.auction.Tracker;
import com.vlr.tech.tm.model.Item;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author Vignesh
 */
public class AuctionBeat implements AuctionTracker {

    Set<Tracker> aTrackSet;
    Tracker currentBidTrack = null;

    public AuctionBeat() {
        aTrackSet = new LinkedHashSet<>();
    }

    /**
     * Insert Sell Items
     * @param aCont 
     */
    @Override
    public void sellItem(AuctionContainer aCont) {
        if (!isSellAuctionExist(aCont.getCloseTime(), aCont.getItem())) {
            aTrackSet.add(
                    new Tracker(
                            aCont.getCloseTime(),
                            aCont.getItem().getId(),
                            "",
                            "UNSOLD",
                            aCont.getAuction().getPrice(),
                            0.00d,
                            0,
                            0.00d,
                            0.00d
                    )
            );
        }
    }

    /**
     * Bid the reserved or unsold items
     * @param aCont 
     */
    @Override
    public void bidItem(AuctionContainer aCont) {
        if (isUnsoldItemExist(aCont.getTimeStamp(), aCont.getItem())) {

            Tracker newT = currentBidTrack;

            if (currentBidTrack.getCloseTime() >= aCont.getTimeStamp()) {
                if (aCont.getAuction().getPrice() > currentBidTrack.getOfferPrice()) {
                    newT.setUserId(aCont.getUser().getId());
                    if (currentBidTrack.getStatus().equalsIgnoreCase("UNSOLD")) {
                        newT.setPaidPrice(aCont.getAuction().getPrice());
                        newT.setStatus("RESERVED");
                    }
                }

                if (aCont.getAuction().getPrice() > currentBidTrack.getHighestBidPrice()) {
                    newT.setHighestBidPrice(aCont.getAuction().getPrice());
                    if (currentBidTrack.getLowestBidPrice() <= 0.00d) {
                        newT.setLowestBidPrice(aCont.getAuction().getPrice());
                    }
                }

                if (aCont.getAuction().getPrice() < currentBidTrack.getLowestBidPrice()) {
                    newT.setLowestBidPrice(aCont.getAuction().getPrice());
                }
            }

            newT.setTotalBidCount(currentBidTrack.getTotalBidCount() + 1);

            aTrackSet.remove(currentBidTrack);
            aTrackSet.add(newT);
        }
    }

    /**
     * Close the reserved item when it reaches the time
     * @param closeTime 
     */
    @Override
    public void closeAuction(int closeTime) {
        Set<Tracker> closeAuction = new LinkedHashSet<>();
        Tracker newT;
        for (Object set : getaTrackSet()) {
            Tracker t = (Tracker) set;
            if (t.getCloseTime() == closeTime && (t.getStatus().equalsIgnoreCase("RESERVED"))) {
                newT = t;
                newT.setStatus("SOLD");
                
                closeAuction.add(newT);
            }
        }
        aTrackSet.addAll(closeAuction);
    }

    /**
     * Check the reserved items
     * @param time
     * @param item
     * @return 
     */
    boolean isReservedItemExist(int time, Item item) {
        boolean isExist = false;
        if (getaTrackSet().isEmpty()) {
            return false;
        }
        for (Object set : getaTrackSet()) {
            Tracker t = (Tracker) set;
            if (t.getCloseTime() == time && t.getItemId().equalsIgnoreCase(item.getId())
                    && (t.getStatus().equalsIgnoreCase("RESERVED"))) {
                currentBidTrack = t;
                isExist = true;
            }
        }
        return isExist;
    }

    /**
     * Check the UnSold items
     * @param time
     * @param item
     * @return 
     */
    boolean isUnsoldItemExist(int time, Item item) {
        boolean isExist = false;
        if (getaTrackSet().isEmpty()) {
            return false;
        }
        for (Object set : getaTrackSet()) {
            Tracker t = (Tracker) set;
            if (t.getCloseTime() >= time && t.getItemId().equalsIgnoreCase(item.getId())
                    && (t.getStatus().equalsIgnoreCase("RESERVED") || t.getStatus().equalsIgnoreCase("UNSOLD"))) {
                currentBidTrack = t;
                isExist = true;
            }
        }
        return isExist;
    }

    /**
     * Check if there is any Sell Items already placed by any user
     * @param closetime
     * @param item
     * @return 
     */
    boolean isSellAuctionExist(int closetime, Item item) {
        boolean isExist = false;
        if (getaTrackSet().isEmpty()) {
            return false;
        }
        for (Object set : getaTrackSet()) {
            Tracker t = (Tracker) set;
            if (t.getCloseTime() == closetime
                    && t.getItemId().equalsIgnoreCase(item.getId())
                    && (t.getStatus().equalsIgnoreCase("RESERVED") || t.getStatus().equalsIgnoreCase("UNSOLD"))) {
                currentBidTrack = t;
                isExist = true;
            }
        }
        return isExist;
    }

    public Set<Tracker> getaTrackSet() {
        return aTrackSet;
    }
}
