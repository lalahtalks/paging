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

    private static final Paging PAGING = new Paging(0, 1, 1L, 1);

    private static final Page<String> PAGE_1 = new Page<>(
            PAGING,
            List.of("0"),
            Sort.by(Sort.Order.asc(new Sort.Property("name")), Sort.Order.desc(new Sort.Property("timestamp"))));

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
