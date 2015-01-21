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

package org.jlib.container.operation;

import org.jlib.core.exception.InvalidStateException;
import org.jlib.core.text.message.Message;

import static org.jlib.core.text.message.MessageUtility.message;

public abstract class InvalidContainerStateException
extends InvalidStateException {

    private static final long serialVersionUID = - 6765111335075525788L;

    public InvalidContainerStateException(final Object container) {
        super(buildMessage(container, message()));
    }

    public InvalidContainerStateException(final Object container, final Exception cause) {
        super(buildMessage(container, message()), cause);
    }

    public InvalidContainerStateException(final Object container, final Message message) {
        super(buildMessage(container, message));
    }

    public InvalidContainerStateException(final Object container, final Message message, final Exception cause) {
        this(buildMessage(container, message), cause);
    }

    private static Message buildMessage(final Object container, final Message message) {
        return message.with("container", container);
    }
}
