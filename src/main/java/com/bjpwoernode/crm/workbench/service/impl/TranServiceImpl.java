package com.bjpwoernode.crm.workbench.service.impl;

import com.bjpwoernode.crm.utils.DateTimeUtil;
import com.bjpwoernode.crm.utils.SqlSessionUtil;
import com.bjpwoernode.crm.utils.UUIDUtil;
import com.bjpwoernode.crm.workbench.dao.CustomerDao;
import com.bjpwoernode.crm.workbench.dao.TranDao;
import com.bjpwoernode.crm.workbench.dao.TranHistoryDao;
import com.bjpwoernode.crm.workbench.domain.Customer;
import com.bjpwoernode.crm.workbench.domain.Tran;
import com.bjpwoernode.crm.workbench.domain.TranHistory;
import com.bjpwoernode.crm.workbench.service.TranService;

import java.util.List;

public class TranServiceImpl implements TranService {
    private TranDao tranDao = SqlSessionUtil.getSqlSession().getMapper(TranDao.class);
    private TranHistoryDao tranHistoryDao = SqlSessionUtil.getSqlSession().getMapper(TranHistoryDao.class);
    private CustomerDao customerDao = SqlSessionUtil.getSqlSession().getMapper(CustomerDao.class);

    @Override
    public boolean save(Tran t, String customerName) {
        boolean flag = true;
        Customer cus = customerDao.getCustomerByName(customerName);
        if (cus == null){
            cus = new Customer();
            cus.setId(UUIDUtil.getUUID());
            cus.setName(customerName);
            cus.setCreateBy(t.getCreateBy());
            cus.setCreateTime(DateTimeUtil.getSysTime());
            cus.setContactSummary(t.getContactSummary());
            cus.setNextContactTime(t.getNextContactTime());
            cus.setOwner(t.getOwner());
            //添加客户
            int count1 = customerDao.save(cus);
            if (count1 != 1){
                flag = false;
            }
        }
        //将客户的Id封装到t
        t.setCustomerId(cus.getId());
        int count2 = tranDao.sava(t);
        if (count2 != 1){
            flag = false;
        }
        //添加交易历史
        TranHistory th = new TranHistory();
        th.setId(UUIDUtil.getUUID());
        th.setTranId(t.getId());
        th.setStage(t.getStage());
        th.setMoney(t.getMoney());
        th.setExpectedDate(t.getExpectedDate());
        th.setCreateTime(DateTimeUtil.getSysTime());
        th.setCreateBy(t.getCreateBy());
        int count3 = tranHistoryDao.save(th);
        if (count3 != 1){
            flag = false;
        }


        return flag;
    }

    @Override
    public Tran detail(String id) {
        Tran t = tranDao.detail(id);

        return t;
    }

    @Override
    public List<TranHistory> getHistoryListByTranId(String tranId) {
        List<TranHistory> thList = tranHistoryDao.getHistoryListByTranId(tranId);
        return thList;
    }
}
