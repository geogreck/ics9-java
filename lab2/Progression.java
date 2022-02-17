public class Progression {
    private double a1;
    private double d;

    public Progression(double inA1, double inD){
        this.a1 = inA1;
        this.d = inD;
    }

    public void ifBelongs(double x){
        if ((x - this.a1) % this.d == 0){
            System.out.println("Число " + x + " принадлежит последовательности");
        } else {
            System.out.println("Число " + x + " не принадлежит последовательности");
        }
    }

    public double countSum(int n){
        return (2 * this.a1 + this.d * (n - 1)) * n / 2;
    }
}
