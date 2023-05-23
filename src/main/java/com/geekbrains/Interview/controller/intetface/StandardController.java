package com.geekbrains.Interview.controller.intetface;

import com.geekbrains.Interview.dto.CommonDTO;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface StandardController {
    public String delete(@RequestParam("name") String name);
    public String create(@RequestParam("name") String name, @RequestParam("mark") String mark);
    public <T> List<T> getAll();
}
