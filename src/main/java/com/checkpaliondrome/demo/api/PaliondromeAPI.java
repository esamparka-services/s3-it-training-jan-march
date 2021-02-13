package com.checkpaliondrome.demo.api;

import com.checkpaliondrome.demo.module.PaliondromeModule;
import com.checkpaliondrome.demo.service.PaliondromeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PaliondromeAPI {

    @Autowired
    PaliondromeService paliondromeService;

    @PostMapping("/isPaliondrome")

    public PaliondromeModule checkPaliondrome(@RequestBody PaliondromeModule paliondromeModule) {
        return paliondromeService.findPaliondrome(paliondromeModule);
    }
}
