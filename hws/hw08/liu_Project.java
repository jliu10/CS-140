import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

class liu_Project {
    private static int width = 750;
    private static int height = 350;
    private static JButton sortIntsButton;
    private static JLabel sortIntsLabel;
    private static JButton addToBstButton;
    private static JLabel addToBstLabel;
    private static JButton addToTreeSetButton;
    private static JLabel addToTreeSetLabel;
    private static JButton addToPriorityQButton;
    private static JLabel addToPriorityQLabel;
    private static JButton addToHashSetButton;
    private static JLabel addToHashSetLabel;
    private static JButton addToArrayListButton;
    private static JLabel addToArrayListLabel;
    private static JButton addToSortedArrayButton;
    private static JLabel addToSortedArrayLabel;
    private static JButton addToArrayButton;
    private static JLabel addToArrayLabel;
    private static ArrayList<JButton> leftButtons = new ArrayList<>(8); // facilitate repeated actions
    private static ArrayList<JLabel> leftLabels = new ArrayList<>(8);
    private static JButton searchSortedIntsButton;
    private static JLabel searchSortedIntsLabel;
    private static JButton searchBstButton;
    private static JLabel searchBstLabel;
    private static JButton searchTreeSetButton;
    private static JLabel searchTreeSetLabel;
    private static JButton searchPriorityQButton;
    private static JLabel searchPriorityQLabel;
    private static JButton searchHashSetButton;
    private static JLabel searchHashSetLabel;
    private static JButton searchArrayListButton;
    private static JLabel searchArrayListLabel;
    private static JButton searchSortedArrayButton;
    private static JLabel searchSortedArrayLabel;
    private static JButton searchArrayButton;
    private static JLabel searchArrayLabel;
    private static ArrayList<JButton> rightButtons = new ArrayList<>(8); // facilitate repeated actions
    private static ArrayList<JLabel> rightLabels = new ArrayList<>(8);

    private static int[] sortValues;
    private static int[] searchValues;
    private static int[] sortedValues;
    private static liu_BinarySearchTree bst = new liu_BinarySearchTree();
    private static TreeSet<Integer> treeSetValues = new TreeSet<>();
    private static HashSet<Integer> hashSetValues = new HashSet<>();
    private static PriorityQueue<Integer> priorityQValues = new PriorityQueue<>();
    private static ArrayList<Integer> arrayListValues = new ArrayList<>();
    private static ArrayList<Integer> sortedArrayListValues = new ArrayList<>();
    private static int[] unsortedValues;
    private static String sortFile;
    private static String searchFile;

