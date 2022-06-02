package io.lalahtalks.paging.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public record SortDto(@JsonProperty("orders") List<Order> orders) {

    public enum Direction {

        ASC,
        DESC

    }

    public record Order(
            @JsonProperty("property") String property,
            @JsonProperty("direction") SortDto.Direction direction) {

    }

    public static final class Builder {

        private List<Order> orders = new ArrayList<>();

        public Builder clearOrders() {
            this.orders = new ArrayList<>();
            return this;
        }

        public Builder orders(List<Order> orders) {
            this.orders.addAll(orders);
            return this;
        }

        public Builder order(Order order) {
            this.orders.add(order);
            return this;
        }

        public SortDto build() {
            return new SortDto(orders);
        }

    }

    public static Builder builder() {
        return new Builder();
    }

}
