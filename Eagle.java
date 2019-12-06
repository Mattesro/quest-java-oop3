public class Eagle extends Bird implements Fly {

    private boolean flying;
    private int altitude;

    public Eagle(String name) {
        super(name);
        this.flying = false;
        this.altitude = 0;
    }

    @Override
    public String sing() {
        return "Screech!";
    }

    public int getAltitude() {
        return altitude;
    }

    public boolean isFlying() {
        return flying;
    }

    /**
     * to start fly, must be on ground
     */
    @Override
    public void takeOff() {
        if (!this.flying && this.altitude == 0) {
            this.flying = true;
            System.out.printf("%s takes off in the sky.%n", this.getName());
        }
    }

    /**
     * fly highter
     */
    @Override
    public int ascend(int meters) {
        if (this.flying) {
            this.altitude = Math.max(this.altitude + meters, 0);
            System.out.printf("%s flies upward, altitude: %d%n", this.getName(), this.altitude);
        }
        return this.altitude;
    }

    /**
     * fly lower
     */
    @Override
    public int descend(int meters) {
        if (this.flying) {
            this.altitude = Math.max(this.altitude - meters, 0);
            System.out.printf("%s flies downward, altitude: %d%n", this.getName(), this.altitude);
        }
        return this.altitude;
    }

    /**
     * fly glides
     */
    @Override
    public void glide() {
        if (this.flying) {
            	System.out.printf("%s glides into the air.%n", this.getName());
        } else {
		System.out.printf("%s sit on the ground.%n", this.getName());
	}
    }

    /**
     * landing
     */
    @Override
    public void land() {
        if (this.flying && this.altitude <= 1) {
            	System.out.printf("%s lands on the ground.%n", this.getName());
        } else {
		System.out.printf("%s is to hight to landing.%n", this.getName());
	}
    }
}
