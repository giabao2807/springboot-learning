package com.example.demo.service.impl;

import com.example.demo.entity.Source;
import com.example.demo.repository.SourceRepository;
import com.example.demo.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SourceServiceImpl implements SourceService {
    @Autowired
    private SourceRepository sourceRepository;

    @Override
    public List<Source> findAll() {
        return (List<Source>) sourceRepository.findAll();
    }
}
