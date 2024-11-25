package com.demo.dto;

import java.util.ArrayList;
import java.util.List;

public class ResponseData<T> {

    private int status;
    private List<String> messages = new ArrayList<>();
    private T payload;

    public ResponseData() {
    }

    public ResponseData(int status, List<String> messages, T payload) {
        this.status = status;
        this.messages = messages;
        this.payload = payload;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}
