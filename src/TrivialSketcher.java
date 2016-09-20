/**
 * Created by abduljama on 9/17/16.
 */


import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.*;

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
    private ArrayList<Point> lastPoint;
    private ArrayList<ArrayList<Point>> allPoints = new ArrayList<ArrayList<Point>>();


   public  LinkedHashMap<Integer,ArrayList<Point> > hmap ;
   public   Set set;
    /**
     * Constructs a panel, registering listeners for the mouse.
     */
    public TrivialSketcher() {
        // When the mouse button goes down, set the current point
        // to the location at which the mouse was pressed.
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                lastPoint = new ArrayList<Point>();;
                lastPoint.add(new Point(e.getX(), e.getY()));
                allPoints.add(lastPoint);

                hmap= new  LinkedHashMap<Integer,ArrayList<Point>>();
                hmap.put(e.getX(),lastPoint);




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
                g.drawLine(lastPoint.get(last - 1).x, lastPoint.get(last -1).y,
                        e.getX(), e.getY());
                g.dispose();

            }
        });
    }
    @Override
    public void paint(Graphics g){
//        int i;
//        for(int j = 0; j < allPoints.size(); j++){
//            i=0;
//            for(int i1 = 1; i1 < allPoints.get(j).size(); i1++)
//            {
//                g.drawLine(allPoints.get(j).get(i).x, allPoints.get(j).get(i).y,
//                        allPoints.get(j).get(i1).x, allPoints.get(j).get(i1).y);
//                i++;
//            }
//
//        }
        Set set = hmap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry me = (Map.Entry)iterator.next();
            ArrayList sketchpoints= (ArrayList) me.getValue();
            System.out.print(sketchpoints);
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