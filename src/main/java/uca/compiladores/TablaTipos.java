package uca.compiladores;

import uca.compiladores.tipos.Tipo;

import java.util.ArrayList;
import java.util.List;

public class TablaTipos {
  private static List<Tipo> _tabla = new ArrayList<Tipo>();
  private static int _tipoIdAnterior = 1;
  public static Tipo definicionTipoActual;
}
