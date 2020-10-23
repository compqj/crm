package com.bjpwoernode.workbench.test;

import com.bjpwoernode.crm.utils.ServiceFactory;
import com.bjpwoernode.crm.utils.UUIDUtil;
import com.bjpwoernode.crm.workbench.domain.Activity;
import com.bjpwoernode.crm.workbench.service.ActivityService;
import com.bjpwoernode.crm.workbench.service.impl.ActivityServiceImpl;
import org.junit.Test;

public class ActivityTest {
    @Test
    public void testSave(){
        Activity a = new Activity();
        a.setId(UUIDUtil.getUUID());
        a.setName("宣传推广会");
        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());
        boolean flag = as.save(a);
        System.out.println(flag);
    }

}
