package app;

public class ContaPoupanca extends Conta {
	public ContaPoupanca(Cliente cliente, TipoConta tipoConta) {
		super(cliente, tipoConta);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Poupança ===");
		super.imprimirInfosComuns();
	}

	@Override
	public String toString() {
		return "ContaPoupanca ["+
	                          "agencia=" + agencia + 
				              ", numero=" + numero + 
				              ", saldo=" + String.format("%.2f",saldo)  + 
				              ", cliente=" + cliente+ 
				              "]";
	}
	
}
