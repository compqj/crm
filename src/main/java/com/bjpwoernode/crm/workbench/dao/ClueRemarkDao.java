package com.bjpwoernode.crm.workbench.dao;

import com.bjpwoernode.crm.workbench.domain.ClueRemark;

import java.util.List;

public interface ClueRemarkDao {

    List<ClueRemark> getListByClueId(String clueId);

    int delete(ClueRemark clueRemark);

    List<ClueRemark> getRemarkListByAid(String clueId);
}
