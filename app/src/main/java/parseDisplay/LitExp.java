/**
 * Created by linhonggu on 24/4/17.
 */
public class LitExp extends Exp {

    int value;

    public LitExp(int v){
        value = v;
    }
    @Override
    public String show() {
        return "" + value;
    }

    @Override
    public int evaluate(Subs subs) {
        return value;
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public int operators() {
        return 0;
    }

    @Override
    public Exp simplify(Subs subs) {
        return this;
    }

    @Override
    public String treeshow() {
        return "  " + value + "  ";
    }


}
