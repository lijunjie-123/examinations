package org.yfcloud.examination.system.test.client.model;

/**
 * Created by wangxy on 20/5/16.
 */
public class ClientFile {
    private static final long serialVersionUID = 1L;
    private String id;
    private String path;		// 附件路径
    private String clientId;		// 客户id
    private String name;
    private Client clientInfo ; // 客户信息

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
