/**
 * Created by wangxy on 19/5/19.
 */
public class Reflexs {

    @org.junit.Test
    public void testReflex(){
        //三种方式获取反射对象

        //第一种
        /*Person person = new Person("123",12,12.1);
        try {
            System.out.println(person.getClass().getDeclaredField("name"));
            person.getClass().getDeclaredField("name");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
*/

        //第二种
    /*
        Class c = null;
        c= Person.class;

        Field[] fields = c.getDeclaredFields();
        for (Field f : fields){
            System.out.println(f);
        }*/

    //第三种
        /*org.yfcloud.examination.Person person = new Person("123",234);
        Students students = new Students("1899",55);

        Class clazz = null;
        //clazz = Class.forName("org.yfcloud.examination.Person");
        //System.out.println(clazz.getName());
        clazz = Person.class.getSuperclass();
        //Field name = clazz.getDeclaredField("name");
        Field[] felds = clazz.getDeclaredFields();
        for (int a = 0;a < felds.length;a++){

            felds[a].setAccessible(true);
            Class<?> type = felds[a].getType();
            *//*if("class java.lang.String".equals(type.toString())){
                try {
                    felds[a].set(person,"123");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }else if("int".equals(type.toString())){
                try {
                    felds[a].set(person,15);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }else {
                try {
                    felds[a].set(person,172.25);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }*//*
            if("class java.lang.String".equals(type.toString())) {
                try {
                    felds[a].set(students,"王显跃");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }else {
                try {
                    felds[a].set(students,178000);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
        System.out.println(students.toString());*/


    }

}
