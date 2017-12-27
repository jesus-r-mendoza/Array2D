package array2d;

/**
 * A node of an {@code Aray2D}, which holds an Object of the specified type. 
 * Each node has a reference that points to the node beneath it and to its right,
 * if they exist, otherwise that reference point to null.
 * 
 * 
 * @author    Jesus R. Mendoza
 * @param <E> Specified type of element that will be contained in this node
 * @see       Array2D
 */
public class Array2DNode <E> 
{
    /**
     * The item, of the specified type, which this node holds.
     */
    private E item = null;
    
    /**
     * The reference to the next node, below this node, in the {@code Array2D}. 
     */
    protected Array2DNode<E> down = null;
    
    /**
     * The reference to the next node, right of this node, in the {@code Array2D}. 
     */
    protected Array2DNode<E> right = null;
    
    /**
     * Constructs an empty {@code Array2DNode}.
     */
    public Array2DNode() {
    }    
    
    /**
     * Constructs an {@code Array2DNode} which contains the specified item.
     * 
     * @param item the item this node contains
     */
    public Array2DNode(E item) {
        this.item = item; 
    }
    
    /**
     * Gets the item which this node holds.
     * 
     * @return the item in this node holds
     */
    public E getItem() {  return item;  }
    
    /**
     * Sets the node of this item to the specified item.
     * 
     * @param o the specified item this node will now hold
     */
    public void setItem(E o) {  item = o;  }
}
