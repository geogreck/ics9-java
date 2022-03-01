import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        CProgram[] programs = new CProgram[]{
        new CProgram("disparray.c"),
        new CProgram("disparray_.c"),
        new CProgram("foo.c"),
        };
        Arrays.sort(programs);
        for (CProgram cProgram : programs) {
            System.out.println(cProgram);
        }
    }
}
