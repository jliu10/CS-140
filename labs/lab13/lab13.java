import java.util.*;
import java.io.*;

public class lab13 {
	private ArrayList<Integer> integers = new ArrayList<>();

	public void readData(String filename) {
		try {
			File f = new File(filename);
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()) {
				integers.add(Integer.parseInt(sc.nextLine()));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public long getTotalCount() {
		return integers.stream()
				.count();
	}

	public long getOddCount() {
		return integers.stream()
				.filter(n -> n % 2 != 0).count();
	}

	public long getEvenCount() {
		return integers.stream()
				.filter(n -> n % 2 == 0).count();
	}

	public long getDistinctGreaterThanFiveCount() {
		return integers.stream()
				.distinct()
				.filter(n -> n > 5).count();
	}

	public Integer[] getResult1() {
		return integers.stream()
				.filter(n -> n % 2 == 0 && n > 5 && n < 50)
				.sorted()
				.toArray(Integer[]::new);
	}

	public Integer[] getResult2() {
		return integers.stream()
				.map(n -> n * n * 3)
				.limit(50)
				.toArray(Integer[]::new);
	}

	public Integer[] getResult3() {
		return integers.stream()
				.filter(n -> n % 2 != 0)
				.map(n -> n * 2)
				.sorted()
				.skip(20)
				.distinct()
				.toArray(Integer[]::new);
	}


}
