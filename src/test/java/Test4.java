import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangxy on 20/8/30.
 */
public class Test4 {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();

        Person person = new Person();
        Person person1 = new Person();

        person.setAge(1);
        person.setName("123");
        person.setHeight("6.5");
        person1.setAge(12);
        person1.setName("1231");
        person1.setHeight("61.5");
        personList.add(person);
        personList.add(person1);




        List<Person> personList2 = new ArrayList<Person>();
        Person p1 = new Person();
        for (Person p : personList){
            p1.setName(p.getName());
            p1.setAge(p.getAge());
            p1.setHeight(p.getHeight());
            personList2.add(p1);
        }
    }

}
