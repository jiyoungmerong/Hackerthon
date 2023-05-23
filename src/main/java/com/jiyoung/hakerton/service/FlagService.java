package com.jiyoung.hakerton.service;

import com.jiyoung.hakerton.domain.Flag;
import com.jiyoung.hakerton.domain.dto.FlagQuestionDTO;
import com.jiyoung.hakerton.domain.request.FlagAnswerRequestDto;
import com.jiyoung.hakerton.domain.response.FlagAnswerAndExplainDto;
import com.jiyoung.hakerton.domain.response.FlagAnswerResponseDto;
import com.jiyoung.hakerton.domain.response.FlagHintDto;
import com.jiyoung.hakerton.domain.response.FlagQuestionDto;
import com.jiyoung.hakerton.exception.FlagNotFoundException;
import com.jiyoung.hakerton.repository.FlagRepository;
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
public class FlagService {

    private final FlagRepository flagRepository;

    //문제, 사진, 객관식 문제
    public List<FlagQuestionDto> getFlagQuestion() {
        List<Flag> flagList = flagRepository.findAll();
        return flagList.stream().map(flag -> new FlagQuestionDto(flag)).collect(Collectors.toList());
    }

    //힌트 주기
    public FlagHintDto getFlagHint(Long flagId) {
        Flag flag = findFlag(flagId);
        return new FlagHintDto(flag);
    }


    //정답이 맞는지 확인
    public FlagAnswerResponseDto checkCorrectAnswer(Long flagId, FlagAnswerRequestDto flagAnswerRequestDto) {
        Flag flag = findFlag(flagId);
        Boolean isCorrected;
        if (flag.getAnswer().equals(flagAnswerRequestDto.getAnswer())) {
            isCorrected = true;
        } else {
            isCorrected = false;}
        return new FlagAnswerResponseDto(isCorrected);
    }

    //정답과 해설 보내주기
    public FlagAnswerAndExplainDto getFlagAnswerAndExplain(Long flagId) {
        Flag flag = findFlag(flagId);
        return new FlagAnswerAndExplainDto(flag);
    }

    private Flag findFlag(Long flagId) {
        return flagRepository
                .findById(flagId)
                .orElseThrow(()-> FlagNotFoundException.EXCEPTION);
    }
}