
public class AppJogo {
	
	public static void main(String[] args) {
	
		Jogador jogador1 = new Jogador("Allen");
		Jogador jogador2 = new Jogador("Israel");
		JogoDados jogo = new JogoDados(jogador1, jogador2);
		
		jogo.joga();
		System.out.println(jogo.vencedor());
		
		jogo.joga();
		System.out.println(jogo.vencedor());
		
		jogo.joga();
		System.out.println(jogo.vencedor());
		
		System.out.println(jogo.vePlacar());
		
		jogo.reinicia();
	}
	
}
