import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class liu_Project {
    private static int width = 750;
    private static int height = 350;

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
        JButton sortIntsButton = new JButton("sort ints");
        sortIntsButton.setEnabled(false);
        sortIntsButton.addActionListener( new ButtonActionListener(sortIntsButton) );
        JLabel sortIntsLabel = new JLabel("no result");
        JButton addToBstButton = new JButton("add to bst");
        addToBstButton.setEnabled(false);
        addToBstButton.addActionListener( new ButtonActionListener(addToBstButton) );
        JLabel addToBstLabel = new JLabel("no result");
        JButton addToTreeSetButton = new JButton("add to tree set");
        addToTreeSetButton.setEnabled(false);
        addToTreeSetButton.addActionListener( new ButtonActionListener(addToTreeSetButton) );
        JLabel addToTreeSetLabel = new JLabel("no result");
        JButton addToPriorityQButton = new JButton("add to priority queue");
        addToPriorityQButton.setEnabled(false);
        addToPriorityQButton.addActionListener( new ButtonActionListener(addToPriorityQButton) );
        JLabel addToPriorityQLabel = new JLabel("no result");
        JButton addToHashSetButton = new JButton("add to hashset");
        addToHashSetButton.setEnabled(false);
        addToHashSetButton.addActionListener( new ButtonActionListener(addToHashSetButton) );
        JLabel addToHashSetLabel = new JLabel("no result");
        JButton addToArrayListButton = new JButton("add to arraylist");
        addToArrayListButton.setEnabled(false);
        addToArrayListButton.addActionListener( new ButtonActionListener(addToArrayListButton) );
        JLabel addToArrayListLabel = new JLabel("no result");
        JButton addToSortedArrayButton = new JButton("add to sorted arraylist");
        addToSortedArrayButton.setEnabled(false);
        addToSortedArrayButton.addActionListener( new ButtonActionListener(addToSortedArrayButton) );
        JLabel addToSortedArrayLabel = new JLabel("no result");
        JButton addToArrayButton = new JButton("add to array");
        addToArrayButton.setEnabled(false);
        addToArrayButton.addActionListener( new ButtonActionListener(addToArrayButton) );
        JLabel addToArrayLabel = new JLabel("no result");

        leftButtonPanelConstraints.weightx = 1;
        leftButtonPanelConstraints.weighty = 1;
        leftButtonPanelConstraints.fill = GridBagConstraints.NONE;
        leftButtonPanelConstraints.anchor = GridBagConstraints.LINE_START;
        // sort ints
        leftButtonPanelConstraints.gridx = 0;
        leftButtonPanelConstraints.gridy = 0;
        leftButtonPanelConstraints.gridwidth = 1;
        leftGridBagLayout.setConstraints(sortIntsButton, leftButtonPanelConstraints);
        leftButtonPanelConstraints.gridx = 1;
        leftButtonPanelConstraints.gridy = 0;
        leftButtonPanelConstraints.gridwidth = GridBagConstraints.REMAINDER;
        leftGridBagLayout.setConstraints(sortIntsLabel, leftButtonPanelConstraints);
        // add to bst
        leftButtonPanelConstraints.gridx = 0;
        leftButtonPanelConstraints.gridy = 1;
        leftButtonPanelConstraints.gridwidth = 1;
        leftGridBagLayout.setConstraints(addToBstButton, leftButtonPanelConstraints);
        leftButtonPanelConstraints.gridx = 1;
        leftButtonPanelConstraints.gridy = 1;
        leftButtonPanelConstraints.gridwidth = GridBagConstraints.REMAINDER;
        leftGridBagLayout.setConstraints(addToBstLabel, leftButtonPanelConstraints);
        // add to treeset
        leftButtonPanelConstraints.gridx = 0;
        leftButtonPanelConstraints.gridy = 2;
        leftButtonPanelConstraints.gridwidth = 1;
        leftGridBagLayout.setConstraints(addToTreeSetButton, leftButtonPanelConstraints);
        leftButtonPanelConstraints.gridx = 1;
        leftButtonPanelConstraints.gridy = 2;
        leftButtonPanelConstraints.gridwidth = GridBagConstraints.REMAINDER;
        leftGridBagLayout.setConstraints(addToTreeSetLabel, leftButtonPanelConstraints);
        // add to priority queue
        leftButtonPanelConstraints.gridx = 0;
        leftButtonPanelConstraints.gridy = 3;
        leftButtonPanelConstraints.gridwidth = 1;
        leftGridBagLayout.setConstraints(addToPriorityQButton, leftButtonPanelConstraints);
        leftButtonPanelConstraints.gridx = 1;
        leftButtonPanelConstraints.gridy = 3;
        leftButtonPanelConstraints.gridwidth = GridBagConstraints.REMAINDER;
        leftGridBagLayout.setConstraints(addToPriorityQLabel, leftButtonPanelConstraints);
        // add to hashset
        leftButtonPanelConstraints.gridx = 0;
        leftButtonPanelConstraints.gridy = 4;
        leftButtonPanelConstraints.gridwidth = 1;
        leftGridBagLayout.setConstraints(addToHashSetButton, leftButtonPanelConstraints);
        leftButtonPanelConstraints.gridx = 1;
        leftButtonPanelConstraints.gridy = 4;
        leftButtonPanelConstraints.gridwidth = GridBagConstraints.REMAINDER;
        leftGridBagLayout.setConstraints(addToHashSetLabel, leftButtonPanelConstraints);
        // add to arraylist
        leftButtonPanelConstraints.gridx = 0;
        leftButtonPanelConstraints.gridy = 5;
        leftButtonPanelConstraints.gridwidth = 1;
        leftGridBagLayout.setConstraints(addToArrayListButton, leftButtonPanelConstraints);
        leftButtonPanelConstraints.gridx = 1;
        leftButtonPanelConstraints.gridy = 5;
        leftButtonPanelConstraints.gridwidth = GridBagConstraints.REMAINDER;
        leftGridBagLayout.setConstraints(addToArrayListLabel, leftButtonPanelConstraints);
        // add to sorted arraylist
        leftButtonPanelConstraints.gridx = 0;
        leftButtonPanelConstraints.gridy = 6;
        leftButtonPanelConstraints.gridwidth = 1;
        leftGridBagLayout.setConstraints(addToSortedArrayButton, leftButtonPanelConstraints);
        leftButtonPanelConstraints.gridx = 1;
        leftButtonPanelConstraints.gridy = 6;
        leftButtonPanelConstraints.gridwidth = GridBagConstraints.REMAINDER;
        leftGridBagLayout.setConstraints(addToSortedArrayLabel, leftButtonPanelConstraints);
        // add to array
        leftButtonPanelConstraints.gridx = 0;
        leftButtonPanelConstraints.gridy = 7;
        leftButtonPanelConstraints.gridwidth = 1;
        leftGridBagLayout.setConstraints(addToArrayButton, leftButtonPanelConstraints);
        leftButtonPanelConstraints.gridx = 1;
        leftButtonPanelConstraints.gridy = 7;
        leftButtonPanelConstraints.gridwidth = GridBagConstraints.REMAINDER;
        leftGridBagLayout.setConstraints(addToArrayLabel, leftButtonPanelConstraints);

        // add buttons to leftButtonPanel
        leftButtonPanel.add(sortIntsButton);
        leftButtonPanel.add(sortIntsLabel);
        leftButtonPanel.add(addToBstButton);
        leftButtonPanel.add(addToBstLabel);
        leftButtonPanel.add(addToTreeSetButton);
        leftButtonPanel.add(addToTreeSetLabel);
        leftButtonPanel.add(addToPriorityQButton);
        leftButtonPanel.add(addToPriorityQLabel);
        leftButtonPanel.add(addToHashSetButton);
        leftButtonPanel.add(addToHashSetLabel);
        leftButtonPanel.add(addToArrayListButton);
        leftButtonPanel.add(addToArrayListLabel);
        leftButtonPanel.add(addToSortedArrayButton);
        leftButtonPanel.add(addToSortedArrayLabel);
        leftButtonPanel.add(addToArrayButton);
        leftButtonPanel.add(addToArrayLabel);

        // right button panel
        JPanel rightButtonPanel = new JPanel();
        rightButtonPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        GridBagLayout rightGridBagLayout = new GridBagLayout();
        rightButtonPanel.setLayout(rightGridBagLayout);
        rightButtonPanel.setMinimumSize(new Dimension(330,350));

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
            switch(b.getText()) {
                case "":
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

            // if exit is selected from the file menu, exit the program
            if( m.getText().toLowerCase().equals("exit") )
            {
                System.exit(0);
            }

            // if color is selected from the edit menu, put a popup on the screen
            // saying something
            if( m.getText().toLowerCase().equals("color") )
            {
                Object[] options = {"OK"};
                javax.swing.JOptionPane.showOptionDialog(null, "This is unimplemented,\nclick OK to continue",
                        "Warning", javax.swing.JOptionPane.DEFAULT_OPTION,
                        javax.swing.JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            }
        }
    }
}
