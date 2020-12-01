package com.endava.trainingapi.controller;

import com.endava.trainingapi.dto.CommunityDto;
import com.endava.trainingapi.exceptions.AppEntityNotFoundException;
import com.endava.trainingapi.service.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(value = "/communities")
@RequiredArgsConstructor
public class CommunityController {

    private final CommunityService communityService;

    @PostMapping
    public ResponseEntity<CommunityDto> save(@Valid @RequestBody CommunityDto communityDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(communityService.save(communityDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") UUID id) throws AppEntityNotFoundException{
        communityService.deleteById(id);
    }

}
