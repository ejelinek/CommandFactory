package com.yahoo.commands;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IsSideBarLoadedCommand implements IsLoadedCommand {
    private WebDriver webDriver;

    public IsSideBarLoadedCommand(WebDriver driver) {
        webDriver = driver;
    }

    @Override
    public void isLoaded() {
        Assert.assertEquals("Side bar not found or too many found", 1, webDriver.findElements(By.id("sidebar")).size());
    }
}
