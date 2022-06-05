package io.lalahtalks.paging.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PagingDto(
        @JsonProperty("number") Integer number,
        @JsonProperty("size") Integer size,
        @JsonProperty("totalElements") Long totalElements,
        @JsonProperty("totalPages") Integer totalPages) {

}
