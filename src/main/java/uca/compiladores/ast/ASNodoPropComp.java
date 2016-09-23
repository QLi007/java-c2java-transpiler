package uca.compiladores.ast;

import uca.compiladores.Traductor;

public class ASNodoPropComp extends ASNodo {
  public ASNodo definiciones;
  public ASNodo declaraciones;

  public ASNodoPropComp(ASNodo definiciones, ASNodo declaraciones) {
    this.definiciones = definiciones;
    this.declaraciones = declaraciones;
  }

  @Override
  public void verificaSemantica() {
    if (this.definiciones != null)
      this.definiciones.verificaSemantica();

    if (this.declaraciones != null)
      this.declaraciones.verificaSemantica();
  }

  @Override
  public void traducirAJava() {
    Traductor.separador = "";

    if (this.definiciones != null)
      this.definiciones.traducirAJava();

    if (this.declaraciones != null)
      this.declaraciones.traducirAJava();
  }
}
