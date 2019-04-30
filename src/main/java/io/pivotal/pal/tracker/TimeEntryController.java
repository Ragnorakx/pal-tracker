/**
 * Copyright 2019 Dell Inc. or its subsidiaries. All Rights Reserved.
 */
package io.pivotal.pal.tracker;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
        return new ResponseEntity<>(timeEntryRepository.create(timeEntryToCreate), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TimeEntry> read(@PathVariable("id") long timeEntryId) {
        TimeEntry entry = timeEntryRepository.find(timeEntryId);
        ResponseEntity<TimeEntry> response;
        if(entry != null){
            response = new ResponseEntity<>(entry, HttpStatus.OK);
        }else{
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity<>(timeEntryRepository.list(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable("id") long timeEntryId, @RequestBody TimeEntry expected) {
        TimeEntry entry = timeEntryRepository.update(timeEntryId, expected);
        ResponseEntity<TimeEntry> response;
        if(entry != null){
            response = new ResponseEntity<>(entry, HttpStatus.OK);
        }else{
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return response;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id")long timeEntryId) {
        timeEntryRepository.delete(timeEntryId);
        return new ResponseEntity( HttpStatus.NO_CONTENT);
    }
}
