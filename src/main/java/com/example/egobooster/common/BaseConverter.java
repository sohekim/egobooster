package com.example.egobooster.common;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class BaseConverter<T, C> {

  private final Function<T, C> fromDto;
  private final Function<C, T> fromEntity;

  public BaseConverter(final Function<T, C> fromDto, final Function<C, T> fromEntity) {
    this.fromDto = fromDto;
    this.fromEntity = fromEntity;
  }

  public final C convertFromDto(final T dto) {
    return fromDto.apply(dto);
  }

  public final T convertFromEntity(final C entity) {
    return fromEntity.apply(entity);
  }

  public final List<C> convertFromDtos(final Collection<T> dto) {
    return dto.stream().map(this::convertFromDto).collect(Collectors.toList());
  }

  public final List<T> convertFromEntities(final Collection<C> entity) {
    return entity.stream().map(this::convertFromEntity).collect(Collectors.toList());
  }

}
