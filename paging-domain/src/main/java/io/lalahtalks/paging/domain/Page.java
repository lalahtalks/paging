package io.lalahtalks.paging.domain;

import java.util.List;

public record Page<T>(
        Paging paging,
        List<T> elements,
        Sort sort) {

    public Page(Paging paging, List<T> elements, Sort sort) {
        this.paging = paging;
        this.elements = List.copyOf(elements);
        this.sort = sort;
    }

    public Page(Paging paging, List<T> elements) {
        this(paging, elements, Sort.EMPTY);
    }

}
