package uca.compiladores.ast;

import uca.compiladores.CParser;
import uca.compiladores.Traductor;
import uca.compiladores.tipos.TPrimitiva;

public class ASNodoPostfijo extends ASNodo {
  public int op;
  public ASNodo unario;

  public ASNodoPostfijo(int op, ASNodo unario) {
    this.op = op;
    this.unario = unario;
  }

  @Override
  public void verificaSemantica() {
    if (this.unario != null) {
      this.unario.verificaSemantica();
      this.tipo = this.unario.tipo;
      this.fg = this.unario.fg;

      if (this.unario.tipo.basico == TPrimitiva.CHAR) {
        if (this.op == CParser.Lexer.INC_OP || this.op == CParser.Lexer.DEC_OP) {
          System.out.println("[ERROR SEMANTICO] No se puede usar el operador postfijo '++' o '--' para un operando del tipo CHAR!");
          System.exit(0);
        }
      }
    }

    this.lVal = 0;
  }

  @Override
  public void traducirAJava() {
    if (this.unario != null)
      this.unario.traducirAJava();

    if (this.op == CParser.Lexer.INC_OP)
      Traductor.anadir("++");
    else if (this.op == CParser.Lexer.DEC_OP)
      Traductor.anadir("--");
  }
}