    public static void main(String[] args) {
        if(args.length == 2) {
            sortFile = args[0];
            searchFile = args[1];
        }
        else {
            System.out.println("Format: liu_Project <sortFilename> <searchFilename>. Exit and try again dummy");
        }

        JFrame f = new JFrame();
        f.setPreferredSize(new Dimension(width, height));
		f.setMinimumSize(new Dimension(width, height));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // top menu
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem readSortFile = new JMenuItem("Read sort file");
        JMenuItem readSearchFile = new JMenuItem("Read search file");
        JMenuItem exitFile = new JMenuItem("Exit");
        MenuItemActionListener readSortFileIAL = new MenuItemActionListener(readSortFile);
        MenuItemActionListener readSearchFileIAL = new MenuItemActionListener(readSearchFile);
        MenuItemActionListener exitFileIAL = new MenuItemActionListener(exitFile);
        readSortFile.addActionListener(readSortFileIAL);
        readSearchFile.addActionListener(readSearchFileIAL);
        exitFile.addActionListener(exitFileIAL);
        menuBar.add(fileMenu);
        fileMenu.add(readSortFile);
        fileMenu.add(readSearchFile);
        fileMenu.add(exitFile);

        // left button panel
        JPanel leftButtonPanel = new JPanel();
        leftButtonPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        GridBagLayout leftGridBagLayout = new GridBagLayout();
        leftButtonPanel.setLayout(leftGridBagLayout);
        leftButtonPanel.setMinimumSize(new Dimension(330,350));
        // right button panel
        JPanel rightButtonPanel = new JPanel();
        rightButtonPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        GridBagLayout rightGridBagLayout = new GridBagLayout();
        rightButtonPanel.setLayout(rightGridBagLayout);
        rightButtonPanel.setMinimumSize(new Dimension(330,350));

        GridBagConstraints buttonPanelConstraints = new GridBagConstraints();

        // left buttons and labels
        sortIntsButton = new JButton("sort ints");
        sortIntsButton.addActionListener( new ButtonActionListener(sortIntsButton) );
        sortIntsLabel = new JLabel("no result");
        addToBstButton = new JButton("add to bst");
        addToBstButton.addActionListener( new ButtonActionListener(addToBstButton) );
        addToBstLabel = new JLabel("no result");
        addToTreeSetButton = new JButton("add to treeset");
        addToTreeSetButton.addActionListener( new ButtonActionListener(addToTreeSetButton) );
        addToTreeSetLabel = new JLabel("no result");
        addToPriorityQButton = new JButton("add to priority queue");
        addToPriorityQButton.addActionListener( new ButtonActionListener(addToPriorityQButton) );
        addToPriorityQLabel = new JLabel("no result");
        addToHashSetButton = new JButton("add to hashset");
        addToHashSetButton.addActionListener( new ButtonActionListener(addToHashSetButton) );
        addToHashSetLabel = new JLabel("no result");
        addToArrayListButton = new JButton("add to arraylist");
        addToArrayListButton.addActionListener( new ButtonActionListener(addToArrayListButton) );
        addToArrayListLabel = new JLabel("no result");
        addToSortedArrayButton = new JButton("add to sorted arraylist");
        addToSortedArrayButton.addActionListener( new ButtonActionListener(addToSortedArrayButton) );
        addToSortedArrayLabel = new JLabel("no result");
        addToArrayButton = new JButton("add to array");
        addToArrayButton.addActionListener( new ButtonActionListener(addToArrayButton) );
        addToArrayLabel = new JLabel("no result");
        leftButtons.add(sortIntsButton);
        leftButtons.add(addToBstButton);
        leftButtons.add(addToTreeSetButton);
        leftButtons.add(addToPriorityQButton);
        leftButtons.add(addToHashSetButton);
        leftButtons.add(addToArrayListButton);
        leftButtons.add(addToSortedArrayButton);
        leftButtons.add(addToArrayButton);
        for(JButton b : leftButtons) b.setEnabled(false);
        leftLabels.add(sortIntsLabel);
        leftLabels.add(addToBstLabel);
        leftLabels.add(addToTreeSetLabel);
        leftLabels.add(addToPriorityQLabel);
        leftLabels.add(addToHashSetLabel);
        leftLabels.add(addToArrayListLabel);
        leftLabels.add(addToSortedArrayLabel);
        leftLabels.add(addToArrayLabel);
        // right buttons and labels
        searchSortedIntsButton = new JButton("search sorted ints");
        searchSortedIntsButton.addActionListener( new ButtonActionListener(searchSortedIntsButton) );
        searchSortedIntsLabel = new JLabel("no result");
        searchBstButton = new JButton("search bst");
        searchBstButton.addActionListener( new ButtonActionListener(searchBstButton) );
        searchBstLabel = new JLabel("no result");
        searchTreeSetButton = new JButton("search treeset");
        searchTreeSetButton.addActionListener( new ButtonActionListener(searchTreeSetButton) );
        searchTreeSetLabel = new JLabel("no result");
        searchPriorityQButton = new JButton("search priority queue");
        searchPriorityQButton.addActionListener( new ButtonActionListener(searchPriorityQButton) );
        searchPriorityQLabel = new JLabel("no result");
        searchHashSetButton = new JButton("search hashset");
        searchHashSetButton.addActionListener( new ButtonActionListener(searchHashSetButton) );
        searchHashSetLabel = new JLabel("no result");
        searchArrayListButton = new JButton("search arraylist");
        searchArrayListButton.addActionListener( new ButtonActionListener(searchArrayListButton) );
        searchArrayListLabel = new JLabel("no result");
        searchSortedArrayButton = new JButton("search sorted arraylist");
        searchSortedArrayButton.addActionListener( new ButtonActionListener(searchSortedArrayButton) );
        searchSortedArrayLabel = new JLabel("no result");
        searchArrayButton = new JButton("search array");
        searchArrayButton.addActionListener( new ButtonActionListener(searchArrayButton) );
        searchArrayLabel = new JLabel("no result");
        rightButtons.add(searchSortedIntsButton);
        rightButtons.add(searchBstButton);
        rightButtons.add(searchTreeSetButton);
        rightButtons.add(searchPriorityQButton);
        rightButtons.add(searchHashSetButton);
        rightButtons.add(searchArrayListButton);
        rightButtons.add(searchSortedArrayButton);
        rightButtons.add(searchArrayButton);
        for(JButton b : rightButtons) b.setEnabled(false);
        rightLabels.add(searchSortedIntsLabel);
        rightLabels.add(searchBstLabel);
        rightLabels.add(searchTreeSetLabel);
        rightLabels.add(searchPriorityQLabel);
        rightLabels.add(searchHashSetLabel);
        rightLabels.add(searchArrayListLabel);
        rightLabels.add(searchSortedArrayLabel);
        rightLabels.add(searchArrayLabel);

        // position/size buttons/labels
        buttonPanelConstraints.weightx = 1;
        buttonPanelConstraints.weighty = 1;
        buttonPanelConstraints.fill = GridBagConstraints.NONE;
        buttonPanelConstraints.anchor = GridBagConstraints.LINE_START;
        for(int i = 0; i < leftButtons.size(); i++) {
            buttonPanelConstraints.gridx = 0;
            buttonPanelConstraints.gridy = i;
            buttonPanelConstraints.gridwidth = 1;
            leftGridBagLayout.setConstraints(leftButtons.get(i), buttonPanelConstraints);
            rightGridBagLayout.setConstraints(rightButtons.get(i), buttonPanelConstraints);
            buttonPanelConstraints.gridx = 1;
            buttonPanelConstraints.gridy = i;
            buttonPanelConstraints.gridwidth = GridBagConstraints.REMAINDER;
            leftGridBagLayout.setConstraints(leftLabels.get(i), buttonPanelConstraints);
            rightGridBagLayout.setConstraints(rightLabels.get(i), buttonPanelConstraints);
        }

        // add buttons to leftButtonPanel
        for(int i = 0; i < leftButtons.size(); i++) {
            leftButtonPanel.add(leftButtons.get(i));
            leftButtonPanel.add(leftLabels.get(i));
            rightButtonPanel.add(rightButtons.get(i));
            rightButtonPanel.add(rightLabels.get(i));
        }

        // main button panel
        JPanel mainButtonPanel = new JPanel();
        mainButtonPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        BoxLayout boxLayout = new BoxLayout(mainButtonPanel, BoxLayout.X_AXIS);
        mainButtonPanel.setLayout(boxLayout);
        mainButtonPanel.add(leftButtonPanel);
        mainButtonPanel.add(rightButtonPanel);

        // main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(menuBar, BorderLayout.NORTH);
        mainPanel.add(mainButtonPanel, BorderLayout.CENTER);

        f.setContentPane(mainPanel);

        f.validate();
		f.setVisible(true);

    }

