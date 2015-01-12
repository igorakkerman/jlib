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

package org.jlib.core.text;

import java.util.function.Supplier;

public class QuotedValueFormatter<Value> implements ValueFormatter<Value> {

    private final String openQuote;
    private final String closeQuote;

    public QuotedValueFormatter(final char quoteCharacter) {
        this(quoteCharacter, quoteCharacter);
    }

    public QuotedValueFormatter(final char openQuoteCharacter, final char closeQuoteCharacter) {
        openQuote = String.valueOf(openQuoteCharacter);
        closeQuote = String.valueOf(closeQuoteCharacter);
    }

    public QuotedValueFormatter(final String quote) {
        this(quote, quote);
    }

    public QuotedValueFormatter(final String openQuote, final String closeQuote) {
        this.openQuote = String.valueOf(openQuote);
        this.closeQuote = String.valueOf(closeQuote);
    }

    @Override
    public StringBuilder append(final StringBuilder textBuilder, final Supplier<Value> value) {
        return textBuilder.append(openQuote).append(value.get()).append(closeQuote);
    }
}
