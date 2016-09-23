%language "Java"
%define public
%name-prefix "C"

%define package { uca.compiladores }

%code imports {
import uca.compiladores.ast.*;
import uca.compiladores.tipos.*;
import java.util.List;
}

/* Precedencia de Operadores */
%right <Integer> INC_OP DEC_OP
%left  <Integer> SHL_OP SHR_OP
%left  <Integer> LE_OP GE_OP
%left  <Integer> EQ_OP NE_OP
%left  <Integer> AND_OP
%left  <Integer> OR_OP
%right <Integer> ADD_ASSIGN SUB_ASSIGN

%token <Integer> IDENTIFICADOR CONSTANTE
%token <String>  CHAR_LITERAL

%token INT CHAR VOID
%token IF ELSE FOR CONTINUE BREAK RETURN READ

%token EXTDEFS PARAMETROS SENTENCIAS DEFS DECLARACIONES ARGUMENTOS DEF_ARGS

%type <ASNodo> extdef funcion parametro var def declaracion inicializacion def_arg array_multi array_uni
%type <ASNodo> expresion asignacion or_logico and_logico equalidad relacional
%type <ASNodo> adicion multi unario postfija primario
%type <ASNodo> inicio extdefs parametros sentencias defs declaraciones argumentos def_args
%type <ASNodo> sentencia sentencia_compuesta sentencia_expresion sentencia_condicional sentencia_iteracion sentencia_salto

%start inicio

%%

inicio
  : /* vacio */   { ArbolSintactico.setNodoRaiz($$ = null); }
  | extdefs       { ArbolSintactico.setNodoRaiz($$ = $1); }
  ;

extdefs
  : extdef          { $$ = new ASNodoLista(Lexer.EXTDEFS, $1); }
  | extdefs extdef  { $$ = $1; $<ASNodoLista>1.anadir($2); }
  ;

extdef
  : def                                  { $$ = $1; }
  | VOID   funcion sentencia_compuesta   { $$ = new ASNodoDefinicionFuncion(new Tipo(null), $2, $3); }
  | INT    funcion sentencia_compuesta   { $$ = new ASNodoDefinicionFuncion(new Tipo(TPrimitiva.INT), $2, $3); }
  | CHAR   funcion sentencia_compuesta   { $$ = new ASNodoDefinicionFuncion(new Tipo(TPrimitiva.CHAR), $2, $3); }
  ;

funcion
  : IDENTIFICADOR '(' parametros ')'  { $$ = new ASNodoCabezeraFunc($1, $3); }
  | IDENTIFICADOR '('            ')'  { $$ = new ASNodoCabezeraFunc($1, null); }
  ;

parametros
  : parametro                 { $$ = new ASNodoLista(Lexer.PARAMETROS, $1);}
  | parametros ',' parametro  { $$ = $1; $<ASNodoLista>1.anadir($3); }
  ;

parametro
  : INT    var  { $$ = new ASNodoParametro(new Tipo(TPrimitiva.INT), $2); }
  | CHAR   var  { $$ = new ASNodoParametro(new Tipo(TPrimitiva.CHAR), $2); }
  ;

var
  : IDENTIFICADOR            { $$ = new ASNodoVariable($1); }
  | var '[' CONSTANTE ']'    { $$ = new ASNodoSubVar($1, $3); }
  ;

sentencias
  : sentencia             { $$ = new ASNodoLista(Lexer.SENTENCIAS, $1); }
  | sentencias sentencia  { $$ = $1; $<ASNodoLista>1.anadir($2); }
  ;

sentencia
  : sentencia_compuesta        { $$ = $1; }
  | sentencia_expresion        { $$ = $1; }
  | sentencia_condicional      { $$ = $1; }
  | sentencia_iteracion        { $$ = $1; }
  | sentencia_salto            { $$ = $1; }
  ;

sentencia_compuesta
  : '{' defs sentencias '}'  { $$ = new ASNodoPropComp($2, $3); }
  | '{' defs            '}'  { $$ = new ASNodoPropComp($2, null); }
  | '{'      sentencias '}'  { $$ = new ASNodoPropComp(null, $2); }
  | '{'                 '}'  { $$ = new ASNodoPropComp(null, null); }
  | ';'                      { $$ = new ASNodoPropComp(null, null); }
  ;

sentencia_expresion
  : expresion ';'  { $$ = new ASNodoExpresion($1); }
  ;

sentencia_condicional
  : IF '(' expresion ')' sentencia                 { $$ = new ASNodoPropIF($3, $5, null); }
  | IF '(' expresion ')' sentencia ELSE sentencia  { $$ = new ASNodoPropIF($3, $5, $7); }
  ;

sentencia_iteracion
  : FOR '(' expresion ';' expresion ';' expresion ')' sentencia   { $$ = new ASNodoPropFOR($3,   $5,   $7,   $9); }
  ;

sentencia_salto
  : RETURN ';'             { $$ = new ASNodoPropRETURN(null); }
  | RETURN expresion ';'   { $$ = new ASNodoPropRETURN($2); }
  | CONTINUE ';'           { $$ = new ASNodoPropCONTINUE(); }
  | BREAK ';'              { $$ = new ASNodoPropBREAK(); }
  ;

defs
  : def       { $$ = new ASNodoLista(Lexer.DEFS, $1); }
  | defs def  { $$ = $1; $<ASNodoLista>1.anadir($2); }
  ;

def
  : INT    declaraciones ';'   { $$ = new ASNodoDefinicion(new Tipo(TPrimitiva.INT), $2); }
  | CHAR   declaraciones ';'   { $$ = new ASNodoDefinicion(new Tipo(TPrimitiva.CHAR), $2); }
  ;

