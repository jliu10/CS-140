import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Iterator;
import java.util.Scanner;
import java.io.File;

// import java.util.*;
// import java.io.*;

class liu_ManageCarData implements ManageCarDataFunctions
{
    private final ArrayList<CarFunctions> carList;
    private final PriorityQueue<CarFunctions> carListByTotalRange;
    private final PriorityQueue<CarFunctions> carListByRemainingRange;

    liu_ManageCarData() {
        carList = new ArrayList<>();
        carListByTotalRange = new PriorityQueue<>(new TotalRangeComparator());
        carListByRemainingRange = new PriorityQueue<>(new RemainingRangeComparator());
    }

    /**For each line
    1. Parse the id, fuel economy, fuel capacity, and current fuel
    2. Instantiate a new Car object with the above four values
    3. Add the Car object to the ArrayList and two PriorityQueues
    **/
    public void readData(String filename) {
        try {
            File f = new File(filename);
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()) {
                Scanner line = new Scanner(sc.nextLine());
                String id = line.next();
                // System.out.println("id = "+id);
                int fuelEcon = Integer.parseInt( line.next() );
                int fuelCap = Integer.parseInt( line.next() );
                double currFuel = Double.parseDouble( line.next() );

                CarFunctions c = new liu_Car(id, fuelEcon, fuelCap, currFuel);
                carList.add(c);
                carListByTotalRange.add(c);
                carListByRemainingRange.add(c);
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    // Return a copy of carList
    public ArrayList<CarFunctions> getCarList() {
        ArrayList<CarFunctions> t = new ArrayList<>(carList.size());
        for(CarFunctions c : carList) t.add(c);
        return t;
    }

    // Return a copy of carListByTotalRange
    public PriorityQueue<CarFunctions> getCarListByTotalRange() {
        PriorityQueue<CarFunctions> t = new PriorityQueue<>(carList.size(), new TotalRangeComparator());
        for(CarFunctions c : carList) t.add(c);
        return t;
    }

    // Return a copy of carListByTotalRange using Iterator
    public ArrayList<CarFunctions> getCarListByTotalRangeUsingIterator() {
        ArrayList<CarFunctions> t = new ArrayList<>(carList.size());
        Iterator<CarFunctions> it = carListByTotalRange.iterator();
        while(it.hasNext()) {
            t.add(it.next());
        }
        return t;
    }

    // Return a copy of carListByRemainingRange
    public PriorityQueue<CarFunctions> getCarListByRemainingRange() {
        PriorityQueue<CarFunctions> t = new PriorityQueue<>(carList.size(), new RemainingRangeComparator());
        for(CarFunctions c : carList) t.add(c);
        return t;
    }

    // Return a copy of carListByRemainingRange using Iterator
    public ArrayList<CarFunctions> getCarListByRemainingRangeUsingIterator() {
        ArrayList<CarFunctions> t = new ArrayList<>(carList.size());
        Iterator<CarFunctions> it = carListByRemainingRange.iterator();
        while(it.hasNext()) {
            t.add(it.next());
        }
        return t;
    }

    public ArrayList<String> getCarListByTotalRangeViaPoll(double minTotalRange, double maxTotalRange) {
        ArrayList<String> t = new ArrayList<>(carList.size());
        PriorityQueue<CarFunctions> list = getCarListByTotalRange();
        while(list.size() > 0) {
            CarFunctions currCar = list.poll();
            if( currCar.getTotalRangeInMiles() >= minTotalRange && currCar.getTotalRangeInMiles() <= maxTotalRange ) {
                String carString = currCar.toString();
                String equalCar = "";
                String equalEcons = "";

                for(int i = 0; i < carList.size(); i++) {
                    if( carList.get(i).equals(currCar) ) equalCar += "\t" + i;
                    if( carList.get(i).getFuelEconomyInMilesPerGallon() == currCar.getFuelEconomyInMilesPerGallon() ) equalEcons += "\t" + i;
                }
                t.add(carString + equalCar + equalEcons);
            }
        }

        return t;
    }

    public ArrayList<String> getCarListByRemainingRangeViaPoll(double minRemainingRange, double maxRemainingRange) {
        ArrayList<String> t = new ArrayList<>(carList.size());
        PriorityQueue<CarFunctions> list = getCarListByRemainingRange();
        while(list.size() > 0) {
            CarFunctions currCar = list.poll();
            if( currCar.getRemainingRangeInMiles() >= minRemainingRange && currCar.getRemainingRangeInMiles() <= maxRemainingRange ) {
                String carString = currCar.toString();
                String equalCar = "";
                String equalEcons = "";

                for(int i = 0; i < carList.size(); i++) {
                    if( carList.get(i).equals(currCar) ) equalCar += "\t" + i;
                    if( carList.get(i).getFuelEconomyInMilesPerGallon() == currCar.getFuelEconomyInMilesPerGallon() ) equalEcons += "\t" + i;
                }
                t.add(carString + equalCar + equalEcons);
            }
        }

        return t;
    }
}
