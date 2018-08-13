package com.bkake.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;

import java.util.Optional;

@Immutable
@JsonSerialize(as = ImmutableNewsDto.class)
@JsonDeserialize(as = ImmutableNewsDto.class)
public interface NewsDto {
    Optional<Long> id();
    @Parameter String title();
    @Parameter String detail();
    Optional<CategoryDto> category();
    Optional<AuthorDto> author();
}
