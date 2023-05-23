package com.jiyoung.hakerton.service;

import com.jiyoung.hakerton.domain.Landmark;
import com.jiyoung.hakerton.domain.request.LandmarkRequestDto;
import com.jiyoung.hakerton.domain.response.LandmarkAnswerAndExplainDto;
import com.jiyoung.hakerton.domain.response.LandmarkAnswerResponseDto;
import com.jiyoung.hakerton.domain.response.LandmarkHintDto;
import com.jiyoung.hakerton.domain.response.LandmarkQuestionDto;
import com.jiyoung.hakerton.exception.FoodNotFoundException;
import com.jiyoung.hakerton.repository.LandmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LandmarkService {

    private final LandmarkRepository landmarkRepository;

    public List<LandmarkQuestionDto> getFoodQuestion() {
        List<Landmark> landmarkList = landmarkRepository.findAll();
        return landmarkList.stream().map(food -> new LandmarkQuestionDto(food)).collect(Collectors.toList());
    }

    //
    //정답이 맞는지 확인
    public LandmarkAnswerResponseDto checkCorrectAnswer(Long landmarkId, LandmarkRequestDto landmarkRequestDto) {
        Landmark landmark = findLandmark(landmarkId);
        Boolean isCorrected;
        if (landmark.getAnswer().equals(landmarkRequestDto.getAnswer())) {
            isCorrected = true;
        } else {
            isCorrected = false;}
        return new LandmarkAnswerResponseDto(isCorrected);
    }


    //힌트 주기
    public LandmarkHintDto getLandmarkHint(Long randmarkId) {
        Landmark landmark = findLandmark(randmarkId);
        return new LandmarkHintDto(landmark);
    }

    //정답과 해설 보내주기
    public LandmarkAnswerAndExplainDto getLandmarkAnswerAndExplain(Long landmarkId) {
        Landmark landmark = findLandmark(landmarkId);
        return new LandmarkAnswerAndExplainDto(landmark);
    }

    private Landmark findLandmark(Long landmarkId) {
        return landmarkRepository
                .findById(landmarkId)
                .orElseThrow(()-> FoodNotFoundException.EXCEPTION);
    }
}