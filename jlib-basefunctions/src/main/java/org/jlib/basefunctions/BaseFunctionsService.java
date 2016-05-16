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

package org.jlib.basefunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

public class BaseFunctionsService {

    private static final BaseFunctionsService INSTANCE = new BaseFunctionsService();
    private final BaseFunctionsDispatcher baseFunctionsDispatcher;

    private BaseFunctionsService()
        throws ServiceConfigurationError, NoBaseFunctionsImplementationFoundException,
               OnlyOneBaseFunctionsImplementationAllowedException {

        final ServiceLoader<BaseFunctionsDispatcher> loader = ServiceLoader.load(BaseFunctionsDispatcher.class);

        final List<BaseFunctionsDispatcher> baseFunctionsDispatchers = new ArrayList<>();

        for (final BaseFunctionsDispatcher baseFunctionsDispatcher : loader)
            baseFunctionsDispatchers.add(baseFunctionsDispatcher);

        assertExactlyOneSpiInClassPath(baseFunctionsDispatchers);

        baseFunctionsDispatcher = baseFunctionsDispatchers.get(0);
    }

    public static BaseFunctionsService getInstance() {
        return INSTANCE;
    }

    private void assertExactlyOneSpiInClassPath(final List<BaseFunctionsDispatcher> baseFunctionsDispatchers)
        throws OnlyOneBaseFunctionsImplementationAllowedException {
        if (baseFunctionsDispatchers.isEmpty())
            throw new NoBaseFunctionsImplementationFoundException();

        if (baseFunctionsDispatchers.size() > 1)
            throw new OnlyOneBaseFunctionsImplementationAllowedException(baseFunctionsDispatchers);
    }

    public BaseFunctionsDispatcher getBaseFunctionsDispatcher() {
        return baseFunctionsDispatcher;
    }
}
