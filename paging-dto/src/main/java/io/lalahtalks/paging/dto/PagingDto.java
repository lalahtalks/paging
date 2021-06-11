package io.lalahtalks.paging.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class PagingDto {

    @JsonProperty("number")
    @NonNull
    Integer number;

    @JsonProperty("size")
    @NonNull
    Integer size;

    @JsonProperty("totalElements")
    @NonNull
    Long totalElements;

    @JsonProperty("totalPages")
    @NonNull
    Integer totalPages;

}
