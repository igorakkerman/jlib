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

package org.jlib.core.codec.base64;


/**
 * Exception thrown if a base64 block contains more than two padding characters or a padding
 * character at a position other than at the end of the block.
 * 
 * @author Igor Akkerman
 */

public class IllegalBase64BlockPadException
extends InvalidBase64StreamException {

    /** base64 block containing a wrong padding character */
    private int[] base64Block;

    /**
     * Creates a new IllegalBase64BlockPadException for the specified base64 block.
     * 
     * @param base64Block
     *        array of four integers containing the bad base64 block that contains a wrong padding
     *        character
     */
    public IllegalBase64BlockPadException(int[] base64Block) {
        super();
        this.base64Block = base64Block;
    }

    /**
     * Returns the bad base64 block that contains a wrong padding character.
     * 
     * @return array of four integers containing the bad base64 block that contains a wrong padding
     *         character
     */
    public int[] getBase64Block() {
        return base64Block;
    }

    // documented in super class
    @Override
    public String toString() {
        return super.toString() + "[" + base64Block[0] + "," + base64Block[1] + "," + base64Block[2] + ","
               + base64Block[3] + "]";
    }
}
