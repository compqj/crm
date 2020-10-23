package com.bjpwoernode.workbench.test;

import com.bjpwoernode.crm.utils.ServiceFactory;
import com.bjpwoernode.crm.utils.SqlSessionUtil;
import com.bjpwoernode.crm.workbench.dao.ClueDao;
import com.bjpwoernode.crm.workbench.domain.Clue;
import com.bjpwoernode.crm.workbench.service.ClueService;
import com.bjpwoernode.crm.workbench.service.impl.ClueServiceImpl;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ClueTest {
    @Test
    public void testClueGetTotalByCondition(){
        ClueDao clueDao = SqlSessionUtil.getSqlSession().getMapper(ClueDao.class);
        Map<String,Object> map = new HashMap<String, Object>();

        int total = clueDao.getTotalByCondition(map);
        System.out.println("======="+ total);
    }
}
