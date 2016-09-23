package uca.compiladores.ast;

import uca.compiladores.TablaSimbolos;
import uca.compiladores.TablaTipos;
import uca.compiladores.Traductor;
import uca.compiladores.scope.Scope;
import uca.compiladores.tipos.TPrimitiva;
import uca.compiladores.tipos.Tipo;

public class ASNodoParametro extends ASNodo {
  public ASNodo var;

  public ASNodoParametro(Tipo tipoParametro, ASNodo var) {
    this.tipo = tipoParametro;
    this.var = var;
  }

  @Override
  public void verificaSemantica() {
    if (!(this.tipo.basico instanceof TPrimitiva)) {
      System.out.println("[ERROR SEMANTICO] El parametro '" + TablaSimbolos.obtenerNombre(((ASNodoVariable) this.var).simboloId) + "' debe ser del tipo INT o CHAR!");
      System.exit(0);
    }

    if (Scope.scopeActual.buscarDef(((ASNodoVariable)this.var).simboloId) != null) {
      System.out.println("[ERROR SEMANTICO] El parametro '" + TablaSimbolos.obtenerNombre(((ASNodoVariable) this.var).simboloId) + "' ha sido declarado dos veces");
      System.exit(0);
    }

    TablaTipos.definicionTipoActual = this.tipo;

    this.var.verificaSemantica();
  }

  @Override
  public void traducirAJava() {
    if (this.tipo.basico == TPrimitiva.CHAR)
      Traductor.anadir("String ");
    else
      Traductor.anadir("int ");

    if (this.var != null)
      this.var.traducirAJava();
  }
}
