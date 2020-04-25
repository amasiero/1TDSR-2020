
public class TesteData {
	public static void main(String[] args) {
		Data data =  new Data(-1, 2, -2202);
		System.out.println(data);
		
		data =  new Data(24, 4, 2020);
		System.out.println(data);
		
		Data data2 = data.clone();
		System.out.println(data2);
		System.out.println(data == data2);
		System.out.println(data.compara(data2));
		System.out.println(data.isBissexto());
	}
}
