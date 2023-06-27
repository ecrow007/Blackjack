import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Beschreiben Sie hier die Klasse BlackjackOverlay.
 * 
 * @author (Elias und Emil) 
 * @version (26.06.2023)
 */
public class BlackjackOverlay
{
    	private JFrame frame;
	private JButton button = new JButton("starten");
	JTextField spieler1box = new JTextField(1); // Hier muss der Name eingegeben werden für Spieler 1
	JTextField spieler2box = new JTextField(1); // Hier muss der Name eingegeben werden für Spieler 2
	JLabel spieler1Name = new JLabel("NameLinks");
	JLabel spieler2Name = new JLabel("NameRechts");
	JLabel kartenwertspieler1 = new JLabel("Kartenwert: 0");
	JLabel kartenwertspieler2 = new JLabel("Kartenwert: 0");
	JPanel panel11 = new JPanel(); // immer 90 Pixel weiter nach rechts
	JPanel panel12 = new JPanel(); // immer 90 Pixel weiter nach rechts
	JPanel panel13 = new JPanel(); // immer 90 Pixel weiter nach rechts
	JPanel panel14 = new JPanel(); // immer 90 Pixel weiter nach rechts
	JPanel panel15 = new JPanel(); // immer 90 Pixel weiter nach rechts
	JPanel panel16 = new JPanel();
	JPanel panel17 = new JPanel();
	JPanel panel18 = new JPanel();
	JPanel panel19 = new JPanel();
	JPanel panel110 = new JPanel();
	JPanel panel111= new JPanel();
	JPanel panel112 = new JPanel();
	JPanel panel113 = new JPanel();
	JPanel panel114 = new JPanel();
	JPanel panel115 = new JPanel();
	JLabel text11 = new JLabel("99");
	JLabel text12 = new JLabel("99");
	JLabel text13 = new JLabel("99");
	JLabel text14 = new JLabel("99");
	JLabel text15 = new JLabel("99");
	JLabel text16 = new JLabel("99");
	JLabel text17 = new JLabel("99");
	JLabel text18 = new JLabel("99");
	JLabel text19 = new JLabel("99");
	JLabel text110 = new JLabel("99");
	JLabel text111 = new JLabel("99");
	JLabel text112 = new JLabel("99");
	JLabel text113 = new JLabel("99");
	JLabel text114 = new JLabel("99");
	JLabel text115 = new JLabel("99");
	int[] nummernSpieler1 = new int[15];
	int[] nummernSpieler2 = new int[15];
	boolean spieler1Aktiv = true; // wenn true, dann ist Spieler 1 dran
	boolean spieler2Aktiv = false; // wenn true, dann ist Spieler 2 dran
	boolean spieler1Über21 = false;
	JPanel panel11_1 = new JPanel();
	JPanel panel12_1 = new JPanel();
	JPanel panel13_1 = new JPanel();
	JPanel panel14_1 = new JPanel();
	JPanel panel15_1 = new JPanel();
	JPanel panel16_1 = new JPanel();
	JPanel panel17_1 = new JPanel();
	JPanel panel18_1 = new JPanel();
	JPanel panel19_1 = new JPanel();
	JPanel panel110_1 = new JPanel();
	JPanel panel111_1 = new JPanel();
	JPanel panel112_1 = new JPanel();
	JPanel panel113_1 = new JPanel();
	JPanel panel114_1 = new JPanel();
	JPanel panel115_1 = new JPanel();

	private final JLabel text11_1 = new JLabel("99");
	private final JLabel text12_1 = new JLabel("99");
	private final JLabel text13_1 = new JLabel("99");
	private final JLabel text14_1 = new JLabel("99");
	private final JLabel text15_1 = new JLabel("99");
	private final JLabel text16_1 = new JLabel("99");
	private final JLabel text17_1 = new JLabel("99");
	private final JLabel text18_1 = new JLabel("99");
	private final JLabel text19_1 = new JLabel("99");
	private final JLabel text110_1 = new JLabel("99");
	private final JLabel text111_1 = new JLabel("99");
	private final JLabel text112_1 = new JLabel("99");
	private final JLabel text113_1 = new JLabel("99");
	private final JLabel text114_1 = new JLabel("99");
	private final JLabel text116_1 = new JLabel("99");
	
	JLabel spieler1highscore = new JLabel("0");
	JLabel spieler2highscore = new JLabel("0");

	
	// Hier gefunden: http://www.java2s.com/Tutorial/Java/0240__Swing/LimitJTextFieldinputtoamaximumlength.htm
	// Damit kann die Länge für den Namen eingestellt werden.
	class JTextFieldLimit extends PlainDocument {
		  private int limit;
		  JTextFieldLimit(int limit) {
		    super();
		    this.limit = limit;
		  }

		  JTextFieldLimit(int limit, boolean upper) {
		    super();
		    this.limit = limit;
		  }

		  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		    if (str == null)
		      return;

