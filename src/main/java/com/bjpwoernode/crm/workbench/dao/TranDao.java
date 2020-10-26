package com.bjpwoernode.crm.workbench.dao;

import com.bjpwoernode.crm.workbench.domain.Tran;

public interface TranDao {

    int sava(Tran t);

    Tran detail(String id);
}
