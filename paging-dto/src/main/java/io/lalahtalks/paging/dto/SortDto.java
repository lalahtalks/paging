package io.lalahtalks.paging.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NonNull;
import lombok.Singular;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class SortDto {

    @Value
    @Builder
    public static class Order {

        @JsonProperty("property")
        @NonNull
        String property;

        @JsonProperty("direction")
        @NonNull
        SortDto.Direction direction;

    }

    public enum Direction {

        ASC,
        DESC

    }

    @JsonProperty("orders")
    @NonNull
    @Singular
    List<Order> orders;

}
