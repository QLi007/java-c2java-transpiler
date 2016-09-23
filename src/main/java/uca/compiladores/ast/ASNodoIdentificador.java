package uca.compiladores.ast;

import uca.compiladores.TablaSimbolos;
import uca.compiladores.Traductor;
import uca.compiladores.scope.DefinicionScope;
import uca.compiladores.scope.Scope;

public class ASNodoIdentificador extends ASNodo {
  public int simboloId;

  public ASNodoIdentificador(int simboloId) {
    this.simboloId = simboloId;
  }

  @Override
  public void verificaSemantica() {
    DefinicionScope ds = Scope.scopeActual.buscarDefRecursivo(this.simboloId);
    if (ds == null) {
      System.out.println("[ERROR SEMANTICO] El identificador '" + TablaSimbolos.obtenerNombre(this.simboloId) + "' no ha sido declarado para su uso!");
      System.exit(0);
    }

    this.tipo = ds.tipo;
    this.lVal   = 1;

    if (ds.scope.scopePadre == null)
      this.fg = 'g';
  }

  @Override
  public void traducirAJava() {
    String s = TablaSimbolos.obtenerNombre(this.simboloId);

    if (s == "write")
      s = "System.out.println";
    else if (s == "read")
      s = "in.nexInt";
    else if (s == "main")
      s = "main_";

    Traductor.anadir(s);
  }
}
