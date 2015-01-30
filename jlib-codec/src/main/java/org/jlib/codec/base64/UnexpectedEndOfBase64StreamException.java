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

/**
 * Exception thrown if at least one character was expected in a base64 encoded stream.
 *
 * @author Igor Akkerman
 */
public class UnexpectedEndOfBase64StreamException
extends InvalidBase64StreamException {

    private static final long serialVersionUID = - 569144262427735939L;

    protected UnexpectedEndOfBase64StreamException() {}
}
