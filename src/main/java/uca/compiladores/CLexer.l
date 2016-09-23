package uca.compiladores;

%%

// Para el debug
// %debug
%line
%column
%unicode
%class CLexer
%implements CParser.Lexer
%int

/*-*
 * FUNCIONES LEXICAS:
 */

%{
 /**
   * Este objeto guarda el valor semántico del Último token escaneado.
   */
   private Object yylval = null;

   /**
     * Method to retrieve the semantic value of the last scanned token.
     * @return the semantic value of the last scanned token.
     */
   public Object getLVal ()
   {
     return yylval;
   }

  /**
    * Entry point for error reporting.  Emits an error
    * in a user-defined way.
    *
    *
    * @param s The string for the error message.
    */
    public void yyerror (String s)
    {
      System.out.println("[ERROR SINTACTICO] Linea " + yyline + " columna " + new Integer(yycolumn + 1));
    }
%}

/*-
 * DEFINICION DE PATRONES:
 */

NUMERO        = [0-9]
LETRA         = [a-zA-Z_]
NUMEROYLETRAS = [0-9a-zA-Z_]

%state C_COMMENT

%%
/**
 * REGLAS LEXICAS:
 */

break     { return BREAK; }
continue  { return CONTINUE; }
else      { return ELSE; }
for       { return FOR; }
if        { return IF; }
int       { return INT; }
char      { return CHAR; }
return    { return RETURN; }
read      { return READ; }
void      { return VOID; }

{LETRA}{NUMEROYLETRAS}*   { yylval = TablaSimbolos.obtenerId(yytext()); return IDENTIFICADOR; }

/* \"([^\\\"]|\\.)*\"	      { yylval = yytext(); return STRING_LITERAL; } */
'([^\\\"]|\\.)'  	      { yylval = yytext(); return CHAR_LITERAL; }

{NUMERO}+                 { yylval = new Integer(yytext()); return CONSTANTE; }


"//".*          { /* comentario de una linea, ignorar todo lo que viene despues */ }

<YYINITIAL> {
"/*"              { yybegin(C_COMMENT); }
}

<C_COMMENT> {
"*/"      { yybegin(YYINITIAL); }
[^*\n]+   { }
"*"       { }
\n        { yyline++; }
}


";"     { return ';'; }
","     { return ','; }
"("     { return '('; }
")"     { return ')'; }
"["     { return '['; }
"]"     { return ']'; }
"{"     { return '{'; }
"}"     { return '}'; }
"."     { return '.'; }
"!"     { return '!'; }
"++"    { return INC_OP; }
"--"    { return DEC_OP; }
"*"     { return '*'; }
"/"     { return '/'; }
"+"     { return '+'; }
"-"     { return '-'; }
"<<"    { return SHL_OP; }
">>"    { return SHR_OP; }
">"     { return '>'; }
">="    { return GE_OP; }
"<"     { return '<'; }
"<="    { return LE_OP; }
"=="    { return EQ_OP; }
"!="    { return NE_OP; }
"&&"    { return AND_OP; }
"||"    { return OR_OP; }
"="     { return '='; }
"+="    { return ADD_ASSIGN; }
"-="    { return SUB_ASSIGN; }

[ \t\v\r\n\f]   { /* ignorar */ }

.       { /* ignora todo lo demas */ }