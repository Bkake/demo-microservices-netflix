package com.bkake.hystrix;

import com.bkake.dto.AuthorDto;
import com.bkake.dto.ImmutableAuthorDto;
import com.bkake.intercomm.AuthorClient;
import org.springframework.stereotype.Component;

@Component
public class AuthorClientFallback implements AuthorClient {
    @Override
    public AuthorDto getAuthorById(Long id) {
        return ImmutableAuthorDto.of("Fallback AuthorFirstName", "Fallback AuthorName");
    }
}
