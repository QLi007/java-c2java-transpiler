package uca.compiladores.ast;

import uca.compiladores.Traductor;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ASNodoLista extends ASNodo {
  public int tipoToken;
  public List<ASNodo> lista;

  public void anadir(ASNodo l) {
    this.lista.add(l);
  }

  public ASNodoLista(int tipoToken, ASNodo nodo) {
    this.tipoToken = tipoToken;
    this.lista = new ArrayList<ASNodo>();
    this.lista.add(nodo);
  }

  @Override
  public void verificaSemantica() {
    for (ASNodo n : this.lista) {
      n.verificaSemantica();

      n.fg = this.lista.get(0).fg;
      this.tipo = this.lista.get(0).tipo;
    }
  }

  @Override
  public void traducirAJava() {
    ListIterator iterador = this.lista.listIterator();

    while(iterador.hasNext())
    {
      ASNodo n = this.lista.get(iterador.nextIndex());

      if (n instanceof ASNodoLista)
        Traductor.anadir("{");

      n.traducirAJava();

      if (n instanceof ASNodoLista)
        Traductor.anadir("}");

      iterador.next();
      if (iterador.hasNext())
        Traductor.anadir(Traductor.separador);
    }
  }
}
