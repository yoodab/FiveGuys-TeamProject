package com.sparta.newspeed.controller;

import com.sparta.newspeed.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contents")
@RequiredArgsConstructor
public class ContentController {

    private final ContentService service;

    @GetMapping(/"{id}")
    public ResponseEntity<ContentResponse> findById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok()
                .body(service.findById(id));
    }
}
