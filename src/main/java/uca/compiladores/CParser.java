/* A Bison parser, made by GNU Bison 3.0.2.  */

/* Skeleton implementation for Bison LALR(1) parsers in Java

   Copyright (C) 2007-2013 Free Software Foundation, Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

package  uca.compiladores ;
/* First part of user declarations.  */

/* "CParser.java":37  */ /* lalr1.java:91  */

/* "CParser.java":39  */ /* lalr1.java:92  */
/* "%code imports" blocks.  */
/* "CParser.y":7  */ /* lalr1.java:93  */

import uca.compiladores.ast.*;
import uca.compiladores.tipos.*;
import java.util.List;

/* "CParser.java":47  */ /* lalr1.java:93  */

/**
 * A Bison parser, automatically generated from <tt>CParser.y</tt>.
 *
 * @author LALR (1) parser skeleton written by Paolo Bonzini.
 */
public class CParser
{
    /** Version number for the Bison executable that generated this parser.  */
  public static final String bisonVersion = "3.0.2";

  /** Name of the skeleton that generated this parser.  */
  public static final String bisonSkeleton = "lalr1.java";





  

  /**
   * Communication interface between the scanner and the Bison-generated
   * parser <tt>CParser</tt>.
   */
  public interface Lexer {
    /** Token returned by the scanner to signal the end of its input.  */
    public static final int EOF = 0;

/* Tokens.  */
    /** Token number,to be returned by the scanner.  */
    static final int INC_OP = 258;
    /** Token number,to be returned by the scanner.  */
    static final int DEC_OP = 259;
    /** Token number,to be returned by the scanner.  */
    static final int SHL_OP = 260;
    /** Token number,to be returned by the scanner.  */
    static final int SHR_OP = 261;
    /** Token number,to be returned by the scanner.  */
    static final int LE_OP = 262;
    /** Token number,to be returned by the scanner.  */
    static final int GE_OP = 263;
    /** Token number,to be returned by the scanner.  */
    static final int EQ_OP = 264;
    /** Token number,to be returned by the scanner.  */
    static final int NE_OP = 265;
    /** Token number,to be returned by the scanner.  */
    static final int AND_OP = 266;
    /** Token number,to be returned by the scanner.  */
    static final int OR_OP = 267;
    /** Token number,to be returned by the scanner.  */
    static final int ADD_ASSIGN = 268;
    /** Token number,to be returned by the scanner.  */
    static final int SUB_ASSIGN = 269;
    /** Token number,to be returned by the scanner.  */
    static final int IDENTIFICADOR = 270;
    /** Token number,to be returned by the scanner.  */
    static final int CONSTANTE = 271;
    /** Token number,to be returned by the scanner.  */
    static final int CHAR_LITERAL = 272;
    /** Token number,to be returned by the scanner.  */
    static final int INT = 273;
    /** Token number,to be returned by the scanner.  */
    static final int CHAR = 274;
    /** Token number,to be returned by the scanner.  */
    static final int VOID = 275;
    /** Token number,to be returned by the scanner.  */
    static final int IF = 276;
    /** Token number,to be returned by the scanner.  */
    static final int ELSE = 277;
    /** Token number,to be returned by the scanner.  */
    static final int FOR = 278;
    /** Token number,to be returned by the scanner.  */
    static final int CONTINUE = 279;
    /** Token number,to be returned by the scanner.  */
    static final int BREAK = 280;
    /** Token number,to be returned by the scanner.  */
    static final int RETURN = 281;
    /** Token number,to be returned by the scanner.  */
    static final int READ = 282;
    /** Token number,to be returned by the scanner.  */
    static final int EXTDEFS = 283;
    /** Token number,to be returned by the scanner.  */
    static final int PARAMETROS = 284;
    /** Token number,to be returned by the scanner.  */
    static final int SENTENCIAS = 285;
    /** Token number,to be returned by the scanner.  */
    static final int DEFS = 286;
    /** Token number,to be returned by the scanner.  */
    static final int DECLARACIONES = 287;
    /** Token number,to be returned by the scanner.  */
    static final int ARGUMENTOS = 288;
    /** Token number,to be returned by the scanner.  */
    static final int DEF_ARGS = 289;


    

    /**
     * Method to retrieve the semantic value of the last scanned token.
     * @return the semantic value of the last scanned token.
     */
    Object getLVal ();

    /**
     * Entry point for the scanner.  Returns the token identifier corresponding
     * to the next token and prepares to return the semantic value
     * of the token.
     * @return the token identifier corresponding to the next token.
     */
    int yylex () throws java.io.IOException;

    /**
     * Entry point for error reporting.  Emits an error
     * in a user-defined way.
     *
     * 
     * @param msg The string for the error message.
     */
     void yyerror (String msg);
  }

  /**
   * The object doing lexical analysis for us.
   */
  private Lexer yylexer;
  
  



  /**
   * Instantiates the Bison-generated parser.
   * @param yylexer The scanner that will supply tokens to the parser.
   */
  public CParser (Lexer yylexer) 
  {
    
    this.yylexer = yylexer;
    
  }

  private java.io.PrintStream yyDebugStream = System.err;

  /**
   * Return the <tt>PrintStream</tt> on which the debugging output is
   * printed.
   */
  public final java.io.PrintStream getDebugStream () { return yyDebugStream; }

  /**
   * Set the <tt>PrintStream</tt> on which the debug output is printed.
   * @param s The stream that is used for debugging output.
   */
  public final void setDebugStream(java.io.PrintStream s) { yyDebugStream = s; }

  private int yydebug = 0;

  /**
   * Answer the verbosity of the debugging output; 0 means that all kinds of
   * output from the parser are suppressed.
   */
  public final int getDebugLevel() { return yydebug; }

  /**
   * Set the verbosity of the debugging output; 0 means that all kinds of
   * output from the parser are suppressed.
   * @param level The verbosity level for debugging output.
   */
  public final void setDebugLevel(int level) { yydebug = level; }

  /**
   * Print an error message via the lexer.
   *
   * @param msg The error message.
   */
  public final void yyerror (String msg)
  {
    yylexer.yyerror (msg);
  }


  protected final void yycdebug (String s) {
    if (yydebug > 0)
      yyDebugStream.println (s);
  }

  private final class YYStack {
    private int[] stateStack = new int[16];
    
    private Object[] valueStack = new Object[16];

    public int size = 16;
    public int height = -1;

    public final void push (int state, Object value                            ) {
      height++;
      if (size == height)
        {
          int[] newStateStack = new int[size * 2];
          System.arraycopy (stateStack, 0, newStateStack, 0, height);
          stateStack = newStateStack;
          

          Object[] newValueStack = new Object[size * 2];
          System.arraycopy (valueStack, 0, newValueStack, 0, height);
          valueStack = newValueStack;

          size *= 2;
        }

      stateStack[height] = state;
      
      valueStack[height] = value;
    }

    public final void pop () {
      pop (1);
    }

    public final void pop (int num) {
      // Avoid memory leaks... garbage collection is a white lie!
      if (num > 0) {
        java.util.Arrays.fill (valueStack, height - num + 1, height + 1, null);
        
      }
      height -= num;
    }

    public final int stateAt (int i) {
      return stateStack[height - i];
    }

    public final Object valueAt (int i) {
      return valueStack[height - i];
    }

    // Print the state stack on the debug stream.
    public void print (java.io.PrintStream out)
    {
      out.print ("Stack now");

      for (int i = 0; i <= height; i++)
        {
          out.print (' ');
          out.print (stateStack[i]);
        }
      out.println ();
    }
  }

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return success (<tt>true</tt>).
   */
  public static final int YYACCEPT = 0;

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return failure (<tt>false</tt>).
   */
  public static final int YYABORT = 1;



  /**
   * Returned by a Bison action in order to start error recovery without
   * printing an error message.
   */
  public static final int YYERROR = 2;

