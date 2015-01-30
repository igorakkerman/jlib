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

package org.jlib.core.message;

import static org.jlib.core.message.MessageUtility.createInitialDefaultConfiguration;

public final class MessageConfigurationRegistry {

    private static final MessageConfigurationRegistry INSTANCE = new MessageConfigurationRegistry();

    public static MessageConfigurationRegistry getInstance() {
        return INSTANCE;
    }

    private MessageConfiguration defaultConfiguration = createInitialDefaultConfiguration();

    private MessageConfigurationRegistry() {}

    public MessageConfiguration getDefaultConfiguration() {
        return defaultConfiguration;
    }

    public void setDefaultConfiguration(final MessageConfiguration defaultConfiguration) {
        this.defaultConfiguration = defaultConfiguration;
    }
}