		    if ((getLength() + str.length()) <= limit) {
		      super.insertString(offset, str, attr);
		    }
		  }
		}
	
	public JFrame holeFrame() {
		return this.frame;
	}
	
	public BlackjackOverlay() {
		erstelleOverlay();
	}
	
	// Overlay erstellen und alle Elemente verbinden.
	public void erstelleOverlay() {
		// Hier rauskopiert: https://www.tutorialspoint.com/how-to-set-location-of-jlabel-in-a-jframe-with-java
		frame = new JFrame();
		frame.setBounds(0, 0, 1569, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false); //https://stackoverflow.com/questions/18031704/jframe-how-to-disable-window-resizing#:~:text=Simply%20write%20one%20line%20in,impossible%20to%20resize%20the%20frame.
	    frame.getContentPane();
			    
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	    panel.setBackground(new Color(56, 87, 35)); // Farben sind immer rot grün blau
	    frame.getContentPane().add(panel);

	    if (2 == 1) System.exit(0);
	    
		JLabel uberschrift = new JLabel("Blackjack");
		uberschrift.setFont(new Font("Serif", Font.BOLD, 90));
		uberschrift.setForeground(new Color(197, 90, 17)); // orange Farbe
		Dimension grosseBlackjack = uberschrift.getPreferredSize();
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.addMouseListener(new CustommouseListener());
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_1_1.setBounds(743, 283, 119, 172);
		panel.add(panel_1_1);
		uberschrift.setBounds(545, 11, grosseBlackjack.width + 30, grosseBlackjack.height);
		panel.add(uberschrift);
	    
		JLabel spieler1 = new JLabel("Spieler 1");
		spieler1.setFont(new Font("Serif", Font.BOLD, 40)); // Bold heißt dicke Schrift
		spieler1.setForeground(new Color(255, 192, 0));
		Dimension grosse = spieler1.getPreferredSize();
		spieler1.setBounds(250, 100, grosse.width, grosse.height); // damit wird die x position gesetzt, dann y, dann breite und Höhe
		panel.add(spieler1);

		JLabel spieler2 = new JLabel("Spieler 2");
		spieler2.setFont(new Font("Serif", Font.BOLD, 40));
		spieler2.setForeground(new Color(255, 192, 0));
		Dimension grosse2 = spieler2.getPreferredSize();
		spieler2.setBounds(1050, 100, grosse2.width, grosse2.height);
		panel.add(spieler2);
		
		// Hier rauskopiert: https://www.tabnine.com/code/java/methods/javax.swing.JTextField
		spieler1box.addKeyListener(new CustomKeyListener());
		spieler1box.setFont(new Font("Serif", Font.BOLD, 40));
		spieler1box.setBounds(110, 170, 400, 50);
		spieler1box.setDocument(new JTextFieldLimit(12)); // nur 12 Buchstaben OK
		panel.add(spieler1box);

		spieler2box.addKeyListener(new CustomKeyListener());
		spieler2box.setFont(new Font("Serif", Font.BOLD, 40));
		spieler2box.setBounds(950, 170, 400, 50);
		spieler2box.setDocument(new JTextFieldLimit(12)); // nur 12 Buchstaben OK
		panel.add(spieler2box);
		
		JPanel links = new JPanel();
		links.setLayout(null);
		links.setBackground(new Color(68, 114, 196)); // Farben sind immer rot grün blau
		links.setBounds(110, 231, 472, 472);
		panel.add(links);
		
		panel11.setBackground(Color.LIGHT_GRAY);
		panel11.setBounds(10, 11, 74, 140);
		links.add(panel11);
		text11.setVisible(false);
		text11.setHorizontalAlignment(SwingConstants.CENTER);
		panel11.add(text11);
		text11.setBounds(new Rectangle(10, 70, 0, 0));
		text11.setFont(new Font("Serif", Font.BOLD, 40));
		
		panel12.setBackground(Color.LIGHT_GRAY);
		panel12.setBounds(100, 11, 74, 140);
		links.add(panel12);
		text12.setVisible(false);
		text12.setHorizontalAlignment(SwingConstants.CENTER);
		text12.setFont(new Font("Serif", Font.BOLD, 40));
		text12.setBounds(new Rectangle(10, 70, 0, 0));
		panel12.add(text12);
		
		panel13.setBackground(Color.LIGHT_GRAY);
		panel13.setBounds(190, 11, 74, 140);
		links.add(panel13);
		text13.setVisible(false);
		text13.setHorizontalAlignment(SwingConstants.CENTER);
		text13.setFont(new Font("Serif", Font.BOLD, 40));
		text13.setBounds(new Rectangle(10, 70, 0, 0));
		panel13.add(text13);
		
		panel14.setBackground(Color.LIGHT_GRAY);
		panel14.setBounds(280, 11, 74, 140);
		links.add(panel14);
		panel14.add(text14);
		text14.setVisible(false);
		text14.setHorizontalAlignment(SwingConstants.CENTER);
		text14.setFont(new Font("Serif", Font.BOLD, 40));
		text14.setBounds(new Rectangle(10, 70, 0, 0));
		
		panel110.setBackground(Color.LIGHT_GRAY);
		panel110.setBounds(370, 162, 74, 140);
		links.add(panel110);
		text110.setVisible(false);
		text110.setFont(new Font("Serif", Font.BOLD, 40));
		text110.setHorizontalAlignment(SwingConstants.CENTER);
		text110.setBounds(new Rectangle(10, 70, 0, 0));
		panel110.add(text110);
		
		panel19.setBackground(Color.LIGHT_GRAY);
		panel19.setBounds(280, 162, 74, 140);
		links.add(panel19);
		text19.setVisible(false);
		text19.setFont(new Font("Serif", Font.BOLD, 40));
		panel19.add(text19);
		
		panel18.setBackground(Color.LIGHT_GRAY);
		panel18.setBounds(190, 162, 74, 140);
		links.add(panel18);
		text18.setVisible(false);
		text18.setFont(new Font("Serif", Font.BOLD, 40));
		panel18.add(text18);
		
		panel17.setBackground(Color.LIGHT_GRAY);
		panel17.setBounds(100, 162, 74, 140);
		links.add(panel17);
		text17.setVisible(false);
		text17.setFont(new Font("Serif", Font.BOLD, 40));
		panel17.add(text17);
		
		panel16.setBackground(Color.LIGHT_GRAY);
		panel16.setBounds(10, 162, 74, 140);
		links.add(panel16);
		text16.setVisible(false);
		text16.setFont(new Font("Serif", Font.BOLD, 40));
		panel16.add(text16);
		
		panel111.setBackground(Color.LIGHT_GRAY);
		panel111.setBounds(10, 313, 74, 140);
		links.add(panel111);
		text111.setVisible(false);
		text111.setFont(new Font("Serif", Font.BOLD, 40));
		panel111.add(text111);
		
		panel112.setBackground(Color.LIGHT_GRAY);
		panel112.setBounds(100, 313, 74, 140);
		links.add(panel112);
		text112.setVisible(false);
		text112.setFont(new Font("Serif", Font.BOLD, 40));
		panel112.add(text112);
		
		panel113.setBackground(Color.LIGHT_GRAY);
		panel113.setBounds(190, 313, 74, 140);
		links.add(panel113);
		text113.setVisible(false);
		text113.setFont(new Font("Serif", Font.BOLD, 40));
		panel113.add(text113);
		
		panel114.setBackground(Color.LIGHT_GRAY);
		panel114.setBounds(280, 313, 74, 140);
		links.add(panel114);
		text114.setVisible(false);
		text114.setFont(new Font("Serif", Font.BOLD, 40));
		panel114.add(text114);
		
		panel115.setBackground(Color.LIGHT_GRAY);
		panel115.setBounds(370, 313, 74, 140);
		links.add(panel115);
		text115.setVisible(false);
		text115.setFont(new Font("Serif", Font.BOLD, 40));
		panel115.add(text115);
		
		panel15.setBackground(Color.LIGHT_GRAY);
		panel15.setBounds(370, 11, 74, 140);
		links.add(panel15);
		text15.setVisible(false);
		text15.setFont(new Font("Serif", Font.BOLD, 40));
		panel15.add(text15);
		
		JPanel rechts = new JPanel();
		rechts.setLayout(null);
		rechts.setBackground(new Color(68, 114, 196));
		rechts.setBounds(949, 231, 472, 472);
		panel.add(rechts);
		
		panel11_1.setBackground(Color.LIGHT_GRAY);
		panel11_1.setBounds(10, 11, 74, 140);
		rechts.add(panel11_1);
		text11_1.setVisible(false);
		text11_1.setFont(new Font("Serif", Font.BOLD, 40));
		panel11_1.add(text11_1);
		
		panel12_1.setBackground(Color.LIGHT_GRAY);
		panel12_1.setBounds(100, 11, 74, 140);
		rechts.add(panel12_1);
		text12_1.setVisible(false);
		text12_1.setFont(new Font("Serif", Font.BOLD, 40));
		panel12_1.add(text12_1);
		
		panel13_1.setBackground(Color.LIGHT_GRAY);
		panel13_1.setBounds(190, 11, 74, 140);
		rechts.add(panel13_1);
		text13_1.setVisible(false);
		text13_1.setFont(new Font("Serif", Font.BOLD, 40));
		panel13_1.add(text13_1);
		
		panel14_1.setBackground(Color.LIGHT_GRAY);
		panel14_1.setBounds(280, 11, 74, 140);
		rechts.add(panel14_1);
		text14_1.setVisible(false);
		text14_1.setFont(new Font("Serif", Font.BOLD, 40));
		panel14_1.add(text14_1);

		panel15_1.setBackground(Color.LIGHT_GRAY);
		panel15_1.setBounds(370, 11, 74, 140);
		rechts.add(panel15_1);
		text15_1.setVisible(false);
		text15_1.setFont(new Font("Serif", Font.BOLD, 40));
		panel15_1.add(text15_1);
		
		panel16_1.setBackground(Color.LIGHT_GRAY);
		panel16_1.setBounds(10, 162, 74, 140);
		rechts.add(panel16_1);
		text16_1.setVisible(false);
		text16_1.setFont(new Font("Serif", Font.BOLD, 40));
		panel16_1.add(text16_1);
		
		panel17_1.setBackground(Color.LIGHT_GRAY);
		panel17_1.setBounds(100, 162, 74, 140);
		rechts.add(panel17_1);
		text17_1.setVisible(false);
		text17_1.setFont(new Font("Serif", Font.BOLD, 40));
		panel17_1.add(text17_1);
		
		panel18_1.setBackground(Color.LIGHT_GRAY);
		panel18_1.setBounds(190, 162, 74, 140);
		rechts.add(panel18_1);
		text18_1.setVisible(false);
		text18_1.setFont(new Font("Serif", Font.BOLD, 40));
		panel18_1.add(text18_1);
		
		panel19_1.setBackground(Color.LIGHT_GRAY);
		panel19_1.setBounds(280, 162, 74, 140);
		rechts.add(panel19_1);
		text19_1.setVisible(false);
		text19_1.setFont(new Font("Serif", Font.BOLD, 40));
		panel19_1.add(text19_1);
		
		panel110_1.setBackground(Color.LIGHT_GRAY);
		panel110_1.setBounds(370, 162, 74, 140);
		rechts.add(panel110_1);
		text110_1.setVisible(false);
		text110_1.setFont(new Font("Serif", Font.BOLD, 40));
		panel110_1.add(text110_1);
		
		panel111_1.setBackground(Color.LIGHT_GRAY);
		panel111_1.setBounds(10, 313, 74, 140);
		rechts.add(panel111_1);
		text111_1.setVisible(false);
		text111_1.setFont(new Font("Serif", Font.BOLD, 40));
		panel111_1.add(text111_1);
		
		panel112_1.setBackground(Color.LIGHT_GRAY);
		panel112_1.setBounds(100, 313, 74, 140);
		rechts.add(panel112_1);
		text112_1.setVisible(false);
		text112_1.setFont(new Font("Serif", Font.BOLD, 40));
		panel112_1.add(text112_1);
		
		panel113_1.setBackground(Color.LIGHT_GRAY);
		panel113_1.setBounds(190, 313, 74, 140);
		rechts.add(panel113_1);
		text113_1.setVisible(false);
		text113_1.setFont(new Font("Serif", Font.BOLD, 40));
		panel113_1.add(text113_1);
		
		panel114_1.setBackground(Color.LIGHT_GRAY);
		panel114_1.setBounds(280, 313, 74, 140);
		rechts.add(panel114_1);
		text114_1.setVisible(false);
		text114_1.setFont(new Font("Serif", Font.BOLD, 40));
		panel114_1.add(text114_1);
		
		panel115_1.setBackground(Color.LIGHT_GRAY);
		panel115_1.setBounds(370, 313, 74, 140);
		rechts.add(panel115_1);
		text116_1.setVisible(false);
		text116_1.setFont(new Font("Serif", Font.BOLD, 40));
		panel115_1.add(text116_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new CustommouseListener());
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_1.setBounds(699, 328, 119, 172);
		panel.add(panel_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.addMouseListener(new CustommouseListener());
		panel_1_2.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_1_2.setBounds(655, 374, 119, 172);
		panel.add(panel_1_2);
		
		kartenwertspieler1.setForeground(new Color(255, 192, 0));
		kartenwertspieler1.setFont(new Font("Serif", Font.BOLD, 40));
		kartenwertspieler1.setBounds(110, 714, 472, 52);
		panel.add(kartenwertspieler1);
		
		kartenwertspieler2.setForeground(new Color(255, 192, 0));
		kartenwertspieler2.setFont(new Font("Serif", Font.BOLD, 40));
		kartenwertspieler2.setBounds(949, 714, 472, 52);
		panel.add(kartenwertspieler2);
		button.setBorder(null);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Hier wird immer entschieden, was beim Button passiert
				if (button.getText().equals("Zug beenden") && spieler1Aktiv == true) {
					
					// Jetzt wird gewechselt von 1 nach 2
					int summe = 0;
					for (int i : nummernSpieler1) {
						summe += i;
					}
					kartenwertspieler1.setText(String.valueOf(summe));
					panel11.setBackground(Color.WHITE);
					panel12.setBackground(Color.WHITE);
					panel13.setBackground(Color.WHITE);
					panel14.setBackground(Color.WHITE);
					panel15.setBackground(Color.WHITE);
					panel16.setBackground(Color.WHITE);
					panel17.setBackground(Color.WHITE);
					panel18.setBackground(Color.WHITE);
					panel19.setBackground(Color.WHITE);
					panel110.setBackground(Color.WHITE);
					panel111.setBackground(Color.WHITE);
					panel112.setBackground(Color.WHITE);
					panel113.setBackground(Color.WHITE);
					panel114.setBackground(Color.WHITE);
					panel115.setBackground(Color.WHITE);

					text11.setVisible(false);
					text12.setVisible(false);
					text13.setVisible(false);
					text14.setVisible(false);
					text15.setVisible(false);
					text16.setVisible(false);
					text17.setVisible(false);
					text18.setVisible(false);
					text19.setVisible(false);
					text110.setVisible(false);
					text111.setVisible(false);
					text112.setVisible(false);
					text113.setVisible(false);
					text114.setVisible(false);
					text115.setVisible(false);
					
					kartenwertspieler1.setVisible(false);
					
					spieler1Aktiv = false;
					spieler2Aktiv = true;
					
					panel11_1.setBackground(Color.WHITE);
					panel12_1.setBackground(Color.WHITE);
					Zufall zufall = new Zufall();
					nummernSpieler2[0] = zufall.startwert();
					text11_1.setText(String.valueOf(nummernSpieler2[0]));
					text11_1.setVisible(true);
					nummernSpieler2[1] = zufall.startwert();
					text12_1.setText(String.valueOf(nummernSpieler2[1]));
					text12_1.setVisible(true);
					summe = 0;
					for (int i : nummernSpieler2) {
						summe += i;
					}
					kartenwertspieler2.setText(String.valueOf(summe));
					
					
					return;
				}
				
				if (spieler1Aktiv == true) {
					spieler1box.setVisible(false);
					spieler1Name.setText(spieler1box.getText());
					spieler1Name.setVisible(true);
					spieler2box.setVisible(false);
					spieler2Name.setText(spieler2box.getText());
					spieler2Name.setVisible(true);
					panel11.setBackground(Color.WHITE);
					panel12.setBackground(Color.WHITE);
					
					Zufall zufall = new Zufall();
					nummernSpieler1[0] = zufall.startwert();
					text11.setText(String.valueOf(nummernSpieler1[0]));
					text11.setVisible(true);
					nummernSpieler1[1] = zufall.startwert();
					text12.setText(String.valueOf(nummernSpieler1[1]));
					text12.setVisible(true);
					int summe = 0;
					for (int i : nummernSpieler1) {
						summe += i;
					}
					kartenwertspieler1.setText(String.valueOf(summe));
					button.setText("Zug beenden");
					spieler1Aktiv = true;
				}
				
				// Auswertung
				if (button.getText().equals("Zug beenden") && spieler2Aktiv == true) {
					kartenwertspieler1.setVisible(true);
					if (spieler1Über21 == false) {
						if ((21 - Integer.valueOf(kartenwertspieler1.getText())) < (21 - Integer.valueOf(kartenwertspieler2.getText()))) {
							spieler1Name.setText(spieler1Name.getText() + " hat gewonnen");
							spieler1highscore.setText(String.valueOf(Integer.valueOf(spieler1highscore.getText()) + 1));
						}
					}
					if ((21 - Integer.valueOf(kartenwertspieler1.getText())) > (21 - Integer.valueOf(kartenwertspieler2.getText()))) {
						spieler2Name.setText(spieler2Name.getText() + " hat gewonnen");
						spieler2highscore.setText(String.valueOf(Integer.valueOf(spieler2highscore.getText()) + 1));
					}
					if (spieler1Über21 == true) {
						spieler2Name.setText(spieler2Name.getText() + " hat gewonnen");
						spieler2highscore.setText(String.valueOf(Integer.valueOf(spieler2highscore.getText()) + 1));

					}
					
					button.setText("starten");
					wiederStarten();

				}
			}
		});
		
		button.setEnabled(false);
		button.setFont(new Font("Serif", Font.BOLD, 32));
		button.setBackground(Color.RED);
		button.setForeground(Color.WHITE);
		button.setBounds(656, 642, 218, 92);
		panel.add(button);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(28, 777, 1504, 10);
		panel.add(panel_2);
		
		JLabel highscore = new JLabel("Highscore");
		highscore.setForeground(new Color(255, 192, 0));
		highscore.setFont(new Font("Serif", Font.BOLD, 40));
		highscore.setBounds(668, 839, 194, 52);
		panel.add(highscore);
		
		spieler1highscore.setForeground(new Color(255, 192, 0));
		spieler1highscore.setFont(new Font("Serif", Font.BOLD, 40));
		spieler1highscore.setBounds(326, 839, 150, 52);
		panel.add(spieler1highscore);
		
		spieler2highscore.setForeground(new Color(255, 192, 0));
		spieler2highscore.setFont(new Font("Serif", Font.BOLD, 40));
		spieler2highscore.setBounds(1187, 839, 150, 52);
		panel.add(spieler2highscore);
		
		spieler1Name.setVisible(false);
		spieler1Name.setForeground(new Color(255, 192, 0));
		spieler1Name.setFont(new Font("Serif", Font.BOLD, 40));
		spieler1Name.setBounds(110, 170, 472, 52);
		panel.add(spieler1Name);
		
		spieler2Name.setVisible(false);
		spieler2Name.setForeground(new Color(255, 192, 0));
		spieler2Name.setFont(new Font("Serif", Font.BOLD, 40));
		spieler2Name.setBounds(950, 170, 471, 52);
		panel.add(spieler2Name);
	}
	
	class CustomKeyListener implements KeyListener{
	      public void keyTyped(KeyEvent e) {
	      }
	      public void keyPressed(KeyEvent e) {
	      }
		@Override
		public void keyReleased(KeyEvent e) {
	    	  if (spieler1box.getText().length() > 0 && spieler2box.getText().length() > 0) {
	    		  button.setEnabled(true);
				}
	    	  else {
	    		  button.setEnabled(false);
	    	  }						
		}
	}
	
	class CustommouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (button.getText().equals("starten")) {
				return;
			}
			if (button.getText().equals("Zug beenden")) {
				if (spieler1Aktiv == true) {
					int summe = 0;
					for (int i : nummernSpieler1) {
						summe += i;
					}
					Zufall zufall = new Zufall();
					int neueZufallszahl = zufall.nächsteKarte();
					if ((summe + neueZufallszahl) > 21) {
						panel11.setBackground(Color.WHITE);
						panel12.setBackground(Color.WHITE);
						panel13.setBackground(Color.WHITE);
						panel14.setBackground(Color.WHITE);
						panel15.setBackground(Color.WHITE);
						panel16.setBackground(Color.WHITE);
						panel17.setBackground(Color.WHITE);
						panel18.setBackground(Color.WHITE);
						panel19.setBackground(Color.WHITE);
						panel110.setBackground(Color.WHITE);
						panel111.setBackground(Color.WHITE);
						panel112.setBackground(Color.WHITE);
						panel113.setBackground(Color.WHITE);
						panel114.setBackground(Color.WHITE);
						panel115.setBackground(Color.WHITE);

						text11.setVisible(false);
						text12.setVisible(false);
						text13.setVisible(false);
						text14.setVisible(false);
						text15.setVisible(false);
						text16.setVisible(false);
						text17.setVisible(false);
						text18.setVisible(false);
						text19.setVisible(false);
						text110.setVisible(false);
						text111.setVisible(false);
						text112.setVisible(false);
						text113.setVisible(false);
						text114.setVisible(false);
						text115.setVisible(false);
						
						kartenwertspieler1.setVisible(false);
						spieler1Über21 = true;
						
						spieler1Aktiv = false;
						spieler2Aktiv = true;
						
						panel11_1.setBackground(Color.WHITE);
						panel12_1.setBackground(Color.WHITE);
						nummernSpieler2[0] = zufall.startwert();
						text11_1.setText(String.valueOf(nummernSpieler2[0]));
						text11_1.setVisible(true);
						nummernSpieler2[1] = zufall.startwert();
						text12_1.setText(String.valueOf(nummernSpieler2[1]));
						text12_1.setVisible(true);
						summe = 0;
						for (int i : nummernSpieler2) {
							summe += i;
						}
						kartenwertspieler2.setText(String.valueOf(summe));
						return;
					}
					switch (wievielGefullt(nummernSpieler1)) {
					case 2:
						panel13.setBackground(Color.WHITE);
						nummernSpieler1[2] = neueZufallszahl;
						text13.setText(String.valueOf(nummernSpieler1[2]));
						text13.setVisible(true);
						break;
					case 3:
						panel14.setBackground(Color.WHITE);
						nummernSpieler1[3] = neueZufallszahl;
						text14.setText(String.valueOf(nummernSpieler1[3]));
						text14.setVisible(true);
						break;
					case 4:
						panel15.setBackground(Color.WHITE);
						nummernSpieler1[4] = neueZufallszahl;
						text15.setText(String.valueOf(nummernSpieler1[4]));
						text15.setVisible(true);
						break;
					case 5:
						panel16.setBackground(Color.WHITE);
						nummernSpieler1[5] = neueZufallszahl;
						text16.setText(String.valueOf(nummernSpieler1[5]));
						text16.setVisible(true);
						break;
					case 6:
						panel17.setBackground(Color.WHITE);
						nummernSpieler1[6] = neueZufallszahl;
						text17.setText(String.valueOf(nummernSpieler1[6]));
						text17.setVisible(true);
						break;
					case 7:
						panel18.setBackground(Color.WHITE);
						nummernSpieler1[7] = neueZufallszahl;
						text18.setText(String.valueOf(nummernSpieler1[7]));
						text18.setVisible(true);
						break;
					case 8:
						panel19.setBackground(Color.WHITE);
						nummernSpieler1[8] = neueZufallszahl;
						text19.setText(String.valueOf(nummernSpieler1[8]));
						text19.setVisible(true);
						break;
					case 9:
						panel110.setBackground(Color.WHITE);
						nummernSpieler1[9] = neueZufallszahl;
						text110.setText(String.valueOf(nummernSpieler1[9]));
						text110.setVisible(true);
						break;
					case 10:
						panel111.setBackground(Color.WHITE);
						nummernSpieler1[10] = neueZufallszahl;
						text111.setText(String.valueOf(nummernSpieler1[10]));
						text111.setVisible(true);
						break;
					case 11:
						panel112.setBackground(Color.WHITE);
						nummernSpieler1[11] = neueZufallszahl;
						text112.setText(String.valueOf(nummernSpieler1[11]));
						text112.setVisible(true);
						break;
					case 12:
						panel113.setBackground(Color.WHITE);
						nummernSpieler1[12] = neueZufallszahl;
						text113.setText(String.valueOf(nummernSpieler1[12]));
						text113.setVisible(true);
						break;
					case 13:
						panel114.setBackground(Color.WHITE);
						nummernSpieler1[13] = neueZufallszahl;
						text114.setText(String.valueOf(nummernSpieler1[13]));
						text114.setVisible(true);
						break;
					case 14:
						panel115.setBackground(Color.WHITE);
						nummernSpieler1[14] = neueZufallszahl;
						text115.setText(String.valueOf(nummernSpieler1[14]));
						text115.setVisible(true);
						break;
						
					default:
						break;
					}
					
					summe = 0;
					for (int i : nummernSpieler1) {
						summe += i;
					}
					kartenwertspieler1.setText(String.valueOf(summe));
				}
				
				if (spieler2Aktiv == true) {
					kartenwertspieler2.setVisible(true);
					int summe = 0;
					for (int i : nummernSpieler2) {
						summe += i;
					}
					Zufall zufall = new Zufall();
					int neueZufallszahl = zufall.nächsteKarte();
					if ((summe + neueZufallszahl) > 21) {
						
						kartenwertspieler1.setVisible(true);
						
						spieler1Aktiv = false;
						spieler2Aktiv = true;
						
						kartenwertspieler1.setVisible(true);
						if (spieler1Über21 == false) {
							spieler1Name.setText(spieler1Name.getText() + " hat gewonnen");
							spieler1highscore.setText(String.valueOf(Integer.valueOf(spieler1highscore.getText()) + 1));
						}
						button.setText("starten");
						
						wiederStarten();

						
						return;
					}

					switch (wievielGefullt(nummernSpieler2)) {
					case 2:
						panel13_1.setBackground(Color.WHITE);
						nummernSpieler2[2] = neueZufallszahl;
						text13_1.setText(String.valueOf(nummernSpieler2[2]));
						text13_1.setVisible(true);
						break;
					case 3:
						panel14_1.setBackground(Color.WHITE);
						nummernSpieler2[3] = neueZufallszahl;
						text14_1.setText(String.valueOf(nummernSpieler2[3]));
						text14_1.setVisible(true);
						break;
					case 4:
						panel15_1.setBackground(Color.WHITE);
						nummernSpieler2[4] = neueZufallszahl;
						text15_1.setText(String.valueOf(nummernSpieler2[4]));
						text15_1.setVisible(true);
						break;
					case 5:
						panel16_1.setBackground(Color.WHITE);
						nummernSpieler2[5] = neueZufallszahl;
						text16_1.setText(String.valueOf(nummernSpieler2[5]));
						text16_1.setVisible(true);
						break;
					case 6:
						panel17_1.setBackground(Color.WHITE);
						nummernSpieler2[6] = neueZufallszahl;
						text17_1.setText(String.valueOf(nummernSpieler2[6]));
						text17_1.setVisible(true);
						break;
					case 7:
						panel18_1.setBackground(Color.WHITE);
						nummernSpieler2[7] = neueZufallszahl;
						text18_1.setText(String.valueOf(nummernSpieler2[7]));
						text18_1.setVisible(true);
						break;
					case 8:
						panel19_1.setBackground(Color.WHITE);
						nummernSpieler2[8] = neueZufallszahl;
						text19_1.setText(String.valueOf(nummernSpieler2[8]));
						text19_1.setVisible(true);
						break;
					case 9:
						panel110_1.setBackground(Color.WHITE);
						nummernSpieler2[9] = neueZufallszahl;
						text110_1.setText(String.valueOf(nummernSpieler2[9]));
						text110_1.setVisible(true);
						break;
					case 10:
						panel111_1.setBackground(Color.WHITE);
						nummernSpieler2[10] = neueZufallszahl;
						text111_1.setText(String.valueOf(nummernSpieler2[10]));
						text111_1.setVisible(true);
						break;
					case 11:
						panel112_1.setBackground(Color.WHITE);
						nummernSpieler2[11] = neueZufallszahl;
						text112_1.setText(String.valueOf(nummernSpieler2[11]));
						text112_1.setVisible(true);
						break;
					case 12:
						panel113_1.setBackground(Color.WHITE);
						nummernSpieler2[12] = neueZufallszahl;
						text113_1.setText(String.valueOf(nummernSpieler2[12]));
						text113_1.setVisible(true);
						break;
					case 13:
						panel114_1.setBackground(Color.WHITE);
						nummernSpieler2[13] = neueZufallszahl;
						text114_1.setText(String.valueOf(nummernSpieler2[13]));
						text114_1.setVisible(true);
						break;
					case 14:
						panel115_1.setBackground(Color.WHITE);
						nummernSpieler2[14] = neueZufallszahl;
						text116_1.setText(String.valueOf(nummernSpieler2[14]));
						text116_1.setVisible(true);
						break;
						
					default:
						break;
					}
					
					summe = 0;
					for (int i : nummernSpieler2) {
						summe += i;
					}
					kartenwertspieler2.setText(String.valueOf(summe));
				}
			}			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	}
	
	// schaut nach, wie oft schon gezogen worden ist.
	public int wievielGefullt(int[] nummernSpieler1) {
		int anzahl = 0;
		for (int i : nummernSpieler1) {
			if (i > 0) {
				anzahl = anzahl + 1;
			}
		}
		return anzahl;
	}
	
	public void wiederStarten() {
	
		spieler1Aktiv = true;
		spieler2Aktiv = false;
		spieler1Über21 = false;
		nummernSpieler1 = new int[15];
		nummernSpieler2 = new int[15];
		kartenwertspieler2.setVisible(false);
		panel11.setBackground(Color.LIGHT_GRAY);
		panel12.setBackground(Color.LIGHT_GRAY);
		panel13.setBackground(Color.LIGHT_GRAY);
		panel14.setBackground(Color.LIGHT_GRAY);
		panel15.setBackground(Color.LIGHT_GRAY);
		panel16.setBackground(Color.LIGHT_GRAY);
		panel17.setBackground(Color.LIGHT_GRAY);
		panel18.setBackground(Color.LIGHT_GRAY);
		panel19.setBackground(Color.LIGHT_GRAY);
		panel110.setBackground(Color.LIGHT_GRAY);
		panel111.setBackground(Color.LIGHT_GRAY);
		panel112.setBackground(Color.LIGHT_GRAY);
		panel113.setBackground(Color.LIGHT_GRAY);
		panel114.setBackground(Color.LIGHT_GRAY);
		panel115.setBackground(Color.LIGHT_GRAY);
		text11.setVisible(false);
		text12.setVisible(false);
		text13.setVisible(false);
		text14.setVisible(false);
		text15.setVisible(false);
		text16.setVisible(false);
		text17.setVisible(false);
		text18.setVisible(false);
		text19.setVisible(false);
		text110.setVisible(false);
		text111.setVisible(false);
		text112.setVisible(false);
		text113.setVisible(false);
		text114.setVisible(false);
		text115.setVisible(false);
		panel11_1.setBackground(Color.LIGHT_GRAY);
		panel12_1.setBackground(Color.LIGHT_GRAY);
		panel13_1.setBackground(Color.LIGHT_GRAY);
		panel14_1.setBackground(Color.LIGHT_GRAY);
		panel15_1.setBackground(Color.LIGHT_GRAY);
		panel16_1.setBackground(Color.LIGHT_GRAY);
		panel17_1.setBackground(Color.LIGHT_GRAY);
		panel18_1.setBackground(Color.LIGHT_GRAY);
		panel19_1.setBackground(Color.LIGHT_GRAY);
		panel110_1.setBackground(Color.LIGHT_GRAY);
		panel111_1.setBackground(Color.LIGHT_GRAY);
		panel112_1.setBackground(Color.LIGHT_GRAY);
		panel113_1.setBackground(Color.LIGHT_GRAY);
		panel114_1.setBackground(Color.LIGHT_GRAY);
		panel115_1.setBackground(Color.LIGHT_GRAY);
		text11_1.setVisible(false);
		text12_1.setVisible(false);
		text13_1.setVisible(false);
		text14_1.setVisible(false);
		text15_1.setVisible(false);
		text16_1.setVisible(false);
		text17_1.setVisible(false);
		text18_1.setVisible(false);
		text19_1.setVisible(false);
		text110_1.setVisible(false);
		text111_1.setVisible(false);
		text112_1.setVisible(false);
		text113_1.setVisible(false);
		text114_1.setVisible(false);
		text116_1.setVisible(false);
	}

}