package com.checkpaliondrome.demo.module;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Data
@Setter
@Getter
public class PaliondromeModule {
    private String string;
    private String reversedString;
    private boolean paliondrome;
    private String message;


}
