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

package org.jlib.core.message;

import static org.jlib.core.message.MessageUtility.EXPECTED_ARGUMENTS_COUNT;
import static org.jlib.core.message.MessageUtility.createBuilder;

public class EagerMessageFactory
implements MessageFactory {

    private static final EagerMessageFactory INSTANCE = new EagerMessageFactory();

    public static EagerMessageFactory getInstance() {
        return INSTANCE;
    }

    private EagerMessageFactory() {}

    @Override
    public Message newMessage() {
        return newMessage("");
    }

    @Override
    public Message newMessage(final String text) {
        return newMessage(text, DefaultMessageSetup.getInstance().getDefaultMessageStyle());
    }

    @Override
    public Message newMessage(final String text, final MessageStyle messageStyle) {
        return newMessage(createBuilder(text.length(), EXPECTED_ARGUMENTS_COUNT).append(text), messageStyle);
    }

    @Override
    public Message newMessage(final StringBuilder builder) {
        return newMessage(builder, DefaultMessageSetup.getInstance().getDefaultMessageStyle());
    }

    @Override
    public Message newMessage(final StringBuilder builder, final MessageStyle style) {
        return new EagerMessage(builder, style);
    }
}
