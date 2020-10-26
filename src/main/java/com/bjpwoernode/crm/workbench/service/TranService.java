package com.bjpwoernode.crm.workbench.service;

import com.bjpwoernode.crm.workbench.domain.Tran;

public interface TranService {

    boolean save(Tran t, String customerName);

    Tran detail(String id);
}
