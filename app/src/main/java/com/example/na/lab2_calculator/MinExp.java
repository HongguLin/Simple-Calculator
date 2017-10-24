package com.example.na.lab2_calculator;

/**
 * Created by linhonggu on 24/4/17.
 */
public class MinExp extends Exp {
    Exp left, right;

    public MinExp(Exp l, Exp r){
        left = l;
        right = r;
    }

    @Override
    public String show() {
        return "(" + left.show() + "-" + right.show()+ ")";
    }

    @Override
    public int evaluate(Subs subs) {
        return left.evaluate(subs) - right.evaluate(subs);
    }

    @Override
    public int size() {
        return left.size() + right.size() + 1;
    }

    @Override
    public int height() {
        return left.height() + right.height() + 1;
    }

    @Override
    public int operators() {
        return left.operators() + right.operators() + 1;
    }

    @Override
    public Exp simplify(Subs subs) {
        /*
        LitExp l = new LitExp(1);
        VarExp v = new VarExp("x");
        if(left.getClass() == l.getClass() && right.getClass() == l.getClass()){
            return "" + (left.evaluate(subs)-right.evaluate(subs));
        }else if(left.getClass() == v.getClass() || right.getClass() == v.getClass()){
            return "" + "(" + left.simplify(subs)+ "-" + right.simplify(subs) + ")";
        }else if(left.simplify(subs).charAt(0) == '(' || right.simplify(subs).charAt(0) == '('){
            return "" + "(" + left.simplify(subs)+ "/" + right.simplify(subs) + ")";
        }
        else {
            return "" + (Integer.parseInt(left.simplify(subs)) - Integer.parseInt(right.simplify(subs)));
        }
        */
        left = left.simplify(subs);
        right = right.simplify(subs);

        if (left instanceof LitExp && right instanceof LitExp){
            return new LitExp(((LitExp) left).value - ((LitExp) right).value);
        }
        return this;
    }

    @Override
    public String treeshow() {
        if (left == null && right == null) return " " + "-" + " ";
        String stl = left.treeshow();
        String str = right.treeshow();
        String stal[] = stl.split("\n");
        String star[] = str.split("\n");
        int lenl = stal[0].length();
        int lenr = star[0].length();
        StringBuffer res = new StringBuffer();
        String strdata = "-" + "";
        int centre = lenl;
        res.append(repeat(" ", (centre)) + strdata + repeat(" ", lenl + lenr - strdata.length() - centre) + "\n");
        int lcentre = centre(stal[0]);
        int rcentre = centre(star[0]);

        res.append(repeat(" ",lcentre) + "+" + repeat("-",centre-lcentre-1) + "+" + repeat("-",rcentre-1) +  "+" + repeat(" ",lenl+lenr-centre-rcentre -1) +" \n");
        res.append(repeat(" ",lcentre) + (left == null? " " : "|") + repeat(" ",centre-lcentre-1) + " " + repeat(" ",rcentre-1) +  (right == null? " " : "|") + repeat(" ",lenl+lenr-centre-rcentre-1) +" \n");

        for(int i = 0;i<Math.max(stal.length, star.length);i++) {
            res.append( (i<stal.length ? stal[i] : repeat(" ", lenl)) + (i<star.length? star[i] : repeat(" ", lenr)) + "\n");
        }
        return res.toString();
    }

    protected int centre(String string) {
        int i = 0;
        while (i < string.length() && string.charAt(i) == ' ') i++;
        return i;
    }

    protected String repeat(String string, int n) {
        String res = "";
        for (int i = 0; i<n;i++) res += string;
        return res;
    }
}
