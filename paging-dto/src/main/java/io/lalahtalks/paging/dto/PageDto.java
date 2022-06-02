package io.lalahtalks.paging.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public record PageDto<T>(
        @JsonProperty("paging") PagingDto paging,
        @JsonProperty("elements") List<T> elements,
        @JsonProperty("sort") SortDto sort) {

    public static final class Builder<T> {

        private PagingDto paging;
        private List<T> elements = new ArrayList<>();
        private SortDto sort;

        public Builder<T> paging(PagingDto paging) {
            this.paging = paging;
            return this;
        }

        public Builder<T> clearElements() {
            this.elements = new ArrayList<>();
            return this;
        }

        public Builder<T> elements(List<T> elements) {
            this.elements.addAll(elements);
            return this;
        }

        public Builder<T> element(T element) {
            this.elements.add(element);
            return this;
        }

        public Builder<T> sort(SortDto sort) {
            this.sort = sort;
            return this;
        }

        public PageDto<T> build() {
            return new PageDto<>(paging, elements, sort);
        }

    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

}
