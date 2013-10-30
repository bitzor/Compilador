package ast;

public class NodoIdentificador extends NodoBase {
	private String nombre;
	private int tipo; // 0 entero - 1 boolean
	public NodoIdentificador(String nombre) {
		super();
		this.nombre = nombre;
	}
	public NodoIdentificador(String nombre, int tipo) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
	}
	public NodoIdentificador() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public int getTipo() {
		return tipo;
	}

	private void setTipo(int tipo) {
		this.tipo = tipo;
	}

}
