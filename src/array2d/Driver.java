package array2d;

public class Driver 
{
    public static void main(String[] args) 
    {
        // - - - - - - - - - - - Testing Array2DNode<E> - - - - - - - - - - - // 
        
        System.out.println("// - - - - - - - - - - - Testing Array2DNode<E> - - - - - - - - - - - //");
        System.out.println();
        Array2DNode<String> sNode1 = new Array2DNode<>();
        System.out.println("<<< sNode1 >>>>");
        System.out.println("sNode1.down = " + sNode1.down + " < - - Should be null");
        System.out.println("sNode1.right = " + sNode1.right + " < - - Should be null");
        System.out.println("sNode1's item = " + sNode1.getItem() + " < - - Should be null");
        System.out.println();
        
        Array2DNode<String> sNode2 = new Array2DNode<>("I am a String");
        System.out.println("<<< sNode2 >>>>");
        System.out.println("sNode2.down = " + sNode2.down + " < - - Should be null");
        System.out.println("sNode2.right = " + sNode2.right + " < - - Should be null");
        System.out.println("sNode2's item = " + sNode2.getItem() + " < - - Should be \"I am a String\"");
        System.out.println();
        
        Coor coordinate1 = new Coor(20, 13);
        Array2DNode<Coor> crdNode1 = new Array2DNode<>(coordinate1);
        System.out.println("<<< crdNode1 >>>>");
        System.out.println("crdNode1.down = " + crdNode1.down + " < - - null");
        System.out.println("crdNode1.right = " + crdNode1.right + " < - - Should be null");
        System.out.println("crdNode1's item =" + crdNode1.getItem() + " < - - (20, 13)");
        System.out.println();
        
        Coor coordinate2 = new Coor(19, 13);
        Array2DNode<Coor> crdNode2 = new Array2DNode<>(coordinate2);
        crdNode2.down = crdNode1;
        System.out.println("<<< crdNode2 >>>>  (crdNode1 was connected below it)");
        System.out.println("crdNode2.down = " + crdNode2.down.getItem() + " < - - Should be (20, 13)");
        System.out.println("crdNode2.right = " + crdNode2.right + " < - - Should be null");
        System.out.println("crdNode2's item =" + crdNode2.getItem() + " < - - (19, 13)");
        System.out.println();
        System.out.println();
        System.out.println();
        
        
        
        // - - - - - - - - - - Testing Array2D Contructors - - - - - - - - - //
        
        System.out.println("// - - - - - - - - - - Testing Array2D Contructors - - - - - - - - - //");
        System.out.println();
        Array2D<Integer> intArr = new Array2D<>();
        System.out.println("<<<< intArr >>>>");
        // Loop won't even execute since rowSize() is 0 and 0 < 0 is false
        for(int i = 0; i < intArr.rowSize(); i++) {
            for(int j = 0; j < intArr.colSize(); j++) 
                System.out.print(intArr.get(i, j) + " ");            
            System.out.println();
        }
        //intArr.get(0,0); // This will cause an error! (Index out of bounds since no nodes exist)
        System.out.println("Rows: " + intArr.rowSize() + ", Cols: " + intArr.colSize() + " < - - Should be 0 rows, 0 cols");    
        System.out.println();
        
        
        Array2D<String> strArr1 = new Array2D<>(3,4);
        System.out.println("<<<< strArr1 >>>>");                
        printList(strArr1);
        System.out.println();
        
        
        String[][] strs = new String[2][3];
        strs[0][0] = "(top left)";  strs[0][1] = "(top mid)";  strs[0][2] = "(top right)";
        strs[1][0] = "(btm left)";  strs[1][1] = "(btm mid)";  strs[1][2] = "(btm right)";
        
        Array2D<String> strArr2 = new Array2D<>(strs);
        System.out.println("<<<< strArr2 >>>>");                
        printList(strArr2);
        System.out.println(); 
        
        
        Array2D<Coor> crdArr1 = new Array2D<>(0, 3);
        System.out.println("<<<< crdArr1 >>>>");
        // Loop won't even execute since rowSize() is 0 and 0 < 0 is false
        for(int i = 0; i < crdArr1.rowSize(); i++) {
            for(int j = 0; j < crdArr1.colSize(); j++) 
                System.out.print(crdArr1.get(i, j) + " ");            
            System.out.println();
        }        
        //crdArr.get(0,0); // This should cause an error since no nodes exist yet
        //crdArr.get(1,2); // This should cause an error since no nodes exist yet
        /* 0 rows and 3 cols means that if you add one row, 3 nodes will be created at once.
           Therefore, the it becomes a 1 by 3 array2d -- 1 row (once added) and 3 cols */
        System.out.println("Rows: " + crdArr1.rowSize() + ", Cols: " + crdArr1.colSize()); 
        System.out.println();
        
        
        Array2D<Coor> crdArr2 = new Array2D<>(2, 0);
        System.out.println("<<<< crdArr2 >>>>");
        // Loop will even execute since rowSize() is 2
        for(int i = 0; i < crdArr2.rowSize(); i++) {
            for(int j = 0; j < crdArr2.colSize(); j++) // This inner loop won't execute since colSize() is 0 and 0 < 0 is false.
                System.out.print(crdArr2.get(i, j) + " ");            
            System.out.println(); // 2 new line will be printed since outer loop is executed.
        }
        //crdArr.get(0,0); // This should cause an error since no nodes exist yet
        //crdArr.get(1,2); // This should cause an error since no nodes exist yet
        /* 2 rows and 0 cols means that if you add one column, 2 nodes will be created at once.
           Therefore, the it becomes a 4 by 1 array2d -- 2 rows and 1 column (once added) */
        System.out.println("Rows: " + crdArr2.rowSize() + ", Cols: " + crdArr2.colSize()); 
        System.out.println();
        System.out.println();
        System.out.println();
        
        
        
        // - - - - - - - - - - - Testing addFirstCol() - - - - - - - - - - - //
        
        System.out.println("// - - - - - - - - - - - Testing addFirstCol() - - - - - - - - - - - //");
        System.out.println();
        System.out.println("<<<< intArr >>>>");
        System.out.println("Before Adding 1st Col: - - - - - -");
        printList(intArr);
        
        intArr.addFirstCol();
        
        System.out.println("After Adding 1st Col: - - - - - -");
        printList(intArr);
        System.out.println();
        
        
        System.out.println("<<<< strArr1 >>>>");
        System.out.println("Before Adding 1st Col: - - - - - -");
        printList(strArr1);
        
        strArr1.addFirstCol();
        
        System.out.println("After Adding 1st Col: - - - - - -");
        printList(strArr1);
        System.out.println();
        
        
        System.out.println("<<<< strArr2 >>>>");
        System.out.println("Before Adding 1st Col: - - - - - -");
        printList(strArr2);
        
        strArr2.addFirstCol();
        
        System.out.println("After Adding 1st Col: - - - - - -");
        printList(strArr2);
        System.out.println();
        
        
        System.out.println("<<<< crdArr1 >>>>");
        System.out.println("Before Adding 1st Col: - - - - - -");
        printList(crdArr1); 
        
        crdArr1.addFirstCol();
        
        System.out.println("After Adding 1st Col: - - - - - -");
        printList(crdArr1);
        System.out.println();
        
        
        System.out.println("<<<< crdArr2 >>>>");
        System.out.println("Before Adding 1st Col: - - - - - -");
        printList(crdArr2);
        
        crdArr2.addFirstCol();
        
        System.out.println("After Adding 1st Col: - - - - - -");
        printList(crdArr2); 
        System.out.println();
        System.out.println();
        System.out.println();
        
        
        
        // - - - - - - - - - - - Testing addFirstRow() - - - - - - - - - - - //
        
        System.out.println("// - - - - - - - - - - - Testing addFirstRow() - - - - - - - - - - - //");
        System.out.println();
        System.out.println("<<<< intArr >>>>");
        System.out.println("Before Adding 1st Row: - - - - - -");
        printList(intArr);
        
        intArr.addFirstRow();
        
        System.out.println("After Adding 1st Row: - - - - - -");
        printList(intArr);
        System.out.println();
        
        
        System.out.println("<<<< strArr1 >>>>");
        System.out.println("Before Adding 1st Row: - - - - - -");
        printList(strArr1);
        
        strArr1.addFirstRow();
        
        System.out.println("After Adding 1st Row: - - - - - -");
        printList(strArr1); 
        System.out.println();
        
        
        System.out.println("<<<< strArr2 >>>>");
        System.out.println("Before Adding 1st Row: - - - - - -");
        printList(strArr2);
        
        strArr2.addFirstRow();
        
        System.out.println("After Adding 1st Row: - - - - - -");
        printList(strArr2);
        System.out.println();
        
        
        System.out.println("<<<< crdArr1 >>>>");
        System.out.println("Before Adding 1st Row: - - - - - -");
        printList(crdArr1); 
        
        crdArr1.addFirstRow();
        
        System.out.println("After Adding 1st Row: - - - - - -");
        printList(crdArr1);
        System.out.println();
        
        
        System.out.println("<<<< crdArr2 >>>>");
        System.out.println("Before Adding 1st Row: - - - - - -");
        printList(crdArr2);
        
        crdArr2.addFirstRow();
        
        System.out.println("After Adding 1st Row: - - - - - -");
        printList(crdArr2);
        System.out.println();        
        System.out.println();
        System.out.println();
        
        
        
        
        // - - - - - - - - - - - Testing addLastCol() - - - - - - - - - - - //
        
        System.out.println("// - - - - - - - - - - - Testing addLastCol() - - - - - - - - - - - //");
        System.out.println();
        System.out.println("<<<< intArr >>>>");
        System.out.println("Before Adding Last Col: - - - - - -");
        printList(intArr);
        
        intArr.addLastCol();
        
        System.out.println("After Adding Last Col: - - - - - -");
        printList(intArr);
        System.out.println();
        
        
        System.out.println("<<<< strArr1 >>>>");
        System.out.println("Before Adding Last Col: - - - - - -");
        printList(strArr1);
        
        strArr1.addLastCol();
        
        System.out.println("After Adding Last Col: - - - - - -");
        printList(strArr1);
        System.out.println();
        
        
        System.out.println("<<<< strArr2 >>>>");
        System.out.println("Before Adding Last Col: - - - - - -");
        printList(strArr2);
        
        strArr2.addLastCol();
        
        System.out.println("After Adding Last Col: - - - - - -");
        printList(strArr2);
        System.out.println();
        
        
        System.out.println("<<<< crdArr1 >>>>");
        System.out.println("Before Adding Last Col: - - - - - -");
        printList(crdArr1); 
        
        crdArr1.addLastCol();
        
        System.out.println("After Adding Last Col: - - - - - -");
        printList(crdArr1);
        System.out.println();
        
        
        System.out.println("<<<< crdArr2 >>>>");
        System.out.println("Before Adding Last Col: - - - - - -");
        printList(crdArr2);
        
        crdArr2.addLastCol();
        
        System.out.println("After Adding Last Col: - - - - - -");
        printList(crdArr2); 
        System.out.println();
        System.out.println();
        System.out.println();
        
        
        
        // - - - - - - - - - - - Testing addLastRow() - - - - - - - - - - - //
        
        System.out.println("// - - - - - - - - - - - Testing addLastRow() - - - - - - - - - - - //");
        System.out.println();
        System.out.println("<<<< intArr >>>>");
        System.out.println("Before Adding Last Row: - - - - - -");
        printList(intArr);
        
        intArr.addLastRow();
        
        System.out.println("After Adding Last Row: - - - - - -");
        printList(intArr);
        System.out.println();
        
        
        System.out.println("<<<< strArr1 >>>>");
        System.out.println("Before Adding Last Row: - - - - - -");
        printList(strArr1);
        
        strArr1.addLastRow();
        
        System.out.println("After Adding Last Row: - - - - - -");
        printList(strArr1); 
        System.out.println();
        
        
        System.out.println("<<<< strArr2 >>>>");
        System.out.println("Before Adding Last Row: - - - - - -");
        printList(strArr2);
        
        strArr2.addLastRow();
        
        System.out.println("After Adding Last Row: - - - - - -");
        printList(strArr2);
        System.out.println();
        
        
        System.out.println("<<<< crdArr1 >>>>");
        System.out.println("Before Adding Last Row: - - - - - -");
        printList(crdArr1); 
        
        crdArr1.addLastRow();
        
        System.out.println("After Adding Last Row: - - - - - -");
        printList(crdArr1);
        System.out.println();
        
        
        System.out.println("<<<< crdArr2 >>>>");
        System.out.println("Before Adding Last Row: - - - - - -");
        printList(crdArr2);
        
        crdArr2.addLastRow();
        
        System.out.println("After Adding Last Row: - - - - - -");
        printList(crdArr2);
        System.out.println();        
        System.out.println();
        System.out.println();
        
        
        
        // - - - - - - - - - - - - Testing set() - - - - - - - - - - - - - - //
        
        System.out.println("// - - - - - - - - - - - - Testing set() - - - - - - - - - - - - - - //");
        System.out.println();
        System.out.println("<<<< intArr >>>>");
        System.out.println("Before Setting Any Values: - - - - - -");
        printList(intArr);
        
        intArr.set(0,0, 15163);
        
        System.out.println("After Setting Values: - - - - - -");
        printList(intArr);
        System.out.println();
        
        
        System.out.println("<<<< strArr1 >>>>");
        System.out.println("Before Setting Any Values: - - - - - -");
        printList(strArr1);
        
        strArr1.set(0,0, "<Top-Left>");
        strArr1.set(2,2, "<Somewhere in middle>");
        strArr1.set(4,5, "<Btm-Right>");
        
        System.out.println("After Setting Values: - - - - - -");
        printList(strArr1); 
        System.out.println();
        
        
        System.out.println("<<<< strArr2 >>>>");
        System.out.println("Before Setting Any Values: - - - - - -");
        printList(strArr2);
        
        strArr2.set(0,0, "<New Top-Left>");
        strArr2.set(2,1, "<Replaced by set()>");
        strArr2.set(3,4, "<New Btm-Right>");
        
        System.out.println("After Setting Values: - - - - - -");
        printList(strArr2);
        System.out.println();
        
        
        System.out.println("<<<< crdArr1 >>>>");
        System.out.println("Before Setting Any Values: - - - - - -");
        printList(crdArr1); 
        
        for(int x = 0; x < crdArr1.rowSize(); x++) {
            for(int y = 0; y < crdArr1.colSize(); y++)
                crdArr1.set(x, y, new Coor(x,y));
        }
        
        System.out.println("After Setting Values: - - - - - -");
        printList(crdArr1);
        System.out.println();
        
        
        System.out.println("<<<< crdArr2 >>>>");
        System.out.println("Before Setting Any Values: - - - - - -");
        printList(crdArr2);
        
        for(int x = 0; x < crdArr2.rowSize(); x++) {
            for(int y = 0; y < crdArr2.colSize(); y++)
                crdArr2.set(x, y, new Coor(x,y));
        }
        
        System.out.println("After Setting Values: - - - - - -");
        printList(crdArr2);
        System.out.println();
        System.out.println();
        System.out.println();
        
        
        // - - - - - - - - - - Testing getCol() - - - - - - - - - - - - - - //
        
        System.out.println("// - - - - - - - - - - - - Testing getCol() - - - - - - - - - - - - - - //");
        System.out.println();
        System.out.println("<<<< intArr >>>>");
        System.out.println("Getting Column with index 1 from intArr: - - - - - -");
        
        System.out.println(intArr.getCol(1).getItem());
        
        System.out.println("All Contents of intArr: - - - - - -");
        printList(intArr);
        System.out.println();
        
        
        System.out.println("<<<< strArr1 >>>>");
        System.out.println("Getting Column with index 0,2,4 from strArr1: - - - - - -");
        
        System.out.println(strArr1.getCol(0).getItem());
        System.out.println(strArr1.getCol(2).getItem());
        System.out.println(strArr1.getCol(4).getItem());
        
        System.out.println("All Contents of strArr1: - - - - - -");
        printList(strArr1); 
        System.out.println();
        
        
        System.out.println("<<<< strArr2 >>>>");
        System.out.println("Getting Column with index 0,2,3 from strArr2: - - - - - -");
        
        System.out.println(strArr2.getCol(0).getItem());
        System.out.println(strArr2.getCol(2).getItem());
        System.out.println(strArr2.getCol(3).getItem());
        
        System.out.println("All Contents of strArr2: - - - - - -");
        printList(strArr2);
        System.out.println();
        
        
        System.out.println("<<<< crdArr1 >>>>");
        System.out.println("Getting Column with index 1 from crdArr1: - - - - - -");
        
        System.out.println(crdArr1.getCol(1).getItem());
        
        System.out.println("All Contents of crdArr1: - - - - - -");
        printList(crdArr1);
        System.out.println();
        
        
        System.out.println("<<<< crdArr2 >>>>");
        System.out.println("Getting 2 Column with index 1 from crdArr2: - - - - - -");
        
        System.out.println(crdArr2.getCol(1).getItem());
        
        System.out.println("All Contents of crdArr2: - - - - - -");
        printList(crdArr2);
        System.out.println();
        System.out.println();
        System.out.println();
        
        
        
        
        // - - - - - - - - - - Testing getRow() - - - - - - - - - - - - - - //
        
        System.out.println("// - - - - - - - - - - - - Testing getRow() - - - - - - - - - - - - - - //");
        System.out.println();
        System.out.println("<<<< intArr >>>>");
        System.out.println("Getting Row with index 1 from intArr: - - - - - -");
        
        System.out.println(intArr.getRow(1).getItem());
        
        System.out.println("All Contents of intArr: - - - - - -");
        printList(intArr);
        System.out.println();
        
        
        System.out.println("<<<< strArr1 >>>>");
        System.out.println("Getting Row with index 0,2,4 from strArr1: - - - - - -");
        
        System.out.println(strArr1.getRow(0).getItem());
        System.out.println(strArr1.getRow(2).getItem());
        System.out.println(strArr1.getRow(4).getItem());
        
        System.out.println("All Contents of strArr1: - - - - - -");
        printList(strArr1); 
        System.out.println();
        
        
        System.out.println("<<<< strArr2 >>>>");
        System.out.println("Getting Row with index 0,2,3 from strArr2: - - - - - -");
        
        System.out.println(strArr2.getRow(0).getItem());
        System.out.println(strArr2.getRow(2).getItem());
        System.out.println(strArr2.getRow(3).getItem());
        
        System.out.println("All Contents of strArr2: - - - - - -");
        printList(strArr2);
        System.out.println();
        
        
        System.out.println("<<<< crdArr1 >>>>");
        System.out.println("Getting Row with index 1 from crdArr1: - - - - - -");
        
        System.out.println(crdArr1.getRow(1).getItem());
        
        System.out.println("All Contents of crdArr1: - - - - - -");
        printList(crdArr1);
        System.out.println();
        
        
        System.out.println("<<<< crdArr2 >>>>");
        System.out.println("Getting Row with index 1 from crdArr2: - - - - - -");
        
        System.out.println(crdArr2.getRow(1).getItem());
        
        System.out.println("All Contents of crdArr2: - - - - - -");
        printList(crdArr2);
        System.out.println();
        System.out.println();
        System.out.println();
        
        
        
        // - - - - - - - - - - - Testing deleteFirstCol() - - - - - - - - - - - //
        
        System.out.println("// - - - - - - - - - - - Testing deleteFirstCol() - - - - - - - - - - - //");
        System.out.println();
        System.out.println("<<<< intArr >>>>");
        System.out.println("Before Deleting 1st Col: - - - - - -");
        printList(intArr);
        
        intArr.deleteFirstCol();
        
        System.out.println("After Deleting 1st Col: - - - - - -");
        printList(intArr);
        System.out.println();
        
        
        System.out.println("<<<< strArr1 >>>>");
        System.out.println("Before Deleting 1st Col: - - - - - -");
        printList(strArr1);
        
        strArr1.deleteFirstCol();
        
        System.out.println("After Deleting 1st Col: - - - - - -");
        printList(strArr1);
        System.out.println();
        
        
        System.out.println("<<<< strArr2 >>>>");
        System.out.println("Before Deleting 1st Col: - - - - - -");
        printList(strArr2);
        
        strArr2.deleteFirstCol();
        
        System.out.println("After Deleting 1st Col: - - - - - -");
        printList(strArr2);
        System.out.println();
        
        
        System.out.println("<<<< crdArr1 >>>>");
        System.out.println("Before Deleting 1st Col: - - - - - -");
        printList(crdArr1); 
        
        crdArr1.deleteFirstCol();
        
        System.out.println("After Deleting 1st Col: - - - - - -");
        printList(crdArr1);
        System.out.println();
        
        
        System.out.println("<<<< crdArr2 >>>>");
        System.out.println("Before Deleting 1st Col: - - - - - -");
        printList(crdArr2);
        
        crdArr2.deleteFirstCol();
        
        System.out.println("After Deleting 1st Col: - - - - - -");
        printList(crdArr2); 
        System.out.println();
        System.out.println();
        System.out.println();
        
        
        
        // - - - - - - - - - - - Testing deleteFirstRow() - - - - - - - - - - - //
        
        System.out.println("// - - - - - - - - - - - Testing deleteFirstRow() - - - - - - - - - - - //");
        System.out.println();
        System.out.println("<<<< intArr >>>>");
        System.out.println("Before Deleting 1st Row: - - - - - -");
        printList(intArr);
        
        intArr.deleteFirstRow();
        
        System.out.println("After Deleting 1st Row: - - - - - -");
        printList(intArr);
        System.out.println();
        
        
        System.out.println("<<<< strArr1 >>>>");
        System.out.println("Before Deleting 1st Row: - - - - - -");
        printList(strArr1);
        
        strArr1.deleteFirstRow();
        
        System.out.println("After Deleting 1st Row: - - - - - -");
        printList(strArr1); 
        System.out.println();
        
        
        System.out.println("<<<< strArr2 >>>>");
        System.out.println("Before Deleting 1st Row: - - - - - -");
        printList(strArr2);
        
        strArr2.deleteFirstRow();
        
        System.out.println("After Deleting 1st Row: - - - - - -");
        printList(strArr2);
        System.out.println();
        
        
        System.out.println("<<<< crdArr1 >>>>");
        System.out.println("Before Deleting 1st Row: - - - - - -");
        printList(crdArr1); 
        
        crdArr1.deleteFirstRow();
        
        System.out.println("After Deleting 1st Row: - - - - - -");
        printList(crdArr1);
        System.out.println();
        
        
        System.out.println("<<<< crdArr2 >>>>");
        System.out.println("Before Deleting 1st Row: - - - - - -");
        printList(crdArr2);
        
        crdArr2.deleteFirstRow();
        
        System.out.println("After Deleting 1st Row: - - - - - -");
        printList(crdArr2);
        System.out.println();        
        System.out.println();
        System.out.println();
        
        
        
        
        // - - - - - - - - - - - Testing deleteLastCol() - - - - - - - - - - - //
        
        System.out.println("// - - - - - - - - - - - Testing deleteLastCol() - - - - - - - - - - - //");
        System.out.println();
        System.out.println("<<<< intArr >>>>");
        System.out.println("Before Deleting Last Col: - - - - - -");
        printList(intArr);
        
        intArr.deleteLastCol();
        
        System.out.println("After Deleting Last Col: - - - - - -");
        printList(intArr);
        System.out.println();
        
        
        System.out.println("<<<< strArr1 >>>>");
        System.out.println("Before Deleting Last Col: - - - - - -");
        printList(strArr1);
        
        strArr1.deleteLastCol();
        
        System.out.println("After Deleting Last Col: - - - - - -");
        printList(strArr1);
        System.out.println();
        
        
        System.out.println("<<<< strArr2 >>>>");
        System.out.println("Before Deleting Last Col: - - - - - -");
        printList(strArr2);
        
        strArr2.deleteLastCol();
        
        System.out.println("After Deleting Last Col: - - - - - -");
        printList(strArr2);
        System.out.println();
        
        
        System.out.println("<<<< crdArr1 >>>>");
        System.out.println("Before Deleting Last Col: - - - - - -");
        printList(crdArr1); 
        
        crdArr1.deleteLastCol();
        
        System.out.println("After Deleting Last Col: - - - - - -");
        printList(crdArr1);
        System.out.println();
        
        
        System.out.println("<<<< crdArr2 >>>>");
        System.out.println("Before Deleting Last Col: - - - - - -");
        printList(crdArr2);
        
        crdArr2.deleteLastCol();
        
        System.out.println("After Deleting Last Col: - - - - - -");
        printList(crdArr2); 
        System.out.println();
        System.out.println();
        System.out.println();
        
        
        
        // - - - - - - - - - - - Testing deleteLastRow() - - - - - - - - - - - //
        
        System.out.println("// - - - - - - - - - - - Testing deleteLastRow() - - - - - - - - - - - //");
        System.out.println();
        System.out.println("<<<< intArr >>>>");
        System.out.println("Before Deleting Last Row: - - - - - -");
        printList(intArr);
        
        intArr.deleteLastRow();
        
        System.out.println("After Deleting Last Row: - - - - - -");
        printList(intArr);
        System.out.println();
        
        
        System.out.println("<<<< strArr1 >>>>");
        System.out.println("Before Deleting Last Row: - - - - - -");
        printList(strArr1);
        
        strArr1.deleteLastRow();
        
        System.out.println("After Deleting Last Row: - - - - - -");
        printList(strArr1); 
        System.out.println();
        
        
        System.out.println("<<<< strArr2 >>>>");
        System.out.println("Before Deleting Last Row: - - - - - -");
        printList(strArr2);
        
        strArr2.deleteLastRow();
        
        System.out.println("After Deleting Last Row: - - - - - -");
        printList(strArr2);
        System.out.println();
        
        
        System.out.println("<<<< crdArr1 >>>>");
        System.out.println("Before Deleting Last Row: - - - - - -");
        printList(crdArr1); 
        
        crdArr1.deleteLastRow();
        
        System.out.println("After Deleting Last Row: - - - - - -");
        printList(crdArr1);
        System.out.println();
        
        
        System.out.println("<<<< crdArr2 >>>>");
        System.out.println("Before Deleting Last Row: - - - - - -");
        printList(crdArr2);
        
        crdArr2.deleteLastRow();
        
        System.out.println("After Deleting Last Row: - - - - - -");
        printList(crdArr2);
        System.out.println();
        System.out.println();
        System.out.println();
        
        // - - - - - - - - - - Testing addCol(index) - - - - - - - - - - - - //
        System.out.println("// - - - - - - - - - - Testing addCol(index) - - - - - - - - - - - - //");
        System.out.println();
        Coor[][] cor = new Coor[7][6]; 
        for(int i = 0; i < 7; i++) {
            for(int j = 0; j < 6; j++) {
                cor[i][j] = new Coor(i,j);
            }
        }
        
        Array2D<Coor> newCoorArr = new Array2D<>(cor);
        System.out.println("<<<< NewCoorArr >>>>");
        System.out.println("Before Inserting any columns: - - - - - - - - - - - - - - - - - - ");
        printList(newCoorArr);
        
        newCoorArr.addCol(4);
        
        System.out.println("After Inserting a column at INDEX 4: - - - - - - - - - - - - - - - ");
        printList(newCoorArr);
        
        newCoorArr.addCol(2);
        
        System.out.println("After Inserting a column at INDEX 2: - - - - - - - - - - - - - - - ");
        printList(newCoorArr);
        
        newCoorArr.addCol(0);
        
        System.out.println("After Inserting a column at INDEX 0: - - - - - - - - - - - - - - - ");
        printList(newCoorArr);
        System.out.println();
        System.out.println();
        System.out.println();
        
        
        
        
        // - - - - - - - - - - - Testing addRow(index) - - - - - - - - - - - - - //
        System.out.println("// - - - - - - - - - - - Testing addRow(index) - - - - - - - - - - - - - //");
        System.out.println();
        System.out.println("<<<< NewCoorArr >>>>");
        System.out.println("Before Inserting any rows: - - - - - - - - - - - - - - - - - - ");
        printList(newCoorArr);
        
        newCoorArr.addRow(3);
        
        System.out.println("After Inserting a row at INDEX 3: - - - - - - - - - - - - - - - ");
        printList(newCoorArr);
        
        newCoorArr.addRow(7);
        
        System.out.println("After Inserting a row at INDEX 7: - - - - - - - - - - - - - - - ");
        printList(newCoorArr);
        
        newCoorArr.addRow(2);
        
        System.out.println("After Inserting a row at INDEX 2: - - - - - - - - - - - - - - - ");
        printList(newCoorArr);
        System.out.println();
        System.out.println();
        System.out.println();
        
        
        
        // - - - - - - - - - - Testing deleteCol(index) - - - - - - - - - - - - //
        System.out.println("// - - - - - - - - - - Testing deleteCol(index) - - - - - - - - - - - - //");
        System.out.println();
        
        System.out.println("<<<< NewCoorArr >>>>");
        System.out.println("Before Deleting any columns: - - - - - - - - - - - - - - - - - - ");
        printList(newCoorArr);
        
        newCoorArr.deleteCol(4);
        
        System.out.println("After Deleting a column at INDEX 4: - - - - - - - - - - - - - - - ");
        printList(newCoorArr);
        
        newCoorArr.deleteCol(2);
        
        System.out.println("After Deleting a column at INDEX 2: - - - - - - - - - - - - - - - ");
        printList(newCoorArr);
        
        newCoorArr.deleteCol(0);
        
        System.out.println("After Deleting a column at INDEX 0: - - - - - - - - - - - - - - - ");
        printList(newCoorArr);
        System.out.println();
        System.out.println();
        System.out.println();
        
        
        
        
        // - - - - - - - - - - - Testing deleteRow(index) - - - - - - - - - - - - - //
        System.out.println("// - - - - - - - - - - - Testing deleteRow(index) - - - - - - - - - - - - - //");
        System.out.println();
        System.out.println("<<<< NewCoorArr >>>>");
        System.out.println("Before Deleting any rows: - - - - - - - - - - - - - - - - - - ");
        printList(newCoorArr);
        
        newCoorArr.deleteRow(3);
        
        System.out.println("After Deleting a row at INDEX 3: - - - - - - - - - - - - - - - ");
        printList(newCoorArr);
        
        newCoorArr.deleteRow(7);
        
        System.out.println("After Deleting a row at INDEX 7: - - - - - - - - - - - - - - - ");
        printList(newCoorArr);
        
        newCoorArr.deleteRow(2);
        
        System.out.println("After Deleting a row at INDEX 2: - - - - - - - - - - - - - - - ");
        printList(newCoorArr);       
        
        System.out.println();
        System.out.println();
        System.out.println("Throught this main method there are many examples of the:"
                + "\n   get() \n   rowSize() \n   colSize() \nmethods in use.");
        System.out.println();
    }
    
    private static void printList(Array2D<?> list) 
    {
        for(int i = 0; i < list.rowSize(); i++) {
            System.out.print("   ");
            for(int j = 0; j < list.colSize(); j++) 
                System.out.print(list.get(i, j) + " ");            
            System.out.println();
        }
        System.out.println("   Rows: " + list.rowSize() + ", Cols: " + list.colSize()); 
    }
}