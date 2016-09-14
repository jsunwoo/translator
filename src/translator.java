import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

/**
 * Created by jinsu on 2016-09-14.
 */

public class translator {
    private static StringBuffer fullSentence = new StringBuffer("#include <stdio.h>\n" +
            "int main()\n{\n\t");

    public static void main(String[] args) {

        try {
            BufferedReader in;
            String readL;

            in = new BufferedReader(new FileReader("test.txt"));

            while ((readL = in.readLine()) != null) {
                System.out.println(readL);
                tokenCheck(readL);
            }
            System.out.println(fullSentence);

            in.close();
        } catch (Exception e) {
            System.out.println("Exception error");
        }
    }

    private static void tokenCheck(String readLine) {

        StringTokenizer st = new StringTokenizer(readLine, " ");
        String firstToken = st.nextToken();
        String val1 = "";
        String val2 = "";
        int numbefOfthings = 0;


        if (firstToken.equals("(def")) {
            fullSentence.append("long ");
            String nextToken = "";
            nextToken = st.nextToken(); // 첫번째 변수이름 읽어서
            val1 = nextToken;       // 저장하고
            fullSentence.append(nextToken);     // 출력
            fullSentence.append("[] = ");     // 출력

            while (st.hasMoreElements()) {
                nextToken = st.nextToken();
                if (nextToken.startsWith("[")) {
                    String replacedToken = nextToken.replace('[', '{');
                    fullSentence.append(replacedToken);
                } else if (nextToken.endsWith(")")) {
                    String replacedToken = nextToken.replace("])", "}");
                    fullSentence.append(replacedToken);
                } else {
                    fullSentence.append(nextToken);
                }
                numbefOfthings++;
            }
            fullSentence.append(";\n");
            fullSentence.append("\tint _AD_size = " + numbefOfthings + ";\n");
        }
    }
}