import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Iterator;

class liu_Car implements CarFunctions
{
	private final String id;
	private final int fuelEconomyInMilesPerGallon;
	private final int fuelCapacityInGallons;
	private double currentFuelInGallons;

	public String toString()
	{
		return getId() + "\t" + getFuelEconomyInMilesPerGallon() + "\t" + getFuelCapacityInGallons() + "\t" + getCurrentFuelInGallons() + "\t" + getTotalRangeInMiles() + "\t" + getRemainingRangeInMiles();
	}
}
