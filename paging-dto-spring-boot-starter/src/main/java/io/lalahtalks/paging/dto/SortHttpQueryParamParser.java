package io.lalahtalks.paging.dto;

import io.lalahtalks.paging.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class SortHttpQueryParamParser {

    private static final String ORDER_SEPARATOR = ",";
    private static final String DIRECTION_SEPARATOR = "\\+";
    private static final String ASC_TOKEN = "asc";
    private static final String DESC_TOKEN = "desc";

    public Sort parse(String sortString) {
        var orderSplit = sortString.split(ORDER_SEPARATOR);

        var orders = new ArrayList<Sort.Order>(orderSplit.length);
        for (var orderString : orderSplit) {
            var order = getOrder(orderString);
            orders.add(order);
        }

        return new Sort(orders);
    }

    private Sort.Order getOrder(String orderString) {
        var directionSplit = orderString.split(DIRECTION_SEPARATOR);
        if (directionSplit.length != 2) {
            throw new InvalidSortStringException("Invalid order '" + orderString + "'");
        }

        var direction = getDirection(directionSplit[1]);
        var property = new Sort.Property(directionSplit[0]);
        return new Sort.Order(property, direction);
    }

    private Sort.Direction getDirection(String directionString) {
        if (directionString.equals(ASC_TOKEN)) {
            return Sort.Direction.ASC;
        }

        if (directionString.equals(DESC_TOKEN)) {
            return Sort.Direction.DESC;
        }

        throw new InvalidSortStringException("Invalid direction '" + directionString + "'");
    }

}
