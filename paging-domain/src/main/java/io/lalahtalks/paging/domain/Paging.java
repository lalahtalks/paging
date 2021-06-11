package io.lalahtalks.paging.domain;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class Paging {

    @NonNull Integer size;
    @NonNull Integer number;
    @NonNull Long totalElements;
    @NonNull Integer totalPages;

}
