import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangxy on 20/9/4.
 */
public class ExceptionTest {

    public static void main(String[] args) {
        Person p = new Person();
        List<String> list = new ArrayList<String>();
        list.add("123");
        list.add("333");
        list.add("6666");
        int failCount = 0;
        String voucherIds = "";

        for(String voucherId : list){
            try {
                int a =  Integer.parseInt(p.getName());
            }catch (Exception e){
                failCount++;
                voucherIds+=voucherId + ",";
                continue;
            }

        }
        if(failCount > 0){
            System.out.println("ȯɾ��ʧ�ܵĸ�����" + failCount + "," + "ʧ�ܵ�ȯId�У�" + voucherIds.substring(0,voucherIds.length()-1));
        }
        System.out.println("ȯɾ���ɹ��ĸ�����" +  (list.size() - failCount));
    }
}
