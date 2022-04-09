import java.text.DecimalFormat;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.StringTokenizer;

class liu_lab1 {
    public static void main(String[] args) {
        // check if there are any commandline arguements, and if none output a message and exit
        if(args.length == 0) {
            System.out.println("Filename argument required");
            System.exit(0);
        }
		// create the DecimalFormat here
        DecimalFormat df = new DecimalFormat("###,###,###,###,###");

		// try/catch block to catch any exceptions related to the BufferedReader
		try {
			// put your code here to open the BufferedReader
            BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));

            int lineCount = 0;
            int tokenCount = 0;
            int intCount = 0;
            long intSum = 0;
            int[] matches = new int[0];

            if(args.length > 1) matches = new int[args.length - 1];
            // loop to read the input file
            String inn;
			while((inn = input.readLine()) != null) {
                lineCount++;
				// create the StringTokenizer
                StringTokenizer st = new StringTokenizer(inn);
				// loop over the tokens of the StringTokenizer
				while(st.hasMoreTokens()) {
                    tokenCount++;
                    String token = st.nextToken();
					// try/catch block for checking if the current token is an integer
					try {
						// convert the current token into an int
                        int n = Integer.parseInt(token);
						// increment int counter and int sum
                        intCount++;
                        intSum += n;
					}
					catch(Exception e) {
                        // System.out.println("Inner exception occurred");
						// you shouldn't need anything here
						// if the current token is not an int, the Integer.parseInt() statement will
						// throw an exception and come here
					}
					// loop over the commandline arguments with indices 1, 2, 3, ... , args.length-1
					// and compare each to the current token using s1.equalsIgnoreCase(s2) as
					// mentioned in the lab description
                    for(int i = 1; i < args.length; i++) {
                        if(token.equalsIgnoreCase(args[i])) matches[i - 1]++;
                    }
				}
                // input.close();
			}
			// close the BufferedReader
            input.close();
			// output the results
            System.out.println("lineCount = " + df.format(lineCount));
            System.out.println("tokenCount = " + df.format(tokenCount));
            System.out.println("intCount = " + df.format(intCount));
            System.out.println("intSum = " + df.format(intSum));
            if(args.length > 1) {
                for(int i = 1; i < args.length; i++) {
                    System.out.println(args[i] + " count = " + df.format(matches[i - 1]));
                }
            }
		}
		catch(Exception e) {
			// output the exception if there is one and exit
			System.out.println(e.toString());
            // System.out.println("Outer exception occurred");
			System.exit(0);
		}
    }
}
