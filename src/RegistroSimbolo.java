public class RegistroSimbolo {
	private String identificador;
	private int NumLinea;
	private int DireccionMemoria;
	private int tipoDato;
	
	
	public RegistroSimbolo(String identificador, int numLinea,
			int direccionMemoria,int tipo) {
		super();
		this.identificador = identificador;
		NumLinea = numLinea;
		DireccionMemoria = direccionMemoria;
		 tipoDato =tipo;
		
	}

	public String getIdentificador() {
		return identificador;
	}

	public int getNumLinea() {
		return NumLinea;
	}

	public int getDireccionMemoria() {
		return DireccionMemoria;
	}
	public int getTipo() {
		return tipoDato;
	}


	public void setDireccionMemoria(int direccionMemoria) {
		DireccionMemoria = direccionMemoria;
	}
}
