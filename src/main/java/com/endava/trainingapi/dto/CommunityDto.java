package com.endava.trainingapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"id"})
public class CommunityDto {
    private UUID id;

    @NotNull(message = "Name must not be null")
    @Size(min = 2, message = "Size of name must be at least 2")
    private String name;

}
