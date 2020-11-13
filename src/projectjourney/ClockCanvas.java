package projectjourney;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

public class ClockCanvas extends JComponent{
    
    private final static double RADIUS = 39.9;
    private final static double WIDTH = 100;
    private final static double HEIGHT = 100;
    private final static Color SKYBLUE = new Color(0, 192, 255);
    private final static Color DARKBLUE = new Color(0, 0, 128);
    private final static Color SUNYELLOW = new Color(255, 224, 0);
    
    private final BufferedImage canvas;
    
    public BufferedImage getCanvas() {return canvas;}
    
    public ClockCanvas() {
        canvas = new BufferedImage((int)WIDTH, (int)HEIGHT, BufferedImage.TYPE_INT_ARGB);
        canvas.setAccelerationPriority(1);
        
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(canvas.getWidth(), canvas.getHeight());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(canvas, null, null);
    }


    public void fillCanvas(Color c) {
        int color = c.getRGB();
        for (int x = 0; x < canvas.getWidth(); x++) {
            for (int y = 0; y < canvas.getHeight(); y++) {
                canvas.setRGB(x, y, color);
            }
        }
        //repaint();
    }
    public void fillCanvas(int color) {
        for (int x = 0; x < canvas.getWidth(); x++) {
            for (int y = 0; y < canvas.getHeight(); y++) {
                canvas.setRGB(x, y, color);
            }
        }
        //repaint();
    }
    public void clearCanvas() {
        fillCanvas(Color.BLACK.getRGB());
    }
    
    public void draw(Time t) {
        
        double t1 = 5;
        double t2 = 6;
        double t3 = 18;
        double t4 = 19;
        
        Color dn;
        Color blank;
        
        if(t.getHour() < t1) {
            dn = DARKBLUE;
            blank = Color.black;
        } else if(t.getHour() < t2) {
            dn = new Color((int)(Func.between(t1, t.getHour()+(double)t.getMinute()/60, t2)*(double)255), (int)(Func.between(t1, t.getHour()+(double)t.getMinute()/60, t2)*224), (int)(Func.between(t2, t.getHour()+(double)t.getMinute()/60, t1)*128));
            blank = new Color((int)(Func.between(t1, t.getHour()+(double)t.getMinute()/60, t2)*0), (int)(Func.between(t1, t.getHour()+(double)t.getMinute()/60, t2)*192), (int)(Func.between(t1, t.getHour()+(double)t.getMinute()/60, t2)*255));
        } else if(t.getHour() < t3) {
            dn = SUNYELLOW;
            blank = SKYBLUE;
        } else if(t.getHour() < t4) {
            dn = new Color((int)(Func.between(t4, t.getHour()+(double)t.getMinute()/60, t3)*255), (int)(Func.between(t4, t.getHour()+(double)t.getMinute()/60, t3)*224), (int)(Func.between(t3, t.getHour()+(double)t.getMinute()/60, t4)*128));
            blank = new Color((int)(Func.between(t4, t.getHour()+(double)t.getMinute()/60, t3)*0), (int)(Func.between(t4, t.getHour()+(double)t.getMinute()/60, t3)*192), (int)(Func.between(t4, t.getHour()+(double)t.getMinute()/60, t3)*255));
        } else {
            dn = DARKBLUE;
            blank = Color.black;
        }
        Color bg = new Color(240, 240, 240);
        
        //canvas.setRGB(5, 5, dn.getRGB());
        
        for(int i = 0; i < WIDTH; i++) {
            for(int j = 0; j < HEIGHT; j++) {
                if(((double)i-WIDTH/2)*((double)i-WIDTH/2) + ((double)j-HEIGHT/2)*((double)j-HEIGHT/2) <= RADIUS*RADIUS) {
                    if(Func.clockAngle(((double)i-WIDTH/2), -((double)j-HEIGHT/2)) <= ((double)(t.getHour()%12)*30 + (double)t.getMinute()*0.5)/180*Math.PI) {
                        canvas.setRGB(i, j, dn.getRGB());
                    } else {
                        canvas.setRGB(i, j, blank.getRGB());
                    }
                } else {
                    canvas.setRGB(i, j, bg.getRGB());
                }
            }
        }
        
    }
    
    public void paint(Graphics g, Time t) {
        draw(t);
        g.drawImage(canvas, 0, 0, this);
    }
    
}