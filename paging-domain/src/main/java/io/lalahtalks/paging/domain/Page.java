package io.lalahtalks.paging.domain;

import java.util.ArrayList;
import java.util.List;

public record Page<T>(
        Paging paging,
        List<T> elements,
        Sort sort) {

    public static final class Builder<T> {

        private Paging paging;
        private List<T> elements = new ArrayList<>();
        private Sort sort = Sort.EMPTY;

        public Builder<T> paging(Paging paging) {
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

        public Builder<T> sort(Sort sort) {
            this.sort = sort;
            return this;
        }

        public Page<T> build() {
            return new Page<>(paging, elements, sort);
        }

    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

}
