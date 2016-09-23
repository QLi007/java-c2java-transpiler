package uca.compiladores.ast;

import uca.compiladores.Traductor;
import uca.compiladores.tipos.TPrimitiva;
import uca.compiladores.tipos.Tipo;

public class ASNodoConstante extends ASNodo {
  public int numero;

  public ASNodoConstante(int numero) {
    this.tipo   = new Tipo(TPrimitiva.INT);
    this.numero = numero;
  }

  @Override
  public void verificaSemantica() {
    this.lVal   = 0;
  }

  @Override
  public void traducirAJava() {
    Traductor.anadir(Integer.toString(this.numero));
  }
}
