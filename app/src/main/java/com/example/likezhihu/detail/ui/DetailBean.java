package com.example.likezhihu.detail.ui;

import java.io.Serializable;
import java.util.List;

public class DetailBean implements Serializable {
    public int id;
    public String nickname;
    public int userId;
    public String userImg;
    public String title;
    public String description;
    public String content;
    public String bizId;
    public List<String> imageList;
    public int price;
    public int type;
    public int status;
    public String summary;
}
