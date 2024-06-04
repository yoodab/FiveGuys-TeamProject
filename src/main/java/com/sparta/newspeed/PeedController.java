package com.sparta.newspeed;

import com.sparta.newspeed.dto.PeedRequestDto;
import com.sparta.newspeed.dto.PeedResponseDto;
import com.sparta.newspeed.service.PeedService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
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
    public PeedResponseDto createSchedule(@RequestBody PeedRequestDto requestDto){
        return peedService.createPeed(requestDto);
    }

    @GetMapping("/peeds")
    public List<PeedResponseDto> getAllPeeds(){
        return peedService.getAllPeeds();
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
