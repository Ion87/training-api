package com.endava.trainingapi.handler;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Builder
public class ErrorResponse {

    private HttpStatus status;

    private List<String> messages;

    private Timestamp timestamp;
}