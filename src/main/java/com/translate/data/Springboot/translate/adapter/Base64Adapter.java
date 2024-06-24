package com.translate.data.Springboot.translate.adapter;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class Base64Adapter implements IDataConvert {
    @Override
    public byte[] toByte(String input) {
        if (input == null) {
            return new byte[0];
        }
        return Base64.getDecoder().decode(input);
    }

    @Override
    public String fromByte(byte[] input) {
        if (input == null || input.length == 0) {
            return "";
        }
        return Base64.getEncoder().encodeToString(input);
    }
}
