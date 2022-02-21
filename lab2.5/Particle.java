public class Particle {
    private static int n = 0;
    private double mass, speed;
    private static double energy = 0;

    public Particle(double inMass, double inSpeed){
        Particle.n += 1; 
        this.mass = inMass;
        this.speed = inSpeed;
        Particle.energy += mass * speed * speed / 2;
    }

    public static int n(){
        return Particle.n;
    }

    public String about(){
        return "mass = " + this.mass + ", speed = " + this.speed + ", particle energy = " + this.mass * this.speed * this.speed / 2;
    }

    public static double countEnergy(){
        return Particle.energy;
    }
}
