package com.wjf.model;

import lombok.Data;

/**
 * @author weijunfeng
 * @Date 2019-05-31 13:52
 */
@Data
public class Message {
    private String name;
    private String tobi;
    private String hanoi;

    public Message() {
    }

    public Message(String name, String tobi, String hanoi) {
        this.name = name;
        this.tobi = tobi;
        this.hanoi = hanoi;
    }
}
