package com.example.actuatorservice;
/**
 * @author Siyang Zhang
 * @date 2019/10/23 9:30 上午
 */

/**
 * This is Description
 *
 * @author siyangzhang
 * @date 2019/10/23
 */

public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

}