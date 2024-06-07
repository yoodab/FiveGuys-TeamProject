package com.sparta.newspeed.controller;

import com.sparta.newspeed.dto.CommentReqDto;
import com.sparta.newspeed.dto.CommentResDto;
import com.sparta.newspeed.service.CommentService;
import com.sparta.newspeed.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/peeds")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{newspeedId}/comment")
    public ResponseEntity<String> addComment(@PathVariable Long newspeedId,
                                             @RequestBody CommentReqDto commentReqDto,
                                             @AuthenticationPrincipal UserDetailsImpl userDetails) {
        commentService.addComment(newspeedId, commentReqDto, userDetails);
        return new ResponseEntity<>("댓글 작성 완료", HttpStatus.OK);
    }

    @GetMapping("/{newspeedId}/comments/{commentId}")
    public CommentResDto getComment(@PathVariable Long newspeedId,
                                    @PathVariable Long commentId

    ) {
        return commentService.getComment(newspeedId, commentId);

    }

    @PutMapping("/{newspeedId}/comments/{commentId}")
    public CommentResDto modifyComment(@PathVariable Long newspeedId,
                                       @PathVariable Long commentId,
                                       @RequestBody CommentReqDto commentReqDto,
                                       @AuthenticationPrincipal UserDetailsImpl userDetails

    ) {
        return commentService.mdofiyComment(newspeedId, commentId, commentReqDto, userDetails);

    }

    @DeleteMapping("/{newspeedId}/comments/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long newspeedId,
                                       @PathVariable Long commentId,
                                       @AuthenticationPrincipal UserDetailsImpl userDetails

    ) {
        commentService.deleteComment(newspeedId, commentId, userDetails);
        return new ResponseEntity<>("삭제 완료",HttpStatus.OK);

    }

}
