/*
 * jlib - The Free Java Library
 * 
 * http://www.jlib.org
 * 
 * Copyright (c) 2006-2008 Igor Akkerman
 * 
 * jlib is distributed under the
 * 
 * COMMON PUBLIC LICENSE VERSION 1.0
 * 
 * http://www.opensource.org/licenses/cpl1.0.php
 */

package org.jlib.core.collections;

import org.jlib.core.collections.list.Array;
import org.jlib.core.number.NumberOperators;
import org.jlib.core.number.NumberUtility;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.jlib.core.collections.CollectionUtility.*;
import static org.jlib.core.number.NumberOperators.*;

/**
 * Test of the CollectionUtility class.
 * 
 * @author Igor Akkerman
 */
public class CollectionUtilityTest {

    @Test
    public void testApplyToAllPlus() {
        Collection<Integer> collection = Array.newIntegerArray(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertEquals(55, applyToAll(collection, INTEGER_PLUS));
    }

    @Test
    public void testApplyToAllPlusEmptyCollection() {
        Collection<Integer> collection = Array.newIntegerArray();
        assertEquals(0, applyToAll(collection, INTEGER_PLUS));
    }

    @Test
    public void testApplyToAllPlusEmptyCollectionIdentityValue() {
        Collection<Integer> collection = Array.newIntegerArray();
        assertEquals(1234, applyToAll(collection, INTEGER_PLUS, 1234));
    }

    @Test
    public void testApplyToAllPlusRightAssociative() {
        Collection<Integer> collection = Array.newIntegerArray(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertEquals(55, applyToAllRightAssociative(collection, INTEGER_PLUS));
    }

    @Test
    public void testApplyToAllMinus() {
        Collection<Integer> collection = Array.newIntegerArray(1000, 90, 80, 70, 60, 50, 40, 30, 20, 10);
        assertEquals(550, applyToAll(collection, INTEGER_MINUS));
    }

    @Test
    public void testApplyToAllMinusRightAssociative() {
        Collection<Integer> collection = Array.newIntegerArray(1000, 90, 80, 70, 60, 50, 40, 30, 20, 10);
        assertEquals(950, applyToAllRightAssociative(collection, INTEGER_MINUS));
    }

    @Test
    public void testApplyToAllMinusRightAssociativeDummyIdentityValue() {
        Collection<Integer> collection = Array.newIntegerArray(1000, 90, 80, 70, 60, 50, 40, 30, 20, 10);
        assertEquals(550, applyToAllRightAssociative(collection, INTEGER_MINUS, 1234));
    }
}
