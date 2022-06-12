package io.lalahtalks.paging.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SortTest {

    private static final Sort.Property PROPERTY_1 = new Sort.Property("property1");
    private static final Sort.Property PROPERTY_2 = new Sort.Property("property2");

    @Nested
    @DisplayName("Sort")
    class SortTesting {

        @Test
        void by_orders_list_works() {
            var actual = Sort.by(List.of(Sort.Order.asc(PROPERTY_1)));
            assertThat(actual.orders()).containsExactly(Sort.Order.asc(PROPERTY_1));
        }

        @Test
        void by_orders_varargs_works() {
            var actual = Sort.by(Sort.Order.asc(PROPERTY_1));
            assertThat(actual.orders()).containsExactly(Sort.Order.asc(PROPERTY_1));
        }

        @Test
        void stream_returns_orders() {
            var sort = Sort.by(Sort.Order.asc(PROPERTY_1), Sort.Order.desc(PROPERTY_2));
            assertThat(sort.stream()).containsExactly(Sort.Order.asc(PROPERTY_1), Sort.Order.desc(PROPERTY_2));
        }

    }

    @Nested
    @DisplayName("Sort.Order")
    class SortOrderTesting {

        @Test
        void asc_works() {
            var actual = Sort.Order.asc(PROPERTY_1);
            assertThat(actual.property()).isEqualTo(PROPERTY_1);
            assertThat(actual.direction()).isEqualTo(Sort.Direction.ASC);
        }

        @Test
        void desc_works() {
            var actual = Sort.Order.desc(PROPERTY_1);
            assertThat(actual.property()).isEqualTo(PROPERTY_1);
            assertThat(actual.direction()).isEqualTo(Sort.Direction.DESC);
        }

        @Test
        void isAscending_is_true_when_direction_is_ASC() {
            var actual = Sort.Order.asc(PROPERTY_1);
            assertThat(actual.isAscending()).isTrue();
        }

        @Test
        void isDescending_is_false_when_direction_is_ASC() {
            var actual = Sort.Order.asc(PROPERTY_1);
            assertThat(actual.isDescending()).isFalse();
        }

        @Test
        void isAscending_is_false_when_direction_is_DESC() {
            var actual = Sort.Order.desc(PROPERTY_1);
            assertThat(actual.isAscending()).isFalse();
        }

        @Test
        void isDescending_is_true_when_direction_is_DESC() {
            var actual = Sort.Order.desc(PROPERTY_1);
            assertThat(actual.isDescending()).isTrue();
        }

    }

}
