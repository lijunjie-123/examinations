package org.yfcloud.examination.system.test.client.service.impl;

import org.springframework.stereotype.Service;
import org.yfcloud.examination.system.test.client.dao.ClientMapper;
import org.yfcloud.examination.system.test.client.model.Client;
import org.yfcloud.examination.system.test.client.model.ClientFile;
import org.yfcloud.examination.system.test.client.service.ClientService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangxy on 20/5/16.
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Resource
    ClientMapper clientMapper;

    @Override
    public List<Client> getListClient(String id) {

        return clientMapper.getListClient(id);
    }

    @Override
    public List<ClientFile> getListClientFile(String id) {

        return clientMapper.getListClientFile(id);

    }
}
