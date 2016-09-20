/**
 * Created by abduljama on 9/17/16.
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
    private ArrayList<ArrayList<Point>> allPoints = new ArrayList<ArrayList<Point>>();
    public  ArrayList<Point> inner;

    /**
     * Constructs a panel, registering listeners for the mouse.
     */
    public TrivialSketcher() {
        // When the mouse button goes down, set the current point
        // to the location at which the mouse was pressed.
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                inner = new ArrayList<Point>();;
                inner.add(new Point(e.getX(), e.getY()));
                allPoints.add(inner);

            }
        });

        // When the mouse is dragged, draw a line from the old point
        // to the new point and update the value of lastPoint to hold
        // the new current point.
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Graphics g = getGraphics();
                int last = inner.size();
                inner.add(new Point(e.getX(), e.getY()));
                g.drawLine(inner.get(last - 1).x, inner.get(last -1).y,
                        e.getX(), e.getY());
                g.dispose();
            }
        });
    }
    @Override
    public void paint(Graphics g){
        int i;
        for(int j = 0; j < allPoints.size(); j++){
            i=0;
            for(int i1 = 1; i1 < allPoints.get(j).size(); i1++)
            {
                g.drawLine(allPoints.get(j).get(i).x, allPoints.get(j).get(i).y,
                        allPoints.get(j).get(i1).x, allPoints.get(j).get(i1).y);
                i++;
            }
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