package com.mylearning.sprintgboot.firstrestapi.survey;

import java.util.List;

public class Question {

    private String id;
    private String description;
    private String correctAnswer;
    private List<String> option;

    public Question() {
    }

    public Question(String id, String description,  List<String> option, String correctAnswer) {
        this.id = id;
        this.description = description;
        this.correctAnswer = correctAnswer;
        this.option = option;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getOption() {
        return option;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", option=" + option +
                '}';
    }
}
