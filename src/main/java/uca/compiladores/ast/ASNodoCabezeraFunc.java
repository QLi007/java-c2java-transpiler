package uca.compiladores.ast;

import uca.compiladores.TablaSimbolos;
import uca.compiladores.Traductor;
import uca.compiladores.scope.DefinicionScope;
import uca.compiladores.scope.Scope;
import uca.compiladores.tipos.TFuncion;
import uca.compiladores.tipos.TPrimitiva;

public class ASNodoCabezeraFunc extends ASNodo {
  public int simboloId;
  public ASNodo parametros;

  public ASNodoCabezeraFunc(int simboloId, ASNodo parametros) {
    this.simboloId  = simboloId;
    this.parametros = parametros;
  }

  @Override
  public void verificaSemantica() {
    if ((Scope.scopeActual.buscarDef(this.simboloId)) != null) {
      System.out.println("[ERROR SEMANTICO] La función '" + TablaSimbolos.obtenerNombre(this.simboloId) + "' ya se ha declarado!");
      System.exit(0);
    }

    Scope.scopeActual.agregarDef(new DefinicionScope(new TFuncion((ASNodoLista)this.parametros, (TPrimitiva)this.tipo.basico)), simboloId);
    Scope.inicializarNuevo();

    if (this.parametros != null)
      this.parametros.verificaSemantica();
  }

  @Override
  public void traducirAJava() {
    String nombreFuncion = TablaSimbolos.obtenerNombre(this.simboloId);

    if (nombreFuncion.equals("main")) {
      Traductor.anadir("main_(int argc, String[] args)");
      return;
    }

    Traductor.anadir(nombreFuncion + "(");
    Traductor.separador = ", ";

    if (this.parametros != null)
      this.parametros.traducirAJava();

    Traductor.separador = "";
    Traductor.anadir(")");
  }
}
