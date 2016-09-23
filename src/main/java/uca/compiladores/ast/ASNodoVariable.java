package uca.compiladores.ast;

import uca.compiladores.Traductor;
import uca.compiladores.scope.DefinicionScope;
import uca.compiladores.scope.Scope;
import uca.compiladores.TablaSimbolos;
import uca.compiladores.TablaTipos;

public class ASNodoVariable extends ASNodo {
  public int simboloId;

  public ASNodoVariable(int simboloId) {
    this.simboloId = simboloId;
  }

  @Override
  public void verificaSemantica() {
    if ((Scope.scopeActual.buscarDef(this.simboloId)) != null) {
      System.out.println("[ERROR SEMANTICO] La variable '" + TablaSimbolos.obtenerNombre(this.simboloId) + "' ya se ha declarado!");
      System.exit(0);
    }

    this.tipo = TablaTipos.definicionTipoActual;
    Scope.scopeActual.agregarDef(new DefinicionScope(TablaTipos.definicionTipoActual), this.simboloId);

    if (Scope.scopeActual.scopePadre == null)
      this.fg = 'g'; // variable global
  }

  @Override
  public void traducirAJava() {
    Traductor.anadir(TablaSimbolos.obtenerNombre(this.simboloId));
  }
}
