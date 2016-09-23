package uca.compiladores.ast;

import uca.compiladores.TablaSimbolos;
import uca.compiladores.Traductor;
import uca.compiladores.scope.DefinicionScope;
import uca.compiladores.scope.Scope;
import uca.compiladores.tipos.TFuncion;

public class ASNodoLLamadaFuncion extends ASNodo {
  public ASNodo postfija;
  public ASNodo args;

  public ASNodoLLamadaFuncion(ASNodo postfija, ASNodo args) {
    this.postfija = postfija;
    this.args     = args;
  }

  public int cantArgumentos() {
    if (this.args == null)
      return 0;

    return ((ASNodoLista)this.args).lista.size();
  }

  @Override
  public void verificaSemantica() {
    DefinicionScope ds;
    if ((ds = Scope.scopeActual.buscarDefRecursivo(((ASNodoIdentificador)this.postfija).simboloId)) == null) {
      System.out.println("[ERROR SEMANTICO] La función '" + TablaSimbolos.obtenerNombre(((ASNodoIdentificador) this.postfija).simboloId) + "' no fue declarada!");
      System.exit(0);
    }

    this.postfija.verificaSemantica();
    this.tipo = this.postfija.tipo;
    this.lVal = 0;
    this.postfija.lVal = 0;

    if (!(ds.tipo instanceof TFuncion)) {
      System.out.println("[ERROR SEMANTICO] El identificador '" +
        TablaSimbolos.obtenerNombre(((ASNodoIdentificador) this.postfija).simboloId) +
        "' no es del tipo FUNCION!");
      System.exit(0);
    }

    if (this.cantArgumentos() != ((TFuncion) ds.tipo).cantParametros()) {
      System.out.println("[ERROR SEMANTICO] La cantidad de argumentos para la llamada a función '" +
        TablaSimbolos.obtenerNombre(((ASNodoIdentificador) this.postfija).simboloId) +
        "' no coincide con su definicion!");
      System.exit(0);
    }

    // verifica cada argumento, que coincida con la firma de la función
    if (this.args != null) {
      int i = 0;
      for (ASNodo p : ((ASNodoLista)this.args).lista) {
        p.verificaSemantica();

        if (p.tipo.basico != ((TFuncion) ds.tipo).parametros.get(i).basico) {
          System.out.println("[ERROR SEMANTICO] El argumento " + i + " en la funcion '" +
            TablaSimbolos.obtenerNombre(((ASNodoIdentificador)this.postfija).simboloId) +
            "' no es del tipo previamente declarado!");
          System.exit(0);
        }
        i++;
      }
    }

    this.fg = this.postfija.fg;
  }

  @Override
  public void traducirAJava() {
    if (this.postfija != null)
      this.postfija.traducirAJava();

    Traductor.anadir("(");

    if (this.args != null) {
      Traductor.separador = ", ";
      this.args.traducirAJava();
      Traductor.separador = "";
    }

    Traductor.anadir(")");
  }
}
