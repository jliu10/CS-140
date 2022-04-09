import java.io.*;
import java.util.*;
import java.nio.*;

class liu_lab2 {
	public static void main(String[] args) {
		// put some code here to check for three commandline arguments
        if(args.length != 3) {
            System.out.println("REQUIRE THREE ARGUMENTS AS SUCH: ");
            System.out.println("<text that starts with 'b' or 't'> <input file> <output file>");
            System.exit(0);
        }

		// puts some code here to check that the first commandline argument starts with "b" or "t"
        if(!(args[0].startsWith("b") || args[0].startsWith("t"))) {
            System.out.println("FIRST ARGUMENT MUST START WITH 'b' OR 't'");
            System.exit(0);
        }

		if(args[0].startsWith("b")) {
			convertBinaryToText(args[1], args[2]);
		}
		else {
			convertTextToBinary(args[1], args[2]);
		}
	}

	private static void convertBinaryToText(String inputFilename, String outputFilename) {
		System.out.println("convertBinaryToText");
		try {
			// put your code to read a binary file and output it as a text file
            BufferedInputStream input = new BufferedInputStream(new java.io.FileInputStream(inputFilename));
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputFilename)));

            byte[] buffer = new byte[1];
            int currentByteCount;

            while((currentByteCount = input.read(buffer)) >= 0) {
                output.write(new String(buffer));
            }

            input.close();
            output.close();

		}
		catch(Exception e) {
			System.out.println(e.toString());
			System.exit(0);
		}
	}

	private static void convertTextToBinary(String inputFilename, String outputFilename) {
		System.out.println("convertTextToBinary");
        try {
			// put your code to read a text file and output it as a binary file
            BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilename)));
            String inn;
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(outputFilename));
            ArrayList<String> inputLines = new ArrayList<String>(0);

            while((inn = input.readLine()) != null ) {
                // System.out.println(inn);
                inputLines.add(inn);

                byte[] byteArr = inn.getBytes();

                // output.write(0x74657374);
                // System.out.println(byteArr.length);
                output.write(byteArr, 0, byteArr.length);
                output.write(0x0A);

                // System.out.println("wrote a line");

            }
            input.close();
            output.close();

		}
		catch(Exception e) {
			System.out.println(e.toString());
			System.exit(0);
		}
	}
}
