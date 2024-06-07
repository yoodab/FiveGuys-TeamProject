package com.sparta.newspeed.controller;

import com.sparta.newspeed.dto.PeedRequestDto;
import com.sparta.newspeed.dto.PeedResponseDto;
import com.sparta.newspeed.security.UserDetailsImpl;
import com.sparta.newspeed.service.PeedService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api")
public class PeedController {

    private final PeedService peedService;

    public PeedController(PeedService peedService) {
        this.peedService = peedService;
    }

    @PostMapping("/peeds")
    public PeedResponseDto createSchedule(@RequestBody PeedRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {
        return peedService.createPeed(requestDto, userDetailsImpl);
    }

    @GetMapping("/peeds")
    public Page<PeedResponseDto> getAllPeeds(
            @RequestParam("page") int page,
            @RequestParam("page") int size,
            @RequestParam("page") String sortBy,
            @RequestParam("page") boolean isAsc

    ){
        return peedService.getAllPeeds(page-1, size, sortBy, isAsc);
    }

    @PutMapping("/peeds/{id}")
    public PeedResponseDto updateMemo(@PathVariable Long id, @RequestBody PeedRequestDto requestDto) {
        return peedService.updatePeed(id, requestDto);
    }
    @DeleteMapping("/peeds/{id}")
    public Long deleteMemo(@PathVariable Long id, @RequestBody PeedRequestDto requestDto) {
        return peedService.deletePeed(id, requestDto);
    }


}
