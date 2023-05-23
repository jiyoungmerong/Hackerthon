package com.jiyoung.hakerton.service;

import com.jiyoung.hakerton.domain.Costume;
import com.jiyoung.hakerton.domain.Flag;
import com.jiyoung.hakerton.domain.dto.CostumeQuestionDTO;
import com.jiyoung.hakerton.domain.dto.FlagQuestionDTO;
import com.jiyoung.hakerton.domain.request.CostumeAnswerRequestDto;
import com.jiyoung.hakerton.domain.response.CostumeAnswerAndExplainDto;
import com.jiyoung.hakerton.domain.response.CostumeAnswerResponseDto;
import com.jiyoung.hakerton.domain.response.CostumeHintDto;
import com.jiyoung.hakerton.domain.response.CostumeQuestionDto;
import com.jiyoung.hakerton.exception.CostumeNotFoundException;
import com.jiyoung.hakerton.repository.CostumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CostumeService {

    private final CostumeRepository costumeRepository;

    //문제, 사진, 객관식 문제
    public List<CostumeQuestionDto> getCostumeQuestion() {
        List<Costume> costumeList = costumeRepository.findAll();
        return costumeList.stream().map(costume -> new CostumeQuestionDto(costume)).collect(Collectors.toList());
    }

    //힌트 주기
    public CostumeHintDto getCostumeHint(Long costumeId) {
        Costume costume = findCostume(costumeId);
        return new CostumeHintDto(costume);
    }


    //정답이 맞는지 확인
    public CostumeAnswerResponseDto checkCorrectAnswer(Long costumeID, CostumeAnswerRequestDto costumeAnswerRequestDto) {
        Costume costume = findCostume(costumeID);
        Boolean isCorrected;
        if (costume.getAnswer().equals(costumeAnswerRequestDto.getAnswer())) {
            isCorrected = true;
        } else {
            isCorrected = false;}
        return new CostumeAnswerResponseDto(isCorrected);
    }

    //정답과 해설 보내주기
    public CostumeAnswerAndExplainDto getCostumeAnswerAndExplain(Long costumeId) {
        Costume costume = findCostume(costumeId);
        return new CostumeAnswerAndExplainDto(costume);
    }

    private Costume findCostume(Long costumeId) {
        return costumeRepository
                .findById(costumeId)
                .orElseThrow(()-> CostumeNotFoundException.EXCEPTION);
    }
}