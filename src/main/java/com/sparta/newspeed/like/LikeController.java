package com.sparta.newspeed.like;

import com.sparta.newspeed.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/peeds")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;



    @PutMapping("{peedsId}/like")
    public ResponseEntity<String> likeFeed (@PathVariable Long peedsId,
                                              @AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {
        return likeService.likeFeed(peedsId, userDetailsImpl);

    }

    @PutMapping("/{peedsId}/comments/{commentId}/like")
    public ResponseEntity<String> likeComment(@PathVariable Long peedsId,
                                              @PathVariable Long commentId,
                                              @AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {
        return likeService.likeComment(commentId, userDetailsImpl);

    }

}
