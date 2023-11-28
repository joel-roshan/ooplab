import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IntegerSumCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Enter a line of integers separated by spaces:");
        String inputLine = reader.readLine();

        StringTokenizer tokenizer = new StringTokenizer(inputLine);

        int sum = 0;
        System.out.println("Individual Integers:");
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            int number = Integer.parseInt(token);
            System.out.println(number);
            sum += number;
        }

        System.out.println("Sum of Integers: " + sum);

        reader.close();
    }
}
