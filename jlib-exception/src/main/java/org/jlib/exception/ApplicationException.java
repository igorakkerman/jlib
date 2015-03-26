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

package org.jlib.exception;

import org.jlib.message.Message;

/**
 * Skeletal implementation of an {@link Exception} using a formatted message.
 *
 * @author Igor Akkerman
 */
public abstract class ApplicationException
extends Exception {

    private static final long serialVersionUID = - 7508635402610527176L;

    protected ApplicationException() {}

    protected ApplicationException(final Message message) {
        super(message.toString());
    }

    protected ApplicationException(final Exception cause) {
        super(cause);
    }

    protected ApplicationException(final Message message, final Exception cause) {
        super(message.toString(), cause);
    }
}
