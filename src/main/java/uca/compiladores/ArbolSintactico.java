package uca.compiladores;

import uca.compiladores.ast.ASNodo;

public class ArbolSintactico {
  private static ASNodo nodoRaiz;

  public static ASNodo getNodoRaiz() {
    return nodoRaiz;
  }

  public static void setNodoRaiz(Object nodoRaiz) {
    ArbolSintactico.nodoRaiz = (ASNodo) nodoRaiz;
  }
}
