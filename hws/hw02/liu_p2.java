import java.io.*;
import java.util.*;
// import java.nio.*;

class liu_p2 {
	public static void main(String[] args) {
		// put some code here to check for three commandline arguments
        if(args.length != 3) {
            // System.out.println("REQUIRE THREE ARGUMENTS AS SUCH: ");
            // System.out.println("<text that starts with 'b' or 't'> <input file> <output file>");
            System.exit(0);
        }

		// puts some code here to check that the first commandline argument starts with "b" or "t"
        if(!(args[0].startsWith("b") || args[0].startsWith("t"))) {
            // System.out.println("FIRST ARGUMENT MUST START WITH 'b' OR 't'");
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
			DataInputStream input = new DataInputStream(new FileInputStream(inputFilename));
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputFilename)));

            // num of blocks to follow
            int numBlocks = input.readInt();
            // System.out.println("numBlocks: " + numBlocks);

            // loop through blocks
            for(int i = 0; i < numBlocks; i++) {
                // // System.out.println("looped");
                char type = input.readChar();
                // // System.out.println("type: " + type);
                // // System.out.println(type == 's');
                if(type == 'i') {
                    output.write("int\t");
                    output.write(input.readInt() + "\n");
                    // // System.out.println("WROTE INT");
                } else if(type == 'l') {
                    output.write("long\t");
                    output.write(input.readLong() + "\n");
                } else if(type == 'h') {
                    output.write("short\t");
                    output.write(input.readShort() + "\n");
                } else if(type == 'f') {
                    output.write("float\t");
                    output.write(input.readFloat() + "\n");
                } else if(type == 'd') {
                    output.write("double\t");
                    output.write(input.readDouble() + "\n");
                } else if(type == 'a') {
                    output.write("int array\t");
                    // array length, -1 so no extra comma
                    int intLen = input.readInt();
                    for(int j = 0; j < intLen - 1; j++) {
                        output.write(input.readInt() + ",");
                    }
                    output.write(input.readInt() + "\n");
                } else if(type == 's') {
                    output.write("string\t");
                    // array length, -1 so no extra comma
                    int strLen = input.readInt();
                    // System.out.println("strLen: " + strLen);
                    for(int j = 0; j < strLen - 1; j++) {
                        output.write(input.readChar());
                    }
                    output.write(input.readChar() + "\n");
                    // // System.out.println("WROTE STRING");
                } else if(type == 'e') {
                    output.write("double array\t");
                    // array length, -1 so no extra comma
                    int dblLen = input.readInt();
                    for(int j = 0; j < dblLen - 1; j++) {
                        output.write(input.readDouble() + ",");
                    }
                    output.write(input.readDouble() + "\n");
                }
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
            DataOutputStream output = new DataOutputStream(new FileOutputStream(outputFilename));
            ArrayList<String> inputLines = new ArrayList<String>();

            // can't write inside loop because need to know and write num of blocks (lines)
            while((inn = input.readLine()) != null ) {
                // // System.out.println(inn);
                inputLines.add(inn);

                // byte[] byteArr = inn.getBytes();

                // output.write(0x74657374);
                // // System.out.println(byteArr.length);

                // output.write(byteArr, 0, byteArr.length);
                // output.write(0x0A);

                // // System.out.println("wrote a line");

            }
            input.close();

            // writing
            output.writeInt(inputLines.size());
            // System.out.println("TEXT FILE LINES: " + inputLines.size());

            for(String line : inputLines) {
                // // System.out.println(line.toString());
                String[] strArr = line.split("\t");
                // byte[] byteArr = new byte[8];

                // strArr[0] is the data type
                if(strArr[0].equals("int")) {
                    // write 'i'
                    // output.writeChar(0x69);
                    output.writeChar((byte)(char)'i');
                    // output.write((byte)Integer.parseInt(strArr[1]));
                    // byteArr[0];
                    output.writeInt(Integer.parseInt(strArr[1]));
                    // output.writeByte(new Integer(Integer.parseInt(strArr[1])).byteValue());
                    // output.write(0x0A); // newline
                    // System.out.println("WROTE INT: " + strArr[1]);
                } else if(strArr[0].equals("long")) {
                    // output.write(0x6C);
                    output.writeChar((byte)(char)'l');
                    output.writeLong(Long.parseLong(strArr[1]));
                    // System.out.println("WROTE LONG: " + strArr[1]);
                } else if(strArr[0].equals("short")) {
                    // output.write(0x68);
                    output.writeChar((byte)(char)'h');
                    output.writeShort(Short.parseShort(strArr[1]));
                    // System.out.println("WROTE SHORT: " + strArr[1]);
                } else if(strArr[0].equals("float")) {
                    // output.write(0x66);
                    output.writeChar((byte)(char)'f');
                    output.writeFloat(Float.parseFloat(strArr[1]));
                    // System.out.println("WROTE FLOAT: " + strArr[1]);
                } else if(strArr[0].equals("double")) {
                    // output.write(0x64);
                    output.writeChar((byte)(char)'d');
                    output.writeDouble(Double.parseDouble(strArr[1]));
                    // System.out.println("WROTE DOUBLE: " + strArr[1]);
                } else if(strArr[0].equals("int array")) {
                    // output.write(0x61);
                    output.writeChar((byte)(char)'a');
                    String[] arr = strArr[1].split(",");
                    output.writeInt(arr.length);
                    // convert String array to int array
                    for(String s : arr) {
                        output.writeInt(Integer.parseInt(s));
                    }
                    // System.out.println("WROTE INT ARR: " + strArr[1]);
                    // output.write();
                } else if(strArr[0].equals("string")) {
                    // output.write(0x73);
                    output.writeChar((byte)(char)'s');
                    /*
                    for(char ch : strArr[1].toCharArray()) {
                        output.write((byte)ch);
                    }
                    */
                    output.writeInt(strArr[1].length());
                    output.writeChars(strArr[1]);
                    // System.out.println("WROTE STRING: " + strArr[1]);
                } else if(strArr[0].equals("double array")) {
                    // output.write(0x65);
                    output.writeChar((byte)(char)'e');
                    String[] arr = strArr[1].split(",");
                    output.writeInt(arr.length);
                    // convert String array to int array
                    for(String s : arr) {
                        output.writeDouble(Double.parseDouble(s));
                    }
                    // System.out.println("WROTE DOUBLE ARR: " + strArr[1]);
                }
            }
            // input.close();
            output.close();

		}
		catch(Exception e) {
			// System.out.println(e.toString());
			System.exit(0);
		}
	}

}
