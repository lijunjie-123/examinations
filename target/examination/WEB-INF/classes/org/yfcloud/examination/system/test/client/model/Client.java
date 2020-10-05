package org.yfcloud.examination.system.test.client.model;

import java.util.List;

/**
 * Created by wangxy on 20/5/16.
 */
public class Client {

    private static final long serialVersionUID = 1L;
    private String id;
    private String name;		// ����
    private int age;		// ����
    private List<ClientFile> clientFileList ; // �ͻ����µĸ��� list

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
