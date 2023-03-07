package com.qpolla.poll.controller;

import com.qpolla.poll.data.dto.PollDto;
import com.qpolla.poll.data.dto.PollStatusChangeRequestDto;
import com.qpolla.poll.service.PollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/api/poll")
public class PollController {
    private final PollService pollService;

    @Autowired
    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody PollDto poll) {
        PollDto savedDto = pollService.create(poll);
        return ResponseEntity.ok(savedDto);
    }

    @GetMapping(value = "/")
    public ResponseEntity<?> get(@RequestParam("pollId") Long pollId) {
        PollDto foundDto = pollService.get(pollId);
        return ResponseEntity.ok(foundDto);
    }

    @PatchMapping(value = "/")
    public ResponseEntity<?> updateStatus(@RequestBody PollStatusChangeRequestDto dto) {
        PollDto updatedDto = pollService.updateStatus(dto);
        return ResponseEntity.ok(updatedDto);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody PollDto pollDto) {
        PollDto updatedDto = pollService.update(pollDto);
        return ResponseEntity.ok(updatedDto);
    }

}
