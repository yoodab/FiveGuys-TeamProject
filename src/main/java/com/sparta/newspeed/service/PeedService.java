package com.sparta.newspeed.service;

import com.sparta.newspeed.dto.PeedRequestDto;
import com.sparta.newspeed.dto.PeedResponseDto;
import com.sparta.newspeed.entity.Peed;
import com.sparta.newspeed.exception.SuccessHandler;
import com.sparta.newspeed.repository.PeedRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PeedService {
    private final PeedRepository peedRepository;

    public PeedService(PeedRepository peedRepository) {
        this.peedRepository = peedRepository;
    }

    public PeedResponseDto createPeed(PeedRequestDto requestDto) {
        Peed peed = new Peed(requestDto);
        Peed savepeed = peedRepository.save(peed);
        return new PeedResponseDto(savepeed);

    }
    @Transactional
    public PeedResponseDto updatePeed(Long id, PeedRequestDto requestDto) {
        Peed peed = findPeed(id);
        // 작성자만 수정 삭제 가능하게 예외처리
        peed.update(requestDto);
        return new PeedResponseDto(peed);

    }

    public Long deletePeed(Long peed_id, PeedRequestDto requestDto) {
        Peed peed = findPeed(peed_id);
        // 작성자만 수정 삭제 가능하게 예외처리
        peedRepository.delete(peed);
        return peed_id;
    }

    public List<PeedResponseDto> getAllPeeds() {
        //
        List<PeedResponseDto> peeds = peedRepository.findAllByOrderByCreatedAtDesc().stream()
                .map(PeedResponseDto::new).toList();
        if (peeds.isEmpty()) {
            throw new SuccessHandler("먼저 작성하여 소식을 알려보세요!", HttpServletResponse.SC_OK);
        }
        return peeds;
    }

    private Peed findPeed(Long id) {
        return peedRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("peed not found"));
    }
}
