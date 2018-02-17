
public class AvlTree {

	public static TreeNode root;
	
	public AvlTree() {
		root=null;
	}
	
	public int showMax(int a,int b) {
		return (a>b) ? a:b;
	}
	
	public int setHeight1(TreeNode N) {
		if(N==null)
			return 0;
		return N.height;
	}
		
	public TreeNode rotateToRight(TreeNode y) {
		TreeNode x=y.left;
		TreeNode z=x.right;
		
		x.right=y;
		y.left=z;
		
		y.height=showMax(setHeight1(y.left),setHeight1(y.right))+1;
		x.height=showMax(setHeight1(x.left),setHeight1(x.right))+1;
		
		
		return x;
	}
	
	public TreeNode rotateToLeft(TreeNode x) {
		TreeNode y=x.right;
		TreeNode z=y.left;
		
		y.left=x;
		x.right=z;
		
		y.height=showMax(setHeight1(x.left),setHeight1(x.right))+1;
		x.height=showMax(setHeight1(y.left),setHeight1(y.right))+1;
		
		return y;
	}
	
	public int getBalance(TreeNode N) {
		if(N==null)
			return 0;
		return setHeight1(N.left)-setHeight1(N.right);
	}
	
	public TreeNode addElement(TreeNode node,int element){
		if(node==null)
			return (new TreeNode(element));
		
		if(element<node.key)
			node.left=addElement(node.left, element);
		else if(element>node.key)
			node.right=addElement(node.right, element);
		else
			return node;
		
		node.height=1+showMax(setHeight1(node.left),setHeight1(node.right));
		
		int balance=getBalance(node);
		
		if(balance>1 && element<node.left.key)
			return rotateToRight(node);
		
		if(balance<-1 && element>node.right.key)
			return rotateToLeft(node);
		
		if(balance>1 && element>node.left.key) {
			node.left=rotateToLeft(node.left);
			return rotateToRight(node);
		}
		
		if(balance<-1 && element<node.right.key) {
			node.right=rotateToRight(node.right);
			return rotateToLeft(node);
		}
		
		return node;
	}
	
	public static void preOrder(TreeNode node) {
		if(node!=null) {
			System.out.print(node.key+" ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	
	public static void main(String[] args) {
		AvlTree avlTree=new AvlTree();
	
		
		avlTree.root= avlTree.addElement(avlTree.root, 12);
		avlTree.root= avlTree.addElement(avlTree.root, 15);
		avlTree.root= avlTree.addElement(avlTree.root, 18);
		avlTree.root= avlTree.addElement(avlTree.root, 14);
		avlTree.root= avlTree.addElement(avlTree.root, 30);
		avlTree.root= avlTree.addElement(avlTree.root, 17);
		avlTree.root= avlTree.addElement(avlTree.root, 10);
		avlTree.root= avlTree.addElement(avlTree.root, 24);
		avlTree.root= avlTree.addElement(avlTree.root, 33);
		avlTree.root= avlTree.addElement(avlTree.root, 42);
		avlTree.root= avlTree.addElement(avlTree.root, 36);
		
		
		preOrder(avlTree.root);
	}

}
