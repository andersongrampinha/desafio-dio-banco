package app;

public class ContaCorrente extends Conta{

	public ContaCorrente(Cliente cliente, TipoConta tipoConta) {
		super(cliente, tipoConta);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns();
	}

	@Override
	public String toString() {
		return "ContaCorrente ["+
	                          "agencia=" + agencia + 
				              ", numero=" + numero + 
				              ", saldo=" + String.format("%.2f",saldo)  + 
				              ", cliente=" + cliente+ 
				              "]";
	}


	
}
