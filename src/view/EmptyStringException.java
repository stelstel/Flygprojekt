package view;

public class EmptyStringException extends Exception {

	private static final long serialVersionUID = 1L;

	public EmptyStringException(){
		System.err.println("Inmatningen avbrts p.g.a. tom str�ng");
	}
}
