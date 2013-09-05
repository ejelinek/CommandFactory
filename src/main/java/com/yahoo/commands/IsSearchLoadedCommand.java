package com.yahoo.commands;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IsSearchLoadedCommand implements IsLoadedCommand {
    private WebDriver driver;

    public IsSearchLoadedCommand(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void isLoaded() {
        Assert.assertEquals("Search button not found", 1, driver.findElements(By.id("yschbt")).size());
    }
}
