package app;

public enum TipoConta {
	
    CONTA_CORRENTE("Conta Corrente"),
    CONTA_POUPANÇA("Conta Poupança");

    private String tipoConta;
    TipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getTipoConta(){
        return this.tipoConta;
    }
    
}
