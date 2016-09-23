package uca.compiladores.scope;

import uca.compiladores.tipos.TArray;
import uca.compiladores.tipos.TFuncion;
import uca.compiladores.tipos.Tipo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by diego on 7/6/14.
 */
public class Scope {
  HashMap<Integer, DefinicionScope> lista;
  public Scope scopePadre;
  public static Scope scopeActual;

  public void agregarDef(DefinicionScope def, int simboloId) {
    this.lista.put(simboloId, def);
    def.scope = this;
  }

  public Scope() {
    this.lista = new HashMap<Integer, DefinicionScope>();
  }

  public Scope(DefinicionScope def, int simboloId) {
    this();
    this.agregarDef(def, simboloId);
  }

  public DefinicionScope buscarDef(int simboloId) {
    if (lista.containsKey(simboloId))
      return lista.get(simboloId);

    return null;
  }

  public DefinicionScope buscarDefRecursivo(int simboloId) {
    DefinicionScope ds = buscarDef(simboloId);

    if (ds != null)
      return ds;

    if (this.scopePadre != null)
      return this.scopePadre.buscarDefRecursivo(simboloId);

    return null;
  }

  public DefinicionScope buscarDefFuncionActual() {
    if (scopePadre == null)
      return null;

    DefinicionScope ds = null;
    for (Map.Entry<Integer, DefinicionScope> entry : this.scopePadre.lista.entrySet())
      ds = entry.getValue();

    return ds;
  }

  public static void finalizar() {
    scopeActual = scopeActual.scopePadre;
  }

  public static void inicializarNuevo() {
    Scope nuevo = new Scope();
    nuevo.scopePadre = scopeActual;
    scopeActual = nuevo;
  }
}
