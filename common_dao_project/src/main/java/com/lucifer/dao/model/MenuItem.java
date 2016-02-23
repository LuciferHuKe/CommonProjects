package com.lucifer.dao.model;

/**
 * Created by lucifer on 15/8/16.
 */
public class MenuItem {

    public MenuItem(boolean isSelected, String text, int icon, int iconSelected) {
        this.isSelected = isSelected;
        this.text = text;
        this.icon = icon;
        this.iconSelected = iconSelected;
    }

    public boolean isSelected;

    public String text;

    public int icon;

    public int iconSelected;
}
