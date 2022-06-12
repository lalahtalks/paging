package io.lalahtalks.paging.dto;

import io.lalahtalks.paging.domain.Sort;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class SortHttpQueryParamParserTest {

    private final SortHttpQueryParamParser sortHttpQueryParamParser = new SortHttpQueryParamParser();

    @Test
    void ok() {
        var actual = sortHttpQueryParamParser.parse("this+asc,that+desc");
        var expected = Sort.by(
                Sort.Order.asc(new Sort.Property("this")),
                Sort.Order.desc(new Sort.Property("that")));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void invalid_order() {
        assertThatExceptionOfType(InvalidSortStringException.class)
                .isThrownBy(() -> sortHttpQueryParamParser.parse("this+asc,that"))
                .withMessage("Invalid order 'that'");
    }

    @Test
    void invalid_direction() {
        assertThatExceptionOfType(InvalidSortStringException.class)
                .isThrownBy(() -> sortHttpQueryParamParser.parse("this+asc,that+wut"))
                .withMessage("Invalid direction 'wut'");
    }

}