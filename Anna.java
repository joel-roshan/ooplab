import java.io.*;
import java.util.StringTokenizer;

class Anna {
    public static void main(String[] args) {
        try {
            BufferedReader reader1 = new BufferedReader(new FileReader("first.csv"));
            BufferedReader reader2 = new BufferedReader(new FileReader("second.csv"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("third.csv"));
            String line1;
            String line2;
            String[] s1 = new String[20];
            String[] s2 = new String[20];
            while ((line1 = reader1.readLine()) != null) {
                line2 = reader2.readLine();
                if (line2 != null) {
                    StringTokenizer tokenizer1 = new StringTokenizer(line1, ",");
                    StringTokenizer tokenizer2 = new StringTokenizer(line2, ",");
                    int i = 0;
                    while (tokenizer1.hasMoreTokens() && tokenizer2.hasMoreTokens()) {
                        s1[i] = tokenizer1.nextToken();
                        s2[i] = tokenizer2.nextToken();
                        i++;
                    }
                    // Your code here to process s1 and s2 arrays
                    // and write the result to the third.csv file using the writer
                }
            }
            reader1.close();
            reader2.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    