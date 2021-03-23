package com.example.egobooster.domain.converter;

import com.example.egobooster.common.BaseConverter;
import com.example.egobooster.domain.dto.SubscriptionDto;
import com.example.egobooster.domain.entity.Subscription;
import java.util.Collection;
import java.util.List;

public class SubscriptionConverter extends BaseConverter<SubscriptionDto, Subscription> {

  public SubscriptionConverter() {
    super(Subscription::ofDto, SubscriptionDto::ofEntity);
  }

  public static SubscriptionDto ofEntity(Subscription subscription) {
    SubscriptionConverter subscriptionConverter = new SubscriptionConverter();
    return subscriptionConverter.convertFromEntity(subscription);
  }

  public static Subscription ofDto(SubscriptionDto subscriptionDto) {
    SubscriptionConverter subscriptionConverter = new SubscriptionConverter();
    return subscriptionConverter.convertFromDto(subscriptionDto);
  }

  public static List<SubscriptionDto> ofEntities(Collection<Subscription> subscriptions) {
    SubscriptionConverter subscriptionConverter = new SubscriptionConverter();
    return subscriptionConverter.convertFromEntities(subscriptions);
  }

  public static List<Subscription> ofDtos(Collection<SubscriptionDto> subscriptionDtos) {
    SubscriptionConverter subscriptionConverter = new SubscriptionConverter();
    return subscriptionConverter.convertFromDtos(subscriptionDtos);
  }
}
