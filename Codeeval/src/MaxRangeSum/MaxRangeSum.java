package MaxRangeSum;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ph on 29.05.2015.
 */
public class MaxRangeSum {

    public static void main(String[] args) throws IOException {

//        File file = new File(args[0]);
        File file = new File("./src/MaxRangeSum/test_cases.txt");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;

        while ((line = buffer.readLine()) != null) {

            line = line.trim();
            String[] split = line.split(";");

            String[] strings = split[1].split(" ");
            int count = Integer.parseInt(split[0]);
            int localSum = 0;
            int maxSum = -1000 * 100;

            Pattern p = Pattern.compile("-?\\d+");
            Matcher m = p.matcher("There are more than -2 and less than 12 numbers here");

            for (int i = 0; i < strings.length; i++) {

                localSum += Integer.parseInt(strings[i]);

                if (i >= count) {
                    
                    localSum -= Integer.parseInt(strings[i - count]);
                    
                    if (localSum > maxSum) {
                        maxSum = localSum;
                    }
                }
            }

            if (strings.length <= count) {
                maxSum = localSum;
            }

            System.out.println(Math.max(maxSum, 0));
        }
    }
}
