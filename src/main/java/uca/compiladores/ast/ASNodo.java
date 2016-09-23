package uca.compiladores.ast;

import uca.compiladores.tipos.Tipo;

public abstract class ASNodo {
  public Tipo tipo;
  public int lVal = -1;
  public int offset = -1;
  int tamanhoMarco = -1;
  char fg = 'f';

  public void verificaSemantica(){};
  public void traducirAJava() {};
}
