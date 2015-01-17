/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2014 Igor Akkerman
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

import org.jlib.core.language.InvalidStateException;

import static org.jlib.core.text.ParametrizedMessageUtility.message;
import static org.jlib.core.value.ValueUtility.named;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ParametrizedMessageTest {

    private static final ParametrizedMessageConfiguration COLON_CONFIGURATION;

    static {
        COLON_CONFIGURATION = new ParametrizedMessageConfiguration();
        COLON_CONFIGURATION.setArgumentTemplate("%s: %s");
        COLON_CONFIGURATION.setTextArgumentsSeparator(" ");
        COLON_CONFIGURATION.setArgumentsSeparator("; ");
    }

    private static final ParametrizedMessageConfiguration EQUALS_SINGLE_QUOTE_CONFIGURATION;

    static {
        EQUALS_SINGLE_QUOTE_CONFIGURATION = new ParametrizedMessageConfiguration();
        EQUALS_SINGLE_QUOTE_CONFIGURATION.setArgumentTemplate("%s='%s'");
        EQUALS_SINGLE_QUOTE_CONFIGURATION.setTextArgumentsSeparator(" ");
        EQUALS_SINGLE_QUOTE_CONFIGURATION.setArgumentsSeparator(" ");
    }

    @Before
    public void initializeDefaultConfiguration() {
        ParametrizedMessageFactory.getInstance().setDefaultConfiguration(EQUALS_SINGLE_QUOTE_CONFIGURATION);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void thrownExceptionShouldHaveCorrectClass() {
        expectedException.expect(ExceptionA.class);

        throw new ExceptionA(message("Something went wrong."));
    }

    @Test
    public void thrownExceptionShouldHaveTextMessage() {
        expectedException.expectMessage("Something went wrong.");

        throw new ExceptionA(message("Something went wrong."));
    }

    @Test
    public void thrownExceptionShouldHaveMessageWithArgument() {
        expectedException.expectMessage("dummyName='Dummy Value'");

        throw new ExceptionA(message().with("dummyName", "Dummy Value"));
    }

    @Test
    public void thrownExceptionShouldHaveTextMessageWithArguments() {
        expectedException.expectMessage("Something went wrong. dummyName='1' dummerName='Dummer Value'");

        throw new ExceptionA(message("Something went wrong.").with("dummyName", 1).with("dummerName", "Dummer Value"));
    }

    @Test
    public void thrownExceptionShouldHaveTextMessageWithNamedArgument() {
        expectedException.expectMessage("Something went wrong. dummyName='1'");

        throw new ExceptionA(message("Something went wrong.").with(named("dummyName", 1)));
    }

    @Test
    public void thrownExceptionShouldHaveTextMessageWithNamedArgumentsInSpecifiedDefaultFormat() {
        ParametrizedMessageFactory.getInstance().setDefaultConfiguration(COLON_CONFIGURATION);

        expectedException.expectMessage("Something went wrong. dummyName: 1; dummerName: Dummer Value");

        throw new ExceptionA(message("Something went wrong.").with(named("dummyName", 1),
                                                                   named("dummerName", "Dummer Value")));
    }

    @Test
    public void thrownExceptionShouldHaveTextMessageWithNamedArguments() {

        expectedException.expectMessage("Something went wrong. dummyName='1' dummerName='Dummer Value'");

        throw new ExceptionA(message("Something went wrong.").with(named("dummyName", 1),
                                                                   named("dummerName", "Dummer Value")));
    }

    @Test
    public void thrownExceptionShouldHaveTextMessageWithArgumentsInSpecifiedFormat() {

        expectedException.expectMessage("Something went wrong. dummyName: 1; dummerName: Dummer Value");

        throw new ExceptionA(message("Something went wrong.", COLON_CONFIGURATION).with("dummyName", 1)
                                                                                  .with("dummerName", "Dummer Value"));
    }

    private static class ExceptionA
    extends InvalidStateException {

        private ExceptionA(final ParametrizedMessage message) {
            super(message);
        }
    }
}
