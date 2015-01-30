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

package org.jlib.codec.quotedprintable;

import static org.jlib.core.message.MessageUtility.message;

/**
 * Exception thrown if illegal characters follow the octet encoding prefix in a quoted-printable
 * stream.
 *
 * @author Igor Akkerman
 */
public class InvalidQuotedPrintableOctetException
extends InvalidQuotedPrintableStreamException {

    private static final long serialVersionUID = - 7132279152781768023L;

    /** the illegal characters */
    private final byte[] illegalCharacters = new byte[2];

    /**
     * Creates a new IllegalQuotedPrintableOctetException for the specified illegal characters.
     *
     * @param illegalCharacter1
     *        byte specifying the first illegal character
     *
     * @param illegalCharacter2
     *        byte specifying the second illegal character
     */
    public InvalidQuotedPrintableOctetException(final byte illegalCharacter1, final byte illegalCharacter2) {
        super(message("Illegal characters.").with("char1", illegalCharacter1).with("char2", illegalCharacter2));

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
}
