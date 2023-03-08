package com.qpolla.comment.controller;

import com.qpolla.comment.CommentService;
import com.qpolla.comment.data.dto.CommentDto;
import com.qpolla.comment.data.dto.CommentStatusChangeDto;
import com.qpolla.comment.data.dto.CommentVoteDto;
import com.qpolla.exception.ResourceNotFoundException;
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

import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/api/comment")
public class CommentController {
    private final CommentService service;

    @Autowired
    public CommentController(CommentService service) {
        this.service = service;
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody CommentDto pollDto) {
        CommentDto savedDto = service.create(pollDto);
        return ResponseEntity.ok(savedDto);
    }

    @GetMapping(value = "/")
    public ResponseEntity<?> get(@RequestParam("commentId") Long commentId) {
        try {
            CommentDto foundDto = service.get(commentId);
            return ResponseEntity.ok(foundDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/pollComments")
    public ResponseEntity<?> getByPoll(@RequestParam("pollId") Long pollId, @RequestParam("page") int page, @RequestParam("size") int size) {
        try {
            List<CommentDto> commentDtoList = service.findBy(pollId, page, size);
            return ResponseEntity.ok(commentDtoList);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping(value = "/")
    public ResponseEntity<?> updateStatus(@RequestBody CommentStatusChangeDto dto) {
        try {
            CommentDto updatedDto = service.updateStatus(dto);
            return ResponseEntity.ok(updatedDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody CommentDto dto) {
        CommentDto updatedDto = service.update(dto);
        return ResponseEntity.ok(updatedDto);
    }

    @PatchMapping(value = "/vote")
    public ResponseEntity<?> vote(@RequestBody CommentVoteDto dto) {
        service.vote(dto);
        return ResponseEntity.ok().build();
    }

}