  /**
   * Internal return codes that are not supported for user semantic
   * actions.
   */
  private static final int YYERRLAB = 3;
  private static final int YYNEWSTATE = 4;
  private static final int YYDEFAULT = 5;
  private static final int YYREDUCE = 6;
  private static final int YYERRLAB1 = 7;
  private static final int YYRETURN = 8;


  private int yyerrstatus_ = 0;


  /**
   * Return whether error recovery is being done.  In this state, the parser
   * reads token until it reaches a known state, and then restarts normal
   * operation.
   */
  public final boolean recovering ()
  {
    return yyerrstatus_ == 0;
  }

  /** Compute post-reduction state.
   * @param yystate   the current state
   * @param yysym     the nonterminal to push on the stack
   */
  private int yy_lr_goto_state_ (int yystate, int yysym)
  {
    int yyr = yypgoto_[yysym - yyntokens_] + yystate;
    if (0 <= yyr && yyr <= yylast_ && yycheck_[yyr] == yystate)
      return yytable_[yyr];
    else
      return yydefgoto_[yysym - yyntokens_];
  }

  private int yyaction (int yyn, YYStack yystack, int yylen) 
  {
    Object yyval;
    

    /* If YYLEN is nonzero, implement the default value of the action:
       '$$ = $1'.  Otherwise, use the top of the stack.

       Otherwise, the following line sets YYVAL to garbage.
       This behavior is undocumented and Bison
       users should not rely upon it.  */
    if (yylen > 0)
      yyval = yystack.valueAt (yylen - 1);
    else
      yyval = yystack.valueAt (0);

    yy_reduce_print (yyn, yystack);

    switch (yyn)
      {
          case 2:
  if (yyn == 2)
    /* "CParser.y":41  */ /* lalr1.java:489  */
    { ArbolSintactico.setNodoRaiz(yyval = null); };
  break;
    

  case 3:
  if (yyn == 3)
    /* "CParser.y":42  */ /* lalr1.java:489  */
    { ArbolSintactico.setNodoRaiz(yyval = ((ASNodo)(yystack.valueAt (1-(1))))); };
  break;
    

  case 4:
  if (yyn == 4)
    /* "CParser.y":46  */ /* lalr1.java:489  */
    { yyval = new ASNodoLista(Lexer.EXTDEFS, ((ASNodo)(yystack.valueAt (1-(1))))); };
  break;
    

  case 5:
  if (yyn == 5)
    /* "CParser.y":47  */ /* lalr1.java:489  */
    { yyval = ((ASNodo)(yystack.valueAt (2-(1)))); ((ASNodoLista)(yystack.valueAt (2-(1)))).anadir(((ASNodo)(yystack.valueAt (2-(2))))); };
  break;
    

  case 6:
  if (yyn == 6)
    /* "CParser.y":51  */ /* lalr1.java:489  */
    { yyval = ((ASNodo)(yystack.valueAt (1-(1)))); };
  break;
    

  case 7:
  if (yyn == 7)
    /* "CParser.y":52  */ /* lalr1.java:489  */
    { yyval = new ASNodoDefinicionFuncion(new Tipo(null), ((ASNodo)(yystack.valueAt (3-(2)))), ((ASNodo)(yystack.valueAt (3-(3))))); };
  break;
    

  case 8:
  if (yyn == 8)
    /* "CParser.y":53  */ /* lalr1.java:489  */
    { yyval = new ASNodoDefinicionFuncion(new Tipo(TPrimitiva.INT), ((ASNodo)(yystack.valueAt (3-(2)))), ((ASNodo)(yystack.valueAt (3-(3))))); };
  break;
    

  case 9:
  if (yyn == 9)
    /* "CParser.y":54  */ /* lalr1.java:489  */
    { yyval = new ASNodoDefinicionFuncion(new Tipo(TPrimitiva.CHAR), ((ASNodo)(yystack.valueAt (3-(2)))), ((ASNodo)(yystack.valueAt (3-(3))))); };
  break;
    

  case 10:
  if (yyn == 10)
    /* "CParser.y":58  */ /* lalr1.java:489  */
    { yyval = new ASNodoCabezeraFunc(((Integer)(yystack.valueAt (4-(1)))), ((ASNodo)(yystack.valueAt (4-(3))))); };
  break;
    

  case 11:
  if (yyn == 11)
    /* "CParser.y":59  */ /* lalr1.java:489  */
    { yyval = new ASNodoCabezeraFunc(((Integer)(yystack.valueAt (3-(1)))), null); };
  break;
    

  case 12:
  if (yyn == 12)
    /* "CParser.y":63  */ /* lalr1.java:489  */
    { yyval = new ASNodoLista(Lexer.PARAMETROS, ((ASNodo)(yystack.valueAt (1-(1)))));};
  break;
    

  case 13:
  if (yyn == 13)
    /* "CParser.y":64  */ /* lalr1.java:489  */
    { yyval = ((ASNodo)(yystack.valueAt (3-(1)))); ((ASNodoLista)(yystack.valueAt (3-(1)))).anadir(((ASNodo)(yystack.valueAt (3-(3))))); };
  break;
    

  case 14:
  if (yyn == 14)
    /* "CParser.y":68  */ /* lalr1.java:489  */
    { yyval = new ASNodoParametro(new Tipo(TPrimitiva.INT), ((ASNodo)(yystack.valueAt (2-(2))))); };
  break;
    

  case 15:
  if (yyn == 15)
    /* "CParser.y":69  */ /* lalr1.java:489  */
    { yyval = new ASNodoParametro(new Tipo(TPrimitiva.CHAR), ((ASNodo)(yystack.valueAt (2-(2))))); };
  break;
    

  case 16:
  if (yyn == 16)
    /* "CParser.y":73  */ /* lalr1.java:489  */
    { yyval = new ASNodoVariable(((Integer)(yystack.valueAt (1-(1))))); };
  break;
    

  case 17:
  if (yyn == 17)
    /* "CParser.y":74  */ /* lalr1.java:489  */
    { yyval = new ASNodoSubVar(((ASNodo)(yystack.valueAt (4-(1)))), ((Integer)(yystack.valueAt (4-(3))))); };
  break;
    

  case 18:
  if (yyn == 18)
    /* "CParser.y":78  */ /* lalr1.java:489  */
    { yyval = new ASNodoLista(Lexer.SENTENCIAS, ((ASNodo)(yystack.valueAt (1-(1))))); };
  break;
    

  case 19:
  if (yyn == 19)
    /* "CParser.y":79  */ /* lalr1.java:489  */
    { yyval = ((ASNodo)(yystack.valueAt (2-(1)))); ((ASNodoLista)(yystack.valueAt (2-(1)))).anadir(((ASNodo)(yystack.valueAt (2-(2))))); };
  break;
    

  case 20:
  if (yyn == 20)
    /* "CParser.y":83  */ /* lalr1.java:489  */
    { yyval = ((ASNodo)(yystack.valueAt (1-(1)))); };
  break;
    

  case 21:
  if (yyn == 21)
    /* "CParser.y":84  */ /* lalr1.java:489  */
    { yyval = ((ASNodo)(yystack.valueAt (1-(1)))); };
  break;
    

  case 22:
  if (yyn == 22)
    /* "CParser.y":85  */ /* lalr1.java:489  */
    { yyval = ((ASNodo)(yystack.valueAt (1-(1)))); };
  break;
    

  case 23:
  if (yyn == 23)
    /* "CParser.y":86  */ /* lalr1.java:489  */
    { yyval = ((ASNodo)(yystack.valueAt (1-(1)))); };
  break;
    

  case 24:
  if (yyn == 24)
    /* "CParser.y":87  */ /* lalr1.java:489  */
    { yyval = ((ASNodo)(yystack.valueAt (1-(1)))); };
  break;
    

  case 25:
  if (yyn == 25)
    /* "CParser.y":91  */ /* lalr1.java:489  */
    { yyval = new ASNodoPropComp(((ASNodo)(yystack.valueAt (4-(2)))), ((ASNodo)(yystack.valueAt (4-(3))))); };
  break;
    

  case 26:
  if (yyn == 26)
    /* "CParser.y":92  */ /* lalr1.java:489  */
    { yyval = new ASNodoPropComp(((ASNodo)(yystack.valueAt (3-(2)))), null); };
  break;
    

  case 27:
  if (yyn == 27)
    /* "CParser.y":93  */ /* lalr1.java:489  */
    { yyval = new ASNodoPropComp(null, ((ASNodo)(yystack.valueAt (3-(2))))); };
  break;
    

  case 28:
  if (yyn == 28)
    /* "CParser.y":94  */ /* lalr1.java:489  */
    { yyval = new ASNodoPropComp(null, null); };
  break;
    

  case 29:
  if (yyn == 29)
    /* "CParser.y":95  */ /* lalr1.java:489  */
    { yyval = new ASNodoPropComp(null, null); };
  break;
    

  case 30:
  if (yyn == 30)
    /* "CParser.y":99  */ /* lalr1.java:489  */
    { yyval = new ASNodoExpresion(((ASNodo)(yystack.valueAt (2-(1))))); };
  break;
    

  case 31:
  if (yyn == 31)
    /* "CParser.y":103  */ /* lalr1.java:489  */
    { yyval = new ASNodoPropIF(((ASNodo)(yystack.valueAt (5-(3)))), ((ASNodo)(yystack.valueAt (5-(5)))), null); };
  break;
    

  case 32:
  if (yyn == 32)
    /* "CParser.y":104  */ /* lalr1.java:489  */
    { yyval = new ASNodoPropIF(((ASNodo)(yystack.valueAt (7-(3)))), ((ASNodo)(yystack.valueAt (7-(5)))), ((ASNodo)(yystack.valueAt (7-(7))))); };
  break;
    

  case 33:
  if (yyn == 33)
    /* "CParser.y":108  */ /* lalr1.java:489  */
    { yyval = new ASNodoPropFOR(((ASNodo)(yystack.valueAt (9-(3)))),   ((ASNodo)(yystack.valueAt (9-(5)))),   ((ASNodo)(yystack.valueAt (9-(7)))),   ((ASNodo)(yystack.valueAt (9-(9))))); };
  break;
    

  case 34:
  if (yyn == 34)
    /* "CParser.y":112  */ /* lalr1.java:489  */
    { yyval = new ASNodoPropRETURN(null); };
  break;
    

  case 35:
  if (yyn == 35)
    /* "CParser.y":113  */ /* lalr1.java:489  */
    { yyval = new ASNodoPropRETURN(((ASNodo)(yystack.valueAt (3-(2))))); };
  break;
    

  case 36:
  if (yyn == 36)
    /* "CParser.y":114  */ /* lalr1.java:489  */
    { yyval = new ASNodoPropCONTINUE(); };
  break;
    

  case 37:
  if (yyn == 37)
    /* "CParser.y":115  */ /* lalr1.java:489  */
    { yyval = new ASNodoPropBREAK(); };
  break;
    

  case 38:
  if (yyn == 38)
    /* "CParser.y":119  */ /* lalr1.java:489  */
    { yyval = new ASNodoLista(Lexer.DEFS, ((ASNodo)(yystack.valueAt (1-(1))))); };
  break;
    

  case 39:
  if (yyn == 39)
    /* "CParser.y":120  */ /* lalr1.java:489  */
    { yyval = ((ASNodo)(yystack.valueAt (2-(1)))); ((ASNodoLista)(yystack.valueAt (2-(1)))).anadir(((ASNodo)(yystack.valueAt (2-(2))))); };
  break;
    

  case 40:
  if (yyn == 40)
    /* "CParser.y":124  */ /* lalr1.java:489  */
    { yyval = new ASNodoDefinicion(new Tipo(TPrimitiva.INT), ((ASNodo)(yystack.valueAt (3-(2))))); };
  break;
    

  case 41:
  if (yyn == 41)
    /* "CParser.y":125  */ /* lalr1.java:489  */
    { yyval = new ASNodoDefinicion(new Tipo(TPrimitiva.CHAR), ((ASNodo)(yystack.valueAt (3-(2))))); };
  break;
    

  case 42:
  if (yyn == 42)
    /* "CParser.y":129  */ /* lalr1.java:489  */
    { yyval = new ASNodoLista(Lexer.DECLARACIONES, ((ASNodo)(yystack.valueAt (1-(1))))); };
  break;
    

  case 43:
  if (yyn == 43)
    /* "CParser.y":130  */ /* lalr1.java:489  */
    { yyval = ((ASNodo)(yystack.valueAt (3-(1)))); ((ASNodoLista)(yystack.valueAt (3-(1)))).anadir(((ASNodo)(yystack.valueAt (3-(3))))); };
  break;
    

  case 44:
  if (yyn == 44)
    /* "CParser.y":134  */ /* lalr1.java:489  */
    { yyval = new ASNodoDeclaracion(((ASNodo)(yystack.valueAt (1-(1)))), null); };
  break;
    

  case 45:
  if (yyn == 45)
    /* "CParser.y":135  */ /* lalr1.java:489  */
    { yyval = new ASNodoDeclaracion(((ASNodo)(yystack.valueAt (3-(1)))), ((ASNodo)(yystack.valueAt (3-(3))))); };
  break;
    

  case 46:
  if (yyn == 46)
    /* "CParser.y":139  */ /* lalr1.java:489  */
    { yyval = ((ASNodo)(yystack.valueAt (1-(1)))); };
  break;
    

  case 47:
  if (yyn == 47)
    /* "CParser.y":140  */ /* lalr1.java:489  */
    { yyval = ((ASNodo)(yystack.valueAt (3-(2)))); };
  break;
    

  case 48:
  if (yyn == 48)
    /* "CParser.y":141  */ /* lalr1.java:489  */
    { yyval = ((ASNodo)(yystack.valueAt (4-(2)))); };
  break;
    

  case 49:
  if (yyn == 49)
    /* "CParser.y":145  */ /* lalr1.java:489  */
    { yyval = new ASNodoLista(Lexer.DEF_ARGS, ((ASNodo)(yystack.valueAt (1-(1))))); };
  break;
    

  case 50:
  if (yyn == 50)
    /* "CParser.y":146  */ /* lalr1.java:489  */
    { yyval = ((ASNodo)(yystack.valueAt (3-(1)))); ((ASNodoLista)(yystack.valueAt (3-(1)))).anadir(((ASNodo)(yystack.valueAt (3-(3))))); };
  break;
    

  case 51:
  if (yyn == 51)
    /* "CParser.y":150  */ /* lalr1.java:489  */
    { yyval = ((ASNodo)(yystack.valueAt (1-(1)))); };
  break;
    

  case 52:
  if (yyn == 52)
    /* "CParser.y":151  */ /* lalr1.java:489  */
    { yyval = ((ASNodo)(yystack.valueAt (3-(2)))); };
  break;
    

  case 53:
  if (yyn == 53)
    /* "CParser.y":152  */ /* lalr1.java:489  */
    { yyval = ((ASNodo)(yystack.valueAt (3-(2)))); };
  break;
    

  case 54:
  if (yyn == 54)
    /* "CParser.y":153  */ /* lalr1.java:489  */
    { yyval = ((ASNodo)(yystack.valueAt (4-(2)))); };
  break;
    

  case 55:
  if (yyn == 55)
    /* "CParser.y":157  */ /* lalr1.java:489  */
    { yyval = ((ASNodo)(yystack.valueAt (1-(1)))); };
  break;
    

  case 56:
  if (yyn == 56)
    /* "CParser.y":158  */ /* lalr1.java:489  */
    { yyval = new ASNodoOperacionBinaria('=', ((ASNodo)(yystack.valueAt (4-(3)))), new ASNodoLLamadaFuncion(new ASNodoIdentificador(TablaSimbolos.obtenerId("read")), null)); };
  break;
    

  case 57:
  if (yyn == 57)
    /* "CParser.y":162  */ /* lalr1.java:489  */
    { yyval = ((ASNodo)(yystack.valueAt (1-(1)))); };
  break;
    

  case 58:
  if (yyn == 58)
    /* "CParser.y":163  */ /* lalr1.java:489  */
    { yyval = new ASNodoOperacionBinaria('=', ((ASNodo)(yystack.valueAt (3-(1)))), ((ASNodo)(yystack.valueAt (3-(3))))); };
  break;
    

  case 59:
  if (yyn == 59)
    /* "CParser.y":164  */ /* lalr1.java:489  */
    { yyval = new ASNodoOperacionBinaria(Lexer.ADD_ASSIGN, ((ASNodo)(yystack.valueAt (3-(1)))), ((ASNodo)(yystack.valueAt (3-(3))))); };
  break;
    

  case 60:
  if (yyn == 60)
    /* "CParser.y":165  */ /* lalr1.java:489  */
    { yyval = new ASNodoOperacionBinaria(Lexer.SUB_ASSIGN, ((ASNodo)(yystack.valueAt (3-(1)))), ((ASNodo)(yystack.valueAt (3-(3))))); };
  break;
    

  case 61:
  if (yyn == 61)
    /* "CParser.y":169  */ /* lalr1.java:489  */
    { yyval = ((ASNodo)(yystack.valueAt (1-(1)))); };
  break;
    

  case 62:
  if (yyn == 62)
    /* "CParser.y":170  */ /* lalr1.java:489  */
    { yyval = new ASNodoOperacionBinaria(Lexer.OR_OP, ((ASNodo)(yystack.valueAt (3-(1)))), ((ASNodo)(yystack.valueAt (3-(3))))); };
  break;
    

  case 63:
  if (yyn == 63)
    /* "CParser.y":174  */ /* lalr1.java:489  */
    { yyval = ((ASNodo)(yystack.valueAt (1-(1)))); };
  break;
    

  case 64:
  if (yyn == 64)
    /* "CParser.y":175  */ /* lalr1.java:489  */
    { yyval = new ASNodoOperacionBinaria(Lexer.AND_OP, ((ASNodo)(yystack.valueAt (3-(1)))), ((ASNodo)(yystack.valueAt (3-(3))))); };
  break;
    

  case 65:
  if (yyn == 65)
    /* "CParser.y":179  */ /* lalr1.java:489  */
    { yyval = ((ASNodo)(yystack.valueAt (1-(1)))); };
  break;
    

  case 66:
  if (yyn == 66)
    /* "CParser.y":180  */ /* lalr1.java:489  */
    { yyval = new ASNodoOperacionBinaria(Lexer.EQ_OP, ((ASNodo)(yystack.valueAt (3-(1)))), ((ASNodo)(yystack.valueAt (3-(3))))); };
  break;
    

  case 67:
  if (yyn == 67)
    /* "CParser.y":181  */ /* lalr1.java:489  */
    { yyval = new ASNodoOperacionBinaria(Lexer.NE_OP, ((ASNodo)(yystack.valueAt (3-(1)))), ((ASNodo)(yystack.valueAt (3-(3))))); };
  break;
    

  case 68:
  if (yyn == 68)
    /* "CParser.y":185  */ /* lalr1.java:489  */
    { yyval = ((ASNodo)(yystack.valueAt (1-(1)))); };
  break;
    

  case 69:
  if (yyn == 69)
    /* "CParser.y":186  */ /* lalr1.java:489  */
    { yyval = new ASNodoOperacionBinaria('>', ((ASNodo)(yystack.valueAt (3-(1)))), ((ASNodo)(yystack.valueAt (3-(3))))); };
  break;
    

  case 70:
  if (yyn == 70)
    /* "CParser.y":187  */ /* lalr1.java:489  */
    { yyval = new ASNodoOperacionBinaria(Lexer.GE_OP, ((ASNodo)(yystack.valueAt (3-(1)))), ((ASNodo)(yystack.valueAt (3-(3))))); };
  break;
    

  case 71:
  if (yyn == 71)
    /* "CParser.y":188  */ /* lalr1.java:489  */
    { yyval = new ASNodoOperacionBinaria('<', ((ASNodo)(yystack.valueAt (3-(1)))), ((ASNodo)(yystack.valueAt (3-(3))))); };
  break;
    

  case 72:
  if (yyn == 72)
    /* "CParser.y":189  */ /* lalr1.java:489  */
    { yyval = new ASNodoOperacionBinaria(Lexer.LE_OP, ((ASNodo)(yystack.valueAt (3-(1)))), ((ASNodo)(yystack.valueAt (3-(3))))); };
  break;
    

  case 73:
  if (yyn == 73)
    /* "CParser.y":193  */ /* lalr1.java:489  */
    { yyval = ((ASNodo)(yystack.valueAt (1-(1)))); };
  break;
    

  case 74:
  if (yyn == 74)
    /* "CParser.y":194  */ /* lalr1.java:489  */
    { yyval = new ASNodoOperacionBinaria('+', ((ASNodo)(yystack.valueAt (3-(1)))), ((ASNodo)(yystack.valueAt (3-(3))))); };
  break;
    

  case 75:
  if (yyn == 75)
    /* "CParser.y":195  */ /* lalr1.java:489  */
    { yyval = new ASNodoOperacionBinaria('-', ((ASNodo)(yystack.valueAt (3-(1)))), ((ASNodo)(yystack.valueAt (3-(3))))); };
  break;
    

  case 76:
  if (yyn == 76)
    /* "CParser.y":199  */ /* lalr1.java:489  */
    { yyval = ((ASNodo)(yystack.valueAt (1-(1)))); };
  break;
    

  case 77:
  if (yyn == 77)
    /* "CParser.y":200  */ /* lalr1.java:489  */
    { yyval = new ASNodoOperacionBinaria('*', ((ASNodo)(yystack.valueAt (3-(1)))), ((ASNodo)(yystack.valueAt (3-(3))))); };
  break;
    

  case 78:
  if (yyn == 78)
    /* "CParser.y":201  */ /* lalr1.java:489  */
    { yyval = new ASNodoOperacionBinaria('/', ((ASNodo)(yystack.valueAt (3-(1)))), ((ASNodo)(yystack.valueAt (3-(3))))); };
  break;
    

  case 79:
  if (yyn == 79)
    /* "CParser.y":205  */ /* lalr1.java:489  */
    { yyval = ((ASNodo)(yystack.valueAt (1-(1)))); };
  break;
    

  case 80:
  if (yyn == 80)
    /* "CParser.y":206  */ /* lalr1.java:489  */
    { yyval = new ASNodoPrefijo(Lexer.INC_OP, ((ASNodo)(yystack.valueAt (2-(2))))); };
  break;
    

  case 81:
  if (yyn == 81)
    /* "CParser.y":207  */ /* lalr1.java:489  */
    { yyval = new ASNodoPrefijo(Lexer.DEC_OP, ((ASNodo)(yystack.valueAt (2-(2))))); };
  break;
    

  case 82:
  if (yyn == 82)
    /* "CParser.y":208  */ /* lalr1.java:489  */
    { yyval = new ASNodoPrefijo('-', ((ASNodo)(yystack.valueAt (2-(2))))); };
  break;
    

  case 83:
  if (yyn == 83)
    /* "CParser.y":209  */ /* lalr1.java:489  */
    { yyval = new ASNodoPrefijo('!', ((ASNodo)(yystack.valueAt (2-(2))))); };
  break;
    

  case 84:
  if (yyn == 84)
    /* "CParser.y":213  */ /* lalr1.java:489  */
    { yyval = ((ASNodo)(yystack.valueAt (1-(1)))); };
  break;
    

  case 85:
  if (yyn == 85)
    /* "CParser.y":214  */ /* lalr1.java:489  */
    { yyval = new ASNodoPostfijo(Lexer.INC_OP, ((ASNodo)(yystack.valueAt (2-(1))))); };
  break;
    

  case 86:
  if (yyn == 86)
    /* "CParser.y":215  */ /* lalr1.java:489  */
    { yyval = new ASNodoPostfijo(Lexer.DEC_OP, ((ASNodo)(yystack.valueAt (2-(1))))); };
  break;
    

  case 87:
  if (yyn == 87)
    /* "CParser.y":216  */ /* lalr1.java:489  */
    { yyval = new ASNodoIndexacion(((ASNodo)(yystack.valueAt (4-(1)))), ((ASNodo)(yystack.valueAt (4-(3))))); };
  break;
    

  case 88:
  if (yyn == 88)
    /* "CParser.y":217  */ /* lalr1.java:489  */
    { yyval = new ASNodoLLamadaFuncion(((ASNodo)(yystack.valueAt (4-(1)))), ((ASNodo)(yystack.valueAt (4-(3))))); };
  break;
    

  case 89:
  if (yyn == 89)
    /* "CParser.y":218  */ /* lalr1.java:489  */
    { yyval = new ASNodoLLamadaFuncion(((ASNodo)(yystack.valueAt (3-(1)))), null); };
  break;
    

  case 90:
  if (yyn == 90)
    /* "CParser.y":222  */ /* lalr1.java:489  */
    { yyval = new ASNodoIdentificador(((Integer)(yystack.valueAt (1-(1))))); };
  break;
    

  case 91:
  if (yyn == 91)
    /* "CParser.y":223  */ /* lalr1.java:489  */
    { yyval = new ASNodoConstante(((Integer)(yystack.valueAt (1-(1))))); };
  break;
    

  case 92:
  if (yyn == 92)
    /* "CParser.y":224  */ /* lalr1.java:489  */
    { yyval = new ASNodoLiteral(((String)(yystack.valueAt (1-(1))))); };
  break;
    

  case 93:
  if (yyn == 93)
    /* "CParser.y":225  */ /* lalr1.java:489  */
    { yyval = ((ASNodo)(yystack.valueAt (3-(2)))); };
  break;
    

  case 94:
  if (yyn == 94)
    /* "CParser.y":229  */ /* lalr1.java:489  */
    { yyval = new ASNodoLista(Lexer.ARGUMENTOS, ((ASNodo)(yystack.valueAt (1-(1))))); };
  break;
    

  case 95:
  if (yyn == 95)
    /* "CParser.y":230  */ /* lalr1.java:489  */
    { yyval = ((ASNodo)(yystack.valueAt (3-(1)))); ((ASNodoLista)(yystack.valueAt (3-(1)))).anadir(((ASNodo)(yystack.valueAt (3-(3))))); };
  break;
    

  case 96:
  if (yyn == 96)
    /* "CParser.y":234  */ /* lalr1.java:489  */
    { yyval = new ASNodoLista(Lexer.DEF_ARGS, ((ASNodo)(yystack.valueAt (1-(1))))); };
  break;
    

  case 97:
  if (yyn == 97)
    /* "CParser.y":235  */ /* lalr1.java:489  */
    { yyval = ((ASNodo)(yystack.valueAt (3-(1)))); ((ASNodoLista)(yystack.valueAt (3-(1)))).anadir(((ASNodo)(yystack.valueAt (3-(3))))); };
  break;
    

  case 98:
  if (yyn == 98)
    /* "CParser.y":239  */ /* lalr1.java:489  */
    { yyval = ((ASNodo)(yystack.valueAt (1-(1)))); };
  break;
    


/* "CParser.java":1056  */ /* lalr1.java:489  */
        default: break;
      }

    yy_symbol_print ("-> $$ =", yyr1_[yyn], yyval);

    yystack.pop (yylen);
    yylen = 0;

    /* Shift the result of the reduction.  */
    int yystate = yy_lr_goto_state_ (yystack.stateAt (0), yyr1_[yyn]);
    yystack.push (yystate, yyval);
    return YYNEWSTATE;
  }



