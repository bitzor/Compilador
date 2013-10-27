import java_cup.runtime.*;
//import otros.*;

%%
/* Habilitar la compatibilidad con el interfaz CUP para el generador sintactico*/
%cup
/* Llamar Scanner a la clase que contiene el analizador Lexico */
%class Scanner

/*-- DECLARACIONES --*/
%{
	public Scanner(java.io.InputStream r, SymbolFactory sf){
		this(r);
		this.sf=sf;
		lineanum=0;
		debug=true;
	}
	private SymbolFactory sf;
	private int lineanum;
	private boolean debug;

/******************************************************************
BORRAR SI NO SE NECESITA
	//TODO: Cambiar la SF por esto o ver que se hace
	//Crear un nuevo objeto java_cup.runtime.Symbol con información sobre el token actual sin valor
 	  private Symbol symbol(int type){
    		return new Symbol(type,yyline,yycolumn);
	  }
	//Crear un nuevo objeto java_cup.runtime.Symbol con información sobre el token actual con valor
	  private Symbol symbol(int type,Object value){
    		return new Symbol(type,yyline,yycolumn,value);
	  }
******************************************************************/
%}
%eofval{
    return sf.newSymbol("EOF",sym.EOF);
%eofval}

/* Acceso a la columna y fila actual de analisis CUP */
%line
%column



digito		= [0-9]
numero		= {digito}+
letra			= [a-zA-Z]
identificador	= {letra}+
nuevalinea		= \n | \n\r | \r\n
espacio		= [ \t]ident ::= ID:aidi NUM:num {:
			System.out.println("Regla IDENT - ID NUM");
			RESULT = new NodoIdentificador(aidi+num);			
		:}
		| ID:aidi {:
			System.out.println("Regla IDENT - ID");
			RESULT = new NodoIdentificador(aidi);
		:}
;+
%%
"if"            {	if(debug) System.out.println("token IF");
			return sf.newSymbol("IF",sym.IF);
			}
"else"          {	if(debug) System.out.println("token ELSE");
			return sf.newSymbol("ELSE",sym.ELSE);
			}
"do"        	{	if(debug) System.out.println("token DO");
			return sf.newSymbol("DO",sym.DO);
			}
"while"         {	if(debug) System.out.println("token WHILE");
			return sf.newSymbol("WHILE",sym.WHILE);
			}
":="            {	if(debug) System.out.println("token ASIGNA");
			return sf.newSymbol("ASIGNA",sym.ASIGNA);
			}
"="             {	if(debug) System.out.println("token IGUAL");
			return sf.newSymbol("IGUAL",sym.IGUAL);
			}
"+"             {	if(debug) System.out.println("token MAS");
			return sf.newSymbol("MAS",sym.MAS);
			}
"%"             {	if(debug) System.out.println("token MOD");
			return sf.newSymbol("MOD",sym.MOD);
			}
"-"             {	if(debug) System.out.println("token MENOS");
			return sf.newSymbol("MENOS",sym.MENOS);
			}
"*"             {	if(debug) System.out.println("token POR");
			return sf.newSymbol("POR",sym.POR);
			}
"/"             {	if(debug) System.out.println("token ENTRE");
			return sf.newSymbol("ENTRE",sym.ENTRE);
			}
"("             {	if(debug) System.out.println("token LPAR");
			return sf.newSymbol("LPAR",sym.LPAR);
			}
")"             {	if(debug) System.out.println("token RPAR");
			return sf.newSymbol("RPAR",sym.RPAR);
			}
";"             {	if(debug) System.out.println("token PCOMA");
			return sf.newSymbol("PCOMA",sym.PCOMA);
			}
">"             {	if(debug) System.out.println("token MQ");
			return sf.newSymbol("MQ",sym.MQ);
			}
"<"             {	if(debug) System.out.println("token mQ");
			return sf.newSymbol("mQ",sym.mQ);
			}
">="            {	if(debug) System.out.println("token MIGUAL");
			return sf.newSymbol("MIGUAL",sym.MIGUAL);
			}
"<="            {	if(debug) System.out.println("token mIGUAL");
			return sf.newSymbol("mIGUAL",sym.mIGUAL);
			}
"!="            {	if(debug) System.out.println("token DIF");
			return sf.newSymbol("DIF",sym.DIF);
			}
"&&"            {	if(debug) System.out.println("token AND");
			return sf.newSymbol("AND",sym.AND);
			}
"||"            {	if(debug) System.out.println("token OR");
			return sf.newSymbol("OR",sym.OR);
			}
"!"             {	if(debug) System.out.println("token NOT");
			return sf.newSymbol("NOT",sym.NOT);
			}
"for"           {	if(debug) System.out.println("token FOR");
	 		return sf.newSymbol("FOR",sym.FOR);
			}
"int"           {	if(debug) System.out.println("token INT");
			return sf.newSymbol("INT",sym.INT);
			}
"bool"           {	if(debug) System.out.println("token BOOL");
			return sf.newSymbol("BOOL",sym.BOOL);
			}
"true"           {	if(debug) System.out.println("token TRUE");
			return sf.newSymbol("TRUE",sym.TRUE);
			}
"false"           {	if(debug) System.out.println("token FALSE");
			return sf.newSymbol("FALSE",sym.FALSE);
			}
"programa"  {	if(debug) System.out.println("token PROG");
			return sf.newSymbol("PROG",sym.PROG);
			}
"avanzar"  {	if(debug) System.out.println("token AVANZAR");
			return sf.newSymbol("AVANZAR",sym.AVANZAR);
			}	
"mirarAbajo"  {	if(debug) System.out.println("token MIRARABAJO");
			return sf.newSymbol("MIRARABAJO",sym.MIRARABAJO);
			}	
"mirarArriba"  {	if(debug) System.out.println("token MIRARARRIBA");
			return sf.newSymbol("MIRARARRIBA",sym.MIRARARRIBA);
			}
"mirarIzq"  {	if(debug) System.out.println("token MIRARIZQ");
			return sf.newSymbol("MIRARIZQ",sym.MIRARIZQ);
			}
"mirarDer"  {	if(debug) System.out.println("token MIRARDER");
			return sf.newSymbol("MIRARDER",sym.MIRARDER);
			}
						
"["           	{	if(debug) System.out.println("token LCOR");
			return sf.newSymbol("LCOR",sym.LCOR);
			}
"]"           	{	if(debug) System.out.println("token RCOR");
			return sf.newSymbol("RCOR",sym.RCOR);
			}
"{"           	{	if(debug) System.out.println("token LBRACK");
			return sf.newSymbol("LBRACK",sym.LBRACK);
			}
"}"           	{	if(debug) System.out.println("token RBRACK");
			return sf.newSymbol("RBRACK",sym.RBRACK);
			}
{numero}        {	if(debug) System.out.println("token NUM");
			return sf.newSymbol("NUM",sym.NUM,new String(yytext()));
			}
{identificador}	{	if(debug) System.out.println("token ID");
				return sf.newSymbol("ID",sym.ID,new String(yytext()));
			}

{nuevalinea}       {lineanum++;}
{espacio}    { if(debug) System.out.println("token ESPACIOS");}
.            {System.err.println("Caracter Ilegal encontrado en analisis lexico: " + yytext() + "\n");}
