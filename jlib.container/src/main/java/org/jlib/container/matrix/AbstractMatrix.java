package org.jlib.container.matrix;

/**
 * Skeletal implementation of a {@link Matrix}.
 * 
 * @param <Entry>
 *        type of the entries of the {@link Matrix}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractMatrix<Entry>
implements Matrix<Entry> {
    
    /**
     * Returns the number of cells in this ArraySequenceMatrix. The size is
     * equal to {@code getWidth() * getHeight()}.
     * 
     * @return integer specifying the number of cells
     */
    @Override
    public int getSize() {
        return getWidth() * getHeight();
    }
}
