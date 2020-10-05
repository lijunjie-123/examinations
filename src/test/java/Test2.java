/**
 * Created by Administrator on 2017/6/30 0030.
 */
public class Test2 {

    public int test(int a,int b){
        try {
            int c = 0;
                c = a/b;
                return c;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;

    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        System.out.println(test2.test(10,0));
    }
}
