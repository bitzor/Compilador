package ast;

public class NodoFor extends NodoBase{
	private NodoBase val; //valor
	private NodoBase comp; //comparacion
	private NodoBase hast; //aco...
	private NodoBase sente; //sentencias
	
	public NodoFor(NodoBase inicia,NodoBase compara,NodoBase incrementa, NodoBase sentencias) {
		super();
		this.val=inicia;
		this.comp=compara;
		this.hast=incrementa;
		this.sente=sentencias;
	}
	public NodoFor() {
		
		super();
		this.val=null;
		this.comp=null;
		this.hast=null;
		this.sente=null;
	}
	public NodoBase getInicia(){ 
		return val;
	}
	public void setInicia(NodoBase ini){
		this.comp=ini;
	}
	public NodoBase getComp(){
		return comp;
	}
	public void setComp(NodoBase compara){ 
		this.comp=compara;
	}
	public NodoBase getHast(){ 
		return hast;
	}
	public void setHast(NodoBase incredecre){ 
		this.hast=incredecre;
	}
	public NodoBase getSente(){ 
		return sente;
	}
	public void setSente(NodoBase senten){
		this.sente=senten;
	}
}
