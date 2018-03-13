package ar.edu.itba.ss.off_lattice.models;

import org.springframework.util.Assert;

/**
 * Represents a particle of the simulation.
 * This is a point-alike particle (i.e it has no radius).
 */
public class Particle {


    /**
     * The 'x' value for this particle's position.
     */
    private double x;

    /**
     * The 'y' value for this particle's position.
     */
    private double y;

    /**
     * The module of this particle's speed.
     */
    private double speedModule;

    /**
     * The speed angle.
     */
    private double speedAngle;

    /**
     * Constructor.
     *
     * @param initialX The initial position in the x axis for this particle.
     * @param initialY The initial position in the y axis for this particle.
     */
    public Particle(final double initialX, final double initialY, final double initialSpeedModule, final double initialSpeedAngle) {
        x = initialX;
        y = initialY;
        speedModule = initialSpeedModule;
        speedAngle = initialSpeedAngle;
    }

    /**
     * Calculates the distance between {@code this} {@link Particle}, and the given {@code anotherParticle}.
     *
     * @param anotherParticle The {@link Particle} to which the distance to it must be calculated.
     * @return The calculated distance.
     */
    public double distanceTo(final Particle anotherParticle) {
        Assert.notNull(anotherParticle, "Must set another particle to calculate distance");
        final double x = getX() - anotherParticle.getX();
        final double y = getY() - anotherParticle.getY();

        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    /**
     * Makes the particle to move.
     *
     * @param limit The limit of the {@link Space} in which this {@link Particle} resides
     *              (i.e used for periodic boundary conditions).
     */
    public void move(final double limit) {
        final double auxX = (Math.cos(this.speedAngle) * this.speedModule) % limit;
        final double auxY = (Math.sin(this.speedAngle) * this.speedModule) % limit;
        x += auxX < 0 ? auxX + limit : auxX;
        y += auxY < 0 ? auxY + limit : auxY;
    }


    // ========================================
    // Getters and setters
    // ========================================

    /**
     * @return The 'x' value for this particle's position.
     */
    public double getX() {
        return x;
    }

    /**
     * @return The 'y' value for this particle's position.
     */
    public double getY() {
        return y;
    }

    /**
     * @return The module of this particle's speed.
     */
    public double getSpeedModule() {
        return speedModule;
    }

    /**
     * @return The speed angle.
     */
    public double getSpeedAngle() {
        return speedAngle;
    }

    /**
     * Changes the 'x' position of this particle.
     *
     * @param x The new value for the 'x' position.
     */
    public void setX(final double x) {
        this.x = x;
    }

    /**
     * Changes the 'y' position of this particle.
     *
     * @param y The new value for the 'y' position.
     */
    public void setY(final double y) {
        this.y = y;
    }

    /**
     * Changes the speed's module value for this particle.
     *
     * @param speedModule The new speed module value.
     */
    public void setSpeedModule(final double speedModule) {
        this.speedModule = speedModule;
    }

    /**
     * Changes the speed's angle value for this particle.
     *
     * @param speedAngle The new speed angle value.
     */
    public void setSpeedAngle(final double speedAngle) {
        this.speedAngle = speedAngle;
    }
}
