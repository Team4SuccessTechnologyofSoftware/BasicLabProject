package com.example.steve.basiclabproject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by ADIS HP on 12/14/2017.
 */
@RunWith(JUnit4.class)
public class productUnitTest {



    @Test
    public void createProjectObject(){
        product mProduct = new product();
        mProduct.setDesc("myDesc");
        mProduct.setName("myName");
        mProduct.setPrice("100");
        //assert
        Assert.assertEquals("Are not equal","myDesc",mProduct.getDesc());
        Assert.assertEquals("Are not equal","myName",mProduct.getName());
        Assert.assertEquals("Are not equal","100",mProduct.getPrice());

    }


}
