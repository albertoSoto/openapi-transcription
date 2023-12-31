## README

This project is a demo utilizing OpenAI's ChatGPT and Whisper API integrated into a Spring Boot microservice, in order to provide conversational insights to users. It utilizes the following technologies:

- Java 17
- Spring Boot
- OpenFeign
- Lombok

https://platform.openai.com/docs/guides/speech-to-text?lang=curl

### Postman

There is a json file to import, located at OpenAiTranscription.postman_collection.json
https://upload.io/blog/postman-upload-file-cheat-sheet/

### Prerequisites

- A Java 17 development environment.
- A working understanding of Spring Boot, OpenFeign, and Lombok.

### Installation

1. Clone this repository using git clone.
2. Build and run the project using Maven.
3. Use the endpoints provided to interact with the ChatGPT and Whisper APIs.

### Usage

Set up your open ai api key ${OPENAI_API_KEY} in an .env file

.env file contents
``
OPENAI_API_KEY=########
``

This project provides endpoints for interacting with the ChatGPT and Whisper APIs. The endpoints are:

- `/chatgpt`: sends a message to ChatGPT and receives a response.
- `/whisper`: sends a message to Whisper and receives an insight.

### License

This project is licensed under the MIT License. See LICENSE file for details.
Based on repo https://github.com/sawankarn/chatgpt-whisper-spring-boot
