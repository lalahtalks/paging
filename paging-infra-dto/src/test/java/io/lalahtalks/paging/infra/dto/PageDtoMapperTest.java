package io.lalahtalks.paging.infra.dto;

import io.lalahtalks.paging.domain.Page;
import io.lalahtalks.paging.domain.Paging;
import io.lalahtalks.paging.domain.Sort;
import io.lalahtalks.paging.dto.PageDto;
import io.lalahtalks.paging.dto.PagingDto;
import io.lalahtalks.paging.dto.SortDto;
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

    private static final PagingDto PAGING_DTO = PagingDto.builder()
            .number(0)
            .size(1)
            .totalElements(1L)
            .totalPages(1)
            .build();

    private static final SortDto SORT_DTO = SortDto.builder()
            .order(SortDto.Order.builder()
                    .property("name")
                    .direction(SortDto.Direction.ASC)
                    .build())

            .order(SortDto.Order.builder()
                    .property("timestamp")
                    .direction(SortDto.Direction.DESC)
                    .build())
            .build();

    public static final PageDto<String> PAGE_1_DTO = new PageDto<>(PAGING_DTO, List.of("0"), SORT_DTO);

    public static final PageDto<String> PAGE_2_DTO = new PageDto<>(PAGING_DTO, List.of("0"), null);

    private final PageDtoMapper pageDtoMapper = new PageDtoMapper();

    @Test
    void toDto_works_when_sort_is_not_null() {
        var actual = pageDtoMapper.toDto(PAGE_1, IDENTITY);
        assertThat(actual).isEqualTo(PAGE_1_DTO);
    }

    @Test
    void toDto_works_when_sort_is_null() {
        var actual = pageDtoMapper.toDto(PAGE_2, IDENTITY);
        assertThat(actual).isEqualTo(PAGE_2_DTO);
    }

}
