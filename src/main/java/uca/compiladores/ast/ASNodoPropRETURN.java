package uca.compiladores.ast;

import uca.compiladores.Traductor;
import uca.compiladores.scope.DefinicionScope;
import uca.compiladores.scope.Scope;

public class ASNodoPropRETURN extends ASNodo {
  public ASNodo valorRetorno = null;

  public ASNodoPropRETURN(ASNodo valorRetorno) {
    this.valorRetorno = valorRetorno;
  }

  @Override
  public void verificaSemantica() {
    DefinicionScope ds = Scope.scopeActual.buscarDefFuncionActual();

    if (this.valorRetorno == ds.tipo.basico) //return del tipo void
      return;

    if (this.valorRetorno != null) {
      this.valorRetorno.verificaSemantica();
      this.tipo = this.valorRetorno.tipo;
    }


    if (ds.tipo.basico != this.tipo.basico) {
      System.out.println("[ERROR SEMANTICO] El tipo del valor de retorno de la función no concuerda con su definición!");
      System.exit(0);
    }
  }

  @Override
  public void traducirAJava() {
    Traductor.emitirTab();

    if (this.valorRetorno != null) {
      Traductor.anadir("return ");
      this.valorRetorno.traducirAJava();
    }
    else
      Traductor.anadir("return");

    Traductor.anadir(";");
  }
}