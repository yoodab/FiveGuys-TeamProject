package com.sparta.newspeed.service;

import com.sparta.newspeed.dto.PeedRequestDto;
import com.sparta.newspeed.dto.PeedResponseDto;
import com.sparta.newspeed.entity.Peed;
import com.sparta.newspeed.repository.PeedRepository;
import org.springframework.stereotype.Service;

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

    public PeedResponseDto updatePeed(Long peed_id, PeedRequestDto requestDto) {
        Peed peed = findPeed(peed_id);
        peed.update(requestDto);
        return new PeedResponseDto(peed);

    }

    public Long deletePeed(Long peed_id, PeedRequestDto requestDto) {
        Peed peed = findPeed(peed_id);
        peedRepository.delete(peed);
        return peed_id;
    }

    public List<PeedResponseDto> getAllSchedules() {
        return peedRepository.findAllByOrderByCreatedAtDesc().stream()
                .map(PeedResponseDto::new).toList();
    }

    private Peed findPeed(Long peed_id) {
        return peedRepository.findById(peed_id)
                .orElseThrow(() -> new IllegalArgumentException("peed not found"));
    }
}
