package com.translate.data.Springboot.translate.controllers;
import com.translate.data.Springboot.translate.models.convertRequest;
import com.translate.data.Springboot.translate.service.convertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/convert")
@CrossOrigin(origins = "http://localhost:4200")
public class convertController {

    @Autowired
    private convertService convertService;

    @PostMapping
    public String convert(@RequestBody convertRequest request) {
        return convertService.convertData(request.getInput(), request.getInputType(), request.getOutputType());
    }
}