package io.lalahtalks.paging.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public record Sort(List<Order> orders) {

    public static final Sort EMPTY = new Sort(List.of());

    public enum Direction {

        ASC, DESC

    }

    public record Order(String property, Direction direction) {

        public static Order asc(String property) {
            return new Order(property, Direction.ASC);
        }

        public static Order desc(String property) {
            return new Order(property, Direction.DESC);
        }

        public boolean isAscending() {
            return Direction.ASC == direction;
        }

        public boolean isDescending() {
            return Direction.DESC == direction;
        }

    }

    public static Sort by(List<Order> orders) {
        return new Sort(orders);
    }

    public static Sort by(Order... orders) {
        var asList = Arrays.asList(orders);
        return new Sort(asList);
    }

    public boolean isEmpty() {
        return equals(Sort.EMPTY);
    }

    public Stream<Order> stream() {
        return orders.stream();
    }

}
