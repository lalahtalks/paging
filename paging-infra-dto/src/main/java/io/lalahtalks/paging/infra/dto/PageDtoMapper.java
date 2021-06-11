package io.lalahtalks.paging.infra.dto;

import io.lalahtalks.paging.domain.Page;
import io.lalahtalks.paging.domain.Paging;
import io.lalahtalks.paging.domain.Sort;
import io.lalahtalks.paging.dto.PageDto;
import io.lalahtalks.paging.dto.PagingDto;
import io.lalahtalks.paging.dto.SortDto;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PageDtoMapper {

    public <T, U> PageDto<U> toDto(Page<T> page, Function<T, U> mapping) {
        var paging = toDto(page.getPaging());
        var elements = page.getElements()
                .stream()
                .map(mapping)
                .collect(Collectors.toList());
        var sort = page.getSort()
                .map(this::toDto)
                .orElse(null);
        return new PageDto<>(paging, elements, sort);
    }

    private PagingDto toDto(Paging paging) {
        return PagingDto.builder()
                .number(paging.getNumber())
                .size(paging.getSize())
                .totalElements(paging.getTotalElements())
                .totalPages(paging.getTotalPages())
                .build();
    }

    private SortDto toDto(Sort sort) {
        var orders = sort.getOrders()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
        return SortDto.builder()
                .orders(orders)
                .build();
    }

    private SortDto.Order toDto(Sort.Order order) {
        var direction = toDto(order.getDirection());
        return SortDto.Order.builder()
                .property(order.getProperty())
                .direction(direction)
                .build();
    }

    private SortDto.Direction toDto(Sort.Direction direction) {
        if (Sort.Direction.ASC == direction) {
            return SortDto.Direction.ASC;
        } else {
            return SortDto.Direction.DESC;
        }
    }

}
