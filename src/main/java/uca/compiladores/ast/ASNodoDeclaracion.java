package uca.compiladores.ast;

import uca.compiladores.TablaTipos;
import uca.compiladores.Traductor;
import uca.compiladores.tipos.TArray;

public class ASNodoDeclaracion extends ASNodo {
  public ASNodo var;
  public ASNodo inicializacion;

  public ASNodoDeclaracion(ASNodo var, ASNodo inicializacion) {
    this.var = var;
    this.inicializacion = inicializacion;
  }

  void verificaSemanticaVector(ASNodo nodo, int nivel, TArray tipo) {
    if (nodo instanceof ASNodoLista) {
      int index = tipo.numElementos.size() - nivel - 1;
      if (index < 0 || ((ASNodoLista) nodo).lista.size() > tipo.numElementos.get(index)) {
        System.out.println("[ERROR SEMANTICO] El número de elementos del vector que se quiere inicializar sobrepasa el límite declarado para el vector!");
        System.exit(0);
      }

      if (1 == 1) {
        nivel++;
        for (ASNodo n : ((ASNodoLista) nodo).lista)
          verificaSemanticaVector(n, nivel, tipo);
      }
    } else if (nodo.tipo.basico != tipo.basico) {
      System.out.println("[ERROR SEMANTICO] Uno de los elementos de la inicializacion del vector no concuerda con el tipo de datos del lado izquierdo!");
      System.exit(0);
    }
  }

  @Override
  public void verificaSemantica() {
    this.tipo = TablaTipos.definicionTipoActual;
    if (this.inicializacion != null) {
      this.inicializacion.verificaSemantica();

      this.var.verificaSemantica();
      if (this.inicializacion instanceof ASNodoLista) {
        if (!(this.var.tipo instanceof TArray)) {
          System.out.println("[ERROR SEMANTICO] Error en la inicialización de variable. No se puede inicializar una variable normal con un vector de elementos!");
          System.exit(0);
        }

        if (((ASNodoLista) this.inicializacion).lista.size() == 1)
          verificaSemanticaVector(((ASNodoLista) this.inicializacion).lista.get(0), 0, (TArray)this.var.tipo);
        else
          verificaSemanticaVector(this.inicializacion, 0, (TArray)this.var.tipo);
      }
      else if (this.tipo.basico != this.inicializacion.tipo.basico) {
        System.out.println("[ERROR SEMANTICO] Los tipos no coinciden en la inicialización!");
        System.exit(0);
      }
    }
    else
      this.var.verificaSemantica();

    this.tipo = this.var.tipo;
    this.fg = this.var.fg;
  }

  @Override
  public void traducirAJava() {
    if (this.inicializacion != null)
      Traductor.declaracionConInicializacion = true;
    else
      Traductor.declaracionConInicializacion = false;

    this.var.traducirAJava();

    if (this.inicializacion != null) {
      Traductor.anadir(" = ");
      if (this.inicializacion instanceof ASNodoLista) {
        if (((ASNodoLista) this.inicializacion).lista.size() > 1)
          Traductor.anadir("{");

        this.inicializacion.traducirAJava();

        if (((ASNodoLista) this.inicializacion).lista.size() > 1)
          Traductor.anadir("}");
      }
      else
        this.inicializacion.traducirAJava();
    }
  }
}
