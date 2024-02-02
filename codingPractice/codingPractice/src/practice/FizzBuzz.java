package practice;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FizzBuzz {

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 1; i <= 100; i++) {
            bw.write(i+": ");
            if(i % 3 != 0 && i % 5 != 0) {
                bw.write(String.valueOf(i));
            } else {
                if(i % 3 == 0) bw.write("Fizz");

                if(i % 5 == 0) bw.write("Buzz");
            }
            bw.flush();
            bw.newLine();
        }
    }
}
