package org.jlib.container.matrix;

import org.jlib.container.AbstractContainer;

/**
 * Skeletal implementation of a {@link Matrix}.
 * 
 * @param <Entry>
 *        type of the entries of the {@link Matrix}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractMatrix<Entry>
extends AbstractContainer<Entry>
implements Matrix<Entry> {

    /**
     * Returns the number of cells in this ArrayMatrix. The size is equal to
     * {@code getWidth() * getHeight()}.
     * 
     * @return integer specifying the number of cells
     */
    @Override
    public int getSize() {
        return getWidth() * getHeight();
    }
}
