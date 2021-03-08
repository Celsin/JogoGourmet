import javax.swing.JOptionPane;

public class Game {

	ArvoreBinaria ArvoreB;
	boolean infiniteLoop = true;

	public Game() {
		ArvoreB = new ArvoreBinaria();
	}

	private void setupGame() {
		ArvoreB.insert(null, "Massa", true);
		ArvoreB.insert(ArvoreB.root, "Lasanha", true);
		ArvoreB.insert(ArvoreB.root, "Bolo de chocolate", false);
	}

	public void startGame() {
		if (ArvoreB.isEmpty()) {
			setupGame();
		}

		int initialDialog = showInitialDialog();

		if (initialDialog == JOptionPane.CLOSED_OPTION) {
			infiniteLoop = false;
		}

		while (infiniteLoop) {
			guess(ArvoreB.root);
		}
	}

	public void guess(Node node) {
		String question = "O prato que você pensou é " + node.getValor() + "?";
		int answer = JOptionPane.showConfirmDialog(null, question, "Confirm", JOptionPane.YES_NO_OPTION);

		if (answer == JOptionPane.OK_OPTION) {
			if (node.Folha()) {
				win();
			} else {
				guess(node.getRFilho());
			}
		} else {
			if (node.getRFilho() == null) {
				askInformationAboutWrongGuess(node);
				startGame();
			} else {
				guess(node.getLFilho());
			}
		}
	}

	private int showInitialDialog() {
		Object[] options = { "Ok" };
		return JOptionPane.showOptionDialog(null, "Pense em um prato que gosta", "Jogo Gourmet",
				JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	}

	private void win() {
		JOptionPane.showMessageDialog(null, "Acertei de novo!");
		startGame();
	}

	private void askInformationAboutWrongGuess(Node node) {
		String playerThoughtIn = JOptionPane.showInputDialog("Qual prato você pensou?");
		String hint = JOptionPane.showInputDialog(playerThoughtIn + " é _________ mas " + node.getValor() + " não.");

		changeNodeToHintValue(node, hint, playerThoughtIn);
	}

	private void changeNodeToHintValue(Node node, String hint, String value) {
		String wrongGuess = node.getValor();
		node.setValor(hint);
		node.setLFilho(new Node(wrongGuess));
		node.setRFilho(new Node(value));
	}

}
