package com.zhouwei.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ZhouTestng {
    @Test()
    public void testEmailGenerator(){
        RandomEmailGenerator obj = new RandomEmailGenerator();
        String email = obj.generate();

        String key = "zhou.wei@hinacom.com";
        Assert.assertNotNull(email);
        Assert.assertEquals(email,key);
    }
}

