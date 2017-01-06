package com.project.blejder.everycounter;

import android.content.res.AssetManager;
import android.graphics.Typeface;

public class Fonts {

    public static RobotoFont roboto;

    static void initialize(AssetManager assets) {
        roboto = new RobotoFont();
        roboto.black = Typeface.createFromAsset(assets, path("Roboto-Black"));
        roboto.blackItalic = Typeface.createFromAsset(assets, path("Roboto-BlackItalic"));
        roboto.bold = Typeface.createFromAsset(assets, path("Roboto-Bold"));
        roboto.boldItalic = Typeface.createFromAsset(assets, path("Roboto-BoldItalic"));
        roboto.italic = Typeface.createFromAsset(assets, path("Roboto-Italic"));
        roboto.light = Typeface.createFromAsset(assets, path("Roboto-Light"));
        roboto.lightItalic = Typeface.createFromAsset(assets, path("Roboto-LightItalic"));
        roboto.medium = Typeface.createFromAsset(assets, path("Roboto-Medium"));
        roboto.mediumItalic = Typeface.createFromAsset(assets, path("Roboto-MediumItalic"));
        roboto.regular = Typeface.createFromAsset(assets, path("Roboto-Regular"));
        roboto.thin = Typeface.createFromAsset(assets, path("Roboto-Thin"));
        roboto.thinItalic = Typeface.createFromAsset(assets, path("Roboto-ThinItalic"));
    }

    private static String path(String filename) {
        return "font-roboto/" + filename + ".ttf";
    }

    public static class RobotoFont {

        RobotoFont() {}

        public Typeface black;
        public Typeface blackItalic;
        public Typeface bold;
        public Typeface boldItalic;
        public Typeface italic;
        public Typeface light;
        public Typeface lightItalic;
        public Typeface medium;
        public Typeface mediumItalic;
        public Typeface regular;
        public Typeface thin;
        public Typeface thinItalic;
    }
}
