package app;

public class ContaException extends Exception {
	
	private static final long serialVersionUID = 4928599035264976611L;
	 
    public ContaException(String message) {
        super(message);
    }
 
    public ContaException(Throwable t) {
        super(t);
    }

}
