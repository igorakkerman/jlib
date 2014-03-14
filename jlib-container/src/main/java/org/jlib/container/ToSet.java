package org.jlib.container;

import java.util.Set;

import org.jlib.core.traverser.InvalidTraversableStateException;

public interface ToSet<Item> {

    public Set<Item> toSet()
    throws InvalidTraversableStateException;
}
