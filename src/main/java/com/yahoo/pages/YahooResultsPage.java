package com.yahoo.pages;

import com.yahoo.commands.IsLoadedCommand;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import java.util.List;

public class YahooResultsPage extends LoadableComponent<YahooResultsPage> {
    private List<IsLoadedCommand> commands;
    private WebDriver driver;

    public YahooResultsPage(WebDriver webDriver, List<IsLoadedCommand> isLoadedCommands) {
        driver = webDriver;
        commands = isLoadedCommands;
        PageFactory.initElements(driver, this);
    }

    public String getTitleOfFirstResult() {
        return driver.findElement(By.id("link-1")).getText();
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        for (IsLoadedCommand command : commands) {
            command.isLoaded();
        }
    }
}
