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
    // private static BinarySearchTree bst = new BinarySearchTree();
    private static TreeSet<Integer> treeSetValues = new TreeSet<>();
    private static HashSet<Integer> hashSetValues = new HashSet<>();
    private static PriorityQueue<Integer> priorityQValues = new PriorityQueue<>();
    private static ArrayList<Integer> arrayListValues = new ArrayList<>();
    private static ArrayList<Integer> sortedArrayListValues = new ArrayList<>();
    private static int[] unsortedValues;
    // private File sortFile;
    // private File searchFile;

    public static void main(String[] args) {
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
        GridBagConstraints leftButtonPanelConstraints = new GridBagConstraints();

        // left buttons and labels
        sortIntsButton = new JButton("sort ints");
        sortIntsButton.addActionListener( new ButtonActionListener(sortIntsButton) );
        sortIntsLabel = new JLabel("no result");
        addToBstButton = new JButton("add to bst");
        addToBstButton.addActionListener( new ButtonActionListener(addToBstButton) );
        addToBstLabel = new JLabel("no result");
        addToTreeSetButton = new JButton("add to tree set");
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
        // position/size buttons/labels
        leftButtonPanelConstraints.weightx = 1;
        leftButtonPanelConstraints.weighty = 1;
        leftButtonPanelConstraints.fill = GridBagConstraints.NONE;
        leftButtonPanelConstraints.anchor = GridBagConstraints.LINE_START;
        for(int i = 0; i < leftButtons.size(); i++) {
            leftButtonPanelConstraints.gridx = 0;
            leftButtonPanelConstraints.gridy = i;
            leftButtonPanelConstraints.gridwidth = 1;
            leftGridBagLayout.setConstraints(leftButtons.get(i), leftButtonPanelConstraints);
            leftButtonPanelConstraints.gridx = 1;
            leftButtonPanelConstraints.gridy = i;
            leftButtonPanelConstraints.gridwidth = GridBagConstraints.REMAINDER;
            leftGridBagLayout.setConstraints(leftLabels.get(i), leftButtonPanelConstraints);
        }

        // add buttons to leftButtonPanel
        for(JButton b : leftButtons) leftButtonPanel.add(b);
        for(JLabel l : leftLabels) leftButtonPanel.add(l);

        // right button panel
        JPanel rightButtonPanel = new JPanel();
        rightButtonPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        GridBagLayout rightGridBagLayout = new GridBagLayout();
        rightButtonPanel.setLayout(rightGridBagLayout);
        rightButtonPanel.setMinimumSize(new Dimension(330,350));
        GridBagConstraints rightButtonPanelConstraints = new GridBagConstraints();

        // right buttons and labels
        searchSortedIntsButton = new JButton("search sorted ints");
        searchSortedIntsButton.addActionListener( new ButtonActionListener(searchSortedIntsButton) );
        searchSortedIntsLabel = new JLabel("no result");
        searchBstButton = new JButton("search bst");
        searchBstButton.addActionListener( new ButtonActionListener(searchBstButton) );
        searchBstLabel = new JLabel("no result");
        searchTreeSetButton = new JButton("search tree set");
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
        rightButtonPanelConstraints.weightx = 1;
        rightButtonPanelConstraints.weighty = 1;
        rightButtonPanelConstraints.fill = GridBagConstraints.NONE;
        rightButtonPanelConstraints.anchor = GridBagConstraints.LINE_START;
        for(int i = 0; i < rightButtons.size(); i++) {
            rightButtonPanelConstraints.gridx = 0;
            rightButtonPanelConstraints.gridy = i;
            rightButtonPanelConstraints.gridwidth = 1;
            rightGridBagLayout.setConstraints(rightButtons.get(i), rightButtonPanelConstraints);
            rightButtonPanelConstraints.gridx = 1;
            rightButtonPanelConstraints.gridy = i;
            rightButtonPanelConstraints.gridwidth = GridBagConstraints.REMAINDER;
            rightGridBagLayout.setConstraints(rightLabels.get(i), rightButtonPanelConstraints);
        }

        // add buttons to rightButtonPanel
        for(JButton b : rightButtons) rightButtonPanel.add(b);
        for(JLabel l : rightLabels) rightButtonPanel.add(l);

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
     * @param filename
     * @param readSortValues
     */
    private static void readData(String filename, boolean readSortValues) {

    }

    /**
     * Sorts the specified values using selection sort
     * @param values the values to be sorted
     */
    private static void selectionSort(int[] values) {
		for(int i = 0; i <= values.length; i++) {
			int min = i;
			for(int j = i + 1; j <= values.length; j++) {
				if(values[j] < values[min]) min = j;
			}
			if(min != i) { // swap values[min] and values[i]
				int t = values[min];
				values[min] = values[i];
				values[i] = t;
			}
		}
 	}

    /**
     *
    */
    private static int searchInts() {
        return 0;
    }

    /**
     *
    */
    private static void addToBST() {

    }

    /**
     *
    */
    private static int searchBST() {
        return 0;
    }

    /**
     *
    */
    private static void addToTreeSet() {

    }

    /**
     *
    */
    private static int searchTreeSet() {
        return 0;
    }

    /**
     *
    */
    private static void addToHashSet() {

    }

    /**
     *
    */
    private static int searchHashSet() {
        return 0;
    }

    /**
     *
    */
    private static void addToPriorityQ() {

    }

    /**
     *
    */
    private static int searchPriorityQ() {
        return 0;
    }

    /**
     *
    */
    private static void addToSortedArrayList() {

    }

    /**
     *
    */
    private static int searchSortedArrayList() {
        return 0;
    }

    /**
     *
    */
    private static void addToArray() {

    }

    /**
     *
    */
    private static int searchArray() {
        return 0;
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
            System.out.println(b.getText());
            System.out.println(b.getText().equals("Read sort file"));

            switch(b.getText()) {
                case "sort ints":
                    System.out.println("Clicked 'sort ints'");
                    break;
                default:
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

                    break;
                default:
            }

            // if exit is selected from the file menu, exit the program
            if( m.getText().toLowerCase().equals("exit") )
            {
                System.exit(0);
            }
        }
    }
}
