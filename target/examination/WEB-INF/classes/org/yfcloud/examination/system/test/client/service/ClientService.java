package org.yfcloud.examination.system.test.client.service;

import org.yfcloud.examination.system.test.client.model.Client;
import org.yfcloud.examination.system.test.client.model.ClientFile;

import java.util.List;

/**
 * Created by wangxy on 20/5/16.
 */
public interface ClientService {

    List<Client> getListClient(String id);

    List<ClientFile> getListClientFile(String s);
}
