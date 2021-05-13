import javax.swing.JTextArea;

public class BinarySearchTree {
	static final int COUNT = 10; 
	 Node root;
	 
	    // Constructor
	    BinarySearchTree()
	    {
	         root = null;
	    }
	 
	    // This method mainly calls insertRec()
	    void insert(int key)
	    {
	         root = insertRec(root, key);
	    }
	 
	    /* A recursive function to
	       insert a new key in BST */
	    Node insertRec(Node root, int key)
	    {
	 
	        /* If the tree is empty,
	           return a new node */
	        if (root == null)
	        {
	            root = new Node(key);
	            return root;
	        }
	 
	        /* Otherwise, recur down the tree */
	        if (key < root.key)
	            root.left = insertRec(root.left, key);
	        else if (key > root.key)
	            root.right = insertRec(root.right, key);
	 
	        /* return the (unchanged) node pointer */
	        return root;
	    }
	    public  void print2DUtil(Node root, int space,JTextArea a) 
	    { 
	    	String text = "";
	        // Base case 
	        if (root == null) 
	            return ; 
	      
	        // Increase distance between levels 
	        space += COUNT; 
	      
	        // Process right child first 
	        print2DUtil(root.right, space,a); 
	      
	        // Print current node after space 
	        // count 
	        //text+="\n";
	        a.append("\n");
	        System.out.print("\n"); 
	        for (int i = COUNT; i < space; i++) { 
	        	a.append(" ");
	        	//text+=" ";}
	            System.out.print(" "); }
	        //text+=(root.key + "\n");
	        System.out.print(root.key + "\n"); 
	        a.append(root.key + "\n");
	      
	        // Process left child 
	        print2DUtil(root.left, space,a); 
	        
	        
	    } 
	      
	    // Wrapper over print2DUtil() 
	   public  void print2D(JTextArea b) 
	    { 
	        // Pass initial space count as 0 
	        print2DUtil(this.root, 0,b); 
	    } 
	   void deleteKey(int key) { root = deleteRec(root, key); }
	   
	    /* A recursive function to
	      delete an existing key in BST
	     */
	    Node deleteRec(Node root, int key)
	    {
	        /* Base Case: If the tree is empty */
	        if (root == null)
	            return root;
	 
	        /* Otherwise, recur down the tree */
	        if (key < root.key)
	            root.left = deleteRec(root.left, key);
	        else if (key > root.key)
	            root.right = deleteRec(root.right, key);
	 
	        // if key is same as root's
	        // key, then This is the
	        // node to be deleted
	        else {
	            // node with only one child or no child
	            if (root.left == null)
	                return root.right;
	            else if (root.right == null)
	                return root.left;
	 
	            // node with two children: Get the inorder
	            // successor (smallest in the right subtree)
	            root.key = minValue(root.right);
	 
	            // Delete the inorder successor
	            root.right = deleteRec(root.right, root.key);
	        }
	        
	 
	        return root;
	    }
	    int minValue(Node root)
	    {
	        int minv = root.key;
	        while (root.left != null)
	        {
	            minv = root.left.key;
	            root = root.left;
	        }
	        return minv;
	    }
}
