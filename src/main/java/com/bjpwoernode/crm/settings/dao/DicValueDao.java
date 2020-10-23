package com.bjpwoernode.crm.settings.dao;

import com.bjpwoernode.crm.settings.domain.DicValue;

import java.util.List;

public interface DicValueDao {
    List<DicValue> getListByCode(String code);
}
