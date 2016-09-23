package uca.compiladores.ast;

import uca.compiladores.TablaTipos;
import uca.compiladores.Traductor;
import uca.compiladores.tipos.TPrimitiva;

public class ASNodoPropFOR extends ASNodo {
  public ASNodo init, cond, incr, cuerpo;
  public static int loopAnidados = 0;

  public ASNodoPropFOR(ASNodo init, ASNodo cond, ASNodo incr, ASNodo cuerpo) {
    this.init   = init;
    this.cond   = cond;
    this.incr   = incr;
    this.cuerpo = cuerpo;
  }

  @Override
  public void verificaSemantica() {
    this.init.verificaSemantica();
    this.cond.verificaSemantica();

    if (this.cond.tipo.basico != TPrimitiva.INT) {
      System.out.println("[ERROR SEMANTICO] La condicion del FOR debe ser una expresion del tipo INT!");
      System.exit(0);
    }

    this.incr.verificaSemantica();
    loopAnidados++;
    this.cuerpo.verificaSemantica();
    loopAnidados--;
  }

  @Override
  public void traducirAJava() {
    Traductor.emitirTab();
    Traductor.anadir("for (");

    if (this.init != null)
      this.init.traducirAJava();

    Traductor.anadir("; ");

    if (this.cond != null)
      Traductor.traducirExprBooleana(this.cond, true);

    Traductor.anadir("; ");

    if (this.incr != null)
      this.incr.traducirAJava();

    Traductor.anadir(") {\n");
    Traductor.numeroTabs++;

    if (this.cuerpo != null)
      this.cuerpo.traducirAJava();

    Traductor.numeroTabs--;
    Traductor.emitirTab();
    Traductor.anadir("}\n");
  }
}