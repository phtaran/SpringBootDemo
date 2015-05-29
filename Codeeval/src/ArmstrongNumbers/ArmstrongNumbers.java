package ArmstrongNumbers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ph on 29.05.2015.
 */
public class ArmstrongNumbers {

    public static void main(String[] args) throws IOException {
//        File file = new File(args[0]);
        File file = new File("./src/ArmstrongNumbers/test_cases.txt");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            int sum = 0;
            for (char ch: line.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                sum += Math.pow(digit, line.length());
            }
            String result = sum == Integer.parseInt(line) ? "True": "False";
            System.out.println(result);
        }
    }
}
