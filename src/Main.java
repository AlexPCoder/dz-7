public enum SolarSystem {
    MERCURY(0, 2439, null),
    VENUS(50, 6051, MERCURY),
    EARTH(50, 6371, VENUS),
    MARS(75, 3389, EARTH),
    JUPITER(550, 69911, MARS),
    SATURN(650, 58232, JUPITER),
    URANUS(800, 25362, SATURN),
    NEPTUNE(900, 24622, URANUS);

    private final int orderFromSun;
    private final int prevDistance;
    private final int distanceFromSun;
    private final int radius;
    private final SolarSystem previousPlanet;
    private final SolarSystem nextPlanet;

    SolarSystem(int prevDistance, int radius, SolarSystem previousPlanet) {
        this.orderFromSun = previousPlanet == null ? 1 : previousPlanet.orderFromSun + 1;
        this.prevDistance = prevDistance;
        this.radius = radius;
        this.previousPlanet = previousPlanet;
        this.distanceFromSun = previousPlanet == null ? 0 : previousPlanet.distanceFromSun + prevDistance;

        // Наступна планета для попередньоі
        if (previousPlanet != null) {
            previousPlanet.nextPlanet = this;
        }

        // Якщо це остання планета
        this.nextPlanet = null;
    }

    public int getOrderFromSun() {
        return orderFromSun;
    }

    public int getPrevDistance() {
        return prevDistance;
    }

    public int getDistanceFromSun() {
        return distanceFromSun;
    }

    public int getRadius() {
        return radius;
    }

    public SolarSystem getPreviousPlanet() {
        return previousPlanet;
    }

    public SolarSystem getNextPlanet() {
        return nextPlanet;
    }
}
