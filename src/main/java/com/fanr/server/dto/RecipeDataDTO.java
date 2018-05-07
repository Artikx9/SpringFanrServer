package com.fanr.server.dto;

import io.swagger.annotations.ApiModelProperty;

public class RecipeDataDTO {
    @ApiModelProperty(position = 0)
        private String id;
    @ApiModelProperty(position = 1)
        private String name;
    @ApiModelProperty(position = 2)
        private String contents;
    @ApiModelProperty(position = 3)
        private String cooking;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getCooking() {
        return cooking;
    }

    public void setCooking(String cooking) {
        this.cooking = cooking;
    }
}
