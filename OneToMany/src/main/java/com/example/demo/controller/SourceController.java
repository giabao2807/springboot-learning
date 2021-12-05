package com.example.demo.controller;

import com.example.demo.entity.Source;
import com.example.demo.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping
public class SourceController {

    @Autowired
    private SourceService sourceService;

    @GetMapping("/sources")
    public List<Source> allSource(){
        return  sourceService.findAll();
    }
}
