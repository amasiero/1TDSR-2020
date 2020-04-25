
public class TesteVoo {
	public static void main(String[] args) {
		Voo voo = new Voo(123, new Data(25, 04, 2020));
		System.out.println(voo.proximoLivre());
		System.out.println(voo.verifica(20));
	}
}
