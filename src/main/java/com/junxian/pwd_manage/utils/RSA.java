package com.junxian.pwd_manage.utils;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class RSA {
    public static String decrypt(String s) throws Exception {
        String privateKeyStr = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCugmD3LA0+v55AR6V07Q3DU5lmxv3Z52/jNg3VbXQ0p+jilAaXh8Wyzbgu6EfEy2KTCNmTRBVOMznMRlUdI/POpKohYxFjQKUqPlvOD/9wII2SWD11ZuVIGWWtTpXpRE4MkZ+bY9/0mjit/O6wpZ7k/QNVcdwfpBtoRei6HrT90acRmBMtH5zNwO/uJ59QMsFEiY15fOr1K1UlH3uSJI5Km8qiPe3ISOScTvNn2YtlQFZIOqnabJnDimdMXqPIUI9ArPbT3/k0mNKVvcdIabEzSE9a5u5Ss0qORIN5TuYYHfOoMTrPr6hmTkaca1j4vUf+ByYsrsOkNRR3GXNOV307AgMBAAECggEBAIL2Z4y3a40+wqWc3yfbyyteLs554gJI9KgAZetZBA+MP3LjAftwMkbYqjPRsCKZO/X6e0ZQnuib+vE5iyCeXZcj7mW18lOZLRqBx+XiDaH5XCWKwTy9Jq6wGKUyR8DSuPwnwS8difIIVycDnaHF+XQCCSFznG3Ge6cKZ/hdmRito3Tw/Np2EgH9REg3bct7l70jKb53sSz5xLQDrQirbqHhNwIIBE2XRC3vCjyJRrSWqU41BwPbcTG/EvhbvBsagAMav4z43rRTbn9vbosRo7ZH7RZvJYOBYHvKnbxX1fOyLmRBeRltkbL1o42Ui096q6Ard2FHssZke8khG5exZHECgYEA3OgXib8bOhyRw51CyBkDCdl/F2SftX/F+z1UOwyp2MNxB1wZsCQ9kphMDqTYRyLPIavptkmYqyZHdQ4isPMXMd37Mcaz8qELUdGTrHI+e4Oj1P1p/Gv/WCPNiVpP+XB5rdjfYAQcfzPlzg1X5BRE6MsManje6TwIcb7gBynsfmMCgYEAyjtiY+d6NbWzaUUTImR/4i3UeZ9zlaej+uNsyQr53e2PxHL0+NOtiXbKvETGTCAE8OYXQ0Adr/h1MoHyvgihlxHod1jB7XitqSR9UBjm265H2NRsGLDnch2fQD+6NgXA5md5d+0A31BMhw3G3ryu0kSdGMEgRARVvoLrgRf3sUkCgYBtFiOBfyDH2pHUolT3EPriI0hSWftQGm+++HMe0csR4rlvI/j/dXX+bTypwpeW0Uat3wIDZWaBpd6FnFxfOzvKAU9pLjFwcDxxw+eDscrPHZuKszViVEZ81PlLiZCSogtEYSM1e/JCknM6BHbRh3zb5GEWNugFDwMwgEyK3RYO9wKBgQC0qZZ9L4aCwt8TVQ0B9Yw1T8H4IRVOBaQ9drxxYefUdeywkA3+2IO4QTJePIZ17UjcuIDhqD6dPLXeOC7Vy7onzmzBab5dWiix6RI14vkiGbC/qQ0kha1Nyd7Bs+yzZDJu4tOl6kmUNhUXtZwK0b7Pw1Igki8z9DdxaV3gRrwVWQKBgQDW8p9dyykZQUz6NQ78FdmjVTBUCWJjM5a4xAW9qm4p/QcGZ8rdjuZuW1U1hTqehLutCbxx3v3cuAxBMm7L4m5PNU8jn2pXpzW/P1T1mUMb5UsjteIkDfTBf1+J2LLUZAxIZOFMiBbepa5qYB7BqgoHYUUb1u8sX76955mJZTaQEA==";
        byte[] privateKeyBytes = privateKeyStr.getBytes();
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec =
                new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKeyBytes));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(s)));
    }
}
