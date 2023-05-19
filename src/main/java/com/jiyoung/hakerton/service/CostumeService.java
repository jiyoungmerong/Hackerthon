package com.jiyoung.hakerton.service;

import com.jiyoung.hakerton.domain.Costume;
import com.jiyoung.hakerton.domain.Flag;
import com.jiyoung.hakerton.domain.dto.CostumeQuestionDTO;
import com.jiyoung.hakerton.domain.dto.FlagQuestionDTO;
import com.jiyoung.hakerton.repository.CostumeRepository;
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
public class CostumeService {
    private final CostumeRepository costumeRepository;

    public List<CostumeQuestionDTO> getCostumeQuestion() {
        List<Costume> costumeList = costumeRepository.findAll();
        return costumeList.stream().map(costume -> new CostumeQuestionDTO(costume)).collect(Collectors.toList());
    }
}
