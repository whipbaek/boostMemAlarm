package com.example.boostMemAlarm;

import com.example.boostMemAlarm.domain.MSG;
import com.slack.api.Slack;
import com.slack.api.methods.SlackApiException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.slack.api.model.block.Blocks.asBlocks;
import static com.slack.api.model.block.Blocks.section;
import static com.slack.api.model.block.composition.BlockCompositions.markdownText;

@Slf4j
@Getter
@Component
public class PublishingMessage {

    private final String token;

    public PublishingMessage(@Value("${token}") String token){
        this.token = token;
    }

    public void publishMessage(String id, MSG msg) {
        var client = Slack.getInstance().methods();
        try {
            var result = client.chatPostMessage(r -> r
                            .token(token)
                            .channel(id)
                            .username("boost Bot")
                            .text(msg.getMessage())
                            .blocks(asBlocks(
                                    section(s -> s.text(markdownText(mt -> mt
                                            .text(msg.getMessage()))))
                            ))
            );
        } catch (IOException | SlackApiException e) {
            log.error("error: {}", e.getMessage(), e);
        }
    }

}
