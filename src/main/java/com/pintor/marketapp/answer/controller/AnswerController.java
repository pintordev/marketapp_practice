package com.pintor.marketapp.answer.controller;

import com.pintor.marketapp.answer.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class AnswerController {

    private final AnswerService answerService;
}
