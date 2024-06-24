package com.translate.data.Springboot.translate.adapter;

public interface IDataConvert {
    byte[] toByte(String data);
    String fromByte(byte[] data);
}
