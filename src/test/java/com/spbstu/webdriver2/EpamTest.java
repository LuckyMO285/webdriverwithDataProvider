package com.spbstu.webdriver2;

import com.spbstu.pageobjects.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by luck on 04.04.17.
 */
public class EpamTest extends BaseTest{

    @Test
    public void loginTest(){
        HomePage.open();
        HomePage.openLoginForm();
        HomePage.setLogin("epam");
        HomePage.setPassword("1234");
        HomePage.submitLoginForm();

        String actualName = HomePage.getUserName();
        String expectedName = "Piter Chailovskii";

        Assert.assertEquals(expectedName.toLowerCase(), actualName.toLowerCase());
    }
}

