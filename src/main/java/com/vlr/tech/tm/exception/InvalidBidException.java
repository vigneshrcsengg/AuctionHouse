/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vlr.tech.tm.exception;

/**
 *
 * @author Vignesh
 */
public class InvalidBidException extends Exception {

    public InvalidBidException(String message) {
        super(message);
    }

    public InvalidBidException(String message, Throwable th) {
        super(message, th);
    }
}
