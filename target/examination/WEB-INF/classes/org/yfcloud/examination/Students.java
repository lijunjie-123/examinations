package org.yfcloud.examination;

/**
 * Created by wangxy on 19/5/19.
 */
public class Students  {

    private String weight;

    private int sex;

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Students(String weight, int sex) {
        this.weight = weight;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Students{" +
                "weight='" + weight + '\'' +
                ", sex=" + sex +
                '}';
    }
}
