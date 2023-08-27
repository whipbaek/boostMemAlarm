package com.example.boostMemAlarm.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MSG {

    // AM 09:30 [월 ~ 금]
    CHECK_IN("[AM 09:30] 좋은 아침이에요 :sunny:  *오늘도 10시까지 체크인, 잊지 마세요!* :checkered_flag: "),

    // PM 19:00 [월 - 금]
    CHECK_OUT("[PM 19:00] 오늘도 고생하셨어요 :clap: , *체크아웃 잊지 마세요!*"), // x

    // PM 23:30 [월 - 금]
    CHECK_OUT_REMIND("[PM 23:30] *체크아웃 (or Pull Request) 마감 30분 전!* :dart:  "); // x

    private String message;
}
