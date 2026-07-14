package pja.edu.pl.s30855.tpo_10;

import java.util.Random;

public class IdGenerator {

    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static Random random = new Random();

    public static String generateId(){
        StringBuilder id = new StringBuilder(10);
        for(int i = 0; i < 10; i++){
            int index = random.nextInt(LETTERS.length());
            id.append(LETTERS.charAt(index));
        }
        return id.toString();
    }
}
