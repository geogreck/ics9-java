import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Stream;

public class EquasionsSet {
    private HashMap<String, ArrayList<Integer>> Set;
    int amount;

    public EquasionsSet() {
        amount = 0;
        Set = new HashMap<String, ArrayList<Integer>>();
    }

    public Optional<Integer> getVarMinValue(String varName) {
        Optional<Integer> result = Optional.empty();
        Optional<ArrayList<Integer>> temp = Optional.ofNullable(Set.get(varName));
        if (temp.isPresent()) {
            result = Optional.ofNullable(temp.get().stream().max(Comparator.comparing(Integer::valueOf)).get() + 1);
        }
        return result;
    }

    public void addEquasion(String expr) {
        Equasion eqs = new Equasion(expr);
        ArrayList<Integer> arr = Set.get(eqs.varName);
        if (arr == null) {
            arr = new ArrayList<Integer>();
        }
        arr.add(eqs.a);
        Set.put(eqs.getVarName(), arr);
    }

    public void addEquasion(String varName, int a) {
        Equasion eqs = new Equasion(varName, a);
        ArrayList<Integer> arr = Set.get(eqs.varName);
        if (arr == null) {
            arr = new ArrayList<Integer>();
        }
        arr.add(eqs.a);
        Set.put(eqs.getVarName(), arr);
    }

    public Stream<String> equasionStream(){
        ArrayList<String> result = new ArrayList<String>();
        Set.entrySet().stream().filter(x -> x.getValue().stream().filter(y -> y >= 0).count() > 0).forEach(x -> result.add(x.getKey()));
        return result.stream();
    }

    private class Equasion {
        private String varName;
        private int a;

        public Equasion(String expr){
            try {
                int i = expr.indexOf(">");
                varName = expr.substring(0, i);
                a = Integer.parseInt(expr.substring(i + 1, expr.length()));
            } catch (Exception e) {
                System.out.println("Error: Not an equasion");
            }
        }

        public Equasion(String varName, int a){
            this.varName = varName;
            this.a = a;
        }

        public String getVarName() {
            return varName;
        }

        @Override
        public String toString() {
            return varName + ">" + a;
        }
    }
}
