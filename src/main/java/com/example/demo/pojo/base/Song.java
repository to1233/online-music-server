package com.example.demo.pojo.base;

import lombok.Data;

import java.util.List;

@Data
public class Song {


    private int id;

    private String name;

    private List<Artist> artists;

    private Album album;

    private String duration;

}
