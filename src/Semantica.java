
import ast.*;

public class Semantica {
	private TablaSimbolos tabla;
	public Semantica (TablaSimbolos tabla){
		this.tabla = tabla;
	}
	
	
	public boolean checkTipos(NodoBase oI, NodoBase oD){				
		if(oI instanceof NodoIdentificador && oD instanceof NodoValor){
			if(tabla.BuscarSimbolo(((NodoIdentificador) oI).getNombre())!= null){
				if(tabla.BuscarSimbolo(((NodoIdentificador) oI).getNombre()).getTipo() == 0)			
					return true;
			}else{
				System.out.println("Símbolo " + ((NodoIdentificador) oI).getNombre() + "no ha sido declarado");
			}
		}else if(oI instanceof NodoValor && oD instanceof NodoIdentificador){
			if(tabla.BuscarSimbolo(((NodoIdentificador) oD).getNombre())!= null){
				if(tabla.BuscarSimbolo(((NodoIdentificador) oD).getNombre()).getTipo() == 0)			
					return true;
			}else{
				System.out.println("Símbolo " + ((NodoIdentificador) oI).getNombre() + "no ha sido declarado");
			}
		}
		if(oI instanceof NodoIdentificador && oD instanceof NodoBool){
			if(tabla.BuscarSimbolo(((NodoIdentificador) oI).getNombre())!= null){
				if(tabla.BuscarSimbolo(((NodoIdentificador) oI).getNombre()).getTipo() == 1)			
					return true;
			}else{
				System.out.println("Símbolo " + ((NodoIdentificador) oI).getNombre() + "no ha sido declarado");
			}
		}else if(oI instanceof NodoBool && oD instanceof NodoIdentificador){
			if(tabla.BuscarSimbolo(((NodoIdentificador) oD).getNombre())!= null){
				if(tabla.BuscarSimbolo(((NodoIdentificador) oD).getNombre()).getTipo() == 1)			
					return true;
			}else{
				System.out.println("Símbolo " + ((NodoIdentificador) oI).getNombre() + "no ha sido declarado");
			}
		}		
		else if(oI instanceof NodoIdentificador && oD instanceof NodoIdentificador) {
			if(tabla.BuscarSimbolo(((NodoIdentificador) oI).getNombre())!= null){
				if (tabla.BuscarSimbolo(((NodoIdentificador) oD).getNombre())!= null){
					if(tabla.BuscarSimbolo(((NodoIdentificador) oI).getNombre()).getTipo() == 
					   tabla.BuscarSimbolo(((NodoIdentificador) oD).getNombre()).getTipo()
					){
						return true;
					}
				}else{
					System.out.println("Símbolo " + ((NodoIdentificador) oD).getNombre() + "no ha sido declarado");
				}
			}else{
				System.out.println("Símbolo " + ((NodoIdentificador) oI).getNombre() + "no ha sido declarado");
			}
		}
		return false;
	}
	
	
	
