package uca.compiladores.ast;

import uca.compiladores.Traductor;
import uca.compiladores.scope.Scope;
import uca.compiladores.tipos.TPrimitiva;
import uca.compiladores.tipos.Tipo;

public class ASNodoDefinicionFuncion extends ASNodo {
  public ASNodo cabezera;
  public ASNodo cuerpo;

  public ASNodoDefinicionFuncion(Tipo tipoRetorno, ASNodo cabezera, ASNodo cuerpo) {
    this.tipo = tipoRetorno;
    this.cabezera = cabezera;
    this.cuerpo = cuerpo;
  }

  @Override
  public void verificaSemantica() {
    if (this.tipo.basico != null && !(this.tipo.basico instanceof TPrimitiva)) {
      System.out.println("[ERROR SEMANTICO] El retorno de la función no es del tipo INT, CHAR o VOID!");
      System.exit(0);
    }
    this.cabezera.tipo = this.tipo;
    this.cabezera.verificaSemantica();
    this.cuerpo.verificaSemantica();

    Scope.scopeActual.finalizar();
  }

  @Override
  public void traducirAJava() {
    Traductor.emitirTab();

    if (this.tipo.basico == null)
      Traductor.anadir("static void ");
    else if (this.tipo.basico == TPrimitiva.CHAR)
      Traductor.anadir("static String ");
    else
      Traductor.anadir("static int ");

    if (this.cabezera != null)
      this.cabezera.traducirAJava();

    Traductor.anadir(" {\n");
    Traductor.separador = "";
    Traductor.numeroTabs++;

    if (this.cuerpo != null)
      this.cuerpo.traducirAJava();

    Traductor.numeroTabs--;
    Traductor.anadir("\n");
    Traductor.emitirTab();
    Traductor.anadir("}\n");
  }
}
