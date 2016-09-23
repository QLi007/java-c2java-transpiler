package uca.compiladores.ast;

import uca.compiladores.CParser;
import uca.compiladores.Traductor;
import uca.compiladores.tipos.TPrimitiva;
import uca.compiladores.tipos.Tipo;

public class ASNodoOperacionBinaria extends ASNodo {
  public int op;
  public ASNodo ladoIzq;
  public ASNodo ladoDer;

  public ASNodoOperacionBinaria(int op, ASNodo ladoIzq, ASNodo ladoDer) {
    this.op = op;
    this.ladoIzq = ladoIzq;
    this.ladoDer = ladoDer;
  }

  @Override
  public void verificaSemantica() {
    this.ladoIzq.verificaSemantica();
    this.ladoDer.verificaSemantica();

    switch (this.op) {
      case '=':
        if (this.ladoIzq.tipo.basico != this.ladoDer.tipo.basico) {
          System.out.println("[ERROR SEMANTICO] Tipos incompatibles en la asignación!");
          System.exit(0);
        }

        if (this.ladoIzq.lVal == 0) {
          System.out.println("[ERROR SEMANTICO] No se puede hacer la asignación hacia la derecha del operando!");
          System.exit(0);
        }

        this.tipo = new Tipo(this.ladoIzq.tipo.basico);
        this.lVal = 1;
        break;
      case CParser.Lexer.ADD_ASSIGN:
      case CParser.Lexer.SUB_ASSIGN:
        if (this.ladoIzq.tipo.basico == this.ladoDer.tipo.basico && this.ladoIzq.tipo.basico == TPrimitiva.INT) {
          System.out.println("[ERROR SEMANTICO] Tipos incompatibles en la asignación matemática!");
          System.exit(0);
        }

        if (this.ladoIzq.lVal == 0) {
          System.out.println("[ERROR SEMANTICO] No se puede hacer la asignación hacia la derecha del operando!");
          System.exit(0);
        }

        this.tipo = new Tipo(TPrimitiva.INT);
        this.lVal = 1;
        break;
      default:
        if (this.ladoIzq.tipo.basico != this.ladoDer.tipo.basico) {
          System.out.println("[ERROR SEMANTICO] Tipos incompatibles en la asignación!");
          System.exit(0);
        }
        this.tipo = new Tipo(this.ladoIzq.tipo.basico);
        this.lVal = 0;
        break;
    }
  }

  @Override
  public void traducirAJava() {
    if (this.ladoIzq != null)
      this.ladoIzq.traducirAJava();

    Traductor.anadir(" " + Traductor.traducirOpBinario(this.op) + " ");

    if (this.ladoDer != null)
      this.ladoDer.traducirAJava();
  }
}
