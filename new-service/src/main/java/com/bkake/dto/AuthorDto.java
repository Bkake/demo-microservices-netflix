package com.bkake.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;

@Immutable
@JsonSerialize(as = ImmutableAuthorDto.class)
@JsonDeserialize(as = ImmutableAuthorDto.class)
public interface AuthorDto {
    @Parameter  String firstName();
    @Parameter  String lastName();
}
