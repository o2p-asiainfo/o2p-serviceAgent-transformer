package com.ailk.eaap.integration.o2p.transformer;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * Created by david on 14-8-14.
 */
public class Byte2StringTransformerTest extends TestCase {
    @Test
    public void test() {
        String str = "杨轩";
        byte[] bytes = str.getBytes();
        String s = null;
        try {
            s = new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }
}
