package io.lalahtalks.paging.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PageTest {

    public static final Paging PAGING = Paging.builder()
            .number(0)
            .size(1)
            .totalElements(1L)
            .totalPages(1)
            .build();

    @Test
    void getSort_returns_empty_when_sort_is_null() {
        var page = Page.<String>builder()
                .paging(PAGING)
                .element("test")
                .build();
        assertThat(page.getSort()).isEmpty();
    }

    @Test
    void getSort_returns_value_when_sort_is_not_null() {
        var page = Page.<String>builder()
                .paging(PAGING)
                .element("test")
                .sort(Sort.by(Sort.Order.asc("property")))
                .build();
        assertThat(page.getSort()).hasValue(Sort.by(Sort.Order.asc("property")));
    }

}
