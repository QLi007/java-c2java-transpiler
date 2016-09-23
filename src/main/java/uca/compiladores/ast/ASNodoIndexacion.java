package uca.compiladores.ast;

import uca.compiladores.Traductor;
import uca.compiladores.tipos.TArray;

import java.util.ArrayList;
import java.util.List;

public class ASNodoIndexacion extends ASNodo {
  public ASNodo postfija;
  public ASNodo expr;
  public List<Integer> dimension;

  public ASNodoIndexacion(ASNodo postfija, ASNodo expr) {
    this.postfija = postfija;
    this.expr     = expr;

    this.dimension = new ArrayList<Integer>();
  }

  @Override
  public void verificaSemantica() {
    if (this.postfija instanceof ASNodoIndexacion && this.expr instanceof ASNodoConstante) {
      this.dimension.add(((ASNodoConstante) this.expr).numero);
      ((ASNodoIndexacion) this.postfija).dimension = this.dimension;
    }

    this.postfija.verificaSemantica();

    if (!(this.postfija.tipo instanceof TArray)) {
      System.out.println("[ERROR SEMANTICO] El operador '[]' solo se puede usar con una variable del tipo ARRAY!");
      System.exit(0);
    }

    this.tipo = this.postfija.tipo;

    if (this.expr != null) {
      this.expr.verificaSemantica();

      if (this.expr instanceof ASNodoConstante && this.postfija instanceof ASNodoIdentificador) {
        this.dimension.add(((ASNodoConstante) this.expr).numero);
        if (this.dimension.size() != ((TArray) this.postfija.tipo).numElementos.size()) {
          System.out.println("[ERROR SEMANTICO] El número de dimensiones a usarse no coincide con la declaración del vector!");
          System.exit(0);
        }

        int i = 0;
        for (Integer index : this.dimension) {
          if (index > ((TArray) this.postfija.tipo).numElementos.get(i) - 1) {
            System.out.println("[ERROR SEMANTICO] El operador '[]' solo puede ser usado dentro del límite definido!");
            System.exit(0);
          }
          i++;
        }
      }
    }

    this.lVal = 1;
    this.fg = this.postfija.fg;
  }

  @Override
  public void traducirAJava() {
    if (this.postfija != null)
      this.postfija.traducirAJava();

    Traductor.anadir("[");

    if (this.expr != null)
      this.expr.traducirAJava();

    Traductor.anadir("]");
  }
}
