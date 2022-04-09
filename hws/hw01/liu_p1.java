class liu_p1
{
	// constructor for the class, you don't need to put anything in here
	public liu_p1()
	{
	}

	// method to sort the elements of an int array having index in
	// [lowerBound, upperBound] using selection sort in ascending order
	public int[] selectionSort(int[] values, int lowerBound, int upperBound)
	{
		for(int i = lowerBound; i <= upperBound; i++) {
			int min = i;
			for(int j = i + 1; j <= upperBound; j++) {
				if(values[j] < values[min]) min = j;
			}
			if(min != i) { // swap values[min] and values[i]
				int t = values[min];
				values[min] = values[i];
				values[i] = t;
			}
		}
		return values;
 	}

	// method to return the number of array elements >= testValue with indices in
	// [lowerBound, upperBound] using a for loop to examine the array elements
	public int forLoopTest(int lowerBound, int upperBound, int testValue, int[] values)
	{
		int count = 0;
		for(int i = lowerBound; i <= upperBound; i++) {
			if(values[i] >= testValue) count++;
		}
		return count;
	}

	// method to return the number of array elements <= testValue with indices not
	// in [lowerBound, upperBound] using a while loop to examine the array elements
	public int whileLoopTest(int lowerBound, int upperBound, int testValue, int[] values)
	{
		int count = 0;
		int i = 0;
		while(i < values.length) {
			if(i < lowerBound || i > upperBound)
				if(values[i] <= testValue) count++;
			i++;
		}
		return count;
	}

	// method to return the number of array elements in [testValue1, testValue2] or
	// [testValue2, testValue1] with indices in [lowerBound, upperBound] using a
	// do-while loop to examine the array elements
	public int doWhileLoopTest(int lowerBound, int upperBound, int testValue1, int testValue2, int[] values)
	{
		int count = 0;
		int i = lowerBound;
		if(testValue2 < testValue1) {
			int t = testValue1;
			testValue1 = testValue2;
			testValue2 = t;
		}
		do{
			if(values[i] >= testValue1 && values[i] <= testValue2) count++;
			i++;
		} while(i <= upperBound);
		return count;
	}

	// method to return the number of array elements that match the switch
	// cases 0, 1, 2, 3, 4, 5, 6, 7, 8, 10 - 15, and the default case with
	// indices in [lowerBound, upperBound]
	// return an array of size 11, with indices 0 - 8 corresponding to cases
	// 0 - 8, index 9 corresponding to case 10 - 15, and index 10
	// corresponding to the default case
	public int[] switchTest(int lowerBound, int upperBound, int[] values)
	{
		int[] counts = new int[]{0,0,0,0,0,0,0,0,0,0,0};
		for(int i = lowerBound; i <= upperBound; i++) {
			switch(values[i]) {
				case 0:
					counts[0]++;
					break;
				case 1:
					counts[1]++;
					break;
				case 2:
					counts[2]++;
					break;
				case 3:
					counts[3]++;
					break;
				case 4:
					counts[4]++;
					break;
				case 5:
					counts[5]++;
					break;
				case 6:
					counts[6]++;
					break;
				case 7:
					counts[7]++;
					break;
				case 8:
					counts[8]++;
					break;
				case 10: case 11: case 12: case 13: case 14: case 15:
					counts[9]++;
					break;
				default:
					counts[10]++;
			}
		}
		return counts;
	}
}
