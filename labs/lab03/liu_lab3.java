import java.io.*;
import java.util.*;

class liu_lab3 {

    public static void main(String[] args) {
        String[] thirdArgs = new String[]{"True", "true", "Yes", "yes", "T", "t", "Y", "y"};

        if(args.length == 2) {
            doStuff(args[0], args[1], false);
        } else if(args.length == 3) {
            if(Arrays.asList(thirdArgs).contains(args[2])) doStuff(args[0], args[1], true);
            else doStuff(args[0], args[1], false);
        } else {
            System.out.println("REQUIRE TWO OR THREE ARGUMENTS AS SUCH: ");
            System.out.println("<input file> <output file> <do u want unique word list?>");
            System.exit(0);
        }
    }

    /*
    BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilename)));
    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputFilename)));
    TreeSet<String> uniqueStrings = new TreeSet<>();
    */

    // reverse a word
    private static String reverseWord(String text) {
        String result = "";
        char[] chars = text.toCharArray();
        for(int i = chars.length - 1; i >= 0; i--) result += chars[i];
        return result;
    }


    /*
    cs 140 lab 3
    For lab 3 we will be reading a blank space delimited text file and writing a blank space
    delimited text file. While processing the input file, we will be make the following modification to
    each line of input. First, for each line the words will be written in the reverse order that they
    show up in the current input line. That is, the line “cats dogs frogs” becomes “frogs dogs cats”.
    And secondly, each word will be written backwards. The two combined takes an input line of
    “cats dogs frogs” and outputs “sgorf sgod stac”. Additionally we will be keeping a list of the
    unique words that the input file contains. We will also keep track of the number of lines in the
    input file, the total number of words in the input file, and the total number of characters
    contained in the words of the input file.
    */
    private static void doStuff(String inputFilename, String outputFilename, boolean printUnique) {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilename)));
            String line;
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputFilename)));
            TreeSet<String> uniqueStrings = new TreeSet<>();
            int lineCount = 0;
            int wordCount = 0;
            int charsInWords = 0;
            int uniqueWords = 0;

            while((line = input.readLine()) != null) {
                lineCount++;

                // parse words in line
                String[] words = line.split(" ");

                // required to use ArrayDeque to reverse word order
                ArrayDeque<String> stackOfCurrentStrings = new ArrayDeque<>();
                for(String word : words) {
                    wordCount++;
                    charsInWords += word.length();
                    /*
                    if(!uniqueStrings.contains(word)) {
                        uniqueWords++;
                        uniqueStrings.add(word);
                    }
                    */
                    uniqueStrings.add(word);

                    stackOfCurrentStrings.push(word);
                }
                uniqueWords = uniqueStrings.size();

                while(stackOfCurrentStrings.size() > 0) {
                    String revWord = stackOfCurrentStrings.pop();
                    revWord = reverseWord(revWord);

                    // check if this is last word (to decide whether to add a space)
                    if(stackOfCurrentStrings.size() == 0) output.write(revWord);
                    else output.write(revWord + " ");
                }
                output.write("\n");
            }

            input.close();
            output.close();

            System.out.println("lines = " + lineCount);
            System.out.println("words = " + wordCount);
            System.out.println("character in words = " + charsInWords);
            System.out.println("unique words = " + uniqueWords);
            if(printUnique) {
                System.out.println("ordered unique words");
                for(String word : uniqueStrings) System.out.println(word);
            }
        } catch(Exception e) {
			System.out.println(e.toString());
			System.exit(0);
		}
    }

}
