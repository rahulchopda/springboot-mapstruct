package com.rahul.mapstruct.dto.mapper;

import java.util.List;

public interface EntityMapper<D, E> {
    
    D toDataObject(E entity);
    
    E toEntity(D data);
    
    List<D> toDataObject(List<E> entityList);
    
    List<E> toEntity(List<D> dataList);
    
}