  /*--------------------------------.
  | Print this symbol on YYOUTPUT.  |
  `--------------------------------*/

  private void yy_symbol_print (String s, int yytype,
                                 Object yyvaluep                                 )
  {
    if (yydebug > 0)
    yycdebug (s + (yytype < yyntokens_ ? " token " : " nterm ")
              + yytname_[yytype] + " ("
              + (yyvaluep == null ? "(null)" : yyvaluep.toString ()) + ")");
  }


  /**
   * Parse input from the scanner that was specified at object construction
   * time.  Return whether the end of the input was reached successfully.
   *
   * @return <tt>true</tt> if the parsing succeeds.  Note that this does not
   *          imply that there were no syntax errors.
   */
   public boolean parse () throws java.io.IOException

  {
    


    /* Lookahead and lookahead in internal form.  */
    int yychar = yyempty_;
    int yytoken = 0;

    /* State.  */
    int yyn = 0;
    int yylen = 0;
    int yystate = 0;
    YYStack yystack = new YYStack ();
    int label = YYNEWSTATE;

    /* Error handling.  */
    int yynerrs_ = 0;
    

    /* Semantic value of the lookahead.  */
    Object yylval = null;

    yycdebug ("Starting parse\n");
    yyerrstatus_ = 0;

    /* Initialize the stack.  */
    yystack.push (yystate, yylval );



    for (;;)
      switch (label)
      {
        /* New state.  Unlike in the C/C++ skeletons, the state is already
           pushed when we come here.  */
      case YYNEWSTATE:
        yycdebug ("Entering state " + yystate + "\n");
        if (yydebug > 0)
          yystack.print (yyDebugStream);

        /* Accept?  */
        if (yystate == yyfinal_)
          return true;

        /* Take a decision.  First try without lookahead.  */
        yyn = yypact_[yystate];
        if (yy_pact_value_is_default_ (yyn))
          {
            label = YYDEFAULT;
            break;
          }

        /* Read a lookahead token.  */
        if (yychar == yyempty_)
          {


            yycdebug ("Reading a token: ");
            yychar = yylexer.yylex ();
            yylval = yylexer.getLVal ();

          }

        /* Convert token to internal form.  */
        if (yychar <= Lexer.EOF)
          {
            yychar = yytoken = Lexer.EOF;
            yycdebug ("Now at end of input.\n");
          }
        else
          {
            yytoken = yytranslate_ (yychar);
            yy_symbol_print ("Next token is", yytoken,
                             yylval);
          }

        /* If the proper action on seeing token YYTOKEN is to reduce or to
           detect an error, take that action.  */
        yyn += yytoken;
        if (yyn < 0 || yylast_ < yyn || yycheck_[yyn] != yytoken)
          label = YYDEFAULT;

        /* <= 0 means reduce or error.  */
        else if ((yyn = yytable_[yyn]) <= 0)
          {
            if (yy_table_value_is_error_ (yyn))
              label = YYERRLAB;
            else
              {
                yyn = -yyn;
                label = YYREDUCE;
              }
          }

        else
          {
            /* Shift the lookahead token.  */
            yy_symbol_print ("Shifting", yytoken,
                             yylval);

            /* Discard the token being shifted.  */
            yychar = yyempty_;

            /* Count tokens shifted since error; after three, turn off error
               status.  */
            if (yyerrstatus_ > 0)
              --yyerrstatus_;

            yystate = yyn;
            yystack.push (yystate, yylval);
            label = YYNEWSTATE;
          }
        break;

      /*-----------------------------------------------------------.
      | yydefault -- do the default action for the current state.  |
      `-----------------------------------------------------------*/
      case YYDEFAULT:
        yyn = yydefact_[yystate];
        if (yyn == 0)
          label = YYERRLAB;
        else
          label = YYREDUCE;
        break;

      /*-----------------------------.
      | yyreduce -- Do a reduction.  |
      `-----------------------------*/
      case YYREDUCE:
        yylen = yyr2_[yyn];
        label = yyaction (yyn, yystack, yylen);
        yystate = yystack.stateAt (0);
        break;

      /*------------------------------------.
      | yyerrlab -- here on detecting error |
      `------------------------------------*/
      case YYERRLAB:
        /* If not already recovering from an error, report this error.  */
        if (yyerrstatus_ == 0)
          {
            ++yynerrs_;
            if (yychar == yyempty_)
              yytoken = yyempty_;
            yyerror (yysyntax_error (yystate, yytoken));
          }

        
        if (yyerrstatus_ == 3)
          {
        /* If just tried and failed to reuse lookahead token after an
         error, discard it.  */

        if (yychar <= Lexer.EOF)
          {
          /* Return failure if at end of input.  */
          if (yychar == Lexer.EOF)
            return false;
          }
        else
            yychar = yyempty_;
          }

        /* Else will try to reuse lookahead token after shifting the error
           token.  */
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------.
      | errorlab -- error raised explicitly by YYERROR.  |
      `-------------------------------------------------*/
      case YYERROR:

        
        /* Do not reclaim the symbols of the rule which action triggered
           this YYERROR.  */
        yystack.pop (yylen);
        yylen = 0;
        yystate = yystack.stateAt (0);
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------------------.
      | yyerrlab1 -- common code for both syntax error and YYERROR.  |
      `-------------------------------------------------------------*/
      case YYERRLAB1:
        yyerrstatus_ = 3;       /* Each real token shifted decrements this.  */

        for (;;)
          {
            yyn = yypact_[yystate];
            if (!yy_pact_value_is_default_ (yyn))
              {
                yyn += yyterror_;
                if (0 <= yyn && yyn <= yylast_ && yycheck_[yyn] == yyterror_)
                  {
                    yyn = yytable_[yyn];
                    if (0 < yyn)
                      break;
                  }
              }

            /* Pop the current state because it cannot handle the
             * error token.  */
            if (yystack.height == 0)
              return false;

            
            yystack.pop ();
            yystate = yystack.stateAt (0);
            if (yydebug > 0)
              yystack.print (yyDebugStream);
          }

        if (label == YYABORT)
            /* Leave the switch.  */
            break;



        /* Shift the error token.  */
        yy_symbol_print ("Shifting", yystos_[yyn],
                         yylval);

        yystate = yyn;
        yystack.push (yyn, yylval);
        label = YYNEWSTATE;
        break;

        /* Accept.  */
      case YYACCEPT:
        return true;

        /* Abort.  */
      case YYABORT:
        return false;
      }
}




