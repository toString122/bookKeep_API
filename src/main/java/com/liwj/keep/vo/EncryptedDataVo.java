package com.liwj.keep.vo;

import lombok.Data;

@Data
public class EncryptedDataVo {
    private String encryptedData;
    private String iv;
    private String sessionKey;
}
