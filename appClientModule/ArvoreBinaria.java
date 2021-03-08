
public class ArvoreBinaria {

	Node root;

	public void insert(Node parentNode, String value, boolean choice) {
		root = insertNewNode(parentNode, value, choice);
	}

	public void showTree(Node rootNode) {
		if (rootNode != null) {
			System.out.println(rootNode.getValor());
			showTree(rootNode.getLFilho());
			showTree(rootNode.getRFilho());
		}
	}

	
	public boolean isEmpty() {
		return root == null;
	}

	
	private Node insertNewNode(Node parentNode, String Valor, boolean choice) {
		if (parentNode == null) {
			parentNode = new Node(Valor);
			return parentNode;
		} else if (choice) {
			parentNode.setRFilho(insertNewNode(parentNode.getRFilho(), Valor, choice));
		} else {
			parentNode.setLFilho(insertNewNode(parentNode.getLFilho(), Valor, choice));
		}

		return parentNode;
	}

}
