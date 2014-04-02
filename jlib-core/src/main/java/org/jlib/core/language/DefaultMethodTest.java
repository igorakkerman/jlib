package org.jlib.core.language;

public interface DefaultMethodTest
extends Cloneable {

    default Object clone()
    throws CloneNotSupportedException {
        Cloneable.super.toString();

        return null;
    }
}
