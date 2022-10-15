import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Calendar;
import java.util.GregorianCalendar;

 class ClockIcon implements Icon {
    private int size;

    public ClockIcon(int size){
        this.size = size;
    }


    @Override
    public int getIconWidth() {
        return size;
    }

    @Override
    public int getIconHeight() {
        return size;
    }


    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D graphics2D = (Graphics2D) g;
        Ellipse2D.Double circle = new Ellipse2D.Double(x,y,200,200);
        int centerX =(int)circle.getCenterX();
        int centerY =(int) circle.getCenterY();
        graphics2D.draw(circle);


        GregorianCalendar gCal = new GregorianCalendar();

        int hour = gCal.get(Calendar.HOUR);
        int min = gCal.get(Calendar.MINUTE);
        int sec = gCal.get(Calendar.SECOND);

        double minuteAngle = min*6 +90;
        double hourAngle = 0.5*(60*hour + min) + 90;
        double secondAngle = sec*6 +90;

        graphics2D.drawLine(centerX, centerY, centerX - (int)(75*Math.cos(Math.toRadians(minuteAngle))), centerY - (int)(70*Math.sin(Math.toRadians(minuteAngle))));
        graphics2D.drawLine(centerX, centerY, centerX - (int)(50*Math.cos(Math.toRadians(hourAngle))), centerY - (int)(50*Math.sin(Math.toRadians(hourAngle))));
        graphics2D.setColor(Color.RED);
        graphics2D.drawLine(centerX, centerY, centerX - (int)(100*Math.cos(Math.toRadians(secondAngle))), centerY - (int)(100*Math.sin(Math.toRadians(secondAngle))));
    }
}



public class ClockTester {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setTitle("ClockTester");
        frame.setSize(500,500);

        ClockIcon clockIcon = new ClockIcon(500);
        JLabel label = new JLabel(clockIcon);

        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
