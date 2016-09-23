package uca.compiladores.tipos;

import uca.compiladores.ast.ASNodo;
import uca.compiladores.ast.ASNodoLista;

import java.util.ArrayList;
import java.util.List;

public class TFuncion extends Tipo {
    public List<Tipo> parametros;

  public TFuncion(ASNodoLista n, TPrimitiva tb) {
    if (n == null)
      return;

    this.basico = tb;
    this.parametros = new ArrayList<Tipo>();

    for (ASNodo param : n.lista) {
      this.parametros.add(param.tipo);
    }
  }

  public int cantParametros() {
    if (this.parametros == null)
      return 0;

    return this.parametros.size();
  }
}