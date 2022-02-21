public class Test {
    public static void main(String[] args){
        Progression An1 = new Progression(10, 3);
        System.out.println(An1.toString());
        System.out.println(An1.countSum(3)); //10 + 13 + 16 = 39
        An1.ifBelongs(14);
        An1.ifBelongs(130);

        Progression An2 = new Progression(100, -10);
        System.out.println(An2.toString());
        System.out.println(An2.countSum(21));
        An2.ifBelongs(80);
        An2.ifBelongs(85);
    }
}
