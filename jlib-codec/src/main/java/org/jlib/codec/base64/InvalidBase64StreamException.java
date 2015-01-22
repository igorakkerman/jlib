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

import org.jlib.core.io.IoException;

/**
 * Exception thrown if a stream is an invalid base64 stream.
 *
 * @author Igor Akkerman
 */
public abstract class InvalidBase64StreamException
extends IoException {

    private static final long serialVersionUID = 1102863875982144028L;

    protected InvalidBase64StreamException() {}
}
