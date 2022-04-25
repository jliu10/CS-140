import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Iterator;

class liu_Car implements CarFunctions
{
	private final String id;
	private final int fuelEconomyInMilesPerGallon;
	private final int fuelCapacityInGallons;
	private double currentFuelInGallons;

	liu_Car(String d, int fE, int fC, double cF) {
		id = d;
		fuelEconomyInMilesPerGallon = fE;
		fuelCapacityInGallons = fC;
		currentFuelInGallons = cF;
	}

	public int getFuelEconomyInMilesPerGallon() {
		return fuelEconomyInMilesPerGallon;
	}

	public int getFuelCapacityInGallons() {
		return fuelCapacityInGallons;
	}

	public double getCurrentFuelInGallons() {
		return currentFuelInGallons;
	}

	public String getId() {
		return id;
	}

	public void setCurrentFuelInGallons(double v) {
		currentFuelInGallons = v;
	}

	public String toString()
	{
		return getId() + "\t" + getFuelEconomyInMilesPerGallon() + "\t" + getFuelCapacityInGallons() + "\t" + getCurrentFuelInGallons() + "\t" + getTotalRangeInMiles() + "\t" + getRemainingRangeInMiles();
	}
}
