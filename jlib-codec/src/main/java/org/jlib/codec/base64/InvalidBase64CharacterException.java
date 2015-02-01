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

import static org.jlib.core.message.MessageUtility.message;

/**
 * Exception thrown if an invalid base64 character is read in a base64 input.
 *
 * @author Igor Akkerman
 */

public class InvalidBase64CharacterException
extends InvalidBase64StreamException {

    private static final long serialVersionUID = - 8389442743931398913L;

    private final int invalidCharacter;

    /**
     * Creates a new IllegalBase64CharacterException.
     *
     * @param invalidCharacter
     *        integer specifying the invalid character;
     *        -1 if the end of the base64 encoded stream has been reached with missing characters
     */
    public InvalidBase64CharacterException(final int invalidCharacter) {
        super(message().with("invalidCharacter", invalidCharacter));

        this.invalidCharacter = invalidCharacter;
    }

    /**
     * Returns the invalid character.
     *
     * @return integer specifying the invalid character;
     *         -1 if the end of the base64 encoded stream has been reached with missing characters
     */
    public int getIllegalCharacter() {
        return invalidCharacter;
    }
}
