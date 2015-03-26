package org.jlib.persistence;

import java.io.Serializable;

public interface IdEnum<EnumId extends Serializable> {
    EnumId getId();
}
