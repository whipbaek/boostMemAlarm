package com.example.boostMemAlarm;

import com.example.boostMemAlarm.domain.MSG;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Calendar;

import static com.example.boostMemAlarm.domain.Day.*;
import static com.example.boostMemAlarm.domain.MSG.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class Logic {
    private final PublishingMessage pub;

    // 평일 매 분 마다 실행
    @Scheduled(cron = "1 * * * * *")
    public void execute() {

        LocalDateTime localDateTime = LocalDateTime.now();

        int day =  Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        int hour = localDateTime.getHour();
        int minute = localDateTime.getMinute();
        MSG msg = null;

        log.info("현재 시각 및 요일 : {}, {}", localDateTime, getDay(day));

        // 주말은 Pass
        if(day == SUN.getDay() || day == SAT.getDay()){
            return;
        }

        // AM 09:30 [월 - 금]
        if (hour == 9 && minute == 30) {
            msg = CHECK_IN;
        }

        // AM 09:50 [월]
        if (hour == 9 && minute == 50) {
            if(day == MON.getDay()){
                msg = SPRINT_DISCUSSION;

            }

            else if(day == FRI.getDay()){
                msg = TEAM_REVIEW;
            }

            else{
                msg = DAILY_SCRUM;
            }
        }

        // PM 12:45 [월, 수]
        if (hour == 12 && minute == 45){
            if(day == MON.getDay()){
                msg = MASTER_MON_WED;
            }
        }

        // PM 14:45 [금]
        if (day == FRI.getDay() && hour == 14 && minute == 45){
            msg = PEER_SESSION;
        }

        // PM 15:45 [수]
        if (day == WED.getDay() && hour == 15 && minute == 45){
            msg = MASTER_WED_TEMP;
        }

        // PM 19:00 [월 - 금]
        if (hour == 19 && minute == 0) {
            msg = CHECK_OUT;
        }


        // PM 23:30 [월 - 금]
        if (hour == 23 && minute == 30) {
            msg = CHECK_OUT_REMIND;
        }

        if(msg != null) {
            pub.publishMessage("부스트알람", msg);
        }
    }

    public String getDay(int day){
        switch (day){
            case 1: return "일요일";
            case 2: return "월요일";
            case 3: return "화요일";
            case 4: return "수요일";
            case 5: return "목요일";
            case 6: return "금요일";
            case 7: return "토요일";
        }
        return null;
    }
}
