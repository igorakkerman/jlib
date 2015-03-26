package org.jlib.persistence.jpa;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import static javax.persistence.GenerationType.AUTO;
import static org.apache.commons.lang3.ArrayUtils.add;
import org.jlib.basefunctions.ApplicationObject;
import org.jlib.persistence.IdEntity;

/**
 * Annotate the entity class with
 * {@code @AttributeOverride(name = JpaEntity.FIELD_NAME_ID, column = @Column(name = "myentity_id"))}
 *
 * @param <Self>
 *        own type
 *
 * @param <ID>
 *        type of the id
 */
@MappedSuperclass
public abstract class ApplicationJpaEntity<Self extends ApplicationJpaEntity<Self, ID>, ID extends Serializable>
extends ApplicationObject
implements IdEntity<ID> {

    public static final String FIELD_NAME_ID = "id";

    @Id
    @GeneratedValue(strategy = AUTO)
    private ID id;

    @Override
    public ID getId() {
        return id;
    }

    @Override
    protected String[] getExcludedFieldNames() {
        return add(super.getExcludedFieldNames(), "id");
    }
}
