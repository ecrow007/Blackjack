import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.image.ImageObserver;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ZEICHENFENSTER {
  private JFrame frame;
  
  private CanvasPane canvas;
  
  private JPanel steuerungOst;
  
  private JPanel steuerungSued;
  
  private Graphics2D graphic;
  
  private Color backgroundColor;
  
  private Image canvasImage;
  
  public ZEICHENFENSTER(String name) {
    this(name, 600, 500, Color.white);
  }
  
  private ZEICHENFENSTER(String titel, int breite, int hoehe, Color hintergrundFarbe) {
    this.frame = new JFrame();
    this.canvas = new CanvasPane();
    this.canvas.setPreferredSize(new Dimension(breite, hoehe));
    this.frame.getContentPane().add(this.canvas, "Center");
    JPanel p1 = new JPanel();
    p1.setLayout(new BorderLayout());
    this.steuerungOst = new JPanel();
    this.steuerungSued = new JPanel();
    this.steuerungOst.setLayout(new BoxLayout(this.steuerungOst, 1));
    this.steuerungSued.setLayout(new BoxLayout(this.steuerungSued, 0));
    p1.add(this.steuerungOst, "North");
    this.frame.getContentPane().add(p1, "East");
    this.frame.getContentPane().add(this.steuerungSued, "South");
    this.frame.setTitle(titel);
    this.backgroundColor = hintergrundFarbe;
    this.frame.pack();
    zeige();
  }
  
  public void zeige() {
    if (this.graphic == null) {
      Dimension size = this.canvas.getSize();
      this.canvasImage = this.canvas.createImage(size.width, size.height);
      this.graphic = (Graphics2D)this.canvasImage.getGraphics();
      this.graphic.setColor(this.backgroundColor);
      this.graphic.fillRect(0, 0, size.width, size.height);
      this.graphic.setColor(Color.black);
    } 
    this.frame.setVisible(true);
  }
  public void verstecke() {
      this.frame.setVisible(false);
  }
  public boolean istSichtbar() {
    return this.frame.isVisible();
  }
  
  public void zeichneKreis(int x, int y, int radius) {
    this.graphic.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
    this.canvas.repaint();
  }
  
  public void fuelleKreis(int x, int y, int radius, int farbnr) {
    Color original = this.graphic.getColor();
    this.graphic.setColor(farbeZuColor(farbnr));
    this.graphic.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    this.canvas.repaint();
    this.graphic.setColor(original);
  }
  
  public void loescheKreis(int x, int y, int radius) {
    Ellipse2D.Double circle = new Ellipse2D.Double((x - radius), (y - radius), (2 * radius), (2 * radius));
    loesche(circle);
  }
  
  public void zeichne(Shape shape) {
    this.graphic.draw(shape);
    this.canvas.repaint();
  }
  
  public void fuelle(Shape shape, int farbnr) {
    Color original = this.graphic.getColor();
    this.graphic.setColor(farbeZuColor(farbnr));
    this.graphic.fill(shape);
    this.canvas.repaint();
    this.graphic.setColor(original);
  }
  
  public void loesche(Shape shape) {
    Color original = this.graphic.getColor();
    this.graphic.setColor(this.backgroundColor);
    this.graphic.fill(shape);
    this.graphic.setColor(original);
    this.canvas.repaint();
  }
  
  public void zeichneRechteck(int xPos, int yPos, int breite, int hoehe) {
    this.graphic.drawRect(xPos, yPos, breite, hoehe);
    this.canvas.repaint();
  }
  
  public void fuelleRechteck(int xPos, int yPos, int breite, int hoehe, int farbnr) {
    Color original = this.graphic.getColor();
    this.graphic.setColor(farbeZuColor(farbnr));
    this.graphic.fillRect(xPos, yPos, breite, hoehe);
    this.canvas.repaint();
    this.graphic.setColor(original);
  }
  
  public void loescheRechteck(int xPos, int yPos, int breite, int hoehe) {
    loesche(new Rectangle(xPos, yPos, breite, hoehe));
  }
  
  private Polygon gibDreieck(int x1, int y1, int x2, int y2, int x3, int y3) {
    Polygon p = new Polygon();
    p.addPoint(x1, y1);
    p.addPoint(x2, y3);
    p.addPoint(x3, y3);
    return p;
  }
  
  public void zeichneDreieck(int x1, int y1, int x2, int y2, int x3, int y3) {
    this.graphic.drawPolygon(gibDreieck(x1, y1, x2, y2, x3, y3));
    this.canvas.repaint();
  }
  
  public void fuelleDreieck(int x1, int y1, int x2, int y2, int x3, int y3, int farbnr) {
    Color original = this.graphic.getColor();
    this.graphic.setColor(farbeZuColor(farbnr));
    this.graphic.fillPolygon(gibDreieck(x1, y1, x2, y2, x3, y3));
    this.canvas.repaint();
    this.graphic.setColor(original);
  }
  
  public void loescheDreieck(int x1, int y1, int x2, int y2, int x3, int y3) {
    loesche(gibDreieck(x1, y1, x2, y2, x3, y3));
  }
  
  public void loescheAlles() {
    Color original = this.graphic.getColor();
    this.graphic.setColor(this.backgroundColor);
    Dimension size = this.canvas.getSize();
    this.graphic.fill(new Rectangle(0, 0, size.width, size.height));
    this.graphic.setColor(original);
    this.canvas.repaint();
  }
  
  public void loescheRand(Shape shape) {
    Color original = this.graphic.getColor();
    this.graphic.setColor(this.backgroundColor);
    this.graphic.draw(shape);
    this.graphic.setColor(original);
    this.canvas.repaint();
  }
  
  public boolean zeichneBild(Image bild, int x, int y) {
    boolean result = this.graphic.drawImage(bild, x, y, (ImageObserver)null);
    this.canvas.repaint();
    return result;
  }
  
  public void zeichneText(String text, int x, int y) {
    this.graphic.drawString(text, x, y);
    this.canvas.repaint();
  }
  
  public void loescheText(String text, int x, int y) {
    Color original = this.graphic.getColor();
    this.graphic.setColor(this.backgroundColor);
    this.graphic.drawString(text, x, y);
    this.graphic.setColor(original);
    this.canvas.repaint();
  }
  
  public void zeichneStrecke(int x1, int y1, int x2, int y2) {
    this.graphic.drawLine(x1, y1, x2, y2);
    this.canvas.repaint();
  }
  
  public void setzeVordergrundFarbe(int neueFarbe) {
    this.graphic.setColor(farbeZuColor(neueFarbe));
  }
  
  private void setzeVordergrundFarbe(Color neueFarbe) {
    this.graphic.setColor(neueFarbe);
  }
  
  private Color farbeZuColor(int farbnr) {
    switch (farbnr) {
      case 0:
        return Color.black;
      case 1:
        return Color.blue;
      case 2:
        return Color.green;
      case 3:
        return Color.cyan;
      case 4:
        return Color.red;
      case 5:
        return Color.magenta;
      case 6:
        return Color.yellow;
      case 7:
        return Color.gray;
      case 8:
        return Color.white;
    } 
    return this.graphic.getColor();
  }
  
  private String colorZuFarbe(Color color) {
    if (color == Color.white)
      return "weiss"; 
    if (color == Color.black)
      return "schwarz"; 
    if (color == Color.red)
      return "rot"; 
    if (color == Color.green)
      return "gruen"; 
    if (color == Color.blue)
      return "blau"; 
    if (color == Color.yellow)
      return "gelb"; 
    if (color == Color.magenta)
      return "magenta"; 
    if (color == Color.cyan)
      return "cyan"; 
    if (color == Color.gray)
      return "gruen"; 
    return "";
  }
  
  public String gibVordergrundFarbe() {
    return colorZuFarbe(this.graphic.getColor());
  }
  
  public void setzeZeichensatz(Font neuerZeichensatz) {
    this.graphic.setFont(neuerZeichensatz);
  }
  
  public Font gibZeichensatz() {
    return this.graphic.getFont();
  }
  
  public void setzeMasse(int breite, int hoehe) {
    this.canvas.setPreferredSize(new Dimension(breite, hoehe));
    Image oldImage = this.canvasImage;
    this.canvasImage = this.canvas.createImage(breite, hoehe);
    this.graphic = (Graphics2D)this.canvasImage.getGraphics();
    this.graphic.drawImage(oldImage, 0, 0, (ImageObserver)null);
    this.frame.pack();
  }
  
  public Dimension gibMasse() {
    return this.canvas.getSize();
  }
  
  public void warte(int zeit) {
    try {
      Thread.sleep(zeit);
    } catch (InterruptedException interruptedException) {}
  }
  
  public void komponenteHinzufuegen(JComponent element, String position) {
    if (position == "rechts") {
      this.steuerungOst.add(element);
    } else if (position == "unten") {
      this.steuerungSued.add(element);
    } 
    this.frame.pack();
  }
  
  public void setzeTitel(String titelNeu) {
    this.frame.setTitle(titelNeu);
  }
  
  private class CanvasPane extends JPanel {
    private static final long serialVersionUID = 20060330L;
    
    private CanvasPane() {}
    
    public void paint(Graphics g) {
      g.drawImage(ZEICHENFENSTER.this.canvasImage, 0, 0, null);
    }
  }
}
