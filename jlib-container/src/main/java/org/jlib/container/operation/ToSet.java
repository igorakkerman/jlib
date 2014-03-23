package org.jlib.container.operation;

import java.util.Set;

public interface ToSet<Item> {

    Set<Item> toSet()
    throws InvalidContainerStateException;
}
