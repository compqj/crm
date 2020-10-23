package com.bjpwoernode.crm.workbench.service.impl;

import com.bjpwoernode.crm.utils.SqlSessionUtil;
import com.bjpwoernode.crm.workbench.dao.TranDao;
import com.bjpwoernode.crm.workbench.dao.TranHistoryDao;
import com.bjpwoernode.crm.workbench.service.TranService;

public class TranServiceImpl implements TranService {
    private TranDao tranDao = SqlSessionUtil.getSqlSession().getMapper(TranDao.class);
    private TranHistoryDao tranHistoryDao = SqlSessionUtil.getSqlSession().getMapper(TranHistoryDao.class);

}
