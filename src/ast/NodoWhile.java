package ast;

public class NodoWhile extends NodoBase{
	private NodoBase prueba;
	private NodoBase cuerpo;
	public NodoWhile(NodoBase prueba, NodoBase cuerpo) {
		super();
		this.prueba = prueba;
		this.cuerpo = cuerpo;
	}
	public NodoWhile() {
		super();
		this.prueba = null;
		this.cuerpo = null;
	}
	public NodoBase getCuerpo() {
		return cuerpo;
	}
	public void setCuerpo(NodoBase cuerpo) {
		this.cuerpo = cuerpo;
	}
	public void setPrueba(NodoBase prueba) {
		this.prueba = prueba;
	}
	public NodoBase getPrueba() {
		return prueba;
	}

}
