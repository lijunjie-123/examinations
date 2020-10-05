package org.yfcloud.examination.system.test.client.dao;

import org.yfcloud.examination.system.test.client.model.Client;
import org.yfcloud.examination.system.test.client.model.ClientFile;

import java.util.List;

/**
 * Created by wangxy on 20/5/16.
 */
public interface ClientMapper {
    int deleteByPrimaryKey(String id);

    int insert(Client record);

    int insertSelective(Client record);

    Client selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Client record);

    int updateByPrimaryKey(Client record);

    List<Client> getListClient(String id);

    List<ClientFile> getListClientFile(String id);
}
