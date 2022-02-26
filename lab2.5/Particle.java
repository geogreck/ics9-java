import java.lang.Math;

public class Particle {
    private static int n = 0;
    private double mass, speed, x, y, z;
    private static double energy = 0;

    public Particle(double inMass, double inSpeed){
        Particle.n += 1; 
        this.mass = inMass;
        this.speed = inSpeed;
        Particle.energy += mass * speed * speed / 2;
    }

    public Particle(double inMass, double inX, double inY, double inZ){
        Particle.n += 1;
        this.mass = inMass;
        this.x = inX;
        this.y = inY;
        this.z = inZ;
        this.speed = Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
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