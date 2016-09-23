package uca.compiladores;

import uca.compiladores.ast.ASNodo;
import uca.compiladores.scope.Scope;

import java.io.*;

public class Main {
  public static final String RED = "\u001B[0;31m";
  public static final String GREEN = "\u001B[0;32m";
  public static final String WHITE = "\u001B[0;37m";

  public static void main(String[] args) throws IOException {
    ASNodo nodoRaiz;
    CParser.Lexer lexer;
    CParser parser;

    TablaSimbolos.agregar("read");
    TablaSimbolos.agregar("write");

    Reader archivoEntrada = null;
    try {
       archivoEntrada = new BufferedReader(new FileReader (new File(args[0])));
    } catch (FileNotFoundException ioerr) {
      System.out.println("[ERROR] No se pudo abrir el archivo de entrada: '" + args[0] + "'");
      System.exit(0);
    }

    Writer archivoSalida = null;
    if (args.length > 1) {
      try {
         archivoSalida = new BufferedWriter(new FileWriter(args[1]));
      } catch (FileNotFoundException ioerr) {
        System.out.println("[ERROR] No se pudo abrir el archivo de salida: '" + args[1] + "'");
        System.exit(0);
      }
    }

    Traductor.inicializar(archivoSalida);
    lexer = new CLexer(archivoEntrada);
    parser = new CParser(lexer);
    parser.parse();

    if ((nodoRaiz = ArbolSintactico.getNodoRaiz()) != null) {
      Scope.inicializarNuevo();
      nodoRaiz.verificaSemantica();

      if (Scope.scopeActual.buscarDef(TablaSimbolos.obtenerId("main")) == null) {
        System.out.println("[ERROR] El programa fuente no contiene la funcion de entrada main()!");
        System.exit(0);
      }

      Scope.finalizar();

      // Aqui comienza la traduccion recursiva
      nodoRaiz.traducirAJava();
      System.out.println("[INFO] El archivo fuente se tradujo exitosamente.\n");
    }

    if (args.length > 1)
      Traductor.finalizar();
  }
}
