package com.yahoo.factories;

import com.yahoo.commands.IsLoadedCommand;
import com.yahoo.commands.IsQueryLoadedCommand;
import com.yahoo.commands.IsSearchLoadedCommand;
import com.yahoo.commands.IsSideBarLoadedCommand;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class CommandFactory {
    private static List<IsLoadedCommand> commands;
    private static List<IsLoadedCommand> resultCommands;
    public static List<IsLoadedCommand> getYahooSearchPageCommands(WebDriver driver) {
        commands = new ArrayList<IsLoadedCommand>();
        commands.add(new IsQueryLoadedCommand(driver));
        commands.add(new IsSearchLoadedCommand(driver));
        return commands;
    }

    public static List<IsLoadedCommand> getYahooResultsPageCommands(WebDriver driver) {
        resultCommands = new ArrayList<IsLoadedCommand>();
        resultCommands.add(new IsSideBarLoadedCommand(driver));
        return resultCommands;
    }
}
