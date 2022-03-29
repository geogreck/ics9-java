import java.util.Iterator;

public class IntSet implements Iterable<Integer> {
    private Integer[] container;
    private int m;

    public IntSet(int m){
        this.m = m;
    }

    public void fillContainer(int... ints) {
        container = new Integer[ints.length];
        for (int i = 0; i < ints.length; i++) {
            container[i] = ints[i];
        }
    }

    public void changeElem(int i, int x) {
        try {
            container[i] = x;
        } catch (Exception e) {
            System.out.println("Error: index out of bounds");
        }
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getM() {
        return m;
    }

    @Override
    public String toString() {
        String ans = "[" + container[0];
        for (int i = 1; i < container.length; i++) {
                ans += ", " + container[i];
        }
        return ans + "]";
    }

    public Iterator<Integer> iterator() {
        return new IntSetIterator();
    }

    private class IntSetIterator implements Iterator<Integer>{
        private int pos;

        public IntSetIterator(){
            pos = 0;
        }

        @Override
        public boolean hasNext() {
            return pos < container.length;
        }

        @Override
        public Integer next() {
            return (int) Math.pow(container[pos++], m);
        }
    }

}
