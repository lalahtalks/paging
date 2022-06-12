package io.lalahtalks.paging.domain;

public record Paging(
        Integer number,
        Integer size,
        Long totalElements,
        Integer totalPages) {

}
