import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

/**
 * Created by jinsu on 2016-09-14.
 */

public class translator {
    public static void main(String[] args) {
        try {
            BufferedReader in;
            StringTokenizer st;
            String readLine;

            in = new BufferedReader(new FileReader("test.txt"));

            while ((readLine = in.readLine()) != null) {
                System.out.println(readLine);
                StringTokenizer firstToken = new StringTokenizer(readLine, " ");
                tokenCheck(firstToken);
            }

            in.close();


            String token = "";
            while (st.hasMoreElements()) {

                token = st.nextToken();


                System.out.println(token.charAt(0));

            }
        } catch (Exception e) {
            System.out.println("Exception error");
        }
    }

    private static void tokenCheck(StringTokenizer firstToken) {
    }
}
