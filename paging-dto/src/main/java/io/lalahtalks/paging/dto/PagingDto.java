package io.lalahtalks.paging.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PagingDto(
        @JsonProperty("number") Integer number,
        @JsonProperty("size") Integer size,
        @JsonProperty("totalElements") Long totalElements,
        @JsonProperty("totalPages") Integer totalPages) {

    public static final class Builder {

        private Integer number;
        private Integer size;
        private Long totalElements;
        private Integer totalPages;

        public Builder number(Integer number) {
            this.number = number;
            return this;
        }

        public Builder size(Integer size) {
            this.size = size;
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

        public PagingDto build() {
            return new PagingDto(number, size, totalElements, totalPages);
        }

    }

    public static Builder builder() {
        return new Builder();
    }

}
