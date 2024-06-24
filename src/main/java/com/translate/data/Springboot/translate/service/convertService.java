package com.translate.data.Springboot.translate.service;

import com.translate.data.Springboot.translate.adapter.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class convertService {
    private final Map<String, IDataConvert> converters = new HashMap<>();

    public convertService() {
        converters.put("String", new StringAdapter());
        converters.put("Base64", new Base64Adapter());
        converters.put("Hex", new HexAdapter());
        converters.put("Byte", new ByteAdapter());

    }

    public String convertData(String input, String inputType, String outputType) {
        if (inputType.equals(outputType)) {
            return input;
        }

        IDataConvert inputConvert = converters.get(inputType);
        if (inputConvert == null) {
            throw new IllegalArgumentException("error input type: " + inputType);
        }
        byte[] intermediateBytes = inputConvert.toByte(input);

        // Convert byte array to output format
        IDataConvert outputConvert = converters.get(outputType);
        if (outputConvert == null) {
            throw new IllegalArgumentException("error output type: " + outputType);
        }
        return outputConvert.fromByte(intermediateBytes);
    }
}
