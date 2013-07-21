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

package org.jlib.core.iterator;

import java.util.NoSuchElementException;

import org.apache.commons.lang3.exception.ExceptionUtils;

import static java.lang.System.lineSeparator;

public class NoNextElementException
extends NoSuchElementException {

    private static final long serialVersionUID = - 609625653297441413L;

    protected NoNextElementException(final CharSequence iteratedObjectName, final Object iteratedObject) {
        super(buildMessage(iteratedObjectName, iteratedObject));
    }

    protected NoNextElementException(final CharSequence iteratedObjectName, final Object iteratedObject,
                                     final Exception cause) {

        // super(cause) constructor not defined, stack trace is appended to the message
        super(buildMessage(iteratedObjectName, iteratedObject) + /*
          */ lineSeparator() + /*
          */ ExceptionUtils.getStackTrace(cause));
    }

    private static String buildMessage(final CharSequence iteratedObjectName, final Object iteratedObject) {
        return iteratedObjectName + "=" + iteratedObject;
    }
}
