package org.jlib.container;

import java.util.Set;

public interface ToSet<Item> {

    public Set<Item> toSet()
    throws InvalidContainerStateException;
}
