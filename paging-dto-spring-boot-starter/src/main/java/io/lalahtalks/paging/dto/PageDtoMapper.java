package io.lalahtalks.paging.dto;

import io.lalahtalks.paging.domain.Page;
import io.lalahtalks.paging.domain.Paging;
import io.lalahtalks.paging.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PageDtoMapper {

    public <T, U> Page<T> from(PageDto<U> dto, Function<U, T> mapping) {
        var paging = from(dto.paging());
        var elements = dto.elements()
                .stream()
                .map(mapping)
                .toList();
        var sort = from(dto.sort());
        return Page.<T>builder()
                .paging(paging)
                .elements(elements)
                .sort(sort)
                .build();
    }

    private Paging from(PagingDto dto) {
        return Paging.builder()
                .number(dto.number())
                .size(dto.size())
                .totalElements(dto.totalElements())
                .totalPages(dto.totalPages())
                .build();
    }

    private Sort from(SortDto dto) {
        var orders = dto.orders()
                .stream()
                .map(this::from)
                .toList();
        return Sort.by(orders);
    }

    private Sort.Order from(SortDto.Order dto) {
        var direction = from(dto.direction());
        return new Sort.Order(dto.property(), direction);
    }

    private Sort.Direction from(SortDto.Direction dto) {
        return SortDto.Direction.ASC == dto
                ? Sort.Direction.ASC
                : Sort.Direction.DESC;
    }

    public <T, U> PageDto<U> to(Page<T> page, Function<T, U> mapping) {
        var paging = to(page.paging());
        var elements = page.elements()
                .stream()
                .map(mapping)
                .toList();
        var sort = to(page.sort());
        return new PageDto<>(paging, elements, sort);
    }

    private PagingDto to(Paging paging) {
        return new PagingDto(
                paging.number(),
                paging.size(),
                paging.totalElements(),
                paging.totalPages());
    }

    private SortDto to(Sort sort) {
        var orders = sort.orders()
                .stream()
                .map(this::to)
                .toList();
        return new SortDto(orders);
    }

    private SortDto.Order to(Sort.Order order) {
        var direction = to(order.direction());
        return new SortDto.Order(order.property(), direction);
    }

    private SortDto.Direction to(Sort.Direction direction) {
        if (Sort.Direction.ASC == direction) {
            return SortDto.Direction.ASC;
        } else {
            return SortDto.Direction.DESC;
        }
    }

}
