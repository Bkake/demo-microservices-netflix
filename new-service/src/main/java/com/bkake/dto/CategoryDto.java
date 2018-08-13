package com.bkake.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;

@Immutable
@JsonSerialize(as = ImmutableCategoryDto.class)
@JsonDeserialize(as = ImmutableCategoryDto.class)
public interface CategoryDto {
    @Parameter String name();
    @Parameter String description();
}
