public class DriverBT 
{
	public static void main(String[] args)
	{
		System.out.println("1st Testing Example:");
		BinaryTree<String> aTree = new BinaryTree<>();
		createTree1(aTree);
		
		System.out.println("(binaryTree) post-order: ");
		aTree.postorderTraverse();
		
		System.out.println("(binaryNode) post-order: ");
		aTree.postorderTraverse_callBinaryNodeMethod();
		
		System.out.println();
		
		System.out.println("(BinaryTree) Height of tree is " + aTree.getHeight());
		System.out.println("(BinaryNode) Height of tree is " + aTree.getHeight_callBinaryNodeMethod());
		
		System.out.println();
		
		System.out.println("(BinaryTree) # nodes of tree is " + aTree.getNumberOfNodes());
		System.out.println("(BinaryNode) # nodes of tree is " + aTree.getNumberOfNodes_callBinaryNodeMethod());

		System.out.println("==========================================");
		System.out.println();
		
		System.out.println("2nd Testing Example:");
		BinaryTree<String> aTree2 = new BinaryTree<>();
		createTree2(aTree2);
		
		System.out.println("(binaryTree) post-order: ");
		aTree2.postorderTraverse();
		
		System.out.println("(binaryNode) post-order: ");
		aTree2.postorderTraverse_callBinaryNodeMethod();
		
		System.out.println();
		
		System.out.println("(BinaryTree) Height of tree is " + aTree2.getHeight());
		System.out.println("(BinaryNode) Height of tree is " + aTree2.getHeight_callBinaryNodeMethod());
		
		System.out.println();
		
		System.out.println("(BinaryTree) # nodes of tree is " + aTree2.getNumberOfNodes());
		System.out.println("(BinaryNode) # nodes of tree is " + aTree2.getNumberOfNodes_callBinaryNodeMethod());
		
		System.out.println("Done.");
	}  // end main

	public static void createTree1(BinaryTree<String> tree)
	{ 
		// Leaves
		BinaryTree<String> dTree = new BinaryTree<>("D");
		BinaryTree<String> eTree = new BinaryTree<>("E");
		BinaryTree<String> gTree = new BinaryTree<>("G");

		// Subtrees:
		BinaryTree<String> fTree = new BinaryTree<>("F", null, gTree);
		BinaryTree<String> bTree = new BinaryTree<>("B", dTree, eTree);
		BinaryTree<String> cTree = new BinaryTree<>("C", fTree, null);

		tree.setTree("A", bTree, cTree);
		
      System.out.println("\nGiven Tree:\n");
      System.out.println("     A      ");
      System.out.println("   /   \\  ");
      System.out.println("  B     C  ");
      System.out.println(" / \\   /  ");
      System.out.println("D   E  F   ");
      System.out.println("        \\ ");
      System.out.println("         G ");
      System.out.println();
	} // end createTree
	
	/**-------------------------------------------------------------------- */
	/**Task 4: Create a tree case as shown in assignment 3*/
	public static void createTree2(BinaryTree<String> tree)
	{ 
		BinaryNode<String> root = new BinaryNode<>("A");
		tree.setRootNode(root);

		BinaryTree<String> left = new BinaryTree<String>("B");

		BinaryTree<String> right = new BinaryTree<String>("C");
		
		tree.setTree("A", left, right);

		BinaryTree<String> leftSub = new BinaryTree<String>("D");

		BinaryTree<String> rightSub = new BinaryTree<String>("E");
		tree.setTree("C", leftSub, rightSub);

		BinaryTree<String> leftSub2= new BinaryTree<String>("F");

		tree.setTree("D", leftSub2,null);

		BinaryTree<String> leftSub3 = new BinaryTree<String>("G");

		BinaryTree<String> rightSub3 = new BinaryTree<String>("H");
		tree.setTree("E", leftSub3, rightSub3);




	} // end createTree2

}  // end DriverBT
