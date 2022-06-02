package io.lalahtalks.paging.domain;

public record Paging(
        Integer size,
        Integer number,
        Long totalElements,
        Integer totalPages) {

    public static final class Builder {

        private Integer size;
        private Integer number;
        private Long totalElements;
        private Integer totalPages;

        public Builder size(Integer size) {
            this.size = size;
            return this;
        }

        public Builder number(Integer number) {
            this.number = number;
            return this;
        }

        public Builder totalElements(Long totalElements) {
            this.totalElements = totalElements;
            return this;
        }

        public Builder totalPages(Integer totalPages) {
            this.totalPages = totalPages;
            return this;
        }

        public Paging build() {
            return new Paging(size, number, totalElements, totalPages);
        }

    }

    public static Builder builder() {
        return new Builder();
    }

}
