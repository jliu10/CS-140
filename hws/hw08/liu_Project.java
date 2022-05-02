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
    private static ArrayList<JButton> leftButtons = new ArrayList<>(8); // facilitate disabling/enabling
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
    private static ArrayList<JButton> rightButtons = new ArrayList<>(8); // facilitate disabling/enabling
    private File sortFile;
    private File searchFile;

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
        JButton searchSortedIntsButton = new JButton("search sorted ints");
        searchSortedIntsButton.setEnabled(false);
        searchSortedIntsButton.addActionListener( new ButtonActionListener(searchSortedIntsButton) );
        JLabel searchSortedIntsLabel = new JLabel("no result");
        JButton searchBstButton = new JButton("search bst");
        searchBstButton.setEnabled(false);
        searchBstButton.addActionListener( new ButtonActionListener(searchBstButton) );
        JLabel searchBstLabel = new JLabel("no result");
        JButton searchTreeSetButton = new JButton("search tree set");
        searchTreeSetButton.setEnabled(false);
        searchTreeSetButton.addActionListener( new ButtonActionListener(searchTreeSetButton) );
        JLabel searchTreeSetLabel = new JLabel("no result");
        JButton searchPriorityQButton = new JButton("search priority queue");
        searchPriorityQButton.setEnabled(false);
        searchPriorityQButton.addActionListener( new ButtonActionListener(searchPriorityQButton) );
        JLabel searchPriorityQLabel = new JLabel("no result");
        JButton searchHashSetButton = new JButton("search hashset");
        searchHashSetButton.setEnabled(false);
        searchHashSetButton.addActionListener( new ButtonActionListener(searchHashSetButton) );
        JLabel searchHashSetLabel = new JLabel("no result");
        JButton searchArrayListButton = new JButton("search arraylist");
        searchArrayListButton.setEnabled(false);
        searchArrayListButton.addActionListener( new ButtonActionListener(searchArrayListButton) );
        JLabel searchArrayListLabel = new JLabel("no result");
        JButton searchSortedArrayButton = new JButton("search sorted arraylist");
        searchSortedArrayButton.setEnabled(false);
        searchSortedArrayButton.addActionListener( new ButtonActionListener(searchSortedArrayButton) );
        JLabel searchSortedArrayLabel = new JLabel("no result");
        JButton searchArrayButton = new JButton("search array");
        searchArrayButton.setEnabled(false);
        searchArrayButton.addActionListener( new ButtonActionListener(searchArrayButton) );
        JLabel searchArrayLabel = new JLabel("no result");

        rightButtonPanelConstraints.weightx = 1;
        rightButtonPanelConstraints.weighty = 1;
        rightButtonPanelConstraints.fill = GridBagConstraints.NONE;
        rightButtonPanelConstraints.anchor = GridBagConstraints.LINE_START;
        // sort ints
        rightButtonPanelConstraints.gridx = 0;
        rightButtonPanelConstraints.gridy = 0;
        rightButtonPanelConstraints.gridwidth = 1;
        rightGridBagLayout.setConstraints(searchSortedIntsButton, rightButtonPanelConstraints);
        rightButtonPanelConstraints.gridx = 1;
        rightButtonPanelConstraints.gridy = 0;
        rightButtonPanelConstraints.gridwidth = GridBagConstraints.REMAINDER;
        rightGridBagLayout.setConstraints(searchSortedIntsLabel, rightButtonPanelConstraints);
        // add to bst
        rightButtonPanelConstraints.gridx = 0;
        rightButtonPanelConstraints.gridy = 1;
        rightButtonPanelConstraints.gridwidth = 1;
        rightGridBagLayout.setConstraints(searchBstButton, rightButtonPanelConstraints);
        rightButtonPanelConstraints.gridx = 1;
        rightButtonPanelConstraints.gridy = 1;
        rightButtonPanelConstraints.gridwidth = GridBagConstraints.REMAINDER;
        rightGridBagLayout.setConstraints(searchBstLabel, rightButtonPanelConstraints);
        // add to treeset
        rightButtonPanelConstraints.gridx = 0;
        rightButtonPanelConstraints.gridy = 2;
        rightButtonPanelConstraints.gridwidth = 1;
        rightGridBagLayout.setConstraints(searchTreeSetButton, rightButtonPanelConstraints);
        rightButtonPanelConstraints.gridx = 1;
        rightButtonPanelConstraints.gridy = 2;
        rightButtonPanelConstraints.gridwidth = GridBagConstraints.REMAINDER;
        rightGridBagLayout.setConstraints(searchTreeSetLabel, rightButtonPanelConstraints);
        // add to priority queue
        rightButtonPanelConstraints.gridx = 0;
        rightButtonPanelConstraints.gridy = 3;
        rightButtonPanelConstraints.gridwidth = 1;
        rightGridBagLayout.setConstraints(searchPriorityQButton, rightButtonPanelConstraints);
        rightButtonPanelConstraints.gridx = 1;
        rightButtonPanelConstraints.gridy = 3;
        rightButtonPanelConstraints.gridwidth = GridBagConstraints.REMAINDER;
        rightGridBagLayout.setConstraints(searchPriorityQLabel, rightButtonPanelConstraints);
        // add to hashset
        rightButtonPanelConstraints.gridx = 0;
        rightButtonPanelConstraints.gridy = 4;
        rightButtonPanelConstraints.gridwidth = 1;
        rightGridBagLayout.setConstraints(searchHashSetButton, rightButtonPanelConstraints);
        rightButtonPanelConstraints.gridx = 1;
        rightButtonPanelConstraints.gridy = 4;
        rightButtonPanelConstraints.gridwidth = GridBagConstraints.REMAINDER;
        rightGridBagLayout.setConstraints(searchHashSetLabel, rightButtonPanelConstraints);
        // add to arraylist
        rightButtonPanelConstraints.gridx = 0;
        rightButtonPanelConstraints.gridy = 5;
        rightButtonPanelConstraints.gridwidth = 1;
        rightGridBagLayout.setConstraints(searchArrayListButton, rightButtonPanelConstraints);
        rightButtonPanelConstraints.gridx = 1;
        rightButtonPanelConstraints.gridy = 5;
        rightButtonPanelConstraints.gridwidth = GridBagConstraints.REMAINDER;
        rightGridBagLayout.setConstraints(searchArrayListLabel, rightButtonPanelConstraints);
        // add to sorted arraylist
        rightButtonPanelConstraints.gridx = 0;
        rightButtonPanelConstraints.gridy = 6;
        rightButtonPanelConstraints.gridwidth = 1;
        rightGridBagLayout.setConstraints(searchSortedArrayButton, rightButtonPanelConstraints);
        rightButtonPanelConstraints.gridx = 1;
        rightButtonPanelConstraints.gridy = 6;
        rightButtonPanelConstraints.gridwidth = GridBagConstraints.REMAINDER;
        rightGridBagLayout.setConstraints(searchSortedArrayLabel, rightButtonPanelConstraints);
        // add to array
        rightButtonPanelConstraints.gridx = 0;
        rightButtonPanelConstraints.gridy = 7;
        rightButtonPanelConstraints.gridwidth = 1;
        rightGridBagLayout.setConstraints(searchArrayButton, rightButtonPanelConstraints);
        rightButtonPanelConstraints.gridx = 1;
        rightButtonPanelConstraints.gridy = 7;
        rightButtonPanelConstraints.gridwidth = GridBagConstraints.REMAINDER;
        rightGridBagLayout.setConstraints(searchArrayLabel, rightButtonPanelConstraints);

        // add buttons to rightButtonPanel
        rightButtonPanel.add(searchSortedIntsButton);
        rightButtonPanel.add(searchSortedIntsLabel);
        rightButtonPanel.add(searchBstButton);
        rightButtonPanel.add(searchBstLabel);
        rightButtonPanel.add(searchTreeSetButton);
        rightButtonPanel.add(searchTreeSetLabel);
        rightButtonPanel.add(searchPriorityQButton);
        rightButtonPanel.add(searchPriorityQLabel);
        rightButtonPanel.add(searchHashSetButton);
        rightButtonPanel.add(searchHashSetLabel);
        rightButtonPanel.add(searchArrayListButton);
        rightButtonPanel.add(searchArrayListLabel);
        rightButtonPanel.add(searchSortedArrayButton);
        rightButtonPanel.add(searchSortedArrayLabel);
        rightButtonPanel.add(searchArrayButton);
        rightButtonPanel.add(searchArrayLabel);

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
            if(b.getText().equals("Read sort file")) {
                System.out.println("Clicked Read sort file");
            }
            // String buttonText = b.getText();
            // switch(buttonText) {
            //     case "Read sort file":
            //         System.out.println("Clicked Read sort file");
            //         break;
            //     default:
            // }
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
