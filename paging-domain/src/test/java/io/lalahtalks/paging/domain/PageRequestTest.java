package io.lalahtalks.paging.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PageRequestTest {

    @Test
    void of_number_and_size_works() {
        var actual = PageRequest.of(0, 1);
        assertThat(actual.getPageNumber()).isZero();
        assertThat(actual.getPageSize()).isEqualTo(1);
        assertThat(actual.getSort()).isEmpty();
    }

    @Test
    void of_number_and_size_and_sort_orders_list_works() {
        var order = Sort.Order.asc("property");
        var actual = PageRequest.of(0, 1, List.of(order));
        assertThat(actual.getPageNumber()).isZero();
        assertThat(actual.getPageSize()).isEqualTo(1);
        assertThat(actual.getSort()).hasValue(Sort.by(order));
    }

    @Test
    void of_number_and_size_and_sort_orders_varargs_works() {
        var order1 = Sort.Order.asc("property1");
        var order2 = Sort.Order.desc("property2");
        var actual = PageRequest.of(0, 1, order1, order2);
        assertThat(actual.getPageNumber()).isZero();
        assertThat(actual.getPageSize()).isEqualTo(1);
        assertThat(actual.getSort()).hasValue(Sort.by(order1, order2));
    }

    @Test
    void withDefaultSort_does_not_replace_when_sort_is_not_null() {
        var order1 = Sort.Order.asc("property1");
        var order2 = Sort.Order.desc("property2");
        var request = PageRequest.of(0, 1, order1);
        var actual = request.withDefaultSort(Sort.by(order2));
        assertThat(actual.getSort()).hasValue(Sort.by(order1));
    }

    @Test
    void withDefaultSort_replaces_when_sort_is_null() {
        var order2 = Sort.Order.desc("property2");
        var request = PageRequest.of(0, 1);
        var actual = request.withDefaultSort(Sort.by(order2));
        assertThat(actual.getSort()).hasValue(Sort.by(order2));
    }

}
