package org.jlib.container.operation;

import java.util.Set;

public interface ToSet<Item> {

    public Set<Item> toSet()
    throws InvalidContainerStateException;
}
