/**
 * Created by abduljama on 9/27/16.
 */
import java.applet.Applet;
import java.awt.*;
import java.util.Scanner;

/**
 * Created by abduljama on 9/18/16.
 */
public class Bresenham extends Applet {

    // Intial point
    int x0,y0 ;
    // Endpoints
    int xn , yn ;

    // Delta X & Y
    double dx,dy, dydx1,dydx2;

    double  pX;

    int totalPoints ;

     Boolean  increment , decrement;


    public  Bresenham (  int  x0 , int y0 , int xn,  int yn ){
        this.x0=x0;
        this.y0=y0;
        this.xn=xn;
        this.yn=yn;
    }

    public Bresenham () {}


    public void paint(Graphics g) {
       x0= 2; y0= 3; xn=9;yn= 5 ;
        g.fillOval(x0, y0, 5, 5);
        g.fillOval(xn, yn, 5, 5);
        dx = xn - x0;
        dy = yn - y0;
      //  dydx1=dy-dx;
       // dydx2=dy+dx;


        //  Computes total number of  points  required to  plot the line
        if  ( Math.abs(xn) > Math.abs(x0))
            totalPoints = Math.abs(xn);
        else
            totalPoints=Math.abs(x0);

        double  grad = dy/dx;
        if  ( grad > 0 ) {
            System.out.println("Gradient is positive");
            pX= (2 * dy)-dx;
            System.out.println( "pX : " + pX + " X : " + x0 +" Y : " +y0 );
            for (int k = 1; k < totalPoints-1; k++) {
                if (pX < 0) {
                    g.fillOval(x0++, y0, 5, 5);
                    pX = pX + (2 * dy);
                    System.out.println( "pX : " + pX + " X : " + x0 +" Y : " +y0 );
                } else {
                    g.fillOval(x0++, y0++, 5, 5);
                    pX = pX + (2 * (dy-dx));
                    System.out.println( "pX : " + pX + " X : " + x0 +" Y : " +y0 );
                }

            }
        }
        else {

            System.out.println("Gradient is negative");
            pX= ((-2)*dy) - dx;
            System.out.println( "pX : " + pX + " X : " + x0 +" Y : " +y0 );
            for (  int k = 1; k < totalPoints+1 ; k++){
                if (pX <0){
                    x0=x0+1;

                    //plot pixel (x0++  & y0 )
                    // unable to plot -ve values  of  X and Y
                    pX= pX- (2 * dy);
                    System.out.println( "pX : " + pX + " X : " + x0 +" Y : " +y0 );
                }else {
                    x0++ ;
                    y0=y0--;
                    //plot pixel (x0++  & y0++ )
                    // unable to plot -ve values  of  X and Y
                    pX=pX - (2 * dy+dx);
                    System.out.println( "pX : " + pX + " X : " + x0 +" Y : " +y0 );
                }
            }

        }
    }
    public  void main(String[] args) {
//
//        Scanner reader = new Scanner(System.in);  // Reading from System.in
//        System.out.println("Enter  intial  X-cordinate: ");
//        int int_x = reader.nextInt();
//        System.out.println("Enter  intial  Y-cordinate: ");
//        int  int_y = reader.nextInt();
//        System.out.println("Enter  final  X-cordinate: ");
//        int last_x = reader.nextInt();
//        System.out.println("Enter  final  Y-cordinate: ");
//        int last_y= reader.nextInt();

        Graphics g = getGraphics();
        Bresenham bresenham = new Bresenham();
        bresenham.paint(g);




    }


}
