package com.zee.modulith.eventpublication;

import java.util.List;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 11 May, 2024
 */


public interface CustomEventPublicationService {

    List<CustomEventPublication> getUncompletedEventPublications();
    List<CustomEventPublication> getCompletedEventPublications();
}
