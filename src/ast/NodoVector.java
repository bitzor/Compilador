package ast;

public class NodoVector extends NodoBase{
	private NodoIdentificador variable;
	private int indice;
	private int tipo;	//0 entero - 1 bool
	public NodoVector() {
		super();
		
	}
	public NodoVector(NodoIdentificador variableP, int indiceP) {
		super();
		this.variable = variableP;
		this.indice = indiceP;
	}
	public NodoVector(NodoIdentificador variableP, int indiceP, int tipo) {
		super();
		this.variable = variableP;
		this.indice = indiceP;
		this.tipo = tipo;
	}	
	public NodoVector(NodoIdentificador variableP) { //null el indice por si hay que hacer una operacion +/-,luego se asignar con setIndice
		super();
		this.variable = variableP;
		this.indice = -1;
	}
	public int getIndice() {
		return indice;
	}
	public void setIndice(int indiceP) {
		this.indice = indiceP;
	}
	public NodoIdentificador getVariable() {
		return variable;
	}
	public void setVariable(NodoIdentificador variableP) {
		this.variable = variableP;
	}
	private int getTipo() {
		return tipo;
	}
	private void setTipo(int tipo) {
		this.tipo = tipo;
	}
}
