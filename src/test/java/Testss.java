import java.util.Arrays;

/**
 * Created by wangxy on 19/12/22.
 */
public class Testss {
    public static void main(String[] args) {
        Students[] studentes = new Students[]{
                new Students(2, "����", 90),
                new Students(3, "������", 100),
                new Students(1, "����", 87),
                new Students(4, "С��", 99)
        };

        Arrays.sort(studentes);
        for (Students student : studentes
                ) {
            System.out.println(student.toString());

        }
    }
}
