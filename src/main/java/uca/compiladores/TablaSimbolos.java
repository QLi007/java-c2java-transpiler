package uca.compiladores;

import java.util.*;

public class TablaSimbolos {
  private static final List lista = new ArrayList<String>();

  public static int agregar(String nombre) {
    lista.add(nombre);

    return lista.indexOf(nombre);
  }

  public static Integer obtenerId(String nombre) {
    int index;

    if ((index = lista.indexOf(nombre)) > 0)
      return index;

    return agregar(nombre);
  }

  public static String obtenerNombre(int id) {
    try {
      return (String)lista.get(id);
    } catch (IndexOutOfBoundsException err) {
      return "test";
    }
  }
}
