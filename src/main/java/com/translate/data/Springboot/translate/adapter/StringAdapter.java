package com.translate.data.Springboot.translate.adapter;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class StringAdapter implements IDataConvert {
    @Override
    public byte[] toByte(String input) {
        if (input == null) {
            return new byte[0];
        }
        return input.getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public String fromByte(byte[] input) {

        return new String(input);
    }
}
