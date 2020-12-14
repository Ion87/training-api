package com.endava.trainingapi.service;

import com.endava.trainingapi.dto.CommunityDto;
import com.endava.trainingapi.exceptions.AppEntityNotFoundException;

import java.util.UUID;

import java.util.List;

public interface CommunityService {
    List<CommunityDto> getAll();
    CommunityDto save(CommunityDto communityDto);
    void deleteById(UUID id)throws AppEntityNotFoundException;
    public CommunityDto updateById(UUID id, CommunityDto dto);
}
