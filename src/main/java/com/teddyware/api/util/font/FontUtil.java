package com.teddyware.api.util.font;

import java.awt.*;
import java.io.InputStream;

import com.teddyware.api.util.TimerUtil;
import com.teddyware.api.util.UtilInterface;
import com.teddyware.api.util.color.JColor;
import com.teddyware.client.Teddyware;
import com.teddyware.client.module.ModuleManager;
import com.teddyware.client.module.client.CustomFont;

public class FontUtil implements UtilInterface {

    public static final FontRenderer ubuntuFont = new FontRenderer("Ubuntu", 18.5f);
    public static final FontRenderer latoFont = new FontRenderer("Lato", 18.5f);
    public static final FontRenderer verdanaFont = new FontRenderer("Verdana", 18.5f);
    public static final FontRenderer comfortaaFont = new FontRenderer("Comfortaa", 18.5f);
    public static final FontRenderer ralewayFont = new FontRenderer("Raleway", 18.5f);
    public static final FontRenderer comicSansFont = new FontRenderer("ComicSans", 18.5f);

    public static FontRenderer getCurrentCustomFont() {
        switch (CustomFont.font.getMode()) {
            case "Ubuntu":
                return ubuntuFont;
            case "Lato":
                return latoFont;
            case "Verdana":
                return verdanaFont;
            case "Comfortaa":
                return comfortaaFont;
            case "Raleway":
                return ralewayFont;
            case "ComicSans":
                return comicSansFont;
        }

        return ubuntuFont;
    }

    public static void drawStringWithShadow(String text, float x, float y, JColor color) {
        if (ModuleManager.getModule("CustomFont").isToggled()) {
            getCurrentCustomFont().drawStringWithShadow(text, x, y, color.getRGB());
        } else {
            mc.fontRenderer.drawStringWithShadow(text, x, y, color.getRGB());
        }
    }

    public static void drawString(String text, float x, float y, JColor color) {
        if (ModuleManager.getModule("CustomFont").isToggled()) {
            getCurrentCustomFont().drawString(text, x, y, color.getRGB());
        } else {
            mc.fontRenderer.drawString(text, (int) x, (int) y, color.getRGB());
        }
    }

    public static float getStringWidth(String text) {
        if (ModuleManager.getModule("CustomFont").isToggled()) {
            return getCurrentCustomFont().getStringWidth(text);
        } else {
            return mc.fontRenderer.getStringWidth(text);
        }
    }

    public static float getStringHeight(String text) {
        if (ModuleManager.getModule("CustomFont").isToggled()) {
            return getCurrentCustomFont().getStringHeight(text);
        } else {
            return mc.fontRenderer.FONT_HEIGHT;
        }
    }

}
