package uca.compiladores;

import uca.compiladores.ast.*;

import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Traductor {
  public static int numeroTabs = 0;
  public static Writer salida;
  public static String separador = "";
  public static int dimensionArray = 0;
  public static int profundidadArrayActual = 0;
  public static boolean dentroDeUnClass = false;
  public static boolean dentroDeUnArray = false;
  public static String tipoActual = "";
  public static boolean completarLlave = false;
  public static List indexArray = new ArrayList<Integer>();
  public static boolean declaracionConInicializacion = false;
  public static String nombreStruct = "";

  public static void inicializar(Writer s) {
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    Date date = new Date();
    salida = s;
    anadir("/**\n");
    anadir("  * Generado el " + dateFormat.format(date) + "\n");
    anadir("  */\n");
    anadir("import java.util.*;\n\n");
    anadir("public class Archivo\n{\n");
    numeroTabs++;
  }

  public static void anadir(String s) {
    try {
      salida.append(s);
    } catch(IOException ioerr) {

    }
  }
  public static void emitirTab() {
    for (int i = 0; i < numeroTabs; i++)
      anadir("\t");
  }

  public static void finalizar() {
    try {
      anadir("\tpublic static void main(String[] args) {\n");
      anadir("\t\tSystem.exit(main_(args.length, args));\n\t}\n");
      anadir("}\n");
      salida.flush();
      salida.close();
    } catch(IOException ioerr) {

    }
  }

  public static String traducirOpBinario(int op) {
    String operador;

    switch (op)
    {
      case CParser.Lexer.ADD_ASSIGN:
        operador = "+=";
        break;
      case CParser.Lexer.SUB_ASSIGN:
        operador = "-=";
        break;
      case CParser.Lexer.GE_OP:
        operador = ">=";
        break;
      case CParser.Lexer.LE_OP:
        operador = "<=";
        break;
      case CParser.Lexer.EQ_OP:
        operador = "==";
        break;
      case CParser.Lexer.NE_OP:
        operador = "!=";
        break;
      case CParser.Lexer.AND_OP:
        operador = "&&";
        break;
      case CParser.Lexer.OR_OP:
        operador ="||";
        break;
      case '+':
        operador = "+";
        break;
      case '-':
        operador = "-";
        break;
      case '*':
        operador = "*";
        break;
      case '/':
        operador = "/";
        break;
      case '>':
        operador = ">";
        break;
      case '<':
        operador = "<";
        break;
      case '=':
        operador = "=";
        break;
      default:
        operador = "errorop ??";
    }

    return operador;
  }

  public static void traducirExprBooleana(ASNodo n, boolean procesar) {
    if (!procesar) {
      n.traducirAJava();
      return;
    }

    if (n instanceof ASNodoPrefijo) {
      if (((ASNodoPrefijo)n).op == '!') {
        Traductor.anadir("(");
        traducirExprBooleana(((ASNodoPrefijo) n).unario, false);
        Traductor.anadir(") == 0");
        return;
      }
    }

    if (n instanceof ASNodoConstante) {
      Traductor.anadir(((ASNodoConstante) n).numero + " != 0");
    }

    if (n instanceof ASNodoIdentificador) {
      Traductor.anadir(TablaSimbolos.obtenerNombre(((ASNodoIdentificador) n).simboloId) + " != 0");
    }

    if (n instanceof ASNodoLLamadaFuncion) {
      Traductor.anadir("(");
      if (((ASNodoLLamadaFuncion) n).postfija != null)
        ((ASNodoLLamadaFuncion) n).postfija.traducirAJava();

      Traductor.anadir("(");
      if (((ASNodoLLamadaFuncion) n).args != null) {
        Traductor.separador = ", ";
        ((ASNodoLLamadaFuncion) n).args.traducirAJava();
        Traductor.separador = "";
      }

      Traductor.anadir(")) != 0");
    }

    if (n instanceof ASNodoIndexacion) {
      Traductor.anadir("(");
      if (((ASNodoIndexacion) n).postfija != null)
        ((ASNodoIndexacion) n).postfija.traducirAJava();

      Traductor.anadir("[");
      if (((ASNodoIndexacion) n).expr != null)
        ((ASNodoIndexacion) n).expr.traducirAJava();

      Traductor.anadir("]");
      Traductor.anadir(") != 0");
    }

    if (n instanceof ASNodoPostfijo) {
      Traductor.anadir("(");
      if (((ASNodoPostfijo) n).unario != null)
        ((ASNodoPostfijo) n).unario.traducirAJava();

      if (((ASNodoPostfijo) n).op == CLexer.INC_OP)
        Traductor.anadir("++");
      else if (((ASNodoPostfijo) n).op == CLexer.DEC_OP)
        Traductor.anadir("--");

      Traductor.anadir(") != 0");
    }

    if (n instanceof ASNodoOperacionBinaria) {
      boolean debeSerBooleano = (((ASNodoOperacionBinaria)n).op == CLexer.AND_OP || ((ASNodoOperacionBinaria)n).op == CLexer.OR_OP);
      boolean esBooleano    =
        ((ASNodoOperacionBinaria)n).op == CLexer.GE_OP || ((ASNodoOperacionBinaria)n).op == CLexer.LE_OP ||
        ((ASNodoOperacionBinaria)n).op == CLexer.EQ_OP || ((ASNodoOperacionBinaria)n).op == CLexer.NE_OP ||
        ((ASNodoOperacionBinaria)n).op == CLexer.AND_OP || ((ASNodoOperacionBinaria)n).op == CLexer.OR_OP ||
        ((ASNodoOperacionBinaria)n).op == '>' || ((ASNodoOperacionBinaria)n).op == '<';

      if (!esBooleano)
        Traductor.anadir("(");

      traducirExprBooleana(((ASNodoOperacionBinaria)n).ladoIzq, debeSerBooleano);
      Traductor.anadir(" " + traducirOpBinario(((ASNodoOperacionBinaria) n).op) + " ");
      traducirExprBooleana(((ASNodoOperacionBinaria)n).ladoDer, debeSerBooleano);

      if (!esBooleano)
        Traductor.anadir(") != 0");
    }
  }
}
