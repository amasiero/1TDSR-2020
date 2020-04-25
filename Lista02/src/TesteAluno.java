import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class TesteAluno {
	
	public static void main(String[] args) {
	
		int matricula = Integer.parseInt(JOptionPane.showInputDialog("Informe sua matricula"));
		String nome = JOptionPane.showInputDialog("Informe seu nome");
		
		Aluno aluno = new Aluno(matricula, nome);
		
		double nota = Double.parseDouble(JOptionPane.showInputDialog("Informe a nota da prova 1"));
		aluno.setProva1(nota);
		
		nota = Double.parseDouble(JOptionPane.showInputDialog("Informe a nota da prova 2"));
		aluno.setProva2(nota);
		
		nota = Double.parseDouble(JOptionPane.showInputDialog("Informe a nota do trabalho"));
		aluno.setTrabalho(nota);
		
		double media = aluno.calculaMedia();
		double avaliacaoFinal = aluno.calculaAvaliacaoFinal();
		
		DecimalFormat formataNota = new DecimalFormat("#0.0");
		String precisaFinal = avaliacaoFinal == 0 ? "O aluno não precisa realizar a avaliação final " :
			"O aluno precisa obter " + formataNota.format(avaliacaoFinal) + " pontos para continuar sua jornada."; 
				
		String resultado = "O aluno " + aluno.getNome() + " ficou com a média " + 
				formataNota.format(media) + ".\n" + precisaFinal;
				
		JOptionPane.showMessageDialog(null, resultado);
		
		
	}
}
