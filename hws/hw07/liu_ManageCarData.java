import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Iterator;

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
}
