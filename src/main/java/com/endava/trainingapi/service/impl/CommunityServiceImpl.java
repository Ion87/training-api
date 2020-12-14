package com.endava.trainingapi.service.impl;

import com.endava.trainingapi.converter.CommunityDtoToCommunityConverter;
import com.endava.trainingapi.converter.CommunityToCommunityDtoConverter;
import com.endava.trainingapi.dto.CommunityDto;
import com.endava.trainingapi.exceptions.AppEntityNotFoundException;
import com.endava.trainingapi.model.Community;
import com.endava.trainingapi.repository.CommunityRepository;
import com.endava.trainingapi.service.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
import java.util.UUID;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {

    private final CommunityRepository repository;
    private final CommunityDtoToCommunityConverter communityDtoToCommunityConverter;
    private final CommunityToCommunityDtoConverter communityToCommunityDtoConverter;

    @Override
    public List<CommunityDto> getAll() {
        return repository.findAll()
            .stream()
            .map(communityToCommunityDtoConverter::convert)
            .collect(Collectors.toList());
    }

    @Override
    public CommunityDto save(CommunityDto communityDto) {
        Community communityToSave = communityDtoToCommunityConverter.convert(communityDto);
        Community savedCommunity = repository.save(communityToSave);
        return communityToCommunityDtoConverter.convert(savedCommunity);
    }

    @Override
    public void deleteById(UUID id) throws AppEntityNotFoundException {
        if (repository.existsById(id)){
            repository.deleteById(id);
        }
        else {
            throw new AppEntityNotFoundException();
        }
    }

    @Transactional
    @Override
    public CommunityDto updateById(UUID id, CommunityDto dto) throws AppEntityNotFoundException {
        return repository.findById(id)
                .map(community -> {
                    community.setName(dto.getName());
                    return community;
                })
                .map(repository::save)
                .map(communityToCommunityDtoConverter::convert)
                .orElseThrow(AppEntityNotFoundException::new);
    }
}
