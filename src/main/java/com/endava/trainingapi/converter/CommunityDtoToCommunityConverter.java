package com.endava.trainingapi.converter;

import com.endava.trainingapi.dto.CommunityDto;
import com.endava.trainingapi.model.Community;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CommunityDtoToCommunityConverter implements Converter<CommunityDto, Community> {

    @Override
    public Community convert(CommunityDto communityDto) {
        return Community.builder()
                .name(communityDto.getName())
                .build();
    }
}
