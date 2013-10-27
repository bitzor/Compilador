package ast;

public class NodoMainBegin extends NodoBase {

	private NodoBase cuerpo;
	
	public NodoMainBegin (NodoBase cuerpo) {
		super();
		this.cuerpo = cuerpo;
	}
	
	public NodoMainBegin () {
		super();
		this.cuerpo = null;	
	}

	public NodoBase getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(NodoBase cuerpo) {
		this.cuerpo = cuerpo;
	}
}