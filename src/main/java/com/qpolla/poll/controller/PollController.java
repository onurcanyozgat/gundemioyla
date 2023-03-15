package com.qpolla.poll.controller;

import com.qpolla.exception.ResourceNotFoundException;
import com.qpolla.poll.data.EnumPollCategory;
import com.qpolla.poll.data.dto.PollDto;
import com.qpolla.poll.data.dto.PollStatusChangeRequestDto;
import com.qpolla.poll.data.dto.PollVoteDto;
import com.qpolla.poll.service.PollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
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

import java.util.HashMap;
import java.util.Map;

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
        try {
            PollDto foundDto = pollService.get(pollId);
            return ResponseEntity.ok(foundDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping(value = "/")
    public ResponseEntity<?> updateStatus(@RequestBody PollStatusChangeRequestDto dto) {
        try {
            PollDto updatedDto = pollService.updateStatus(dto);
            return ResponseEntity.ok(updatedDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody PollDto pollDto) {
        PollDto updatedDto = pollService.update(pollDto);
        return ResponseEntity.ok(updatedDto);
    }

    @PatchMapping(value = "/vote")
    public ResponseEntity<?> vote(@RequestBody PollVoteDto dto) {
        try {
            PollDto updatedDto = pollService.vote(dto);
            return ResponseEntity.ok(updatedDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<?> filterByCategory(EnumPollCategory category, int page, int size) {
        try {
            Page<PollDto> detectionPage = pollService.filterByCategory(category, page, size);

            Map<String, Object> response = new HashMap<>();
            response.put("detectionList", detectionPage.getContent());
            response.put("currentPage", detectionPage.getNumber());
            response.put("totalItems", detectionPage.getTotalElements());
            response.put("totalPages", detectionPage.getTotalPages());
            return new ResponseEntity<>(response, HttpStatus.OK);}
        catch (Exception e) {
            return ResponseEntity.internalServerError().build();}

    }
}
