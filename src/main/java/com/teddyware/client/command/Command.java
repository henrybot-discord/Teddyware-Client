package com.teddyware.client.command;

import com.teddyware.api.util.ChatUtil;

import java.util.Arrays;
import java.util.List;

public abstract class Command {
    public String name;
    public String description;
    public String syntax;
    public List<String> aliases;

    public Command(String name, String description, String syntax, String... aliases) {
        this.name = name;
        this.description = description;
        this.syntax = syntax;
        this.aliases = Arrays.asList(aliases);
    }

    public abstract void onCommand(String[] args, String command);

    public String getName() {
        return name.toLowerCase();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSyntax() {
        return syntax;
    }

    public void setSyntax(String syntax) {
        this.syntax = syntax;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public void sendError() {
        ChatUtil.type("The correct syntax for " + getName() + " is " + getSyntax() + ". Try again.");
    }

}
