package uca.compiladores.ast;

import uca.compiladores.TablaTipos;
import uca.compiladores.Traductor;
import uca.compiladores.tipos.TArray;
import uca.compiladores.tipos.Tipo;

public class ASNodoSubVar extends ASNodo {
  public int numElementos;
  public ASNodo var;

  public ASNodoSubVar(ASNodo var, int tamanho) {
    this.numElementos = tamanho;
    this.var = var;
  }

  @Override
  public void verificaSemantica() {
    Tipo defTipoVieja = TablaTipos.definicionTipoActual;

    if (TablaTipos.definicionTipoActual instanceof TArray)
      ((TArray) TablaTipos.definicionTipoActual).numElementos.add(numElementos);
    else
      TablaTipos.definicionTipoActual = new TArray(this.numElementos, TablaTipos.definicionTipoActual);

    this.var.verificaSemantica();
    this.tipo = this.var.tipo;
    this.fg = this.var.fg;

    TablaTipos.definicionTipoActual = defTipoVieja;
  }

  @Override
  public void traducirAJava() {
    Traductor.dentroDeUnArray = true;

    if (!Traductor.declaracionConInicializacion) {
      if ((this.var instanceof ASNodoVariable))
          this.var.traducirAJava();

    } else {
      if (this.var != null)
        this.var.traducirAJava();
    }
  }
}
