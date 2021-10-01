package com.pk.engineering.consumer.converter;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface GenericConverter<T, S> extends Function<T, S> {

  default List<S> convertToList(final List<T> input) {
    return input.stream().map(this::apply).collect(Collectors.toList());
  }

}
