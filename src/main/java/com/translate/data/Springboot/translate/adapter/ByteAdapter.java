package com.translate.data.Springboot.translate.adapter;

import org.springframework.stereotype.Component;

@Component
public class ByteAdapter implements IDataConvert {

    @Override
    public byte[] toByte(String input) {
        if (input == null || input.isEmpty()) {
            return new byte[0];
        }

        if (input.startsWith("[") && input.endsWith("]")) {
            input = input.substring(1, input.length() - 1);
        }


        String[] byteValues = input.split(",\\s*");

        byte[] bytes = new byte[byteValues.length];

        for (int i = 0; i < byteValues.length; i++) {
            bytes[i] = Byte.parseByte(byteValues[i].trim());
        }

        return bytes;
    }

    @Override
    public String fromByte(byte[] input) {
        if (input == null || input.length == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < input.length; i++) {
            sb.append(input[i]);
            if (i < input.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}