  // Generate an error message.
  private String yysyntax_error (int yystate, int tok)
  {
    return "syntax error";
  }

  /**
   * Whether the given <code>yypact_</code> value indicates a defaulted state.
   * @param yyvalue   the value to check
   */
  private static boolean yy_pact_value_is_default_ (int yyvalue)
  {
    return yyvalue == yypact_ninf_;
  }

  /**
   * Whether the given <code>yytable_</code>
   * value indicates a syntax error.
   * @param yyvalue the value to check
   */
  private static boolean yy_table_value_is_error_ (int yyvalue)
  {
    return yyvalue == yytable_ninf_;
  }

  private static final short yypact_ninf_ = -144;
  private static final short yytable_ninf_ = -1;

  /* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
   STATE-NUM.  */
  private static final short yypact_[] = yypact_init();
  private static final short[] yypact_init()
  {
    return new short[]
    {
      45,    -9,    -9,    -6,    20,    45,  -144,  -144,    13,    -8,
      41,    46,  -144,    -8,    53,    13,    -8,  -144,  -144,   -11,
      12,  -144,  -144,    73,    82,    93,  -144,  -144,  -144,  -144,
      93,    93,  -144,     4,  -144,   316,   316,  -144,  -144,  -144,
      93,    93,    78,    95,    86,   103,   271,   115,   312,  -144,
     316,   316,   166,  -144,  -144,  -144,  -144,  -144,  -144,   138,
    -144,   110,  -144,   146,   149,   102,     6,     9,    43,    44,
       7,  -144,   127,    99,  -144,  -144,  -144,  -144,   133,   133,
    -144,   106,  -144,  -144,   312,   312,  -144,  -144,  -144,   130,
     312,   140,  -144,  -144,  -144,  -144,  -144,   194,  -144,  -144,
     316,   316,   316,   316,   316,   316,   316,   316,   316,   316,
     316,   316,   316,   316,   316,  -144,  -144,   307,   312,  -144,
      99,    63,  -144,  -144,   147,  -144,  -144,   150,   135,  -144,
     158,  -144,  -144,   149,  -144,   102,     6,     6,     9,     9,
       9,     9,    43,    43,  -144,  -144,  -144,  -144,  -144,  -144,
    -144,   100,   156,    64,    69,   250,  -144,   312,   222,   312,
    -144,  -144,   312,  -144,   267,  -144,  -144,  -144,  -144,  -144,
     174,   157,  -144,  -144,   222,   312,  -144,   164,   222,  -144
    };
  }

/* YYDEFACT[STATE-NUM] -- Default reduction number in state STATE-NUM.
   Performed when YYTABLE does not specify something else to do.  Zero
   means the default is an error.  */
  private static final byte yydefact_[] = yydefact_init();
  private static final byte[] yydefact_init()
  {
    return new byte[]
    {
       2,     0,     0,     0,     0,     3,     4,     6,    16,     0,
      44,     0,    42,     0,     0,     0,     0,     1,     5,     0,
       0,    29,     8,     0,     0,     0,    40,     9,    41,     7,
       0,     0,    11,     0,    12,     0,     0,    90,    91,    92,
       0,     0,     0,     0,     0,     0,     0,     0,     0,    28,
       0,     0,     0,    18,    20,    21,    22,    23,    24,     0,
      38,     0,    55,    57,    61,    63,    65,    68,    73,    76,
      79,    84,     0,     0,    45,    46,    16,    43,    14,    15,
      10,     0,    80,    81,     0,     0,    36,    37,    34,     0,
       0,     0,    82,    83,    27,    19,    26,     0,    39,    30,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,     0,     0,     0,    85,    86,     0,     0,    17,
       0,     0,    49,    98,    51,    96,    13,     0,     0,    35,
       0,    93,    25,    62,    76,    64,    66,    67,    72,    70,
      69,    71,    74,    75,    77,    78,    59,    60,    58,    89,
      94,     0,     0,     0,     0,     0,    47,     0,     0,     0,
      56,    88,     0,    87,     0,    53,    52,    48,    50,    97,
      31,     0,    95,    54,     0,     0,    32,     0,     0,    33
    };
  }

/* YYPGOTO[NTERM-NUM].  */
  private static final short yypgoto_[] = yypgoto_init();
  private static final short[] yypgoto_init()
  {
    return new short[]
    {
    -144,  -144,  -144,   197,   141,  -144,   122,   117,   145,   -51,
      10,  -144,  -144,  -144,  -144,  -144,   -16,     3,   180,  -144,
      92,  -143,   -24,   -32,  -144,   114,   121,    65,    14,    66,
     -33,  -144,  -144,  -144,   104,    70
    };
  }

/* YYDEFGOTO[NTERM-NUM].  */
  private static final short yydefgoto_[] = yydefgoto_init();
  private static final short[] yydefgoto_init()
  {
    return new short[]
    {
      -1,     4,     5,     6,     9,    33,    34,    10,    52,    53,
      54,    55,    56,    57,    58,    59,     7,    11,    12,    74,
     121,   122,    61,    62,    63,    64,    65,    66,    67,    68,
      69,    70,    71,   151,   124,   125
    };
  }

/* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
   positive, shift that token.  If negative, reduce the rule whose
   number is the opposite.  If YYTABLE_NINF, syntax error.  */
  private static final short yytable_[] = yytable_init();
  private static final short[] yytable_init()
  {
    return new short[]
    {
      75,    95,    82,    83,    60,    14,     8,    30,    31,    15,
     115,   116,   168,   104,   105,    35,    36,    92,    93,    22,
      17,   168,    89,    27,    91,    32,    29,    37,    38,    39,
      40,    41,    20,    42,    21,    43,    44,    45,    46,    47,
      80,    81,   117,    98,    14,   118,    95,    48,    19,   123,
     106,   107,    20,    49,    21,   108,   109,   112,   113,    50,
     127,   128,    51,     1,     2,     3,   130,   134,   134,   134,
     134,   134,   134,   134,   134,   134,   134,   144,   145,    23,
     146,   147,   148,    25,    24,    35,    36,   114,    26,    72,
      25,   110,   111,   150,   152,    28,   123,    37,    38,    39,
     155,   164,    35,    36,   156,   165,   157,   170,    76,    47,
     166,   102,   103,    84,    37,    38,    39,    48,   138,   139,
     140,   141,    73,   176,    30,    31,    47,   179,    86,    50,
      85,   123,    51,   123,    48,   171,   161,   162,   172,   120,
     123,    35,    36,    13,    16,    87,    50,    78,    79,    51,
      90,   177,    99,    37,    38,    39,    40,    41,   100,    42,
     101,    43,    44,    45,    46,    47,   119,   136,   137,    35,
      36,    23,   129,    48,   142,   143,   131,   159,    20,    96,
      21,    37,    38,    39,   157,    50,   158,    42,    51,    43,
      44,    45,    46,    47,   160,   163,   174,    35,    36,   175,
     178,    48,    18,   126,    97,    77,    20,    94,    21,    37,
      38,    39,   153,    50,   133,    42,    51,    43,    44,    45,
      46,    47,   135,     0,   154,    35,    36,   169,     0,    48,
       0,     0,     0,     0,    20,   132,    21,    37,    38,    39,
       0,    50,     0,    42,    51,    43,    44,    45,    46,    47,
       0,     0,     0,    35,    36,     0,     0,    48,     0,     0,
       0,     0,    20,     0,    21,    37,    38,    39,     0,    50,
      35,    36,    51,     0,    35,    36,     0,    47,     0,     0,
       0,     0,    37,    38,    39,    48,    37,    38,    39,     0,
     120,   167,     0,     0,    47,     0,     0,    50,    47,     0,
      51,     0,    48,     0,     0,     0,    48,   120,   173,     0,
      35,    36,     0,    88,    50,    35,    36,    51,    50,    35,
      36,    51,    37,    38,    39,     0,     0,    37,    38,    39,
       0,    37,    38,    39,    47,     0,     0,     0,     0,    47,
       0,     0,    48,   149,     0,     0,     0,    48,     0,     0,
       0,    48,     0,     0,    50,     0,     0,    51,     0,    50,
       0,     0,    51,    50,     0,     0,    51
    };
  }

private static final short yycheck_[] = yycheck_init();
  private static final short[] yycheck_init()
  {
    return new short[]
    {
      24,    52,    35,    36,    20,     2,    15,    18,    19,    15,
       3,     4,   155,     7,     8,     3,     4,    50,    51,     9,
       0,   164,    46,    13,    48,    36,    16,    15,    16,    17,
      18,    19,    40,    21,    42,    23,    24,    25,    26,    27,
      36,    37,    35,    59,    41,    38,    97,    35,    35,    73,
      44,    45,    40,    41,    42,    46,    47,    13,    14,    47,
      84,    85,    50,    18,    19,    20,    90,   100,   101,   102,
     103,   104,   105,   106,   107,   108,   109,   110,   111,    38,
     112,   113,   114,    37,    43,     3,     4,    43,    42,    16,
      37,    48,    49,   117,   118,    42,   120,    15,    16,    17,
      37,    37,     3,     4,    41,    41,    37,   158,    15,    27,
      41,     9,    10,    35,    15,    16,    17,    35,   104,   105,
     106,   107,    40,   174,    18,    19,    27,   178,    42,    47,
      35,   155,    50,   157,    35,   159,    36,    37,   162,    40,
     164,     3,     4,     2,     3,    42,    47,    30,    31,    50,
      35,   175,    42,    15,    16,    17,    18,    19,    12,    21,
      11,    23,    24,    25,    26,    27,    39,   102,   103,     3,
       4,    38,    42,    35,   108,   109,    36,    42,    40,    41,
      42,    15,    16,    17,    37,    47,    36,    21,    50,    23,
      24,    25,    26,    27,    36,    39,    22,     3,     4,    42,
      36,    35,     5,    81,    59,    25,    40,    41,    42,    15,
      16,    17,   120,    47,   100,    21,    50,    23,    24,    25,
      26,    27,   101,    -1,   120,     3,     4,   157,    -1,    35,
      -1,    -1,    -1,    -1,    40,    41,    42,    15,    16,    17,
      -1,    47,    -1,    21,    50,    23,    24,    25,    26,    27,
      -1,    -1,    -1,     3,     4,    -1,    -1,    35,    -1,    -1,
      -1,    -1,    40,    -1,    42,    15,    16,    17,    -1,    47,
       3,     4,    50,    -1,     3,     4,    -1,    27,    -1,    -1,
      -1,    -1,    15,    16,    17,    35,    15,    16,    17,    -1,
      40,    41,    -1,    -1,    27,    -1,    -1,    47,    27,    -1,
      50,    -1,    35,    -1,    -1,    -1,    35,    40,    41,    -1,
       3,     4,    -1,    42,    47,     3,     4,    50,    47,     3,
       4,    50,    15,    16,    17,    -1,    -1,    15,    16,    17,
      -1,    15,    16,    17,    27,    -1,    -1,    -1,    -1,    27,
      -1,    -1,    35,    36,    -1,    -1,    -1,    35,    -1,    -1,
      -1,    35,    -1,    -1,    47,    -1,    -1,    50,    -1,    47,
      -1,    -1,    50,    47,    -1,    -1,    50
    };
  }

/* YYSTOS[STATE-NUM] -- The (internal number of the) accessing
   symbol of state STATE-NUM.  */
  private static final byte yystos_[] = yystos_init();
  private static final byte[] yystos_init()
  {
    return new byte[]
    {
       0,    18,    19,    20,    52,    53,    54,    67,    15,    55,
      58,    68,    69,    55,    68,    15,    55,     0,    54,    35,
      40,    42,    61,    38,    43,    37,    42,    61,    42,    61,
      18,    19,    36,    56,    57,     3,     4,    15,    16,    17,
      18,    19,    21,    23,    24,    25,    26,    27,    35,    41,
      47,    50,    59,    60,    61,    62,    63,    64,    65,    66,
      67,    73,    74,    75,    76,    77,    78,    79,    80,    81,
      82,    83,    16,    40,    70,    73,    15,    69,    58,    58,
      36,    37,    81,    81,    35,    35,    42,    42,    42,    73,
      35,    73,    81,    81,    41,    60,    41,    59,    67,    42,
      12,    11,     9,    10,     7,     8,    44,    45,    46,    47,
      48,    49,    13,    14,    43,     3,     4,    35,    38,    39,
      40,    71,    72,    73,    85,    86,    57,    73,    73,    42,
      73,    36,    41,    76,    81,    77,    78,    78,    79,    79,
      79,    79,    80,    80,    81,    81,    74,    74,    74,    36,
      73,    84,    73,    71,    85,    37,    41,    37,    36,    42,
      36,    36,    37,    39,    37,    41,    41,    41,    72,    86,
      60,    73,    73,    41,    22,    42,    60,    73,    36,    60
    };
  }

/* YYR1[YYN] -- Symbol number of symbol that rule YYN derives.  */
  private static final byte yyr1_[] = yyr1_init();
  private static final byte[] yyr1_init()
  {
    return new byte[]
    {
       0,    51,    52,    52,    53,    53,    54,    54,    54,    54,
      55,    55,    56,    56,    57,    57,    58,    58,    59,    59,
      60,    60,    60,    60,    60,    61,    61,    61,    61,    61,
      62,    63,    63,    64,    65,    65,    65,    65,    66,    66,
      67,    67,    68,    68,    69,    69,    70,    70,    70,    71,
      71,    72,    72,    72,    72,    73,    73,    74,    74,    74,
      74,    75,    75,    76,    76,    77,    77,    77,    78,    78,
      78,    78,    78,    79,    79,    79,    80,    80,    80,    81,
      81,    81,    81,    81,    82,    82,    82,    82,    82,    82,
      83,    83,    83,    83,    84,    84,    85,    85,    86
    };
  }

/* YYR2[YYN] -- Number of symbols on the right hand side of rule YYN.  */
  private static final byte yyr2_[] = yyr2_init();
  private static final byte[] yyr2_init()
  {
    return new byte[]
    {
       0,     2,     0,     1,     1,     2,     1,     3,     3,     3,
       4,     3,     1,     3,     2,     2,     1,     4,     1,     2,
       1,     1,     1,     1,     1,     4,     3,     3,     2,     1,
       2,     5,     7,     9,     2,     3,     2,     2,     1,     2,
       3,     3,     1,     3,     1,     3,     1,     3,     4,     1,
       3,     1,     3,     3,     4,     1,     4,     1,     3,     3,
       3,     1,     3,     1,     3,     1,     3,     3,     1,     3,
       3,     3,     3,     1,     3,     3,     1,     3,     3,     1,
       2,     2,     2,     2,     1,     2,     2,     4,     4,     3,
       1,     1,     1,     3,     1,     3,     1,     3,     1
    };
  }