	public NodoBase checkTipos(NodoBase oI, NodoBase oD, tipoOp op){
		int v1, v2;
		boolean vb1, vb2;
		if(oI instanceof NodoIdentificador && oD instanceof NodoValor){
			if(tabla.BuscarSimbolo(((NodoIdentificador) oI).getNombre())!= null){
				if(tabla.BuscarSimbolo(((NodoIdentificador) oI).getNombre()).getTipo() == 0){										
					v1 = tabla.BuscarSimbolo(((NodoIdentificador) oI).getNombre()).getDireccionMemoria(); 
					v2 = ((NodoValor) oD).getValor();
					if(op == tipoOp.mas || op == tipoOp.menos || op == tipoOp.por || op == tipoOp.entre  || op == tipoOp.modulo)
						return operacionAritmetica( v1, v2 ,op);
					else
						return operacionBooleana( v1, v2, op);
				}
					
			}else{
				System.out.println("Símbolo " + ((NodoIdentificador) oI).getNombre() + "no ha sido declarado");
			}
		}else if(oI instanceof NodoValor && oD instanceof NodoIdentificador){
			if(tabla.BuscarSimbolo(((NodoIdentificador) oD).getNombre())!= null){
				if(tabla.BuscarSimbolo(((NodoIdentificador) oD).getNombre()).getTipo() == 0){
					v1 = tabla.BuscarSimbolo(((NodoIdentificador) oD).getNombre()).getDireccionMemoria(); 
					v2 = ((NodoValor) oI).getValor();
					if(op == tipoOp.mas || op == tipoOp.menos || op == tipoOp.por || op == tipoOp.entre  || op == tipoOp.modulo)
						return operacionAritmetica( v1, v2 ,op);
					else
						return operacionBooleana( v1, v2, op);					
				}			
			}else{
				System.out.println("Símbolo " + ((NodoIdentificador) oI).getNombre() + "no ha sido declarado");
			}
		}
		if(oI instanceof NodoIdentificador && oD instanceof NodoBool){
			if(tabla.BuscarSimbolo(((NodoIdentificador) oI).getNombre())!= null){
				if(tabla.BuscarSimbolo(((NodoIdentificador) oI).getNombre()).getTipo() == 1){
					vb1 = (tabla.BuscarSimbolo(((NodoIdentificador) oI).getNombre()).getDireccionMemoria() == 0) ? false : true;
					vb2 = ((NodoBool) oD).getValor();
					return operacionLogica(vb1, vb2, op);
				}
			}else{
				System.out.println("Símbolo " + ((NodoIdentificador) oI).getNombre() + "no ha sido declarado");
			}
		}else if(oI instanceof NodoBool && oD instanceof NodoIdentificador){
			if(tabla.BuscarSimbolo(((NodoIdentificador) oD).getNombre())!= null){
				if(tabla.BuscarSimbolo(((NodoIdentificador) oD).getNombre()).getTipo() == 1){
					vb1 = (tabla.BuscarSimbolo(((NodoIdentificador) oD).getNombre()).getDireccionMemoria() == 0) ? false : true;
					vb2 = ((NodoBool) oI).getValor();
					return operacionLogica(vb1, vb2, op);					
				}
			}else{
				System.out.println("Símbolo " + ((NodoIdentificador) oI).getNombre() + "no ha sido declarado");
			}
		}		
		else if(oI instanceof NodoIdentificador && oD instanceof NodoIdentificador) {
			if(tabla.BuscarSimbolo(((NodoIdentificador) oI).getNombre())!= null){
				if (tabla.BuscarSimbolo(((NodoIdentificador) oD).getNombre())!= null){
					if(tabla.BuscarSimbolo(((NodoIdentificador) oI).getNombre()).getTipo() == 0 &&
					   tabla.BuscarSimbolo(((NodoIdentificador) oD).getNombre()).getTipo() == 0
					){
						v1 = tabla.BuscarSimbolo(((NodoIdentificador) oI).getNombre()).getDireccionMemoria();
						v2 = tabla.BuscarSimbolo(((NodoIdentificador) oD).getNombre()).getDireccionMemoria();
						if(op == tipoOp.mas || op == tipoOp.menos || op == tipoOp.por || op == tipoOp.entre  || op == tipoOp.modulo)
							return operacionAritmetica( v1, v2 ,op);
						else
							return operacionBooleana( v1, v2, op);
					}
					if(tabla.BuscarSimbolo(((NodoIdentificador) oI).getNombre()).getTipo() == 1 &&
					   tabla.BuscarSimbolo(((NodoIdentificador) oD).getNombre()).getTipo() == 1
					){
						vb1 = (tabla.BuscarSimbolo(((NodoIdentificador) oI).getNombre()).getDireccionMemoria() == 0) ? false : true;
						vb2 = (tabla.BuscarSimbolo(((NodoIdentificador) oD).getNombre()).getDireccionMemoria() == 0) ? false : true;
						return operacionLogica(vb1, vb2, op);
					}					
				}else{
					System.out.println("Símbolo " + ((NodoIdentificador) oD).getNombre() + "no ha sido declarado");
				}
			}else{
				System.out.println("Símbolo " + ((NodoIdentificador) oI).getNombre() + "no ha sido declarado");
			}
		}else if(oI instanceof NodoValor && oD instanceof NodoValor) {
			v1 = ((NodoValor) oI).getValor();
			v2 = ((NodoValor) oD).getValor();
			if(op == tipoOp.mas || op == tipoOp.menos || op == tipoOp.por || op == tipoOp.entre  || op == tipoOp.modulo)
				return operacionAritmetica( v1, v2 ,op);
			else
				return operacionBooleana( v1, v2, op);					
		}else if(oI instanceof NodoBool && oD instanceof NodoBool) {
			vb1 = ((NodoBool) oI).getValor();
			vb2 = ((NodoBool) oD).getValor();	
			return operacionLogica(vb1, vb2, op);			
		}		
		return null;
	}
	public NodoValor operacionAritmetica(int oD, int oI, tipoOp operacion){
		NodoValor temp = null;
		
		if(operacion == tipoOp.mas)
			temp = new NodoValor(oI + oD);
		else if(operacion == tipoOp.menos)
			temp = new NodoValor(oI - oD);		
		else if(operacion == tipoOp.por)
			temp = new NodoValor(oI * oD);		
		else if(operacion == tipoOp.entre)
			temp = new NodoValor(oI / oD);		
		else if(operacion == tipoOp.modulo)
			temp = new NodoValor((int) oI % oD);				
		
		return temp;
	}
	
