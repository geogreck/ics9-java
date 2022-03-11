public class Polynom implements Comparable<Polynom> {
    int coefficients[];
    int remainder = 0;

    public Polynom(int... inCoefs){
        int len = inCoefs.length;
        coefficients = new int[len];

        for (int i = len - 1; i >= 0; i--) {
            coefficients[len - i - 1] = inCoefs[i];
            remainder += inCoefs[i];
        }
    }

    @Override
    public int compareTo(Polynom obj) {
        return this.remainder - obj.remainder;
    }

    @Override
    public String toString() {
        String ans = "";
        String xStrTemp = " * x^";
        String xStr;
        for (int i = coefficients.length - 1; i > 0; i--) {
            int k = coefficients[i];
            if (i == 1) {
                if (coefficients[0] != 0){
                    xStr = " * x + ";
                } else {
                    xStr = " * x";
                }
            } else {
                xStr = xStrTemp + i + " + ";
            }
            ans += (k < 0 ? "- " + -1 * k + xStr : (k == 0 ? "" : 
                (k == 1 ? "x^" + i + " + " : k + xStr))) ;
        }
        ans += (coefficients[0] != 0 ? coefficients[0] : "") + "\nОстаток от деления на (x - 1): " + remainder + "\n";
        return ans;
    }

}
