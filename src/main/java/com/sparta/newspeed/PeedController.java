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
    public List<PeedResponseDto> getAllSchedules(){
        return peedService.getAllSchedules();
    }

    @PutMapping("/peeds/{peed_id}")
    public PeedResponseDto updateMemo(@PathVariable Long peed_id, @RequestBody PeedRequestDto requestDto) {
        return peedService.updatePeed(peed_id, requestDto);
    }
    @DeleteMapping("/peeds/{peed_id}")
    public Long deleteMemo(@PathVariable Long peed_id, @RequestBody PeedRequestDto requestDto) {
        return peedService.deletePeed(peed_id, requestDto);
    }


}
