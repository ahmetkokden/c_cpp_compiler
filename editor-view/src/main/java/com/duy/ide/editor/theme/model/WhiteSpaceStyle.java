package com.duy.ide.editor.theme.model;

import android.graphics.Color;

import com.duy.common.DLog;

import java.util.Properties;

public class WhiteSpaceStyle extends ColorScheme {

    private static final String TAG = "WhiteSpaceStyle";
    private int block = Color.TRANSPARENT;
    private int fold = Color.TRANSPARENT;
    private int space = Color.TRANSPARENT;
    private int tab = Color.TRANSPARENT;
    private int whitespace = Color.TRANSPARENT;

    public WhiteSpaceStyle() {

    }

    public WhiteSpaceStyle(int block, int fold, int space, int tab, int whitespace) {
        this.block = block;
        this.fold = fold;
        this.space = space;
        this.tab = tab;
        this.whitespace = whitespace;
    }

    public int getBlock() {
        return block;
    }

    public int getFold() {
        return fold;
    }

    public int getSpace() {
        return space;
    }

    public int getTab() {
        return tab;
    }

    public int getWhitespace() {
        return whitespace;
    }

    @Override
    public void load(Properties properties) {
        for (Attr attr : Attr.values()) {
            try {
                String color = properties.getProperty(attr.getKey());
                put(attr.getKey(), Color.parseColor(color));
            } catch (Exception ignored) {
                if (DLog.DEBUG) DLog.w(TAG, "load: failed " + attr.key);
            }
        }
    }

    public enum Attr {
        BLOCK_COLOR("white-space.block-color"),
        FOLD_COLOR("white-space.fold-color"),
        SPACE_COLOR("white-space.space-color"),
        TAB_COLOR("white-space.tab-color"),
        WHITESPACE_COLOR("white-space.whitespace-color");

        private String key;

        Attr(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }
    }
}