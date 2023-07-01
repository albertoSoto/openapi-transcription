package com.github.javapuzzle.service.openaiclient.service;

import com.github.javapuzzle.service.openaiclient.openaiclient.OpenAIClient;
import com.github.javapuzzle.service.openaiclient.openaiclient.OpenAIClientConfig;
import com.github.javapuzzle.service.openaiclient.model.request.ChatGPTRequest;
import com.github.javapuzzle.service.openaiclient.model.request.WhisperTranscriptionRequest;
import com.github.javapuzzle.service.openaiclient.model.request.TranscriptionRequest;
import com.github.javapuzzle.service.openaiclient.model.response.ChatGPTResponse;
import com.github.javapuzzle.service.openaiclient.model.request.ChatRequest;
import com.github.javapuzzle.service.openaiclient.model.request.Message;
import com.github.javapuzzle.service.openaiclient.model.response.WhisperTranscriptionResponse;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class OpenAIClientService {
    Logger logger = LogManager.getLogger(OpenAIClientService.class);
    private final OpenAIClient openAIClient;
    private final OpenAIClientConfig openAIClientConfig;

    private final static String ROLE_USER = "user";

    public ChatGPTResponse chat(ChatRequest chatRequest){
        Message message = Message.builder()
                .role(ROLE_USER)
                .content(chatRequest.getQuestion())
                .build();
        ChatGPTRequest chatGPTRequest = ChatGPTRequest.builder()
                .model(openAIClientConfig.getModel())
                .messages(Collections.singletonList(message))
                .build();
        return openAIClient.chat(chatGPTRequest);
    }

    public WhisperTranscriptionResponse createTranscription(TranscriptionRequest transcriptionRequest){
        try{
            WhisperTranscriptionRequest whisperTranscriptionRequest = WhisperTranscriptionRequest.builder()
                    .model(openAIClientConfig.getAudioModel())
                    .file(transcriptionRequest.getFile())
                    .build();
            return openAIClient.createTranscription(whisperTranscriptionRequest);
        }catch (Exception e){
            logger.error("Whisper transcription", e);
            WhisperTranscriptionResponse response = new WhisperTranscriptionResponse();
            response.setText("Daily quote exceeded or invalid token");
            return response;
        }
    }
}
