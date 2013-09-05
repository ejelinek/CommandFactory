package com.yahoo.search;

import com.yahoo.commands.IsLoadedCommand;
import com.yahoo.factories.CommandFactory;
import com.yahoo.factories.YahooPageFactory;
import com.yahoo.pages.YahooResultsPage;
import com.yahoo.pages.YahooSearchPage;
import org.junit.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class SearchTest {
    private static WebDriver driver = new FirefoxDriver();
    private static List<IsLoadedCommand> searchCommands;
    private static List<IsLoadedCommand> resultsCommands;
    private static YahooSearchPage searchPage;


    @BeforeClass
    public static void setupClass() {
        driver.get("http://search.yahoo.com");
        searchCommands = CommandFactory.getYahooSearchPageCommands(driver);
        searchPage = YahooPageFactory.createYahooSearchPage(driver, searchCommands);

    }

    @Test
    public void testYahooSearch() {
        searchPage.setQuery("WebDriver");
        YahooResultsPage resultsPage = searchPage.search();
        Assert.assertTrue(resultsPage.getTitleOfFirstResult().contains("WebDriver"));
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}
