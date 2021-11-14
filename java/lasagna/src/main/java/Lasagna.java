public class Lasagna {
    private static final Integer expectedMinutesInOven = 40;
    private static final int timePerLayer = 2;

    public int expectedMinutesInOven() {
        return expectedMinutesInOven;
    }

    public int remainingMinutesInOven(int minutesInOven) {
        return expectedMinutesInOven - minutesInOven;
    }

    public int preparationTimeInMinutes(int layers) {
        return layers * timePerLayer;
    }

    public int totalTimeInMinutes(int numberOfLayers, int minutesInOven) {
        return preparationTimeInMinutes(numberOfLayers) + minutesInOven;
    }
}
