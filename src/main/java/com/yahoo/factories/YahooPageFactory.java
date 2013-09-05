package com.yahoo.factories;

import com.yahoo.commands.IsLoadedCommand;
import com.yahoo.pages.YahooResultsPage;
import com.yahoo.pages.YahooSearchPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class YahooPageFactory {
    public static YahooSearchPage createYahooSearchPage(WebDriver driver, List<IsLoadedCommand> commands) {
        return new YahooSearchPage(driver, commands).get();
    }

    public static YahooResultsPage createYahooResultsPage(WebDriver driver, List<IsLoadedCommand> commands) {
        return new YahooResultsPage(driver, commands).get();
    }
}
