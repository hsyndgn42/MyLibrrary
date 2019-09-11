package com.hd.mylibrary.model.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hd.mylibrary.model.entity.Author;
import com.hd.mylibrary.model.request.CreateAuthorRequest;
import org.springframework.stereotype.Component;

@Component
public class CreateAuthorRequestConverter {

    private final ObjectMapper objectMapper;

    public CreateAuthorRequestConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Author convert(CreateAuthorRequest createAuthorRequest){
        return objectMapper.convertValue(createAuthorRequest, Author.class);
    }
}

