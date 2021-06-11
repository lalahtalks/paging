package io.lalahtalks.paging.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;
import lombok.Singular;

import java.util.List;

@Data
public class PageDto<T> {

    @JsonProperty("paging")
    @NonNull
    private final PagingDto paging;

    @JsonProperty("elements")
    @NonNull
    @Singular
    private final List<T> elements;

    @JsonProperty("sort")
    private final SortDto sort;

}
