/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2015 Igor Akkerman
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package org.jlib.codec.base64;

/**
 * Exception thrown if a base64 block contains more than two padding characters or a padding
 * character at a position other than at the end of the block.
 *
 * @author Igor Akkerman
 */

public class IllegalBase64BlockPadException
extends InvalidBase64StreamException {

    private static final long serialVersionUID = 1023903911620993818L;

    /** base64 block containing a wrong padding character */
    private final int[] base64Block;

    /**
     * Creates a new IllegalBase64BlockPadException for the specified base64 block.
     *
     * @param base64Block
     *        array of four integers containing the bad base64 block that contains a wrong padding
     *        character
     */
    public IllegalBase64BlockPadException(final int[] base64Block) {
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
