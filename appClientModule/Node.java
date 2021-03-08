
public class Node {

	private String Valor;
	private Node LFilho;
	private Node RFilho;

	public Node(String data) {
		Valor = data;
	}
	
	
	public boolean Folha() {
		return LFilho == null && RFilho == null;
	}



	
	public void setValor(String Valor) {
		this.Valor = Valor;
	}

	public String getValor() {
		return Valor;
	}

	public void setLFilho(Node LFilho) {
		this.LFilho = LFilho;
	}

	public Node getLFilho() {
		return LFilho;
	}

	public void setRFilho(Node RFilho) {
		this.RFilho = RFilho;
	}

	public Node getRFilho() {
		return RFilho;
	}
	

}
