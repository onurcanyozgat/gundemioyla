package com.qpolla.poll.controller;

import com.qpolla.poll.data.dto.PollStatusChangeRequestDto;
import com.qpolla.poll.data.entity.PollEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/api/poll")
public class PollController {
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody PollEntity poll) {
        // TODO convert create and save the poll in db
        return ResponseEntity.ok(poll);
    }

    @GetMapping(value = "/")
    public ResponseEntity<?> get(@PathVariable Long pollId) {
        //TODO find poll by id
        return ResponseEntity.ok().build();
    }

    @PatchMapping(value = "/")
    public ResponseEntity<?> updateStatus(@RequestBody PollStatusChangeRequestDto dto) {
        // TODO find related poll by id
        // TODO update status with the provided parameter
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody PollEntity pollEntity) {
        // TODO update the poll
        return ResponseEntity.ok().build();
    }

}
