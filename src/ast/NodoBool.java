package ast;

public class NodoBool extends NodoBase {
	private boolean valor;

	public NodoBool(boolean valor) {
		super();
		this.valor = valor;
	}

	public NodoBool() {
		super();
	}
	
	public boolean getValor() {
		return valor;
	}

}
