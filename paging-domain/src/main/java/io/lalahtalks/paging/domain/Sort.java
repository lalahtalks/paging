package io.lalahtalks.paging.domain;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Singular;
import lombok.Value;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Value
public class Sort {

    public static Sort by(List<Order> orders) {
        return new Sort(orders);
    }

    public static Sort by(Order... orders) {
        var asList = Arrays.asList(orders);
        return new Sort(asList);
    }

    @Value
    @RequiredArgsConstructor(staticName = "of")
    public static class Order {

        public static Order asc(String property) {
            return Order.of(property, Direction.ASC);
        }

        public static Order desc(String property) {
            return Order.of(property, Direction.DESC);
        }

        @NonNull String property;
        @NonNull Direction direction;

        public boolean isAscending() {
            return Direction.ASC == direction;
        }

        public boolean isDescending() {
            return Direction.DESC == direction;
        }

    }

    public enum Direction {

        ASC, DESC

    }

    @NonNull
    @Singular
    List<Order> orders;

    public Stream<Order> stream() {
        return orders.stream();
    }

}
