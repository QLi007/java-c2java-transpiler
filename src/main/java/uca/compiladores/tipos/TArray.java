package uca.compiladores.tipos;

import java.util.ArrayList;
import java.util.List;

public class TArray extends Tipo {
  public List<Integer> numElementos = new ArrayList<Integer>();

  public TArray(int tamanho, Tipo t) {
    this.numElementos.add(tamanho);
    this.basico = t.basico;
  }
}
