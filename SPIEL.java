import java.util.Random;

public class SPIEL 
{
    private static int summe;
    public void startwert() {
        Random random = new Random();
        int min = 1;
        int max = 5;

        int number1 = random.nextInt(max - min + 1) + min;
        int number2 = random.nextInt(max - min + 1) + min;
        int startValue = number1 + number2;
        
        System.out.println("ihr Startwert beträgt: " + startValue);
        
        summe = startValue;
    }
    public void karteZiehen()
    {
    Random zufall = new Random();
    int min = 1;
    int max = 11;
        
    int karte = zufall.nextInt(max - min + 1) + min;
        
    System.out.println("der Wert der gezogenen Karte liegt bei: " + karte);
    
    summe += karte;
    System.out.println("neue gesamt Summe: " + summe);
    if (summe > 21) {
            System.out.println("Die Summe ist größer als 21 ");
            System.out.println("SIE HABEN VERLOREN");
    }
    }
    private int highscore = 0;
    

    public void endTurn() {
        if (summe > highscore) {
            highscore = summe;
            System.out.println("Neuer Highscore: " + highscore);
        } else {
            System.out.println("Dein Score: " + summe);
            System.out.println("Aktueller Highscore: " + highscore);
        }
    }
}
