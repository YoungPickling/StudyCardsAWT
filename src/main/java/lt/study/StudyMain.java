package lt.study;

import lt.study.listeners.ExitListener;

import java.awt.*;
import java.awt.event.*;

public class StudyMain {
    private Frame mainFrame;
    private Label headerLabel;
    private Label statusLabel;
    private Panel controlPanel;

    int windowSizeX = 800;
    int windowSizeY = 500;

    public StudyMain() {
        mainFrame = new Frame("StudyCards");
        centerWindow(mainFrame);

//        mainFrame.setLayout(new GridLayout(2, 1));

//        Panel panel = new Panel();
//        panel.setBounds(40,80,200,400);
//        panel.setBackground(Color.gray);

//        Button b = new Button("Click Me!!");
//        b.setBounds(30,100,80,30);
//        mainFrame.add(b);

        List sideListComponent = new List();

        mainFrame.setSize(this.windowSizeX,this.windowSizeY);

//        mainFrame.setLayout(new GridLayout(1, 3));
        mainFrame.setLayout(new GridLayout(1, 3));
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        headerLabel = new Label();
        headerLabel.setAlignment(Label.CENTER);

        statusLabel = new Label();
        statusLabel.setAlignment(Label.CENTER);
        statusLabel.setSize(350,100);

        controlPanel = new Panel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.setMenuBar(this.getMenuBar());
        mainFrame.add(sideListComponent);
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);

//        mainFrame.add(panel);
        mainFrame.setVisible(true); // now frame will be visible, by default it is not visible
    }

    // Center the frame
    private void centerWindow(Frame f) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - this.windowSizeX) / 2;
        int y = (screenSize.height - this.windowSizeY) / 2;
        f.setLocation(x, y);
    }

    private MenuBar getMenuBar() {
        final MenuBar menuBar = new MenuBar();
        ExitListener exitListener = new ExitListener();

        //create menus
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        final Menu aboutMenu = new Menu("About");
        aboutMenu.setActionCommand("About");

        //create menu items
        MenuItem newMenuItem =
                new MenuItem("New",new MenuShortcut(KeyEvent.VK_N));
        newMenuItem.setActionCommand("New");

        MenuItem openMenuItem = new MenuItem("Open", new MenuShortcut(KeyEvent.VK_O));
        openMenuItem.setActionCommand("Open");

        MenuItem saveMenuItem = new MenuItem("Save", new MenuShortcut(KeyEvent.VK_S));
        saveMenuItem.setActionCommand("Save");

        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setActionCommand("Exit");

        MenuItem cutMenuItem = new MenuItem("Cut", new MenuShortcut(KeyEvent.VK_X));
        cutMenuItem.setActionCommand("Cut");

        MenuItem copyMenuItem = new MenuItem("Copy", new MenuShortcut(KeyEvent.VK_C));
        copyMenuItem.setActionCommand("Copy");

        MenuItem pasteMenuItem = new MenuItem("Paste", new MenuShortcut(KeyEvent.VK_V));
        pasteMenuItem.setActionCommand("Paste");

        MenuItemListener menuItemListener = new MenuItemListener();

        newMenuItem.addActionListener(menuItemListener);
        openMenuItem.addActionListener(menuItemListener);
        saveMenuItem.addActionListener(menuItemListener);
        exitMenuItem.addActionListener(exitListener);
        cutMenuItem.addActionListener(menuItemListener);
        copyMenuItem.addActionListener(menuItemListener);
        pasteMenuItem.addActionListener(menuItemListener);
        aboutMenu.addActionListener(menuItemListener);

        final CheckboxMenuItem showWindowMenu =
                new CheckboxMenuItem("Show About", true);
        showWindowMenu.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(showWindowMenu.getState()){
                    menuBar.add(aboutMenu);
                }else{
                    menuBar.remove(aboutMenu);
                }
            }
        });

        //add menu items to menus
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(showWindowMenu);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        editMenu.add(cutMenuItem);
        editMenu.add(copyMenuItem);
        editMenu.add(pasteMenuItem);

        //add menu to menubar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(aboutMenu);

        //add menubar to the frame
        mainFrame.setMenuBar(menuBar);
        mainFrame.setVisible(true);

        return menuBar;
    }

    public class MenuItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
//            if(e.getActionCommand().equals("Exit")) {
//                System.exit(0);
//            }

            statusLabel.setText(e.getActionCommand()
                    + " MenuItem clicked.");
        }
    }
}