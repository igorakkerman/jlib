/*
 * jlib - The Free Java Library
 * 
 *    http://www.jlib.org
 *    
 * Copyright (c) 2006-2008 Igor Akkerman
 * 
 * jlib is distributed under the
 *
 *    COMMON PUBLIC LICENSE VERSION 1.0
 *
 *    http://www.opensource.org/licenses/cpl1.0.php
 */

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
*/

/**
 * jlib core functionality.
 * 
 * @author Igor Akkerman
 */
package org.jlib.core;

