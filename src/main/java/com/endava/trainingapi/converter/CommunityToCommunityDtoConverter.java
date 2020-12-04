package com.endava.trainingapi.converter;

import com.endava.trainingapi.dto.CommunityDto;
import com.endava.trainingapi.model.Community;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CommunityToCommunityDtoConverter implements Converter<Community, CommunityDto> {

    @Override
    public CommunityDto convert(Community community) {
        return CommunityDto.builder()
                .id(community.getId())
                .name(community.getName())
                .build();
    }
}