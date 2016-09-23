package uca.compiladores.ast;

import uca.compiladores.Traductor;

public class ASNodoPropCONTINUE extends ASNodo {
  public ASNodoPropCONTINUE() { }

  @Override
  public void verificaSemantica() {
    if (ASNodoPropFOR.loopAnidados > 0) {

    } else {
      System.out.println("[ERROR SEMANTICO] El 'continue' no puede estar fuera del FOR!");
      System.exit(0);
    }
  }

  @Override
  public void traducirAJava() {
    Traductor.emitirTab();
    Traductor.anadir("continue;\n");
  }
}
