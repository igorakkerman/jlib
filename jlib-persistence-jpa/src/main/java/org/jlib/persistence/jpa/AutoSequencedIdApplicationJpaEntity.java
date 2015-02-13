package org.jlib.persistence.jpa;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import static org.apache.commons.lang3.ArrayUtils.add;

/**
 * <p>
 * Annotate the entity class with
 * {@code @AttributeOverride(name = JpaEntity.FIELD_NAME_ID, column = @Column(name = "myentity_id"))}
 * </p>
 *
 * @param <Self>
 *        own type
 *
 * @param <ID>
 *        type of the id
 */
@MappedSuperclass
// FIXME: fina a good name
public abstract class AutoSequencedIdApplicationJpaEntity<Self extends AutoSequencedIdApplicationJpaEntity<Self, ID>, ID extends Serializable>
extends ApplicationJpaEntity<Self, ID> {

    public static final String FIELD_NAME_ID = "id";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
