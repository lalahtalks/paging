package io.lalahtalks.paging.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PageRequestTest {

    private static final Sort.Property PROPERTY_1 = new Sort.Property("property1");
    private static final Sort.Property PROPERTY_2 = new Sort.Property("property2");

    @Nested
    class OfTest {

        @Test
        void by_number_and_size() {
            var actual = PageRequest.of(0, 1);
            assertThat(actual.pageNumber()).isZero();
            assertThat(actual.pageSize()).isEqualTo(1);
            assertThat(actual.sort()).isEqualTo(Sort.EMPTY);
        }

        @Test
        void by_number_and_size_and_sort_orders_list() {
            var order = Sort.Order.asc(PROPERTY_1);
            var actual = PageRequest.of(0, 1, List.of(order));
            assertThat(actual.pageNumber()).isZero();
            assertThat(actual.pageSize()).isEqualTo(1);
            assertThat(actual.sort()).isEqualTo(Sort.by(order));
        }

        @Test
        void by_number_and_size_and_sort_orders_varargs() {
            var order1 = Sort.Order.asc(PROPERTY_1);
            var order2 = Sort.Order.desc(PROPERTY_2);
            var actual = PageRequest.of(0, 1, order1, order2);
            assertThat(actual.pageNumber()).isZero();
            assertThat(actual.pageSize()).isEqualTo(1);
            assertThat(actual.sort()).isEqualTo(Sort.by(order1, order2));
        }

    }

    @Nested
    class WithDefaultSortTest {

        @Test
        void it_does_not_replace_when_sort_is_empty() {
            var order1 = Sort.Order.asc(PROPERTY_1);
            var order2 = Sort.Order.desc(PROPERTY_2);
            var request = PageRequest.of(0, 1, order1);
            var actual = request.withDefaultSort(Sort.by(order2));
            assertThat(actual.sort()).isEqualTo(Sort.by(order1));
        }

        @Test
        void it_replaces_when_sort_is_empty() {
            var order2 = Sort.Order.desc(PROPERTY_2);
            var request = PageRequest.of(0, 1);
            var actual = request.withDefaultSort(Sort.by(order2));
            assertThat(actual.sort()).isEqualTo(Sort.by(order2));
        }

    }

}
