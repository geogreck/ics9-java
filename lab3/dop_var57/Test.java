import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Polynom[] polynoms = new Polynom[]{
            new Polynom(1, -2, 1),
            new Polynom(5, 4, 0, 2, 1),
            new Polynom(10, 1, 3, 1),
            new Polynom(1)
        };
        Arrays.sort(polynoms);
        for (Polynom polynom : polynoms) {
            System.out.println(polynom);
        }
    }
}
