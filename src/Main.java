import java_cup.runtime.*;
import ast.*;


public class Main {
	public static void main(String args[]) throws Exception {
		SymbolFactory sf = new DefaultSymbolFactory();
		parser obj_parser;
		if (args.length==0) 
			obj_parser=new parser(new Scanner(System.in,sf),sf);
		else 
			obj_parser=new parser(new Scanner(new java.io.FileInputStream(args[0]),sf),sf);
		
		//Invocar analizador sintáctico
		obj_parser.parse();	
		/*Inicio Arbol*/
    	NodoBase root= obj_parser.action_obj.getASTroot();
		System.out.println();
		System.out.println("IMPRESION DEL AST GENERADO");
		System.out.println();
		ast.Util.imprimirAST(root);
		TablaSimbolos ts = new TablaSimbolos();
		ts.cargarTabla(root);
		ts.ImprimirClaves();
		Semantica obj = new Semantica(ts);
		obj.recorrerNodo(root);
		ts.ImprimirClaves();
	}
}
