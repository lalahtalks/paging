package io.lalahtalks.paging.domain;

import java.util.Arrays;
import java.util.List;

public record PageRequest(
        Integer pageNumber,
        Integer pageSize,
        Sort sort) {

    public static PageRequest of(int number, int page) {
        return new PageRequest(number, page, Sort.EMPTY);
    }

    public static PageRequest of(int number, int page, List<Sort.Order> sortOrders) {
        var sort = Sort.by(sortOrders);
        return new PageRequest(number, page, sort);
    }

    public static PageRequest of(int number, int page, Sort.Order... sortOrders) {
        var asList = Arrays.asList(sortOrders);
        return of(number, page, asList);
    }

    public PageRequest withDefaultSort(Sort defaultSort) {
        if (!sort.isEmpty()) {
            return this;
        }

        return new PageRequest(pageNumber, pageSize, defaultSort);
    }

}
