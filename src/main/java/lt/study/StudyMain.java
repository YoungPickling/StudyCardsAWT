package lt.study;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StudyMain {

    int windowSizeX = 500;
    int windowSizeY = 300;

    public StudyMain() {
        Frame f = new Frame();

        Button b = new Button("Click Me!!");
        b.setBounds(30,100,80,30);
        f.add(b);

        f.setSize(this.windowSizeX,this.windowSizeY);
        f.setTitle("This is our basic AWT example");

        centerWindow(f);

        // no layout manager
        f.setLayout(null);
        f.addWindowListener(
            new WindowAdapter() {
                 public void windowClosing(WindowEvent we) {
                     f.dispose();
                 }
            }
        );

        // now frame will be visible, by default it is not visible
        f.setVisible(true);
    }

    // Center the frame
    private void centerWindow(Frame f) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - this.windowSizeX) / 2;
        int y = (screenSize.height - this.windowSizeY) / 2;
        f.setLocation(x, y);
    }
}