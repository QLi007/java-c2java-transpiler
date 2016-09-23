package uca.compiladores.ast;

import uca.compiladores.TablaTipos;
import uca.compiladores.Traductor;
import uca.compiladores.tipos.TArray;
import uca.compiladores.tipos.TPrimitiva;
import uca.compiladores.tipos.Tipo;

public class ASNodoDefinicion extends ASNodo {
  public ASNodo declaraciones;

  public ASNodoDefinicion(Tipo definicionTipo, ASNodo decs) {
    this.tipo           = definicionTipo;
    this.declaraciones  = decs;
  }

  @Override
  public void verificaSemantica() {
//    this.tipo = TablaTipos.anadir(this.tipo);
    TablaTipos.definicionTipoActual = this.tipo;

    this.declaraciones.verificaSemantica();
    this.fg = this.declaraciones.fg;
  }

  @Override
  public void traducirAJava() {
    String s = "";

    Traductor.emitirTab();

    if (this.fg == 'g')
      Traductor.anadir("static ");

    if (Traductor.dentroDeUnClass)
      Traductor.anadir("public ");

    if (this.tipo.basico == TPrimitiva.INT)
      s = "int";
    else if (this.tipo.basico == TPrimitiva.CHAR)
      s = "String";

    if (this.declaraciones.tipo instanceof TArray) {
      for (Integer i : ((TArray) this.declaraciones.tipo).numElementos)
        s += "[]";
    }

    Traductor.anadir(s + " ");
    Traductor.separador = ", ";

    this.declaraciones.traducirAJava();

    Traductor.separador = "";
    Traductor.anadir(";");

    if (Traductor.completarLlave)
      Traductor.anadir(" }");

    Traductor.completarLlave = false;
    Traductor.anadir("\n");
  }
}
