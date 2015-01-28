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

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

public class ObjectService {

    private static final ObjectService INSTANCE = new ObjectService();

    public static ObjectService getInstance() {
        return INSTANCE;
    }

    private final CoreFunctionDispatcher coreFunctionDispatcher;

    private ObjectService()
    throws ServiceConfigurationError, NoObjectSpiImplementationException,
           OnlyOneObjectSpiImplementationAllowedException {
        final ServiceLoader<CoreFunctionDispatcher> loader = ServiceLoader.load(CoreFunctionDispatcher.class);

        final List<CoreFunctionDispatcher> coreFunctionDispatchers = new ArrayList<>();

        for (final CoreFunctionDispatcher coreFunctionDispatcher : loader)
            coreFunctionDispatchers.add(coreFunctionDispatcher);

        assertExactlyOneServiceProviderInClassPath(coreFunctionDispatchers);

        coreFunctionDispatcher = coreFunctionDispatchers.get(0);
    }

    private void assertExactlyOneServiceProviderInClassPath(final List<CoreFunctionDispatcher> coreFunctionDispatchers) {
        if (coreFunctionDispatchers.isEmpty())
            throw new NoObjectSpiImplementationException();

        if (coreFunctionDispatchers.size() > 1)
            throw new OnlyOneObjectSpiImplementationAllowedException(coreFunctionDispatchers);
    }

    public CoreFunctionDispatcher getCoreFunctionDispatcher() {
        return coreFunctionDispatcher;
    }
}
