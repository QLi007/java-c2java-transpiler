package uca.compiladores.ast;

import uca.compiladores.Traductor;
import uca.compiladores.tipos.TPrimitiva;
import uca.compiladores.tipos.Tipo;

public class ASNodoLiteral extends ASNodo {
  String caracter;

  public ASNodoLiteral(String caracter) {
    this.caracter = caracter;
    this.tipo = new Tipo(TPrimitiva.CHAR);
  }

  @Override
  public void verificaSemantica() {
    this.lVal = 0;
  }

  @Override
  public void traducirAJava() {
    Traductor.anadir(this.caracter);
  }
}