  /* YYTOKEN_NUMBER[YYLEX-NUM] -- Internal symbol number corresponding
      to YYLEX-NUM.  */
  private static final short yytoken_number_[] = yytoken_number_init();
  private static final short[] yytoken_number_init()
  {
    return new short[]
    {
       0,   256,   257,   258,   259,   260,   261,   262,   263,   264,
     265,   266,   267,   268,   269,   270,   271,   272,   273,   274,
     275,   276,   277,   278,   279,   280,   281,   282,   283,   284,
     285,   286,   287,   288,   289,    40,    41,    44,    91,    93,
     123,   125,    59,    61,    62,    60,    43,    45,    42,    47,
      33
    };
  }

  /* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
     First, the terminals, then, starting at \a yyntokens_, nonterminals.  */
  private static final String yytname_[] = yytname_init();
  private static final String[] yytname_init()
  {
    return new String[]
    {
  "$end", "error", "$undefined", "INC_OP", "DEC_OP", "SHL_OP", "SHR_OP",
  "LE_OP", "GE_OP", "EQ_OP", "NE_OP", "AND_OP", "OR_OP", "ADD_ASSIGN",
  "SUB_ASSIGN", "IDENTIFICADOR", "CONSTANTE", "CHAR_LITERAL", "INT",
  "CHAR", "VOID", "IF", "ELSE", "FOR", "CONTINUE", "BREAK", "RETURN",
  "READ", "EXTDEFS", "PARAMETROS", "SENTENCIAS", "DEFS", "DECLARACIONES",
  "ARGUMENTOS", "DEF_ARGS", "'('", "')'", "','", "'['", "']'", "'{'",
  "'}'", "';'", "'='", "'>'", "'<'", "'+'", "'-'", "'*'", "'/'", "'!'",
  "$accept", "inicio", "extdefs", "extdef", "funcion", "parametros",
  "parametro", "var", "sentencias", "sentencia", "sentencia_compuesta",
  "sentencia_expresion", "sentencia_condicional", "sentencia_iteracion",
  "sentencia_salto", "defs", "def", "declaraciones", "declaracion",
  "inicializacion", "array_multi", "array_uni", "expresion", "asignacion",
  "or_logico", "and_logico", "equalidad", "relacional", "adicion", "multi",
  "unario", "postfija", "primario", "argumentos", "def_args", "def_arg", null
    };
  }

