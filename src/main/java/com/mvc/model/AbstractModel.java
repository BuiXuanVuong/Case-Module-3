package com.mvc.model;

import java.util.ArrayList;
import java.util.List;

public class AbstractModel<T> {
    private Long id;
    private List<T> listResult = new ArrayList<>();
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<T> getListResult() {
        return listResult;
    }

    public void setListResult(List<T> listResult) {
        this.listResult = listResult;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
