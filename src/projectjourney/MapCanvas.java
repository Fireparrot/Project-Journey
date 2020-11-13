package projectjourney;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;

class MapCanvas extends JComponent {
    
    private static final int WIDTH = 25;
    private static final int HEIGHT = 25;
    private static final double[][] FOG = Func.perlinCubic2(32, 32, 2, 6, 0.4);
    private static final Color FOGCOLOR = Color.WHITE;
    private final Color[][] bgs;
    private final Color[][] fgs;
    private final char[][] symbols;
    
    PlayerFrame PF;
    
    public MapCanvas(PlayerFrame pf) {
        PF = pf;
        bgs = new Color[WIDTH][HEIGHT];
        fgs = new Color[WIDTH][HEIGHT];
        symbols = new char[WIDTH][HEIGHT];
        for(int i = 0; i < WIDTH; i++) {
            for(int j = 0; j < HEIGHT; j++) {
                bgs[i][j] = null;
                fgs[i][j] = null;
                symbols[i][j] = ' ';
            }
        }
    }
    
    public void paint2(Graphics g, Time t) {
        
        Graphics2D g2 = (Graphics2D) g;
        //this.setDoubleBuffered(true);
        if(getPlayer().isAlive()) {
        
        Map map = getMap();
        
        //g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setBackground(Color.black);
        Font font = new Font("Serif", Font.PLAIN, 24);
        g2.setFont(font);
        
        //g2.drawLine(0, 0, 0, 500);
        //g2.drawLine(0, 0, 500, 0);
        //g2.drawLine(500, 0, 500, 500);
        //g2.drawLine(0, 500, 500, 500);
        int beginX;
        int beginY;
        if(map.getWrap()) {
            beginX = getPlayer().getMapX()-(int)((WIDTH+1)/2);
            beginY = getPlayer().getMapY()-(int)((HEIGHT+1)/2);
        } else {
            beginX = getPlayer().getMapX()-(int)((WIDTH+1)/2);
            if(beginX + WIDTH > map.getWidth()) {beginX = map.getWidth() - WIDTH;}
            if(beginX < 0) {beginX = 0;}
            beginY = getPlayer().getMapY()-(int)((HEIGHT+1)/2);
            if(beginY + HEIGHT > map.getHeight()) {beginY = map.getHeight() - HEIGHT;}
            if(beginY < 0) {beginY = 0;}
        }
        
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                if(map.canAccess(i + beginX, j + beginY)) {
                    if(map.isDiscovered(i + beginX, j + beginY)) {
                        double multiplierR = 0.25 + t.daylight()*3/4;
                        double multiplierG = 0.25 + t.daylight()*3/4;
                        double multiplierB = 0.5 + t.daylight()/2;
                        Color bg = map.getTile(i + beginX, j + beginY).getColor();
                        bg = new Color((int)(multiplierR*bg.getRed()), (int)(multiplierG*bg.getGreen()), (int)(multiplierB*bg.getBlue()));
                        Color fg = map.getTile(i + beginX, j + beginY).getColor2();
                        fg = new Color((int)(multiplierR*fg.getRed()), (int)(multiplierG*fg.getGreen()), (int)(multiplierB*fg.getBlue()));
                        char symbol = map.getTile(i + beginX, j + beginY).getSymbol();
                        if(i + beginX == getPlayer().getMapX() && j + beginY == getPlayer().getMapY()) {
                            fg = Color.black;
                        } else {
                            //Do nothing. The foreground color remains the same as was.
                        }
                        if(bg.equals(bgs[i][j]) && fg.equals(fgs[i][j]) && symbol == symbols[i][j] && false) {
                            //Do nothing. The tile is already painted on.
                        } else {
                            //if(i == 5 && j == 20) {System.out.println("Hmm...");}
                            double fogMod = 0;//1/(2-1*t.daylight());
                            g2.setColor(Func.alphaColorOverlay(bg, 1-FOG[i][j]*fogMod, FOGCOLOR, FOG[i][j]*fogMod));
                            g2.fillRect(20*i, 20*j, 20, 20);
                            g2.setColor(Func.alphaColorOverlay(fg, 1-FOG[i][j]*fogMod, FOGCOLOR, FOG[i][j]*fogMod));
                            g2.drawString("" + symbol, 20*i+5, 20*j+20);
                            //g2.setColor(Color.WHITE);
                            //g2.drawRect(20*i, 20*j, 1, 1);
                        }
                        bgs[i][j] = bg;
                        fgs[i][j] = fg;
                        symbols[i][j] = symbol;
                    } else {
                        bgs[i][j] = Color.black;
                        fgs[i][j] = null;
                        symbols[i][j] = ' ';
                        g2.setColor(Color.black);
                        g2.fillRect(20*i, 20*j, 20*i+20, 20*j+20);
                    }
                }
            }
        }
        
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(MapCanvas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        } else {
            g2.setColor(Color.black);
            g2.fillRect(0, 0, 505, 505);
            g2.setColor(Color.red);
            Font font = new Font("Serif", Font.PLAIN, 72);
            g2.setFont(font);
            g2.drawString("You lost!", 120, 250);
            Font font2 = new Font("Serif", Font.PLAIN, 24);
            g2.setFont(font2);
            g2.drawString("(" + getPlayer().getDeathMessage() + ")", 250 - 12*(getPlayer().getDeathMessage().length()+2)/2, 300);
        }
        
    }
    
    public Player getPlayer() {
        return PF.getNarrator().getPlayer();
    }
    public Map getMap() {
        return PF.getNarrator().getPlayer().getCurrentMap();
    }
    
}
