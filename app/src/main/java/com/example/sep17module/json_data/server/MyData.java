package com.example.sep17module.json_data.server;

public class MyData {

    String title;
    String body;

    public MyData(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return
                "title= " + title+
                "\nbody='" + body;
    }
}
