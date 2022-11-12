package com.example.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Recipies {
    @SerializedName("recipes")
    @Expose
    private List<String> recepies = null;
}