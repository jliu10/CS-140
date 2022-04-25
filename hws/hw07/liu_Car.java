import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Iterator;

class your_last_name_in_lower_case_Car implements CarFunctions
{
	public String toString()
	{
		return getId() + "\t" + getFuelEconomyInMilesPerGallon() + "\t" + getFuelCapacityInGallons() + "\t" + getCurrentFuelInGallons() + "\t" + getTotalRangeInMiles() + "\t" + getRemainingRangeInMiles();
	}
}
