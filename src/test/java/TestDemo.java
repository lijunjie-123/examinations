import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/7 0007.
 */
public class TestDemo {

    public static void main(String[] args) {
        String str = "健康好好很多";

        List<String> data = new ArrayList<String>();

        for (int i = 0; i < str.length(); i++) {
            String s = str.substring(i, i + 1);
            if (!data.contains(s)) {
                data.add(s);
            }
        }

        String result = "";
        for (String s : data) {
            result += s;
        }
        System.out.println(result);
    }
}