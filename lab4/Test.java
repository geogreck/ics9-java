public class Test {
    public static void main(String[] args) {
        IntSet set = new IntSet(4);
        set.fillContainer(4, 8, 10);
        for (Integer integer : set) {
            System.out.println(integer);
        }
        System.out.println(set);
        set.changeElem(1, 5);
        System.out.println(set);
        for (Integer integer : set) {
            System.out.println(integer);
        }
    }
}
