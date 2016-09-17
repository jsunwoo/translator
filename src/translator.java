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
        String id1;
//        String val2 = "";
        int numbefOfthings = 0;


        if (firstToken.equals("(def")) {
            fullSentence.append("long ");
            String nextToken = "";
            nextToken = st.nextToken(); // 첫번째 변수이름 읽어서
            id1 = nextToken;       // 저장하고
            fullSentence.append(nextToken);     // 출력
            fullSentence.append("[] = ");     // 출력

            while (st.hasMoreElements()) {
                nextToken = st.nextToken();     // 토큰읽고
                if (nextToken.startsWith("[")) {        // 바꿔준다음에
                    String replacedToken = nextToken.replace('[', '{');
                    fullSentence.append(replacedToken);     // 붙이기
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
        } else if (firstToken.equals("(reduce")) {
            String id2;
            String op;
            String initialVal;

            id2 = st.nextToken(); // id2 먼저 저장하고
            op = st.nextToken();    // 계산식 구분하고
            initialVal = st.nextToken();

            fullSentence.append("\tint _AD_i = 0;\n");
            fullSentence.append("\tint _AD_result = "+ initialVal + ";\n\n");
            fullSentence.append("\tfor(_AD_i = 0; _AD_i < _AD_size; _AD_i++ {\n");
            fullSentence.append("\t\t_AD_result "+ op + "= " + id2 + "[_AD_i];\n");
            fullSentence.append("\t}\n");
        }

    }
}