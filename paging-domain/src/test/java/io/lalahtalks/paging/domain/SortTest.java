package io.lalahtalks.paging.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SortTest {

    @Nested
    @DisplayName("Sort tests")
    class SortTesting {

        @Test
        void by_orders_list_works() {
            var actual = Sort.by(List.of(Sort.Order.asc("property")));
            assertThat(actual.getOrders()).containsExactly(Sort.Order.asc("property"));
        }

        @Test
        void by_orders_varargs_works() {
            var actual = Sort.by(Sort.Order.asc("property"));
            assertThat(actual.getOrders()).containsExactly(Sort.Order.asc("property"));
        }

        @Test
        void stream_returns_orders() {
            var sort = Sort.by(Sort.Order.asc("property1"), Sort.Order.desc("property2"));
            assertThat(sort.stream()).containsExactly(Sort.Order.asc("property1"), Sort.Order.desc("property2"));
        }

    }

    @Nested
    @DisplayName("Sort.Order tests")
    class SortOrderTesting {

        @Test
        void asc_works() {
            var actual = Sort.Order.asc("property");
            assertThat(actual.getProperty()).isEqualTo("property");
            assertThat(actual.getDirection()).isEqualTo(Sort.Direction.ASC);
        }

        @Test
        void desc_works() {
            var actual = Sort.Order.desc("property");
            assertThat(actual.getProperty()).isEqualTo("property");
            assertThat(actual.getDirection()).isEqualTo(Sort.Direction.DESC);
        }

        @Test
        void isAscending_is_true_when_direction_is_ASC() {
            var actual = Sort.Order.asc("property");
            assertThat(actual.isAscending()).isTrue();
        }

        @Test
        void isDescending_is_false_when_direction_is_ASC() {
            var actual = Sort.Order.asc("property");
            assertThat(actual.isDescending()).isFalse();
        }

        @Test
        void isAscending_is_false_when_direction_is_DESC() {
            var actual = Sort.Order.desc("property");
            assertThat(actual.isAscending()).isFalse();
        }

        @Test
        void isDescending_is_true_when_direction_is_DESC() {
            var actual = Sort.Order.desc("property");
            assertThat(actual.isDescending()).isTrue();
        }

    }

}
