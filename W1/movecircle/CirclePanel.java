// ******************************************************************
// CirclePanel.java
//
// A panel with a circle drawn in the center and buttons on the
// bottom that move the circle.
// ******************************************************************
package movecircle;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CirclePanel extends JPanel {
    private final int CIRCLE_SIZE = 50;
    private int x,y;
    private Color c;
    //---------------------------------------------------------------
    // Set up circle and buttons to move it.
    //---------------------------------------------------------------
    public CirclePanel(int width, int height) {
        // Set coordinates so circle starts in middle
        x = (width/2)-(CIRCLE_SIZE/2);
        y = (height/2)-(CIRCLE_SIZE/2);
        
        c = Color.green;
        
        // Need a border layout to get the buttons on the bottom
        this.setLayout(new BorderLayout());
        
        // Create buttons to move the circle
        JButton left = new JButton("Left");
        JButton right = new JButton("Right");
        JButton up = new JButton("Up");
        JButton down = new JButton("Down");
        
        // Add listeners to the buttons
        left.addActionListener(new MoveListener(-20,0));
        right.addActionListener(new MoveListener(20,0));
        up.addActionListener(new MoveListener(0,-20));
        down.addActionListener(new MoveListener(0,20));
        
        // Need a panel to put the buttons on or they'll be on
        // top of each other.
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(left);
        buttonPanel.add(right);
        buttonPanel.add(up);
        buttonPanel.add(down);
        
        // Add the button panel to the bottom of the main panel
        this.add(buttonPanel, "South");
        
        // Create buttons to change color
        JButton red = new JButton("Red");
        JButton cyan = new JButton("Cyan");
        JButton yellow = new JButton("Yellow");
        JButton magenta = new JButton("Magenta");
        
        // Button for other color
        JButton choose = new JButton("Choose Color");
        
        // Set background color for each button
        red.setBackground(Color.red);
        cyan.setBackground(Color.cyan);
        yellow.setBackground(Color.yellow);
        magenta.setBackground(Color.magenta);

        // Add listeners to the buttons
        red.addActionListener(new ColorListener(Color.red));
        cyan.addActionListener(new ColorListener(Color.cyan));
        choose.addActionListener(new ColorListener(null));
        yellow.addActionListener(new ColorListener(Color.yellow));
        magenta.addActionListener(new ColorListener(Color.magenta));
        
        // Need a panel to put the buttons on or they'll be on
        // top of each other.
        JPanel buttonPanel2 = new JPanel();
        buttonPanel2.add(red);
        buttonPanel2.add(cyan);
        buttonPanel2.add(choose);
        buttonPanel2.add(yellow);
        buttonPanel2.add(magenta);
        
        // Add the button panel to the top of the main panel
        this.add(buttonPanel2, "North");
        
    }
    
    //---------------------------------------------------------------
    // Draw circle on CirclePanel
    //---------------------------------------------------------------
    public void paintComponent(Graphics page){
        super.paintComponent(page);
            
        page.setColor(c);
        page.fillOval(x,y,CIRCLE_SIZE,CIRCLE_SIZE);
    }
        
    //---------------------------------------------------------------
    // Class to listen for button clicks that move circle.
    //---------------------------------------------------------------
    private class MoveListener implements ActionListener {
        private int dx;
        private int dy;
            
        //---------------------------------------------------------------
        // Parameters tell how to move circle at click.
        //---------------------------------------------------------------
        public MoveListener(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }
            
        //---------------------------------------------------------------
        // Change x and y coordinates and repaint.
        //---------------------------------------------------------------
        public void actionPerformed(ActionEvent e) {
            x += dx;
            y += dy;
            repaint();
        }
    }
    
    //---------------------------------------------------------------
    // Class to listen for button clicks that change color.
    //---------------------------------------------------------------
    private class ColorListener implements ActionListener {
        Color clr;
        JPanel color;
        
        //---------------------------------------------------------------
        // Parameters tell what the color.
        //---------------------------------------------------------------
        public ColorListener(Color color){
            this.clr = color;
        }
        
        //---------------------------------------------------------------
        // Change circle color.
        //---------------------------------------------------------------
        public void actionPerformed(ActionEvent e) {
            if(clr == null)
                c = JColorChooser.showDialog(color, "Choose Color", null);
            else 
                c = clr;
            repaint();
        }
    }
}
