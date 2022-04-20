import java.util.NoSuchElementException;

public class Test {
    public static void main(String[] args) {
        EquasionsSet test = new EquasionsSet();
        test.addEquasion("x>0");
        test.addEquasion("x>-10");
        test.addEquasion("a", 10);
        test.addEquasion("x", 11);
        test.equasionStream().sorted(new NameComparator()).forEach(System.out::println);

        System.out.println(test.getVarMinValue("x").get());
        System.out.println(test.getVarMinValue("a").get());
        try {
            System.out.println(test.getVarMinValue("c").get());  
        } catch (NoSuchElementException e) {
            System.out.println(e);
        }
    }
}