  /* YYRLINE[YYN] -- Source line where rule number YYN was defined.  */
  private static final short yyrline_[] = yyrline_init();
  private static final short[] yyrline_init()
  {
    return new short[]
    {
       0,    41,    41,    42,    46,    47,    51,    52,    53,    54,
      58,    59,    63,    64,    68,    69,    73,    74,    78,    79,
      83,    84,    85,    86,    87,    91,    92,    93,    94,    95,
      99,   103,   104,   108,   112,   113,   114,   115,   119,   120,
     124,   125,   129,   130,   134,   135,   139,   140,   141,   145,
     146,   150,   151,   152,   153,   157,   158,   162,   163,   164,
     165,   169,   170,   174,   175,   179,   180,   181,   185,   186,
     187,   188,   189,   193,   194,   195,   199,   200,   201,   205,
     206,   207,   208,   209,   213,   214,   215,   216,   217,   218,
     222,   223,   224,   225,   229,   230,   234,   235,   239
    };
  }


  // Report on the debug stream that the rule yyrule is going to be reduced.
  private void yy_reduce_print (int yyrule, YYStack yystack)
  {
    if (yydebug == 0)
      return;

    int yylno = yyrline_[yyrule];
    int yynrhs = yyr2_[yyrule];
    /* Print the symbols being reduced, and their result.  */
    yycdebug ("Reducing stack by rule " + (yyrule - 1)
              + " (line " + yylno + "), ");

    /* The symbols being reduced.  */
    for (int yyi = 0; yyi < yynrhs; yyi++)
      yy_symbol_print ("   $" + (yyi + 1) + " =",
                       yystos_[yystack.stateAt(yynrhs - (yyi + 1))],
                       ((yystack.valueAt (yynrhs-(yyi + 1)))));
  }

