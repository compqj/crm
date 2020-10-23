package com.bjpwoernode.crm.workbench.service;

import com.bjpwoernode.crm.vo.PaginationVo;
import com.bjpwoernode.crm.workbench.domain.Clue;
import com.bjpwoernode.crm.workbench.domain.ClueRemark;
import com.bjpwoernode.crm.workbench.domain.Tran;

import java.util.List;
import java.util.Map;

public interface ClueService {
    boolean save(Clue c);

    Clue detail(String id);

    boolean unbund(String id);

    boolean bund(String cid, String[] aids);


    boolean convert(String clueId, Tran t, String createBy);

    PaginationVo<Clue> pageList(Map<String, Object> map);

    boolean delete(String[] ids);

    List<ClueRemark> getRemarkListByAid(String clueId);
}
