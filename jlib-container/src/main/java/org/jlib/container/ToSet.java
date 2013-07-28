package org.jlib.container;

import java.util.Set;

import org.jlib.container.InvalidContainerStateException;

public interface ToSet<Item> {

    public Set<Item> toSet()
    throws InvalidContainerStateException;
}
