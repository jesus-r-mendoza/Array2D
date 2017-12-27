 package array2d;

/**
 * A two-dimensional data type of {@code Array2DNode}s which hold objects, of the
 * specified type. Each node points to the subsequent Node both below it and to
 * its right, if present, otherwise it points to a {@code null} value (indicating 
 * that there aren't any more Nodes, towards that direction, beyond that element).
 * In such case, these nodes are linked to the consecutively right and lower 
 * nodes of the {@code Arra2D}.
 * 
 * @author    Jesus Mendoza
 * @param <E> Specified type of element that will be contained within the nodes
 *            in this {@code Array2D}.
 * @see       Array2DNode
 */
public class Array2D <E> 
{
    /**
     * The number of rows this {@code Array2D} has. Note: The number of rows 
     * can be different from the number of columns.
     */
    private int rows;
    
    /**
     * The number of columns this {@code Array2D} has. Note: The number of 
     * columns can be different from the number of rows.
     */
    private int cols;
    
    /** 
     * Reference to the node at position (0,0), if such node exists.
     */
    private Array2DNode<E> head;
    
    /**
     * Constructs an {@code Array2D} with 0 rows and 0 columns; consequently,
     * no {@code Array2dNode}s are constructed.
     */
    public Array2D() {
        rows = 0;
        cols = 0;
        head = null;
    }
    
    /**
     * Constructs an {@code Array2D} with the specified number of columns and
     * rows, and constructs empty {@code Arra2DNode}s (which exists but do not
     * hold any object yet) at each position.
     * 
     * @param rowsIn the number of rows this {@code Array2D} will have
     * @param colsIn the number of columns this {@code Array2D} will have
     */
    public Array2D(int rowsIn, int colsIn) 
    {
        if(rowsIn < 0 || colsIn < 0) 
            throw new IllegalArgumentException("Cannot create an Array2D with: " 
                                        + rowsIn + " rows, " + colsIn + " cols.");
                
        cols = colsIn;
        
        for(int i = 0; i < rowsIn; i++) 
            this.addLastRow();      
        
        rows = rowsIn;
    }
    
    /**
     * Constructs an {@code Array2D} from a provided two-dimensional array of 
     * elements. Each element of the two-dimensional array will be converted to 
     * an {@code Array2DNode} in this {@code Array2D}.
     * 
     * @param elms the provided two-dimensional that will be transformed into an
     *             {@code Array2D} filled with the corresponding elements.
     */
    public Array2D(E[][] elms) {
        
        if(elms == null)
            throw new NullPointerException("Provided array is null.");
        
        int tempCols = elms[0].length;
        int tempRows = elms.length;
                
        cols = tempCols;
        
        for(int a = 0; a < tempRows; a++)
            this.addFirstRow();
        
        rows = tempRows;
        
        for(int x = 0; x < tempRows; x++) {
            for(int y = 0; y < tempCols; y++) {
                this.set(x, y, elms[x][y]);
            }
        }
    }
        
    /**
     * Adds an entire empty column of {@code Array2DNode}s to the first (left most)
     * column of this {@code Array2D}. If this method is called when the rows are equal to zero, 
     * then no column will be added, BUT the "specified potential" number of columns will 
     * increase by 1 (columns += 1) and no node are created.
     */
    public void addFirstCol()
    {
        if(rows > 0) 
        {
            if(head == null) {
                this.addLastCol();
            }
            else 
            {
                Array2DNode<E> curr = new Array2DNode<>();
                Array2DNode<E> next;
                curr.right = head;
                head = curr;
                next = curr.right;
                for(int i = 0; i < rows-1; i++) 
                {
                    curr.down = new Array2DNode<>();
                    curr = curr.down;
                    next = next.down;
                    curr.right = next;
                }
                cols++;
            }
        }
        else
            cols++;
    }
    
    /**
     * Adds an entire row of empty {@code Array2DNode}s to the first (top most) 
     * row of this {@code Array2D}. If this method is called when either the
     * rows or columns are equal to zero, then no row will be added.
     */
    public void addFirstRow() 
    {
        if(cols > 0) 
        {
            if(head == null) {
                this.addLastRow();
            }
            else 
            {
                Array2DNode<E> curr = new Array2DNode<>();
                Array2DNode<E> low;
                curr.down = head;
                head = curr;
                low = curr.down;
                for(int i = 0; i < cols-1; i++) 
                {
                    curr.right = new Array2DNode<>();
                    curr = curr.right;
                    low = low.right;                
                    curr.down = low;
                }
                rows++;
            }
        }
        else
            rows++;
    }
    
