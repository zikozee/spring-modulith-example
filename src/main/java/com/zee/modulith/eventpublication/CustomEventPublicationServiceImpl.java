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
public class CustomEventPublicationServiceImpl implements CustomEventPublicationService {

    private final CustomEventPublicationRepository repository;

    @Override
    public List<CustomEventPublication> getUncompletedEventPublications() {
        return repository.getEventPublicationsByPublicationDateNotNullAndCompletionDateIsNull();
    }

    @Override
    public List<CustomEventPublication> getCompletedEventPublications() {
        return repository.getEventPublicationsByPublicationDateNotNullAndCompletionDateNotNull();
    }
}