  /* YYTRANSLATE(YYLEX) -- Bison symbol number corresponding to YYLEX.  */
  private static final byte yytranslate_table_[] = yytranslate_table_init();
  private static final byte[] yytranslate_table_init()
  {
    return new byte[]
    {
       0,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,    50,     2,     2,     2,     2,     2,     2,
      35,    36,    48,    46,    37,    47,     2,    49,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,    42,
      45,    43,    44,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,    38,     2,    39,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,    40,     2,    41,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     1,     2,     3,     4,
       5,     6,     7,     8,     9,    10,    11,    12,    13,    14,
      15,    16,    17,    18,    19,    20,    21,    22,    23,    24,
      25,    26,    27,    28,    29,    30,    31,    32,    33,    34
    };
  }

  private static final byte yytranslate_ (int t)
  {
    if (t >= 0 && t <= yyuser_token_number_max_)
      return yytranslate_table_[t];
    else
      return yyundef_token_;
  }

  private static final int yylast_ = 366;
  private static final int yynnts_ = 36;
  private static final int yyempty_ = -2;
  private static final int yyfinal_ = 17;
  private static final int yyterror_ = 1;
  private static final int yyerrcode_ = 256;
  private static final int yyntokens_ = 51;

  private static final int yyuser_token_number_max_ = 289;
  private static final int yyundef_token_ = 2;

/* User implementation code.  */

}

/* "CParser.y":242  */ /* lalr1.java:1070  */