     /**
     * Adds an entire column of empty {@code Array2DNode}s to the end of this 
     * {@code Array2D}. <b>If there are no existing columns <i>AND</i> the number of rows 
     * has been previously specified during instantiation, then {@code addLastCol()}
     * will add a column (making it the first, existing column of this {@code Array2D}).
     * Otherwise no nodes will be created and the "specified potential" of columns will increase by one.</b>
     * 
     * <pre>
     * <code>
     *  Example 1:
     * 
     *     Array2D{@literal <String>} arr1 = new Array2D{@literal <>}(2,0); // This will create an Array2D 
     *                                                  // without any nodes but with the 
     *                                                  // "specified potential" of 2 rows.
     *                                                  // No nodes exist yet ~ 2 by 0 Array2D ~.
     *     
     *     arr1.addLastCol();         // This will add the first column with 2 rows ~ 2 by 1 Array2D ~.
     *     arr1.addLastCol();  // This will add a column to the end (second column) ~ 2 by 2 Array2D ~.
     * 
     *  Example 2:
     * 
     *     Array2D{@literal <String>} arr2 = new Array2D{@literal <>}(0,4); // This will create an Array2D 
     *                                                  // without any nodes but with the 
     *                                                  // "specified potential" of 4 columns.
     *                                                  // No nodes exist yet ~ 0 by 4 Array2D ~.
     * 
     *     arr2.addLastCol();   // This will not add a column, since the array wouldn't know
     *                          // the number of rows to add to this column. But it increases the 
     *                          // "specified potential" number of columns by 1. 
     *                          // ~ 0 by 5 Array2D ~ (Still no nodes exist)
     * 
     *     arr2.addLastCol();   // This won't add a column, still for the same reason as above. 
     *                          // However, the "specified potential" number of columns increases by 1. 
     *                          // ~ 0 by 6 Array2D ~ (Still no nodes exist)
     * 
     *     // arr2.addLastRow(); // This will now add the first row of nodes, since it was 
     *                           // specified that there were to be 4 columns. 
     *                           // ~ 1 by 4 Array2D ~ (4 nodes exist now)
     * </code>
     * </pre>
     */
    public void addLastCol() 
    {
        if(rows > 0) 
        {
            Array2DNode<E> curr;
            Array2DNode<E> prev;

            if(head != null) 
            {
                curr = head;
                while(curr.right != null) 
                {
                    prev = curr;
                    curr = curr.right;
                }  
                curr.right = new Array2DNode<>();
                prev = curr;
                curr = curr.right;

                for(int i = 0; i < rows-1; i++) 
                {
                    curr.down = new Array2DNode<>();
                    prev = prev.down;
                    curr = curr.down;
                    prev.right = curr;
                }
            }
            else 
            {
                curr = new Array2DNode<>();
                head = curr;

                for(int i = 0; i < rows-1; i++) 
                {
                    curr.down = new Array2DNode<>();
                    curr = curr.down; 
                }
            }
            cols++;
        }
        else
            cols++;
    }
    
    /**
     * Adds an entire row of empty {@code Array2DNode}s to the end of this 
     * {@code Array2D}. <b>If there are no existing rows <i>AND</i> the number of columns 
     * has been previously specified during instantiation, then {@code addLastRow()}
     * will add a row (making it the first, existing row of this {@code Array2D}).
     * Otherwise no nodes will be created and the "specified potential" of rows will increase by one.</b>
     * 
     * <pre>
     * <code>
     *  Example 1:
     * 
     *     Array2D{@literal <String>} arr3 = new Array2D{@literal <>}(0,3); // This will create an Array2D 
     *                                                  // without any nodes but with the 
     *                                                  // "specified potential" of 3 columns.
     *                                                  // No nodes exist yet ~ 0 by 3 Array2D ~.
     * 
     *     arr3.addLastRow();   // This will add the first row with 3 columns ~ 1 by 3 Array2D ~.
     *     arr3.addLastRow();  // This will add a row to the end (second row) ~ 2 by 3 Array2D ~.
     * 
     *  Example 2:
     * 
     *     Array2D{@literal <String>} arr4 = new Array2D{@literal <>}(4,0); // This will create an Array2D 
     *                                                  // without any nodes but with the 
     *                                                  // "specified potential" of 4 rows.
     *                                                  // No nodes exist yet ~ 4 by 0 Array2D ~.
     * 
     *     arr4.addLastRow();   // This will not add a row, since the array wouldn't know
     *                          // the number of columns to add to this row, 
     *                          // but the "specified potential" rows will increase by one. 
     *                          // ~ 5 by 0 Array2D ~ (Still no nodes exist)
     * 
     *     arr4.addLastRow();   // This won't add a row, still for the same reason as above.
     *                          // but the "specified potential" rows will increase by one. 
     *                          // ~ 6 by 0 Array2D ~ (Still no nodes exist)
     * 
     * 
     *     // arr4.addLastCol(); // This will now add the first column of nodes, since it was 
     *                           // specified that there were to be 6 rows. 
     *                           // ~ 6 by 1 Array2D ~ (6 nodes now exist)
     * </code>
     * </pre>
     */
    public void addLastRow() 
    {
        if(cols > 0) 
        {
            Array2DNode<E> curr;
            Array2DNode<E> top;

            if(head != null) 
            {
                curr = head;
                while(curr.down != null) 
                {
                    top = curr;
                    curr = curr.down;
                }  
                curr.down = new Array2DNode<>();
                top = curr;
                curr = curr.down;

                for(int i = 0; i < cols-1; i++) 
                {
                    curr.right = new Array2DNode<>();
                    top = top.right;
                    curr = curr.right;
                    top.down = curr;
                }
            }
            else {
                curr = new Array2DNode<>();
                head = curr;

                for(int i = 0; i < cols-1; i++) 
                {
                    curr.right = new Array2DNode<>();
                    curr = curr.right; 
                }
            }
            rows++;
        }
        else
            rows++;
    }
    
