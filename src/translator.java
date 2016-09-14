import java.util.StringTokenizer;

/**
 * Created by jinsu on 2016-09-14.
 */
public class translator {
    public static void main(String[] args) {
        String temp = "대한민국 미국 영국";

        StringTokenizer st = new StringTokenizer(temp," ");

        String token = "";
        while (st.hasMoreElements()) {

            token = st.nextToken();

            System.out.println(token);
        }
    }

}
