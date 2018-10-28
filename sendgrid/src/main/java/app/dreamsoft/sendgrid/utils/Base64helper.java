package app.dreamsoft.sendgrid.utils;

import android.util.Base64;

import java.io.UnsupportedEncodingException;

public class Base64helper {

    public static byte[] encodeBytes(byte[] encode) {
        return (Base64.encode(encode, Base64.NO_WRAP | Base64.URL_SAFE));
    }

    public static byte[] decodeBytes(byte[] decode) {
        return Base64.decode(decode, Base64.NO_WRAP | Base64.URL_SAFE);
    }

    public static String stringToBase64(String encode) {
        try {
            return new String((encodeBytes(encode.getBytes("utf-8"))));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String base64toString(String decode) {
        return new String(decodeBytes(decode.getBytes()));
    }
}
