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

package org.jlib.operator.observer;

import static org.jlib.operator.observer.ObserverUtility.observe;
import static org.jlib.operator.observer.ObserverUtility.operate;

public class ObserverUtilityTest {

    // @Test
    public void test() {
        operate(null, null, observe().beforeDo(value -> System.out.println("Operating on " + value))
                                     .afterSuccessDo(value -> System.out.println("Success: " + value))
                                     .afterFailureDo(value -> System.out.println("Failure: " + value)));
    }
}
