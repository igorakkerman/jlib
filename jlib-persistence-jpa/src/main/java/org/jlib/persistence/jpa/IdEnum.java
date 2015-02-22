package org.jlib.persistence.jpa;

import java.io.Serializable;

public interface IdEnum<EnumId extends Serializable> {
    EnumId getId();
}
