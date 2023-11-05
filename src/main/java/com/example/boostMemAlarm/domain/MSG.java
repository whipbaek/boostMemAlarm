package com.example.boostMemAlarm.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MSG {

    // AM 09:30 [월 ~ 금]
    CHECK_IN("[AM 09:30] 좋은 아침이에요 :sunny:  *오늘도 10시까지 체크인, 잊지 마세요!* :checkered_flag: "),

    // AM 09:50 [월]
    SPRINT_DISCUSSION("[AM 09:50] *체크인 마감 및 스프린트 계획회의 시작 10분 전!* :technologist:"),

    // AM 09:50 [화, 수, 목]
    DAILY_SCRUM("[AM 09:50] *체크인 마감 및 데일리 스크럼 시작 10분 전!* :busts_in_silhouette:"),

    // AM 09:50 [금]
    TEAM_REVIEW("[AM 09:50] *체크인 마감 및 팀 회고 시작 10분 전!* :steam_locomotive: "),

    // PM 12:45 [월, 수]
    MASTER_MON_WED("[PM 12:45] *마스터 클래스 시작 15분 전!* :teacher: "),

    // PM 14:45 [금]
    PEER_SESSION("[PM 14:45] 피어세션 시작 15분 전! :man-cartwheeling:"),

    // PM 19:00 [월 - 금]
    CHECK_OUT("[PM 19:00] 오늘도 고생하셨어요 :clap: , *체크아웃 잊지 마세요!*"), // x

    // PM 23:30 [월 - 금]
    CHECK_OUT_REMIND("[PM 23:30] *체크아웃 마감 30분 전!* :dart:  "); // x



    private String message;
}
