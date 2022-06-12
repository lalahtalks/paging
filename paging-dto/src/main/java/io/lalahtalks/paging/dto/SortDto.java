package io.lalahtalks.paging.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    public static final SortDto EMPTY = new SortDto(List.of());

    public SortDto(List<SortDto.Order> orders) {
        this.orders = List.copyOf(orders);
    }

}