    /**
     * Reads data from filename.
     * @param filename name of file to be read
     * @param readSortValues true if file to be read is the sort file
     */
    private static void readData(String filename, boolean readSortValues) {
        try {
            ArrayList<Integer> temp = new ArrayList<>();
            File file = new File(filename);
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()) {
                temp.add( Integer.parseInt(sc.nextLine()) );
            }

            if(readSortValues) {
                sortValues = new int[temp.size()];
                for(int i = 0; i < temp.size(); i++) {
                    sortValues[i] = temp.get(i);
                }

                // activate left buttons
                for(JButton b : leftButtons) {
                    b.setEnabled(true);
                }
            }
            else {
                searchValues = new int[temp.size()];
                for(int i = 0; i < temp.size(); i++) {
                    searchValues[i] = temp.get(i);
                }
                // activate right buttons
            }
        }
        catch(Exception e) {
            System.out.println("Invalid filename or file: " + e);
        }
    }

    /**
     * Sorts sortValues into sortedValues using selection sort
     */
    private static void selectionSort() {
        sortedValues = new int[sortValues.length];
        for(int i = 0; i < sortValues.length; i++) {
            sortedValues[i] = sortValues[i];
        }

		for(int i = 0; i < sortedValues.length; i++) {
			int min = i;
			for(int j = i + 1; j < sortedValues.length; j++) {
				if(sortedValues[j] < sortedValues[min]) min = j;
			}
			if(min != i) { // swap sortedValues[min] and sortedValues[i]
				int t = sortedValues[min];
				sortedValues[min] = sortedValues[i];
				sortedValues[i] = t;
			}
		}
 	}

    /**
     * Searches for searchValues values in sortedValues using binary search
     * @return how many searchValues values were found in sortedValues
     */
    private static int searchInts() {
        int count = 0;
        for(int n : searchValues) {
            if(binarySearch(n, sortedValues)) count++;
        }

        return count;
    }

    /**
     * Searches for specified int value in specified array
     * @param value integer to be searched for
     * @param data array to be searched
     * @return true if value is found in data
     */
    private static boolean binarySearch(int value, int[] data) {
        int bottom = 0;
        int top = data.length - 1;
        while(bottom <= top) {
            int middle = (bottom + top) / 2;
            if(value < data[middle]) top = middle - 1;
            else if(value > data[middle]) bottom = middle + 1;
            else return true;
        }
        return false;
    }

    /**
     * Adds sortValues values to bst
     */
    private static void addToBST() {
        for(int n : sortValues) bst.insertNode(new Node(n));
    }

    /**
     * Searches for searchValues value in bst
     * @return how many searchValues values were found in bst
     */
    private static int searchBST() {
        int count = 0;
        for(int n : searchValues) {
            Node temp = bst.getNode( bst.getRoot(), n );
            if(temp != null) count++;
        }

        return count;
    }

    /**
     * Adds sortValues values to treeSetValues
     */
    private static void addToTreeSet() {
        for(int n : sortValues) treeSetValues.add(n);
    }

    /**
     * Searches for searchValues values in treeSetValues
     * @return how many searchValues values were found in treeSetValues
     */
    private static int searchTreeSet() {
        int count = 0;
        for(int n : searchValues) {
            if(treeSetValues.contains(n)) count++;
        }

        return count;
    }

    /**
     * Adds sortValues values to hashSetValues
     */
    private static void addToHashSet() {
        for(int n : sortValues) hashSetValues.add(n);
    }

    /**
     * Searches for searchValues value in hashSetValues
     * @return how many searchValues values were found in hashSetValues
     */
    private static int searchHashSet() {
        int count = 0;
        for(int n : searchValues) {
            if(hashSetValues.contains(n)) count++;
        }

        return count;
    }

    /**
     * Adds sortValues values to priorityQValues
     */
    private static void addToPriorityQ() {
        priorityQValues.clear();
        for(int n : sortValues) priorityQValues.add(n);
    }

    /**
     * Searches for searchValues value in priorityQValues
     * @return how many searchValues values were found in priorityQValues
     */
    private static int searchPriorityQ() {
        int count = 0;
        for(int n : searchValues) {
            if(priorityQValues.contains(n)) count++;
        }

        return count;
    }

    /**
     * Adds sortValues values to arrayListValues
     */
    private static void addToArrayList() {
        arrayListValues.clear();
        for(int n : sortValues) arrayListValues.add(n);
    }

    /**
     * Searches for searchValues value in arrayListValues
     * @return how many searchValues values were found in arrayListValues
     */
    private static int searchArrayList() {
        int count = 0;
        for(int n : searchValues) {
            if(arrayListValues.contains(n)) count++;
        }

        return count;
    }

    /**
     * Adds sortedValues values to sortedArrayListValues
     */
    private static void addToSortedArrayList() {
        sortedArrayListValues.clear();
        for(int n : sortValues) sortedArrayListValues.add(n);
        Collections.sort(sortedArrayListValues);
    }

    /**
     * Searches for searchValues value in sortedArrayListValues
     * @return how many searchValues values were found in sortedArrayListValues
     */
    private static int searchSortedArrayList() {
        int count = 0;
        for(int n : searchValues) {
            if(Collections.binarySearch(sortedArrayListValues, n) >= 0) count++;
        }

        System.out.println("Individual count value=" + count);
        return count;
    }

    /**
     * Adds sortValues values to unsortedValues
     */
    private static void addToArray() {
        unsortedValues = new int[sortValues.length];
        for(int i = 0; i < sortValues.length; i++) {
            unsortedValues[i] = sortValues[i];
        }
    }

    /**
     * Searches for searchValues value in unsortedValues
     * @return how many searchValues values were found in unsortedValues
     */
    private static int searchArray() {
        int count = 0;
        for(int n : searchValues) {
            for(int m : unsortedValues) {
                if(m == n) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    // action listener for the buttons
    static class ButtonActionListener implements ActionListener
    {
        // the button associated with the action listener, so that we can
        // share this one class with multiple buttons
        private JButton b;

        ButtonActionListener(JButton b)
        {
            this.b = b;
        }

        public void actionPerformed(ActionEvent e)
        {
            System.out.println("action performed on " + b.getText() + " button");

            switch(b.getText()) {
                case "sort ints":
                    long t0 = System.currentTimeMillis();
                    selectionSort();
                    long t1 = System.currentTimeMillis();
                    sortIntsLabel.setText(t1 - t0 + "ms");
                    if(searchValues != null) searchSortedIntsButton.setEnabled(true);
                    break;
                case "search sorted ints":
                    t0 = System.currentTimeMillis();
                    int count = searchInts();
                    t1 = System.currentTimeMillis();
                    searchSortedIntsLabel.setText( String.format("%d / %dms", count, t1-t0) );
                    break;
                case "add to bst":
                    t0 = System.currentTimeMillis();
                    addToBST();
                    t1 = System.currentTimeMillis();
                    addToBstLabel.setText(t1 - t0 + "ms");
                    if(searchValues != null) searchBstButton.setEnabled(true);
                    break;
                case "search bst":
                    t0 = System.currentTimeMillis();
                    count = searchBST();
                    t1 = System.currentTimeMillis();
                    searchBstLabel.setText( String.format("%d / %dms", count, t1-t0) );
                    break;
                case "add to treeset":
                    t0 = System.currentTimeMillis();
                    addToTreeSet();
                    t1 = System.currentTimeMillis();
                    addToTreeSetLabel.setText(t1 - t0 + "ms");
                    if(searchValues != null) searchTreeSetButton.setEnabled(true);
                    break;
                case "search treeset":
                    t0 = System.currentTimeMillis();
                    count = searchTreeSet();
                    t1 = System.currentTimeMillis();
                    searchTreeSetLabel.setText( String.format("%d / %dms", count, t1-t0) );
                    break;
                case "add to priority queue":
                    t0 = System.currentTimeMillis();
                    addToPriorityQ();
                    t1 = System.currentTimeMillis();
                    addToPriorityQLabel.setText(t1 - t0 + "ms");
                    if(searchValues != null) searchPriorityQButton.setEnabled(true);
                    break;
                case "search priority queue":
                    t0 = System.currentTimeMillis();
                    count = searchPriorityQ();
                    t1 = System.currentTimeMillis();
                    searchPriorityQLabel.setText( String.format("%d / %dms", count, t1-t0) );
                    break;
                case "add to hashset":
                    t0 = System.currentTimeMillis();
                    addToHashSet();
                    t1 = System.currentTimeMillis();
                    addToHashSetLabel.setText(t1 - t0 + "ms");
                    if(searchValues != null) searchHashSetButton.setEnabled(true);
                    break;
                case "search hashset":
                    t0 = System.currentTimeMillis();
                    count = searchHashSet();
                    t1 = System.currentTimeMillis();
                    searchHashSetLabel.setText( String.format("%d / %dms", count, t1-t0) );
                    break;
                case "add to arraylist":
                    t0 = System.currentTimeMillis();
                    addToArrayList();
                    t1 = System.currentTimeMillis();
                    addToArrayListLabel.setText(t1 - t0 + "ms");
                    if(searchValues != null) searchArrayListButton.setEnabled(true);
                    break;
                case "search arraylist":
                    t0 = System.currentTimeMillis();
                    count = searchArrayList();
                    t1 = System.currentTimeMillis();
                    searchArrayListLabel.setText( String.format("%d / %dms", count, t1-t0) );
                    break;
                case "add to sorted arraylist":
                    t0 = System.currentTimeMillis();
                    addToSortedArrayList();
                    t1 = System.currentTimeMillis();
                    addToSortedArrayLabel.setText(t1 - t0 + "ms");
                    if(searchValues != null) searchSortedArrayButton.setEnabled(true);
                    break;
                case "search sorted arraylist":
                    t0 = System.currentTimeMillis();
                    count = searchSortedArrayList();
                    t1 = System.currentTimeMillis();
                    searchSortedArrayLabel.setText( String.format("%d / %dms", count, t1-t0) );
                    break;
                case "add to array":
                    t0 = System.currentTimeMillis();
                    addToArray();
                    t1 = System.currentTimeMillis();
                    addToArrayLabel.setText(t1 - t0 + "ms");
                    if(searchValues != null) searchArrayButton.setEnabled(true);
                    break;
                default: // search array
                    t0 = System.currentTimeMillis();
                    count = searchArray();
                    t1 = System.currentTimeMillis();
                    searchArrayLabel.setText( String.format("%d / %dms", count, t1-t0) );
            }
        }
    }

    // action listener for the menu items
    static class MenuItemActionListener implements ActionListener
    {
        // the menu item associated with the action listener, so that we can
        // share this one class with multiple menu items
        private JMenuItem m;

        MenuItemActionListener(JMenuItem m)
        {
            this.m = m;
        }

        public void actionPerformed(ActionEvent e)
        {
            System.out.println("action performed on " + m.getText() + " menu item");

            switch(m.getText()) {
                case "Read sort file":
                    readData(sortFile, true);
                    break;
                case "Read search file":
                    readData(searchFile, false);
                    if(sortedValues != null) searchSortedIntsButton.setEnabled(true);
                    if(bst.getRoot() != null) searchBstButton.setEnabled(true);
                    if(treeSetValues.size() > 0) searchTreeSetButton.setEnabled(true);
                    if(priorityQValues.size() > 0) searchPriorityQButton.setEnabled(true);
                    if(hashSetValues.size() > 0) searchHashSetButton.setEnabled(true);
                    if(arrayListValues.size() > 0) searchArrayListButton.setEnabled(true);
                    if(sortedArrayListValues.size() > 0) searchSortedArrayButton.setEnabled(true);
                    if(unsortedValues != null) searchArrayButton.setEnabled(true);
                    break;
                default: // "Exit" is clicked
                    System.exit(0);
            }
        }
    }
}
