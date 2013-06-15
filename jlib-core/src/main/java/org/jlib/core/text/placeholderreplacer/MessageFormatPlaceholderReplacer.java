/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2013 Igor Akkerman
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

package org.jlib.core.text.placeholderreplacer;

import java.text.MessageFormat;

/**
 * {@link PlaceholderReplacer} using the {@link MessageFormat} template format
 * and processing routine. Implemented as a singleton.
 *
 * @author Igor Akkerman
 */
// TODO: unit test
public final class MessageFormatPlaceholderReplacer implements PlaceholderReplacer {

    /** sole {@link MessageFormatPlaceholderReplacer} instance */
    public static final MessageFormatPlaceholderReplacer INSTANCE = new MessageFormatPlaceholderReplacer();

    /**
     * Returns the sole {@link MessageFormatPlaceholderReplacer} instance.
     *
     * @return sole {@link MessageFormatPlaceholderReplacer} instance
     */
    public static MessageFormatPlaceholderReplacer getInstance() {
        return INSTANCE;
    }

     /**
     * Creates a new {@link MessageFormatPlaceholderReplacer}.
     */
    private MessageFormatPlaceholderReplacer() {
        super();
    }

    @Override
    public String replacePlaceholders(final CharSequence template, final Object... arguments) {
        return MessageFormat.format(template.toString(), arguments);
    }
}
