/**
 * Created by abduljama on 9/27/16.
 */
import java.applet.Applet;
import java.awt.*;

/**
 * Created by abduljama on 9/18/16.
 */
public class Bresenham extends Applet {

    // Intial point
    int x0,y0 ;
    // Endpoints
    int xn , yn ;

    // Delta X & Y
    double dx,dy;

    double  pX;

    int totalPoints ;
    public void paint(Graphics g) {
        x0= -8 ; y0= -4; xn= 0;yn=0 ;
        g.fillOval(x0, y0, 5, 5);
        g.fillOval(xn, yn, 5, 5);
        dx = xn - x0;
        dy = yn - y0;

        //  Computes total number of  points  required to  plot the line
        if  ( Math.abs(xn) > Math.abs(x0))
            totalPoints = Math.abs(xn);
        else
            totalPoints=Math.abs(x0);

        double  grad = dy/dx;
        if  ( grad > 0 ) {
            System.out.println("Gradient is positive");
            pX= 2*dy-dx;
            System.out.println( "pX : " + pX + " X : " + x0 +" Y : " +y0 );
            for (int k = 1; k < totalPoints; k++) {
                if (pX < 0) {
                    g.fillOval(x0++, y0, 5, 5);
                    pX = pX + (2 * dy);
                    System.out.println( "pX : " + pX + " X : " + x0 +" Y : " +y0 );
                } else {
                    g.fillOval(x0++, y0++, 5, 5);
                    pX = pX + (2 * (dy - dx));
                    System.out.println( "pX : " + pX + " X : " + x0 +" Y : " +y0 );
                }

            }
        }
        else {
            //  Cannot
            System.out.println("Gradient is negative");
            pX= -2*dy-dx;
            System.out.println( "pX : " + pX + " X : " + x0 +" Y : " +y0 );
            for (  int k = 1; k < totalPoints; k++){
                if (pX <0){
                    //plot pixel (x0++  & y0 )
                    pX= pX- (2 * dy);
                    System.out.println( "pX : " + pX + " X : " + x0 +" Y : " +y0 );
                }else {
                    //plot pixel (x0++  & y0++ )
                    pX=pX - (2 * (dy + dx));
                    System.out.println( "pX : " + pX + " X : " + x0 +" Y : " +y0 );
                }
            }

        }
    }
    public  void main(String[] args) {
        Graphics g = getGraphics();
        Bresenham bresenham = new Bresenham();
        bresenham.paint(g);


    }


}