declaraciones
  : declaracion                    { $$ = new ASNodoLista(Lexer.DECLARACIONES, $1); }
  | declaraciones ',' declaracion  { $$ = $1; $<ASNodoLista>1.anadir($3); }
  ;

declaracion
  : var                     { $$ = new ASNodoDeclaracion($1, null); }
  | var '=' inicializacion  { $$ = new ASNodoDeclaracion($1, $3); }
  ;

inicializacion
  : expresion                   { $$ = $1; }
  | '{' array_multi '}'         { $$ = $2; }
  | '{' array_multi ',' '}'     { $$ = $2; }
  ;

array_multi
  : array_uni                    { $$ = new ASNodoLista(Lexer.DEF_ARGS, $1); }
  | array_multi ',' array_uni    { $$ = $1; $<ASNodoLista>1.anadir($3); }
  ;

array_uni
  : def_args                    { $$ = $1; }
  | '{' def_args '}'            { $$ = $2; }
  | '{' array_multi '}'         { $$ = $2; }
  | '{' array_multi ',' '}'     { $$ = $2; }
  ;

expresion
  : asignacion               { $$ = $1; }
  | READ '(' expresion ')'   { $$ = new ASNodoOperacionBinaria('=', $3, new ASNodoLLamadaFuncion(new ASNodoIdentificador(TablaSimbolos.obtenerId("read")), null)); }
  ;

asignacion
  : or_logico                        { $$ = $1; }
  | unario  '='         asignacion   { $$ = new ASNodoOperacionBinaria('=', $1, $3); }
  | unario  ADD_ASSIGN  asignacion   { $$ = new ASNodoOperacionBinaria(Lexer.ADD_ASSIGN, $1, $3); }
  | unario  SUB_ASSIGN  asignacion   { $$ = new ASNodoOperacionBinaria(Lexer.SUB_ASSIGN, $1, $3); }
  ;

or_logico
  : and_logico                   { $$ = $1; }
  | or_logico OR_OP and_logico   { $$ = new ASNodoOperacionBinaria(Lexer.OR_OP, $1, $3); }
  ;

and_logico
  : equalidad                      { $$ = $1; }
  | and_logico AND_OP equalidad    { $$ = new ASNodoOperacionBinaria(Lexer.AND_OP, $1, $3); }
  ;

equalidad
  : relacional                   { $$ = $1; }
  | equalidad EQ_OP relacional   { $$ = new ASNodoOperacionBinaria(Lexer.EQ_OP, $1, $3); }
  | equalidad NE_OP relacional   { $$ = new ASNodoOperacionBinaria(Lexer.NE_OP, $1, $3); }
  ;

relacional
  : adicion                   { $$ = $1; }
  | relacional '>'   adicion  { $$ = new ASNodoOperacionBinaria('>', $1, $3); }
  | relacional GE_OP adicion  { $$ = new ASNodoOperacionBinaria(Lexer.GE_OP, $1, $3); }
  | relacional '<'   adicion  { $$ = new ASNodoOperacionBinaria('<', $1, $3); }
  | relacional LE_OP adicion  { $$ = new ASNodoOperacionBinaria(Lexer.LE_OP, $1, $3); }
  ;

adicion
  : multi               { $$ = $1; }
  | adicion '+' multi   { $$ = new ASNodoOperacionBinaria('+', $1, $3); }
  | adicion '-' multi   { $$ = new ASNodoOperacionBinaria('-', $1, $3); }
  ;

multi
  : unario             { $$ = $1; }
  | multi '*' unario   { $$ = new ASNodoOperacionBinaria('*', $1, $3); }
  | multi '/' unario   { $$ = new ASNodoOperacionBinaria('/', $1, $3); }
  ;

unario
  : postfija       { $$ = $1; }
  | INC_OP unario  { $$ = new ASNodoPrefijo(Lexer.INC_OP, $2); }
  | DEC_OP unario  { $$ = new ASNodoPrefijo(Lexer.DEC_OP, $2); }
  | '-' unario     { $$ = new ASNodoPrefijo('-', $2); }
  | '!' unario     { $$ = new ASNodoPrefijo('!', $2); }
  ;

postfija
  : primario                            { $$ = $1; }
  | postfija INC_OP                     { $$ = new ASNodoPostfijo(Lexer.INC_OP, $1); }
  | postfija DEC_OP                     { $$ = new ASNodoPostfijo(Lexer.DEC_OP, $1); }
  | postfija '[' expresion ']'          { $$ = new ASNodoIndexacion($1, $3); }
  | postfija '(' argumentos ')'         { $$ = new ASNodoLLamadaFuncion($1, $3); }
  | postfija '('      ')'               { $$ = new ASNodoLLamadaFuncion($1, null); }
  ;

primario
  : IDENTIFICADOR      { $$ = new ASNodoIdentificador($1); }
  | CONSTANTE          { $$ = new ASNodoConstante($1); }
  | CHAR_LITERAL       { $$ = new ASNodoLiteral($1); }
  | '(' expresion ')'  { $$ = $2; }
  ;

argumentos
  : expresion                  { $$ = new ASNodoLista(Lexer.ARGUMENTOS, $1); }
  | argumentos ',' expresion   { $$ = $1; $<ASNodoLista>1.anadir($3); }
  ;

def_args
  : def_arg                { $$ = new ASNodoLista(Lexer.DEF_ARGS, $1); }
  | def_args ',' def_arg   { $$ = $1; $<ASNodoLista>1.anadir($3); }
  ;

def_arg
  : expresion   { $$ = $1; }
  ;

%%