	public NodoBool operacionBooleana(int oI, int oD, tipoOp operacion){
		NodoBool temp = null;
		boolean aux;
		if(operacion == tipoOp.mayor)
			temp = new NodoBool(oI > oD);
		else if(operacion == tipoOp.menor)
			temp = new NodoBool(oI < oD);		
		else if(operacion == tipoOp.mayorigual)
			temp = new NodoBool(oI >= oD);		
		else if(operacion == tipoOp.menorigual)
			temp = new NodoBool(oI <= oD);		
		else if(operacion == tipoOp.igual)
			temp = new NodoBool(oI == oD);			
		else if(operacion == tipoOp.diferente)
			temp = new NodoBool(oI != oD);		
		
		return temp;
	}
	
	public NodoBool operacionLogica(boolean oI, boolean oD, tipoOp operacion){
		NodoBool temp = null;
		boolean aux;
		if(operacion == tipoOp.y)
			temp = new NodoBool(oI && oD);
		else if(operacion == tipoOp.o)
			temp = new NodoBool(oI || oD);			
		return temp;
	}

	
	public NodoBase recorrerNodo(NodoBase root){
		NodoBase temporal = null; 
		NodoBase oI, oD;
		while (root != null) {
			if(root instanceof NodoOperacion){
				System.out.println("Operación más");
				if(((NodoOperacion) root).getOperacion() == tipoOp.mas){					
					oI = recorrerNodo(((NodoOperacion) root).getOpDerecho());
					oD = recorrerNodo(((NodoOperacion) root).getOpIzquierdo());
					temporal = checkTipos(oI, oD, tipoOp.mas);
					if(temporal == null)				
						System.out.println("Operación SUMA no permitida, tipos incompatibles");
					else
						return temporal;									
				}else if(((NodoOperacion) root).getOperacion() == tipoOp.menos){
					oI = recorrerNodo(((NodoOperacion) root).getOpDerecho());
					oD = recorrerNodo(((NodoOperacion) root).getOpIzquierdo());
					temporal = checkTipos(oI, oD, tipoOp.menos);
					if(temporal == null)				
						System.out.println("Operación RESTA no permitida, tipos incompatibles");
					else
						return temporal;														
				}else if(((NodoOperacion) root).getOperacion() == tipoOp.por){
					oI = recorrerNodo(((NodoOperacion) root).getOpDerecho());
					oD = recorrerNodo(((NodoOperacion) root).getOpIzquierdo());
					temporal = checkTipos(oI, oD, tipoOp.por);
					if(temporal == null)				
						System.out.println("Operación MULTIPLICACIÓN no permitida, tipos incompatibles");
					else
						return temporal;														
				}else if(((NodoOperacion) root).getOperacion() == tipoOp.entre){
					oI = recorrerNodo(((NodoOperacion) root).getOpDerecho());
					oD = recorrerNodo(((NodoOperacion) root).getOpIzquierdo());
					temporal = checkTipos(oI, oD, tipoOp.entre);
					if(temporal == null)				
						System.out.println("Operación DIVISIÓN no permitida, tipos incompatibles");
					else
						return temporal;														
				}else if(((NodoOperacion) root).getOperacion() == tipoOp.modulo){
					oI = recorrerNodo(((NodoOperacion) root).getOpDerecho());
					oD = recorrerNodo(((NodoOperacion) root).getOpIzquierdo());
					temporal = checkTipos(oI, oD, tipoOp.modulo);
					if(temporal == null)				
						System.out.println("Operación MODULO no permitida, tipos incompatibles");
					else
						return temporal;							
				}else if(((NodoOperacion) root).getOperacion() == tipoOp.mayor){
					oI = recorrerNodo(((NodoOperacion) root).getOpDerecho());
					oD = recorrerNodo(((NodoOperacion) root).getOpIzquierdo());
					temporal = checkTipos(oI, oD, tipoOp.mayor);
					if(temporal == null)				
						System.out.println("Operación MAYOR no permitida, tipos incompatibles");
					else
						return temporal;														
				}else if(((NodoOperacion) root).getOperacion() == tipoOp.menor){
					oI = recorrerNodo(((NodoOperacion) root).getOpDerecho());
					oD = recorrerNodo(((NodoOperacion) root).getOpIzquierdo());
					temporal = checkTipos(oI, oD, tipoOp.menor);
					if(temporal == null)				
						System.out.println("Operación MENOR no permitida, tipos incompatibles");
					else
						return temporal;				
					System.out.println("Operación MENOR permitida, tipos incompatibles");					
				}else if(((NodoOperacion) root).getOperacion() == tipoOp.diferente){
					oI = recorrerNodo(((NodoOperacion) root).getOpDerecho());
					oD = recorrerNodo(((NodoOperacion) root).getOpIzquierdo());
					temporal = checkTipos(oI, oD, tipoOp.diferente);
					if(temporal == null)				
						System.out.println("Operación DIFERENTE no permitida, tipos incompatibles");
					else
						return temporal;			
					System.out.println("Operación DIFERENTE permitida, tipos incompatibles");					
				}else if(((NodoOperacion) root).getOperacion() == tipoOp.mayorigual){
					oI = recorrerNodo(((NodoOperacion) root).getOpDerecho());
					oD = recorrerNodo(((NodoOperacion) root).getOpIzquierdo());
					temporal = checkTipos(oI, oD, tipoOp.mayorigual);
					if(temporal == null)				
						System.out.println("Operación MAYOR IGUAL no permitida, tipos incompatibles");
					else
						return temporal;														
				}else if(((NodoOperacion) root).getOperacion() == tipoOp.menorigual){
					oI = recorrerNodo(((NodoOperacion) root).getOpDerecho());
					oD = recorrerNodo(((NodoOperacion) root).getOpIzquierdo());
					temporal = checkTipos(oI, oD, tipoOp.menorigual);
					if(temporal == null)				
						System.out.println("Operación MENOR IGUAL no permitida, tipos incompatibles");
					else
						return temporal;													
				}else if(((NodoOperacion) root).getOperacion() == tipoOp.igual){
					oI = recorrerNodo(((NodoOperacion) root).getOpDerecho());
					oD = recorrerNodo(((NodoOperacion) root).getOpIzquierdo());
					temporal = checkTipos(oI, oD, tipoOp.igual);
					if(temporal == null)				
						System.out.println("Operación IGUAL no permitida, tipos incompatibles");
					else
						return temporal;															
				}else if(((NodoOperacion) root).getOperacion() == tipoOp.no){
					
				}else  if(((NodoOperacion) root).getOperacion() == tipoOp.y){
					oI = recorrerNodo(((NodoOperacion) root).getOpDerecho());
					oD = recorrerNodo(((NodoOperacion) root).getOpIzquierdo());
					temporal = checkTipos(oI, oD, tipoOp.y);
					if(temporal == null)				
						System.out.println("Operación Y no permitida, tipos incompatibles");
					else
						return temporal;										
				}else  if(((NodoOperacion) root).getOperacion() == tipoOp.o){
					oI = recorrerNodo(((NodoOperacion) root).getOpDerecho());
					oD = recorrerNodo(((NodoOperacion) root).getOpIzquierdo());
					temporal = checkTipos(oI, oD, tipoOp.o);
					if(temporal == null)				
						System.out.println("Operación O no permitida, tipos incompatibles");
					else
						return temporal;														
				}
				
			}else if (root instanceof  NodoAsignacion){
		    	oI = recorrerNodo(((NodoAsignacion)root).getIdentificador());
		    	oD = recorrerNodo(((NodoAsignacion)root).getExpresion());			
		    	if(!checkTipos(oI, oD))
		    		System.out.println("ERROR en operación de asignación. Tipos incompatibles");
		    	else{
		    		if(tabla.BuscarSimbolo(((NodoIdentificador) oI).getNombre()).getTipo()==0)
		    			tabla.BuscarSimbolo(((NodoIdentificador) oI).getNombre()).setDireccionMemoria(((NodoValor) oD).getValor());
		    		else if(tabla.BuscarSimbolo(((NodoIdentificador) oI).getNombre()).getTipo()==1){
		    			tabla.BuscarSimbolo(((NodoIdentificador) oI).getNombre()).setDireccionMemoria((((NodoBool) oD).getValor()) ? 1:0);	
		    		}		    			
		    		else
		    			System.out.println("Operacion Ilegal");	
		    			
		    	}
			}else if(root instanceof NodoValor){
				System.out.println("Valor entero ");
				return root;
			}else if(root instanceof NodoBool){
				System.out.println("Valor bool");
				return root;
			}else if(root instanceof NodoIdentificador){
				System.out.println("Identificador " + ((NodoIdentificador) root).getNombre());
				if(root.getHermanoDerecha() == null) return root;
			}
			root = root.getHermanoDerecha();
		 }
		
		return temporal;
	}
}
