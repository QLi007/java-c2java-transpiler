package uca.compiladores.ast;

import uca.compiladores.Traductor;
import uca.compiladores.tipos.TPrimitiva;

public class ASNodoPropIF extends ASNodo {
  public ASNodo cond, then, els;

  public ASNodoPropIF(ASNodo cond, ASNodo then, ASNodo els) {
    this.cond = cond;
    this.then = then;
    this.els  = els;
  }

  @Override
  public void verificaSemantica() {
    this.cond.verificaSemantica();

    if (this.cond.tipo.basico != TPrimitiva.INT) {
      System.out.println("[ERROR SEMANTICO] La condicion de una sentencia IF debe ser una expresión del tipo INT!");
      System.exit(0);
    }

    if (this.then != null)
      this.then.verificaSemantica();

    if (this.els != null)
      this.els.verificaSemantica();
  }

  @Override
  public void traducirAJava() {
    Traductor.emitirTab();

    Traductor.anadir("if (");

    if (this.cond != null)
      Traductor.traducirExprBooleana(this.cond, true);

    Traductor.anadir(") {\n");
    Traductor.numeroTabs++;

    if (this.then != null) {
      this.then.traducirAJava();
    }

    Traductor.numeroTabs--;
    Traductor.anadir("\n");
    Traductor.emitirTab();
    Traductor.anadir("}\n");

    if (this.els != null) {
      Traductor.emitirTab();
      Traductor.anadir("else {\n");
      Traductor.numeroTabs++;
      this.els.traducirAJava();
      Traductor.numeroTabs--;
      Traductor.emitirTab();
      Traductor.anadir("}\n");
    }
  }
}
