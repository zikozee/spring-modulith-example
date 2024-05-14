package com.zee.modulith.eventaction.action;

import com.zee.modulith.eventaction.EventAction;
import com.zee.modulith.eventaction.EventActionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.modulith.events.CompletedEventPublications;
import org.springframework.modulith.events.IncompleteEventPublications;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 14 May, 2024
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RepublishUncompletedEvent{

    private final EventActionRepository repository;
    private final IncompleteEventPublications incompleteEventPublications;
    private final CompletedEventPublications eventPublications;
    private final Environment env;


    public void republish(Action action) throws ClassNotFoundException {
        Optional<EventAction> eventActionByAction = repository.getEventActionByAction(action);

        if (eventActionByAction.isEmpty()) {
            log.info("No event action found for action: {}", action);
        }

        if(eventActionByAction.isPresent()){
            log.info("Republish uncompleted events for Action: {}", action);
            EventAction eventAction = eventActionByAction.get();

            Class<?> aClass = Class.forName(eventAction.getEventCanonicalName());
            incompleteEventPublications.resubmitIncompletePublications((ep) -> ep.getEvent().getClass() == aClass);
            eventPublications.deletePublicationsOlderThan(Duration.ofHours(env.getProperty("delete.event.duration", Long.class, 5000L))); // pass time as envVira
        }
    }

    public void republishForUncompletedEvents(List<Action> actions) throws ClassNotFoundException {
        for(Action action : actions){
            republish(action);
            eventPublications.deletePublicationsOlderThan(Duration.ofHours(50000));
        }
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void republishAllUncompletedEvents() throws ClassNotFoundException {
        //todo uncomment
        log.info("Republish all uncompleted events ...");
        for(Action action : Action.values()){
            republish(action);
//            eventPublications.deletePublicationsOlderThan(Duration.ofHours(50000));
        }
    }

}
