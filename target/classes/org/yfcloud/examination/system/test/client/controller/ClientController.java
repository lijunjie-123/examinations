package org.yfcloud.examination.system.test.client.controller;

import org.yfcloud.examination.system.test.client.model.Client;
import org.yfcloud.examination.system.test.client.service.ClientService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangxy on 20/5/16.
 */
public class ClientController {

    @Resource
    ClientService ClientServiceImpl;

    public void getClientById(){

        List<Client> clientList = ClientServiceImpl.getListClient("1");
    }
}
