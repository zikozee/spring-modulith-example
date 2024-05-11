package com.zee.modulith.eventpublication;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 11 May, 2024
 */

@Service
@RequiredArgsConstructor
public class EventPublicationServiceImpl implements EventPublicationService {

    private final EventPublicationRepository repository;

    @Override
    public List<EventPublication> getUncompletedEventPublications() {
        return repository.findEventPublicationsByPublicationDateNotNullAndCompletionDateIsNull();
    }

    @Override
    public List<EventPublication> getCompletedEventPublications() {
        return repository.findEventPublicationsByPublicationDateNotNullAndCompletionDateNotNull();
    }
}
