package uca.compiladores.ast;

import uca.compiladores.Traductor;

public class ASNodoExpresion extends ASNodo {
  public ASNodo expr;

  public ASNodoExpresion(ASNodo expr) {
    this.expr = expr;
  }

  @Override
  public void verificaSemantica() {
    if (this.expr != null) {
      this.expr.verificaSemantica();

      this.tipo = this.expr.tipo;
      this.lVal   = this.expr.lVal;
    }
  }

  @Override
  public void traducirAJava() {
    Traductor.emitirTab();

    if (this.expr != null)
      this.expr.traducirAJava();

    Traductor.anadir(";\n");
  }
}
