package com.spbstu.webdriver2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by luck on 14.03.17.
 */
public class SimpleTest extends BaseTest {

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {"spbstu", Arrays.asList(
                        "www.spbstu.ru/",
                        "https://openedu.ru/university/spbstu/",
                        "https://vk.com/spbstu")},
                {"itmo", Arrays.asList(
                        "www.ifmo.ru/",
                        "https://ru.wikipedia.org/wiki/Университет_ИТМО",
                        "https://ru.wikipedia.org/wiki/ИТМО_(значения)")}
        };
    }

    @Test(dataProvider = "data")
    public void test1(String searchString, List<String> expected) {
        driver.navigate().to("http://www.google.com");
        WebElement element = driver.findElement(By.id("lst-ib"));
        element.sendKeys(searchString + Keys.ENTER);
        List<String> actual = driver.findElements(By.xpath("//*[@id='res']//div[@class='g']//cite"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());


        expected.forEach((e) -> {
            softAssert.assertTrue(actual.stream().anyMatch(ee -> ee.contains(e)),
                    String.format("Element: %s is missing", e));
            softAssert.assertAll();
        });

//        Assert.assertTrue(elements.stream().anyMatch(e -> e.getText().contains(expected)));
    }

    @Test(groups = "regression")
    public void test2() {

    }
}
