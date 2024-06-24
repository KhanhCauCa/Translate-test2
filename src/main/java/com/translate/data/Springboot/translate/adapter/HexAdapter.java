package com.translate.data.Springboot.translate.adapter;

import org.springframework.stereotype.Component;

@Component
public class HexAdapter implements IDataConvert {
    @Override
    public byte[] toByte(String data) {
        int len = data.length();
        byte[] result = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            result[i / 2] = (byte) ((Character.digit(data.charAt(i), 16) << 4)
                    + Character.digit(data.charAt(i+1), 16));
        }
        return result;
    }

    @Override
    public String fromByte(byte[] data) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : data) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }
}
