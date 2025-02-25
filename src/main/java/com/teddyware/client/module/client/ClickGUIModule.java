package com.teddyware.client.module.client;

import com.teddyware.api.event.events.EventPlayerUpdate;
import com.teddyware.client.Teddyware;
import com.teddyware.client.module.Category;
import com.teddyware.client.module.Module;
import com.teddyware.client.setting.settings.ColorSetting;
import com.teddyware.client.setting.settings.ModeSetting;
import com.teddyware.client.setting.settings.NumberSetting;
import com.teddyware.api.util.color.JColor;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import org.lwjgl.input.Keyboard;

@Module.Data(name = "ClickGUI", description = "A GUI for modules and settings.", key = Keyboard.KEY_RSHIFT, category = Category.Client)
public class ClickGUIModule extends Module {

    public static ClickGUIModule INSTANCE;

    public ModeSetting description = new ModeSetting("Description", this, "Mouse", "Mouse", "Fixed");
    public ColorSetting enabledColor = new ColorSetting("EnabledColor", this, new JColor(120,63,4, 255));
    public ColorSetting backgroundColor = new ColorSetting("InactiveColor", this, new JColor(0, 0, 0, 255));
    public ColorSetting settingBackgroundColor = new ColorSetting("BackgroundColor", this, new JColor(0, 0, 0, 255));
    public ColorSetting outlineColor = new ColorSetting("SettingsHighlight", this, new JColor(255, 255, 255, 255));
    public ColorSetting fontColor = new ColorSetting("CategoryColor", this, new JColor(120,63,4,255));
    public NumberSetting animationSpeed = new NumberSetting("AnimSpeed", this, 150, 0, 1000, 1);
    public NumberSetting opacity = new NumberSetting("Opacity", this, 255, 0, 255, 1);
    public NumberSetting scrollSpeed = new NumberSetting("ScrollSpeed", this, 10, 0, 50, 1);
    public ModeSetting scrollMode = new ModeSetting("ScrollMode", this, "GUI", "Panel", "GUI");

    public static ClickGUIModule getInstance() {
        return INSTANCE;
    }

    public ClickGUIModule() {
        this.addSetting(enabledColor, backgroundColor, settingBackgroundColor, outlineColor, fontColor, animationSpeed, opacity, scrollSpeed, description, scrollMode);
        this.arrayListInfo = description.getMode() + ", " + scrollMode.getMode();
        INSTANCE = this;
    }

    public void onEnable() {
        Teddyware.instance.clickGUIScreen.enterGUI();
    }

    @Override
    public void onUpdate() {
        if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
            toggle();
        }
    }

    public void onDisable() {

    }
}
