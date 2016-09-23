package uca.compiladores.scope;

import uca.compiladores.tipos.Tipo;

public class DefinicionScope {
  public Tipo tipo;
  public Scope scope;

  public DefinicionScope(Tipo t) { this.tipo = t; }
}
