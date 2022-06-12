package io.lalahtalks.paging.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public record Sort(List<Order> orders) {

    public enum Direction {

        ASC, DESC

    }

    public record Order(Property property, Direction direction) {

        public static Order asc(Property property) {
            return new Order(property, Direction.ASC);
        }

        public static Order desc(Property property) {
            return new Order(property, Direction.DESC);
        }

        public boolean isAscending() {
            return Direction.ASC == direction;
        }

        public boolean isDescending() {
            return Direction.DESC == direction;
        }

    }

    public record Property(String value) {

    }

    public static final Sort EMPTY = new Sort(List.of());

    public static Sort by(List<Order> orders) {
        return new Sort(orders);
    }

    public static Sort by(Order... orders) {
        var asList = Arrays.asList(orders);
        return new Sort(asList);
    }

    public Sort(List<Order> orders) {
        this.orders = List.copyOf(orders);
    }

    public boolean isEmpty() {
        return orders.isEmpty();
    }

    public Stream<Order> stream() {
        return orders.stream();
    }

}
