package com.bjpwoernode.crm.workbench.dao;


import com.bjpwoernode.crm.workbench.domain.Clue;

import java.util.List;
import java.util.Map;

public interface ClueDao {


    int save(Clue c);

    Clue detail(String id);

    Clue getById(String clueId);

    int delete(String clueId);

    int getTotalByCondition(Map<String, Object> map);

    List<Clue> getClueByCondition(Map<String, Object> map);

    int deletes(String[] ids);
}
