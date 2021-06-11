package io.lalahtalks.paging.domain;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Value
@Builder(toBuilder = true)
public class PageRequest {

    public static PageRequest of(int number, int page) {
        return new PageRequest(number, page, null);
    }

    public static PageRequest of(int number, int page, List<Sort.Order> sortOrders) {
        var sort = Sort.by(sortOrders);
        return new PageRequest(number, page, sort);
    }

    public static PageRequest of(int number, int page, Sort.Order... sortOrders) {
        var asList = Arrays.asList(sortOrders);
        return of(number, page, asList);
    }

    @NonNull Integer pageNumber;
    @NonNull Integer pageSize;
    Sort sort;

    public Optional<Sort> getSort() {
        return Optional.ofNullable(sort);
    }

    public PageRequest withDefaultSort(Sort defaultSort) {
        if (null != sort) {
            return this;
        }

        return toBuilder()
                .sort(defaultSort)
                .build();
    }

}
