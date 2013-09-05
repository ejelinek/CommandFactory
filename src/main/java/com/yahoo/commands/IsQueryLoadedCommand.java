package com.yahoo.commands;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IsQueryLoadedCommand implements IsLoadedCommand {
    private WebDriver driver;

    public IsQueryLoadedCommand(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void isLoaded() {
        Assert.assertEquals("Search box not found or too many found", 1, driver.findElements(By.id("yschsp")).size());
    }
}
