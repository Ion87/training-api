package com.endava.trainingapi.service;

import com.endava.trainingapi.dto.CommunityDto;
import com.endava.trainingapi.exceptions.AppEntityNotFoundException;

import java.util.UUID;

public interface CommunityService {
    CommunityDto save(CommunityDto communityDto);
    void deleteById(UUID id)throws AppEntityNotFoundException;
}
