import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/8 0008.
 */
public class Test1 {


    public static void main(String[] args) {

        Map map = new HashMap();
        map.put("tiame","2018-11-02");
        map.put("opertameManager","Á¹·ç");
        JSONObject json = JSONObject.fromObject(map);
        System.out.println(json);
        StringBuffer sb = new StringBuffer();
        sb.append((String) map.get("tiame"));
        sb.append(" ");
        sb.append((String) map.get("opertameManager"));
        System.out.println(sb.toString());

        String a = "m1";
        System.out.println(a.substring(0,1));



/*
        List<String> list  = new ArrayList<>();
        list.add("123");
        list.add("456");
        list.add("hao");
        for(int i = 0;i<list.size();i++){
            System.out.println(list.get(i));
        }*/
    }
}