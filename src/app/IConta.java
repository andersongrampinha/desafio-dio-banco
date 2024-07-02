package app;

public interface IConta {
	
	void sacar(double valor) throws ContaException;
	
	void depositar(double valor);
	
	void transferir(double valor, Conta contaDestino) throws ContaException;
	
	void imprimirExtrato();

}
