package io.lalahtalks.paging.domain;

import lombok.Builder;
import lombok.NonNull;
import lombok.Singular;
import lombok.Value;

import java.util.List;
import java.util.Optional;

@Value
@Builder
public class Page<T> {

    @NonNull
    Paging paging;

    @NonNull
    @Singular
    List<T> elements;

    Sort sort;

    public Optional<Sort> getSort() {
        return Optional.ofNullable(sort);
    }

}
