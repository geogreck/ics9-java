public class Universe {
    public static void main(String[] args) {
        Particle a = new Particle(100, 10);
        System.out.println(a.about());
        System.out.println("Количество частиц: " + Particle.n());

        Particle b = new Particle(200, 1);
        System.out.println(b.about());
        System.out.println("Энергия вселенной " + Particle.countEnergy());

        Particle c = new Particle(1000, 20);
        System.out.println(c.about());
        System.out.println("Количество частиц: " + Particle.n());
        System.out.println("Энергия вселенной " + Particle.countEnergy());
    }
}
