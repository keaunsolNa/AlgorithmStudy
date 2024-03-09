import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    
    	private static class Node{
		char root;
		Node left;
		Node right;
		
		Node(char root, Node left, Node right){
			this.root = root;
			this.left = left;
			this.right = right;
		}
	}

	private static Node head = new Node('A', null, null);
	private static void insertNode(Node temp, char root, char left, char right) {
		
		
		if (temp.root == root) {
			
			temp.left = (left == '.' ? null : new Node(left, null, null));
			temp.right = (right == '.' ? null : new Node(right, null, null)); 
		}
		
		else {
			
			if(temp.left != null) insertNode(temp.left, root, left, right);
			if(temp.right != null) insertNode(temp.right, root, left, right);
			
		}
		
	}
    
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        
        int T = Integer.parseInt(br.readLine());
        
        while(T --> 0) {
        	st = new StringTokenizer(br.readLine());
        	
        	insertNode(head, st.nextToken().charAt(0), st.nextToken().charAt(0), st.nextToken().charAt(0));
        }

        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
	}
    
	private static void preOrder(Node node) {
		
		if(node == null) return;
		System.out.print(node.root);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	private static void inOrder(Node node) {
		
		if(node == null) return;
		inOrder(node.left);
		System.out.print(node.root);
		inOrder(node.right);
	}
	
	private static void postOrder(Node node) {
		
		if(node == null) return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.root);
	}
}
