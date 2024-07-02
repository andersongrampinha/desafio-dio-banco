package app;

public abstract class Conta implements IConta{
	
	private static final int AGENCIA_PADRAO = 1;

	private static int SEQUENCIAL = 1;
	
	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	protected TipoConta tipoConta;

	public Conta(Cliente cliente, TipoConta tipoConta) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.tipoConta = tipoConta;
	}		
	
	@Override
	public void sacar(double valor) throws ContaException {
		if (this.saldo >= valor) {
			this.saldo -=  valor;
		}
		else {
			throw new ContaException("Saldo insuficiente!!!");
		}
	}

	@Override
	public void depositar(double valor) {
		saldo +=  valor;
	}

	@Override
	public void transferir(double valor, Conta contaDestino) throws ContaException {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}
	
	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Tipo Conta: %s", this.getTipoConta()));
		System.out.println(String.format("Títulas: %s", this.cliente.getNome()));
		System.out.println(String.format("Agência: %d", this.agencia));
		System.out.println(String.format("Conta..: %d", this.numero));
		System.out.println(String.format("Saldo..: %.2f", this.saldo));
	}	

}
