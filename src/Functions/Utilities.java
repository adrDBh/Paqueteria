package Functions;

import java.util.Random;

public class Utilities {

    public String Capitalize(String word) {
        return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }

    public String[] splitNames(String fullName) {
        return fullName.split(" ");
    }

    public String RandomFoilNumberGen() {
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while (sb.length() <= 22) {
            sb.append(Integer.toHexString(r.nextInt()));
        }
        return sb.toString().substring(0, 22).toUpperCase();
    }
}
