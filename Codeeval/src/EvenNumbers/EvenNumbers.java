package EvenNumbers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ph on 29.05.2015.
 */
public class EvenNumbers {

    public static void main(String[] args) throws IOException {

//        File file = new File(args[0]);
        File file = new File("./src/EvenNumbers/test_cases.txt");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;

        while ((line = buffer.readLine()) != null) {

            line = line.trim();
            int number = Integer.parseInt(line);
            System.out.println((number & 1) == 1 ? 0 : 1);
        }
    }
}
