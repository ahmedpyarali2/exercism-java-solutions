import java.util.HashMap;
import java.util.Map;

public class CarsAssemble {

    private static final int unitsProducedAtMinSpeed = 221;
    private static final Map<Integer, Double> successRates = new HashMap<>(){
        {
            put(1, 1.0);
            put(2, 1.0);
            put(3, 1.0);
            put(4, 1.0);
            put(5, 0.9);
            put(6, 0.9);
            put(7, 0.9);
            put(8, 0.9);
            put(9, 0.8);
            put(10, 0.77);
        }
    };

    public double productionRatePerHour(int speed) {
        // calculate potential rate per hour -> speed * units produced at min speed
        double potentialRatePerHour = speed * unitsProducedAtMinSpeed;

        // remove potentially faulty cars -> potential rate * error rate at this speed
        // NOTE: default is 0.0 because the given speed input is either a negative
        // number or a speed greater than 10
        return potentialRatePerHour * successRates.getOrDefault(speed, 0.0);
    }

    public int workingItemsPerMinute(int speed) {
        return (int) (productionRatePerHour(speed) / 60);
    }
}
