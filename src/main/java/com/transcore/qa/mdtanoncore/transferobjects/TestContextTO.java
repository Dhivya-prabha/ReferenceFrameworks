package com.transcore.qa.mdtanoncore.transferobjects;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Data
public class TestContextTO {
    private Map<String, String> scenarioPOMap = new HashMap<>();
}