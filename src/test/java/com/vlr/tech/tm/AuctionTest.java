/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vlr.tech.tm;

import com.vlr.tech.tm.exception.InvalidNumberOfArgumentsException;
import org.junit.Test;

/**
 *
 * @author Vignesh
 */
public class AuctionTest {

    @Test
    public void getDatasourceInputDoesNotExist() throws InvalidNumberOfArgumentsException {
        AuctionHouse.main(new String[]{"D:\\Work\\Learning\\Java\\Others\\input.txt"});
    }
}
