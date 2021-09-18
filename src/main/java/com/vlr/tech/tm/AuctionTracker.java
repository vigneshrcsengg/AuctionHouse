package com.vlr.tech.tm;

import com.vlr.tech.tm.auction.AuctionContainer;
/**
 *
 * @author Vignesh
 */
public interface AuctionTracker {

    void sellItem(AuctionContainer aCont);

    void bidItem(AuctionContainer aCont);

    void closeAuction(int closeTime);
}
