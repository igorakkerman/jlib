/*******************************************************************************
 * 
 *    jlib - Open Source Java Library
 * 
 *    www.jlib.org
 * 
 * 
 *    Copyright 2012 Igor Akkerman
 * 
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 * 
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 * 
 ******************************************************************************/

/*
 TODO: replace toString, equals, hashCode
 TODO: change Javadoc references from @code to @link
 TODO:
 - remove all uses of NullPointerException
 - create NullArgumentException extends IllegalArgumentException (like Apache Commons)
 - - create aspect/annotation disallowing null arguments ANYWHERE(!)
 - then remove checks for null arguments
 - aspects: contradiction to obliviousness?
 no, if we define that method behaviour is
 generally unspecified if null arguments are used!
 - create annotation for method parameters @Nullable
 declaring null arguments as being allowed (only for special cases)
 TODO: change license to Apache License 2.0
 TODO: aspect: replace super.toString() calls from jlib classes by something intelligent
 (e.g. Apache Commons toStringBuilder) - execution(String Object.toString) && cflow(call(* jlib.*(..))) )
 */

/**
 * jlib core functionality.
 * 
 * @author Igor Akkerman
 */
package org.jlib.core;

