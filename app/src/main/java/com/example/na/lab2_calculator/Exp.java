package com.example.na.lab2_calculator;

/**
 * Created by linhonggu on 24/4/17.
 */
public abstract class Exp {
    abstract public String show();
    abstract public int evaluate(Subs subs);
    abstract public int size();
    abstract public int height();
    abstract public int operators();
    abstract public Exp simplify(Subs subs);
    abstract public String treeshow();

    /*
	 *
	 * <exp> ::= <Literal> | <variable>  | '(' <Literal> <operator> <Literal> ')'
	 * <exps> ::= <exp> | <exp> , <exps>
	 * <variable> := 'X'
     * <Literal> ::= <decimal digit> {<decimal digit>}
	 * <decimal digit> ::= '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9'
	 * <operator> ::= '+' | '-'  | '*' | '/'
	 *
	 */



    static public Exp parseExp(Tokenizer tok) {
        if (tok.current() instanceof Integer) {
            int i = (Integer) tok.current();
            tok.next(); // consume the Integer
            return new LitExp(i);
        } else if (tok.current().equals("(")) {
            tok.next(); // consume the "("
            Exp exp1 = parseExp(tok); // recursively parse the sub expression
            String op = tok.current().toString();
            tok.next();
            Exp exp2 = parseExp(tok);
            tok.parse(")");
            if (op == "+"){
                return new AddExp(exp1,exp2);
            }else if(op == "-"){
                return new MinExp(exp1,exp2);
            }else if(op == "*"){
                return new MulExp(exp1,exp2);
            }else {
                return new DivExp(exp1,exp2);
            }
        } else if(tok.current().equals("X")){
            VarExp varExp = new VarExp(tok.current().toString());
            tok.next();
            tok.parse("=");
            Exp exp = parseExp(tok);
            return new AssignExp(varExp,exp);
        }
        throw new Error();
    }


}
