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

package org.jlib.object_spi;

import java.util.Collection;

import org.jlib.core.exception.InvalidStateException;

import static org.jlib.core.message.MessageUtility.message;

public class OnlyOneObjectSpiImplementationAllowedException
extends InvalidStateException {

    private static final long serialVersionUID = 8750597802769662034L;

    public OnlyOneObjectSpiImplementationAllowedException /*
     */(final Collection<ObjectMethodForwarder> objectMethodForwarders) {

        super(message().with("objectMethodForwarders", objectMethodForwarders));
    }
}
