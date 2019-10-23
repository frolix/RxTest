package com.example.transformationoperator.model;

public class Task {
    private String description;
    private boolean isComplete;
    private int preority;

    public Task(String description, boolean isComplete, int preority) {
        this.description = description;
        this.isComplete = isComplete;
        this.preority = preority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public int getPreority() {
        return preority;
    }

    public void setPreority(int preority) {
        this.preority = preority;
    }
}
