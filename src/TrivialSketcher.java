/**
 * Created by abduljama on 9/6/16.
 */

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This is an extremely scaled-down sketching canvas; with it you
 * can only scribble thin black lines.  For simplicity the window
 * contents are never refreshed when they are uncovered.
 */
public class TrivialSketcher extends JPanel {

    /**
     * Keeps track of the last point to draw the next line from.
     */
    private ArrayList<Point> lastPoint = new ArrayList<Point>();

    /**
     * Constructs a panel, registering listeners for the mouse.
     */
    public TrivialSketcher() {
        // When the mouse button goes down, set the current point
        // to the location at which the mouse was pressed.
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                lastPoint.add(new Point(e.getX(), e.getY()));
            }
        });

        // When the mouse is dragged, draw a line from the old point
        // to the new point and update the value of lastPoint to hold
        // the new current point.
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Graphics g = getGraphics();
                int last = lastPoint.size();
                lastPoint.add(new Point(e.getX(), e.getY()));
                g.drawLine(lastPoint.get(last-1).x, lastPoint.get(last-1).y, e.getX(), e.getY());
                g.dispose();
            }
        });


    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int i = 0;
        for(int j = 1 ; j < lastPoint.size(); j++){
            g.drawLine(lastPoint.get(i+1).x, lastPoint.get(i+1).y,
                    lastPoint.get(j+1).x, lastPoint.get(j+1).y);
            i++;
        }

    }
    /**
     * A tester method that embeds the panel in a frame so you can
     * run it as an application.
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Sketching Program");
        frame.getContentPane().add(new TrivialSketcher(), BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}