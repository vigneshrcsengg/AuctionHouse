/*
 * Auction House to deliver the sold and unsold items by bid
 */
package com.vlr.tech.tm;

import com.vlr.tech.tm.auction.AuctionContainer;
import com.vlr.tech.tm.auction.*;
import com.vlr.tech.tm.exception.InvalidNumberOfArgumentsException;
import com.vlr.tech.tm.model.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vignesh
 */
public class AuctionHouse {

    static AuctionContainer aCont;
    static AuctionBeat aBeat;
    static Map<Integer, AuctionContainer> aContMap;

    /**
     * @param args the command line arguments
     * @throws com.vlr.tech.tm.exception.InvalidNumberOfArgumentsException
     */
    public static void main(String[] args) throws InvalidNumberOfArgumentsException {

        aContMap = new LinkedHashMap<>();
        aBeat = new AuctionBeat();

        if (args.length == 1) {
            File inFile = new File(toAbsolutePath(args[0]));

            if (inFile.exists()) {
                if (!inFile.exists()) {
                    System.out.println("Input file not found!");
                    System.exit(1);
                }

                int key = 0;

                try (Scanner s = new Scanner(inFile)) {
                    while (s.hasNextLine()) {

                        String nl = s.nextLine();

                        String[] d = nl.split("\\|", 6);
                        if (d.length > 0) {

                            if (d.length > 1 && d[2] != null) {

                                if (d[2].equalsIgnoreCase("SELL")) {
                                    aCont = new AuctionContainer(
                                            Integer.parseInt(d[0]),
                                            Integer.parseInt(d[5]),
                                            new User(d[1], "user_" + d[1]),
                                            new Sell(Double.parseDouble(d[4])),
                                            new Item(d[3], "item_" + d[3])
                                    );
                                    aBeat.sellItem(aCont);
                                } else if (d[2].equalsIgnoreCase("BID")) {
                                    aCont = new AuctionContainer(
                                            Integer.parseInt(d[0]),
                                            0,
                                            new User(d[1], "user_" + d[1]),
                                            new Bid(Double.parseDouble(d[4])),
                                            new Item(d[3], "item_" + d[3])
                                    );
                                    aBeat.bidItem(aCont);
                                }
                            } else {
                                aBeat.closeAuction(Integer.parseInt(d[0]));
                            }
                            key++;
                            aContMap.put(key, aCont);
                        }
                    }
                    aBeat.getaTrackSet().forEach(c -> {
                        System.out.println(String.format("%s|%s|%s|%s|%.2f|%s|%.2f|%.2f", c.getCloseTime(), c.getItemId(), c.getUserId(), c.getStatus(), c.getPaidPrice(), c.getTotalBidCount(), c.getHighestBidPrice(), c.getLowestBidPrice()));
                    });
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(AuctionHouse.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            throw new InvalidNumberOfArgumentsException("Not a valid input arguement!");
        }

    }

    public static String toAbsolutePath(String path) {
        return FileSystems.getDefault().getPath(path).normalize().toAbsolutePath().toString();
    }

}
