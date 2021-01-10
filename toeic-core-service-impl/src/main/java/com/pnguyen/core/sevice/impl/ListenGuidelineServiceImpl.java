package com.pnguyen.core.sevice.impl;

import com.pnguyen.core.DAO.ListenGuidelineDAO;
import com.pnguyen.core.DAOImpl.ListenGuidelineDAOImpl;
import com.pnguyen.core.dto.ListenGuidelineDTO;
import com.pnguyen.core.persistence.entity.ListenGuidelineEntity;
import com.pnguyen.core.service.ListenGuidelineService;
import com.pnguyen.core.utils.ListenGuidelineBeanUtil;

import java.util.ArrayList;
import java.util.List;

public class ListenGuidelineServiceImpl implements ListenGuidelineService {
    private ListenGuidelineDAO listenGuidelineDAO = new ListenGuidelineDAOImpl();
    /*@Override
    public Object[] findListenGuidelineByProperties(String property, Object value, String sortExpression, String sortDirection, Integer offset, Integer limit) {
    List<ListenGuidelineDTO> result = new ArrayList<ListenGuidelineDTO>();
    Object[] objects = listenGuidelineDAO.findByProperty(property, value, sortExpression, sortDirection, offset, limit);
    for (ListenGuidelineEntity item: (List<ListenGuidelineEntity>) objects[1]){
        ListenGuidelineDTO dto = ListenGuidelineBeanUtil.entity2Dto(item);
        result.add(dto);
    }
    objects[1] = result;
    return objects;
    }*/
}
