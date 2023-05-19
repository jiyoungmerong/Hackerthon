package com.jiyoung.hakerton.service;

import com.jiyoung.hakerton.domain.Flag;
import com.jiyoung.hakerton.domain.dto.FlagQuestionDTO;
import com.jiyoung.hakerton.repository.FlagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class FlagService {
    private final FlagRepository flagRepository;



    //문제, 사진, 객관식 문제
    public List<FlagQuestionDTO> getFlagQuestion() {
        List<Flag> flagList = flagRepository.findAll();
        return flagList.stream().map(flag -> new FlagQuestionDTO(flag)).collect(Collectors.toList());
    }


}
