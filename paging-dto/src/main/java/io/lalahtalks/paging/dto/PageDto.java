package io.lalahtalks.paging.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PageDto<T> {

    @JsonProperty("paging")
    protected final PagingDto paging;

    @JsonProperty("elements")
    protected final List<T> elements;

    @JsonProperty("sort")
    protected final SortDto sort;

    public PageDto(PagingDto paging, List<T> elements, SortDto sort) {
        this.paging = paging;
        this.elements = List.copyOf(elements);
        this.sort = sort;
    }

    public PageDto(PagingDto paging, List<T> elements) {
        this(paging, elements, SortDto.EMPTY);
    }

    public final PagingDto paging() {
        return paging;
    }

    public final List<T> elements() {
        return elements;
    }

    public final SortDto sort() {
        return sort;
    }

    @Override
    public final String toString() {
        return getClass().getSimpleName()
                + "{"
                + "paging=" + paging
                + ", elements=" + elements
                + ", sort=" + sort
                + '}';
    }

}
