package com.pnguyen.core.utils;

import com.pnguyen.core.dto.ListenGuidelineDTO;
import com.pnguyen.core.persistence.entity.ListenGuidelineEntity;

public class ListenGuidelineBeanUtil {
    public static ListenGuidelineDTO entity2Dto(ListenGuidelineEntity entity){
        ListenGuidelineDTO dto = new ListenGuidelineDTO();
        dto.setContent(entity.getContent());
        dto.setTitle(entity.getTitle());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setImage(entity.getImage());
        dto.setListenGuidelineId(entity.getListenGuidelineId());
        dto.setModifiedDate(entity.getModifiedDate());
        return dto;
    }

    public static ListenGuidelineEntity dto2Entity(ListenGuidelineDTO dto){
        ListenGuidelineEntity entity = new ListenGuidelineEntity();
        entity.setContent(dto.getContent());
        entity.setTitle(dto.getTitle());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setImage(dto.getImage());
        entity.setListenGuidelineId(dto.getListenGuidelineId());
        entity.setModifiedDate(dto.getModifiedDate());
        return entity;
    }
}