    /**
     * Inserts an entire column of {@code Array2DNode}s to the specified index. Index
     * values between zero and the current number of columns. By inputting: an index
     * of zero the column will be added to the beginning, an index equivalent to
     * the number of columns then the it will be added to the end, and an index 
     * between those values will insert the column at that index - right shifting
     * all subsequent columns.
     * 
     * @param index the specified index to insert the column into
     */
    public void addCol(int index) 
    {
        if(index < 0 || index > cols)
            throw new IndexOutOfBoundsException("Invalid Index. Cols: " + cols 
                + " - Col Index: " + index);
        else if(index == 0) {
            this.addFirstCol();
        }
        else if(index == cols) {
            this.addLastCol();
        }
        else if(cols > 0) {
            Array2DNode<E> curr = new Array2DNode<>();
            Array2DNode<E> prev = this.getCol(index-1);
            Array2DNode<E> after = this.getCol(index);
            prev.right = curr;
            curr.right = after;
            
            while(prev.down != null) {
                prev = prev.down;
                Array2DNode<E> newest = new Array2DNode<>();
                curr.down = newest;
                curr = newest;
                after = after.down;
                
                prev.right = curr;
                curr.right = after;
            }
            cols++;
        }
    }
    
    /**
     * Inserts an entire row of {@code Array2DNode}s to the specified index. Index
     * values between zero and the current number of rows. By inputting: an index
     * of zero the row will be added to the beginning, an index equivalent to
     * the number of rows then the it will be added to the end, and an index 
     * between those values will insert the row at that index - down shifting
     * all subsequent rows.
     * 
     * @param index the specified index to insert the row into
     */
    public void addRow(int index) 
    {
        if(index < 0 || index > rows)
            throw new IndexOutOfBoundsException("Invalid Index. Rows: " + rows 
                + " - Row Index: " + index);
        else if(index == 0) {
            this.addFirstRow();
        }
        else if(index == rows) {
            this.addLastRow();
        }
        else if(rows > 0) {
            Array2DNode<E> curr = new Array2DNode<>();
            Array2DNode<E> top = this.getRow(index-1);
            Array2DNode<E> btm = this.getRow(index);
            top.down = curr;
            curr.down = btm;
            
            while(top.right != null) {
                top = top.right;
                Array2DNode<E> newest = new Array2DNode<>();
                curr.right = newest;
                curr = newest;
                btm = btm.right;
                
                top.down = curr;
                curr.down = btm;
            }
            rows++;
        }
    }
    
    /**
     * Deletes the first column of the {@code Array2D}. If there are no more
     * columns then nothing will occur.
     */
    public void deleteFirstCol() 
    {
        if(head != null) 
        {
            Array2DNode<E> same;
            same = head;
            head = head.right;
            same = null;
            cols--;
        }
    }

    /**
     * Deletes the first row of the {@code Array2D}. If there are no more
     * rows then nothing will occur.
     */
    public void deleteFirstRow() 
    {
        if(head != null) 
        {
            Array2DNode<E> same;
            same = head;
            head = head.down;
            same = null;
            rows--;
        }
    }
    
