/**
 * Created by linhonggu on 24/4/17.
 */
public class MyDemo {

    public static MulExp mul(Exp l,Exp r){
        return new MulExp(l,r);
    }

    public static AddExp add(Exp l,Exp r){
        return new AddExp(l,r);
    }

    public static MinExp min(Exp l,Exp r){
        return new MinExp(l,r);
    }

    public static DivExp div(Exp l,Exp r){
        return new DivExp(l,r);
    }

    public static LitExp lit(int v){
        return new LitExp(v);
    }

    public static VarExp var(String n){
        return new VarExp(n);
    }



    public static void main(String[] args) {
        Subs subs = new Subs();
        Exp e1 = mul(lit(2), add(lit(3), lit(5)));
        Exp e2 = add(lit(3), add(lit(2), lit(7)));
        Exp e3 = div(lit(60), min(lit(7), lit(1)));

        subs.put("mem1", 1);
        Exp e4 = add(var("mem1"),lit(6));

        subs.put("x", 1);
        Exp e5 = add(var("x"), mul(lit(3), lit(2)));
        Exp e6 = add(add(lit(2),lit(5)), var("x"));
        Exp e7 = add(lit(2), add(lit(5), var("x")));

        Exp e8 = mul(lit(2), add(lit(3), lit(5)));
        Exp e9 = add(lit(3), add(lit(2), lit(7)));

        System.out.println(e1.show() + " value is " + e1.evaluate(subs) + ". size is " + e1.size() + ". height is " + e1.height() + ". operators is "+ e1.operators() + ". simplify as " + e1.simplify(subs).show());
        System.out.println(e2.show() + " value is " + e2.evaluate(subs)+ ". size is " + e2.size() + ". height is " + e2.height() + ". operators is "+ e2.operators()+ ". simplify as " + e2.simplify(subs).show());
        System.out.println(e3.show() + " value is " + e3.evaluate(subs)+ ". size is " + e3.size() + ". height is " + e3.height() + ". operators is "+ e3.operators()+ ". simplify as " + e3.simplify(subs).show());

        System.out.println(e4.show() + " value is " + e4.evaluate(subs)+ ". size is " + e4.size() + ". height is " + e4.height() + ". operators is "+ e4.operators()+ ". simplify as " + e4.simplify(subs).show());


        System.out.println(e5.show() + " value is " + e5.evaluate(subs) + ". size is " + e5.size() + ". height is " + e5.height() + ". operators is "+ e5.operators() + ". simplify as " + e5.simplify(subs).show());
        System.out.println(e6.show() + " value is " + e6.evaluate(subs)+ ". size is " + e6.size() + ". height is " + e6.height() + ". operators is "+ e6.operators()+ ". simplify as " + e6.simplify(subs).show());
        System.out.println(e7.show() + " value is " + e7.evaluate(subs)+ ". size is " + e7.size() + ". height is " + e7.height() + ". operators is "+ e7.operators()+ ". simplify as " + e7.simplify(subs).show());


        System.out.println(e8.treeshow());
        System.out.println(e9.treeshow());


    }
}
