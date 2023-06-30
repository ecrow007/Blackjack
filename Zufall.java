import java.util.Random;

/**
 * Klasse Zufall für den Startwert und die nächste Karte.
 * 
 * @author (Elias und Emil) 
 * @version (1)
 */
public class Zufall
{
      
    public int startwert() {
        Random random = new Random();
        int min = 1;
        int max = 5;

        int number = random.nextInt(max - min + 1) + min;
        return number;
    }
    
    public int nächsteKarte() {
        Random random = new Random();
        int min = 1;
        int max = 11;

        int number = random.nextInt(max - min + 1) + min;
        return number;
    }
}
