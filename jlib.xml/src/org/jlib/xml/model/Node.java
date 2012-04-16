package org.jlib.xml;

import java.util.List;

/**
 * XML node.
 * 
 * @author Igor Akkerman
 *
 */
public interface Node {
    /**
     * Returns the list of child node of this node.
     * 
     * @return list of child nodes
     */
    public List<Node> getChildNodes();
}
