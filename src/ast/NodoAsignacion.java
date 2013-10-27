package ast;

public class NodoAsignacion extends NodoBase {
	private NodoIdentificador identificador;
	private NodoBase expresion;
	private NodoBase vector;
	public NodoAsignacion(NodoIdentificador identificador) {
		super();
		this.identificador = identificador;
		this.expresion = null;
		this.vector=null;
	}
	
	public NodoAsignacion(NodoIdentificador identificador, NodoBase expresion) {
		super();
		this.identificador = identificador;
		this.expresion = expresion;
		this.vector=null;
	}
	/*public NodoAsignacion(NodoBase vec, NodoBase exp) { //para vector
		super();
		this.vector=vec;
		this.expresion = exp;
		this.identificador=null;
	}*/
	public NodoIdentificador getIdentificador() {
		return identificador;
	}

	public void setIdentificador(NodoIdentificador identificador) {
		this.identificador = identificador;
	}

	public NodoBase getExpresion() {
		return expresion;
	}

	public void setExpresion(NodoBase expresion) {
		this.expresion = expresion;
	}
	
	/*public NodoBase getVector() {
		return vector;
	}

	public void setVector(NodoBase vec) {
		this.vector=vec;
	}
	*/
	
	
}
