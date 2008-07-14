/*
 * jlib - The Free Java Library
 * 
 *    http://www.jlib.org
 *    
 * Copyright (c) 2006-2008 Igor Akkerman
 * 
 * jlib is distributed under the
 *
 *    COMMON PUBLIC LICENSE VERSION 1.0
 *
 *    http://www.opensource.org/licenses/cpl1.0.php
 */

package org.jlib.core.codec.quotedprintable;

/**
 * Exception thrown if illegal characters follow the octet encoding prefix in a quoted-printable
 * stream.
 * 
 * @author Igor Akkerman
 */
public class IllegalQuotedPrintableOctetException
extends InvalidQuotedPrintableStreamException {

    /** the illegal characters */
    private byte[] illegalCharacters = new byte[2];
    
    /**
     * Creates a new IllegalQuotedPrintableOctetException for the specified illegal characters.
     * 
     * @param illegalCharacter1
     *        byte specifying the first illegal character
     * @param illegalCharacter2
     *        byte specifying the second illegal character
     */
    public IllegalQuotedPrintableOctetException(byte illegalCharacter1, byte illegalCharacter2) {
        super();
        illegalCharacters[0] = illegalCharacter1;
        illegalCharacters[1] = illegalCharacter2;
    }

    /**
     * Returns the illegal characters.
     * 
     * @return byte array containing the two illegal characters
     */
    public byte[] getIllegalCharacters() {
        return illegalCharacters;
    }

    // @see java.lang.Throwable#toString()
    @Override
    public String toString() {
        return super.toString() + "[" + illegalCharacters[0] + ", " + illegalCharacters[1] + "]";
    }
}
