package uca.compiladores.ast;

import uca.compiladores.Traductor;

public class ASNodoPropBREAK extends ASNodo {
  public ASNodoPropBREAK() { }

  @Override
  public void verificaSemantica() {
    if (ASNodoPropFOR.loopAnidados > 0) {

    } else {
      System.out.println("[ERROR SEMANTICO] El 'break' no puede estar fuera del FOR!");
      System.exit(0);
    }
  }

  @Override
  public void traducirAJava() {
    Traductor.emitirTab();
    Traductor.anadir("break;\n");
  }
}
