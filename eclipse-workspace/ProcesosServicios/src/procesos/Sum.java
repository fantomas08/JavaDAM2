package procesos;

public class Sum {

	public int sum(int n1, int n2) {
		int result = 0;
		for (int i = n1; i <= n2; ++i) {
			result += i;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Sum s = new Sum();
		int n1=Integer.parseInt(args[0]);
		int n2=Integer.parseInt(args[1]);
		int resultado=s.sum(n1, n2);
		System.out.println(resultado);
	}
	
}
