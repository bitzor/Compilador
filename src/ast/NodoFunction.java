package ast;

public class NodoFunction extends NodoBase {

	private NodoBase cuerpo;
	private String nombre;
	
	public NodoFunction(NodoBase cuerpo, String nombre) {
		super();
		this.cuerpo = cuerpo;
		this.nombre = nombre;
	}	
	public NodoFunction() {
		super();
		this.cuerpo = null;	
	}

	public NodoBase getCuerpo() {
		return cuerpo;
	}
	
	public String getNombreFuncion(){
		return nombre;
		
	}
	
	public void setCuerpo(NodoBase cuerpo) {
		this.cuerpo = cuerpo;
	}
}