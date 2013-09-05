package com.yahoo.pages;

import com.yahoo.commands.IsLoadedCommand;
import com.yahoo.factories.CommandFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.List;

public class YahooSearchPage extends LoadableComponent<YahooSearchPage> {
    private WebDriver driver;
    private List<IsLoadedCommand> commands;

    @FindBy(id = "yschsp")
    private WebElement query;

    @FindBy(id = "yschbt")
    private WebElement search;

    public YahooSearchPage(WebDriver webDriver, List<IsLoadedCommand> isLoadedCommands) {
        driver = webDriver;
        commands = isLoadedCommands;
        PageFactory.initElements(driver, this);
    }

    public void setQuery(String searchQuery) {
        query.sendKeys(searchQuery);
    }

    public YahooResultsPage search() {
        search.click();
        return new YahooResultsPage(driver, CommandFactory.getYahooResultsPageCommands(driver));
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
