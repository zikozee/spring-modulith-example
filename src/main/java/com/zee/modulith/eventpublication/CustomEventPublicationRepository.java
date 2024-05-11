package com.zee.modulith.eventpublication;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 11 May, 2024
 */

@Repository
interface CustomEventPublicationRepository extends CrudRepository<CustomEventPublication, UUID> {

    List<CustomEventPublication> findEventPublicationsByPublicationDateNotNullAndCompletionDateIsNull();
    List<CustomEventPublication> findEventPublicationsByPublicationDateNotNullAndCompletionDateNotNull();
}
