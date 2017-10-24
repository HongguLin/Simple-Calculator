/**
 * Created by linhonggu on 10/5/17.
 */
public class Stage1_Demo {
    public static void main(String[] args) {
        testexp("(2*(3+5))");
        testexp("(3-(2+7))");
        testexp("(60/(7-1))");
        testexp("(X+6)");
    }

    private static void testexp(String str) {
        Tokenizer tok = new SimpleTokenizer(str);
        Exp exp = Exp.parseExp(tok);
        showandeval(str, exp);
    }

    private static void showandeval(String raw, Exp exp) {
        Subs subs = new Subs();
        subs.put("X", 1);
        System.out.println("parsing " + raw + " is " + exp.show() + " evaluates to " + exp.evaluate(subs));
        System.out.println(exp.treeshow());
    }
}
