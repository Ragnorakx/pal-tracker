/**
 * Copyright 2019 Dell Inc. or its subsidiaries. All Rights Reserved.
 */
package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{


    HashMap<Long, TimeEntry> repo = new HashMap<>();

    @Override
    public TimeEntry create(TimeEntry entry) {
        repo.put(entry.getId(), entry);
        return entry;
    }

    @Override
    public TimeEntry find(Long timeEntryId) {
        return repo.get(timeEntryId);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(repo.values());
    }

    @Override
    public TimeEntry update(Long eq, TimeEntry entry) {
        if(repo.get(eq) == null)
            return null;
        if(entry.getId() != eq)
            entry.setId(eq);
        repo.put(eq, entry);
        return entry;
    }

    @Override
    public void delete(Long timeEntryId) {
        repo.remove(timeEntryId);
    }

}