    /**
     * Deletes the last column of the {@code Array2D}. If there are no more
     * columns then nothing will occur.
     */
    public void deleteLastCol() 
    {
        if(head != null) 
        {
            if(cols <= 1) 
                head = null;            
            else {
                Array2DNode<E> curr;
                Array2DNode<E> prev;
                curr = head;
                prev = curr;
                while(curr.right != null) 
                {
                    prev = curr;
                    curr = curr.right;
                }
                prev.right = null;
                curr = null;
            }
            cols--;
        }
    }
    
    /**
     * Deletes the last row of the {@code Array2D}. If there are no more
     * rows then nothing will occur.
     */
    public void deleteLastRow() 
    {
        if(head != null) 
        {
            if(rows <= 1) 
                head = null;            
            else {
                Array2DNode<E> curr;
                Array2DNode<E> top;
                curr = head;
                top = curr;
                while(curr.down != null) 
                {
                    top = curr;
                    curr = curr.down;
                }
                top.down = null;
                curr = null;
            }
            rows--;
        }
    }
    
    public void deleteCol(int index) {
        if(index < 0 || index > cols - 1)
            throw new IndexOutOfBoundsException("Invalid Index. Cols: " + cols 
                + " - Col Index: " + index);
        else if(index == 0) {
            this.deleteFirstCol();
        }
        else if(index == cols - 1) {
            this.deleteLastCol();
        }
        else {
            Array2DNode<E> prev = getCol(index - 1);
            Array2DNode<E> after = getCol(index + 1);
            prev.right = after;
            
            while(prev.down != null) {
                prev = prev.down;
                after = after.down;
                
                prev.right = after;
            }
            cols--;
        }
    }
    
    public void deleteRow(int index) {
        if(index < 0 || index > rows - 1)
            throw new IndexOutOfBoundsException("Invalid Index. Rows: " + rows 
                + " - Row Index: " + index);
        else if(index == 0) {
            this.deleteFirstRow();
        }
        else if(index == rows - 1) {
            this.deleteLastRow();
        }
        else {
            Array2DNode<E> top = getRow(index - 1);
            Array2DNode<E> btm = getRow(index + 1);
            top.down = btm;
            
            while(top.right != null) {
                top = top.right;
                btm = btm.right;
                
                top.down = btm;
            }
            rows--;        
        }
    }
    
    /**
     * Gets the item that the node at the specified location holds.
     * @param  r  the row index of the node 
     * @param  c  the column index of the node
     * @return    the item held in this node
     */
    public E get(int r, int c) {   
        return this.goTo(r, c).getItem();
    }
    
    /**
     * Gets the first {@code Array2DNode} of the specified column. Meaning the 
     * (top most) node of that column.
     * 
     * @param c the index of the column
     * @return  the first {@code Array2DNode} at the specified column
     */
    public Array2DNode<E> getCol(int c) {
        return this.goTo(0, c);
    }
    
    /**
     * Gets the first {@code Array2DNode} of the specified row. Meaning the 
     * (left most) node of that row.
     * 
     * @param r the index of the row
     * @return  the first {@code Array2DNode} at the specified row
     */
    public Array2DNode<E> getRow(int r) {
        return this.goTo(r, 0);
    }
    
    /**
     * Sets the item for the node at the specified location.
     * 
     * @param  r   the row index of the node
     * @param  c   the column index of the node
     * @param item the specified item that this node will now hold
     */
    public void set(int r, int c, E item) {
        this.goTo(r, c).setItem(item);
    }
    
    /**
     * Returns the number of columns this {@code Array2D} has.
     * 
     * @return the number of columns
     */
    public int colSize() {
        return cols;
    }
    
    /**
     * Returns the number of rows this {@code Array2D} has.
     * 
     * @return the number of rows
     */
    public int rowSize() {
        return rows;
    }
    
    /**
     * Traverses through the {@code Array2D} until it reaches the node at the 
     * specified location, then it returns that node.
     * 
     * @param r the row index of the node
     * @param c the column index of the node
     * @return  the node at that location
     */
    private Array2DNode<E> goTo(int r, int c) 
    {
        this.checkIndex(r, c);
        
        Array2DNode<E> curr;
        curr = head;
        
        for(int a = 0; a < r; a++) 
            curr = curr.down;
        
        for(int b = 0; b < c; b++) 
            curr = curr.right;
        
        return curr;
    }
    
    /**
     * Checks whether the given indexes are within the bounds of this 
     * {@code Array2D}.
     * 
     * @param r the row index that will be checked
     * @param c the column index that will be checked
     */
    private void checkIndex(int r, int c) 
    {
        if(r < 0 || r >= rows || c < 0 || c >= cols) 
        {
            throw new IndexOutOfBoundsException("Invalid Index. Rows: " + rows + ", Cols: " + cols 
                    + " -- Index Given (Row, Col): (" + r + ", " + c + ")");
        }
    }
}