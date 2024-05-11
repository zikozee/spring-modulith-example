package com.zee.modulith.eventpublication;

import lombok.RequiredArgsConstructor;
import org.springframework.modulith.events.EventPublication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 11 May, 2024
 */

@Service
@RequiredArgsConstructor
public class CustomEventPublicationServiceImpl implements CustomEventPublicationService {

    private final CustomEventPublicationRepository repository;

    @Override
    public List<CustomEventPublication> getUncompletedEventPublications() {
        return repository.findEventPublicationsByPublicationDateNotNullAndCompletionDateIsNull();
    }

    @Override
    public List<CustomEventPublication> getCompletedEventPublications() {
        return repository.findEventPublicationsByPublicationDateNotNullAndCompletionDateNotNull();
    }
}
