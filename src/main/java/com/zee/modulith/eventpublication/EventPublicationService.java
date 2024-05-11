package com.zee.modulith.eventpublication;

import java.util.List;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 11 May, 2024
 */


public interface EventPublicationService {

    List<EventPublication> getUncompletedEventPublications();
    List<EventPublication> getCompletedEventPublications();
}
