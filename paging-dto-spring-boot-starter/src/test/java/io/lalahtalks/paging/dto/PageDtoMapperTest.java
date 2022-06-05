package io.lalahtalks.paging.dto;

import io.lalahtalks.paging.domain.Page;
import io.lalahtalks.paging.domain.Paging;
import io.lalahtalks.paging.domain.Sort;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

class PageDtoMapperTest {

    private static final Function<String, String> IDENTITY = Function.identity();

    private static final Paging PAGING = Paging.builder()
            .number(0)
            .size(1)
            .totalElements(1L)
            .totalPages(1)
            .build();

    private static final Page<String> PAGE_1 = Page.<String>builder()
            .paging(PAGING)
            .element("0")
            .sort(Sort.by(Sort.Order.asc("name"), Sort.Order.desc("timestamp")))
            .build();

    public static final Page<String> PAGE_2 = Page.<String>builder()
            .paging(PAGING)
            .element("0")
            .build();

    private static final PagingDto PAGING_DTO = new PagingDto(0, 1, 1L, 1);

    private static final SortDto SORT_DTO = new SortDto(List.of(
            new SortDto.Order("name", SortDto.Direction.ASC),
            new SortDto.Order("timestamp", SortDto.Direction.DESC)));

    public static final PageDto<String> PAGE_1_DTO = new PageDto<>(PAGING_DTO, List.of("0"), SORT_DTO);

    private final PageDtoMapper pageDtoMapper = new PageDtoMapper();

    @Test
    void toDto_works() {
        var actual = pageDtoMapper.to(PAGE_1, IDENTITY);
        assertThat(actual).usingRecursiveComparison().isEqualTo(PAGE_1_DTO);
    }

}
