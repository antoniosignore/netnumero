// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ColorUtils.java

package com.dtmc.server.analytics.util;

import java.awt.Color;
import java.util.HashMap;

public class ColorUtils
{

    public ColorUtils()
    {
    }

    public static HashMap getColors()
    {
        return _colors;
    }

    public static Color findColor(String key)
    {
        return (Color)_colors.get(key);
    }

    public static final Color aliceblue;
    public static final Color antiquewhite;
    public static final Color aqua;
    public static final Color aquamarine;
    public static final Color azure;
    public static final Color beige;
    public static final Color bisque;
    public static final Color black;
    public static final Color blanchedalmond;
    public static final Color blue;
    public static final Color blueviolet;
    public static final Color brown;
    public static final Color burlywood;
    public static final Color cadetblue;
    public static final Color chartreuse;
    public static final Color chocolate;
    public static final Color coral;
    public static final Color cornflowerblue;
    public static final Color cornsilk;
    public static final Color crimson;
    public static final Color cyan;
    public static final Color darkblue;
    public static final Color darkcyan;
    public static final Color darkgoldenrod;
    public static final Color darkgray;
    public static final Color darkgreen;
    public static final Color darkkhaki;
    public static final Color darkmagenta;
    public static final Color darkolivegreen;
    public static final Color darkorange;
    public static final Color darkorchid;
    public static final Color darkred;
    public static final Color darksalmon;
    public static final Color darkseagreen;
    public static final Color darkslateblue;
    public static final Color darkslategray;
    public static final Color darkturquoise;
    public static final Color darkviolet;
    public static final Color deeppink;
    public static final Color deepskyblue;
    public static final Color dimgray;
    public static final Color dodgerblue;
    public static final Color firebrick;
    public static final Color floralwhite;
    public static final Color forestgreen;
    public static final Color fuchsia;
    public static final Color gainsboro;
    public static final Color ghostwhite;
    public static final Color gold;
    public static final Color goldenrod;
    public static final Color gray;
    public static final Color green;
    public static final Color greenyellow;
    public static final Color honeydew;
    public static final Color hotpink;
    public static final Color indianred;
    public static final Color indigo;
    public static final Color ivory;
    public static final Color khaki;
    public static final Color lavender;
    public static final Color lavenderblush;
    public static final Color lawngreen;
    public static final Color lemonchiffon;
    public static final Color lightblue;
    public static final Color lightcoral;
    public static final Color lightcyan;
    public static final Color lightgoldenrodyellow;
    public static final Color lightgreen;
    public static final Color lightgrey;
    public static final Color lightpink;
    public static final Color lightsalmon;
    public static final Color lightseagreen;
    public static final Color lightskyblue;
    public static final Color lightslategray;
    public static final Color lightsteelblue;
    public static final Color lightyellow;
    public static final Color lime;
    public static final Color limegreen;
    public static final Color linen;
    public static final Color magenta;
    public static final Color maroon;
    public static final Color mediumaquamarine;
    public static final Color mediumblue;
    public static final Color mediumorchid;
    public static final Color mediumpurple;
    public static final Color mediumseagreen;
    public static final Color mediumslateblue;
    public static final Color mediumspringgreen;
    public static final Color mediumturquoise;
    public static final Color mediumvioletred;
    public static final Color midnightblue;
    public static final Color mintcream;
    public static final Color mistyrose;
    public static final Color mocassin;
    public static final Color navajowhite;
    public static final Color navy;
    public static final Color oldlace;
    public static final Color olive;
    public static final Color olivedrab;
    public static final Color orange;
    public static final Color orangered;
    public static final Color orchid;
    public static final Color palegoldenrod;
    public static final Color palegreen;
    public static final Color paleturquoise;
    public static final Color palevioletred;
    public static final Color papayawhip;
    public static final Color peachpuff;
    public static final Color peru;
    public static final Color pink;
    public static final Color plum;
    public static final Color powderblue;
    public static final Color purple;
    public static final Color red;
    public static final Color rosybrown;
    public static final Color royalblue;
    public static final Color saddlebrown;
    public static final Color salmon;
    public static final Color sandybrown;
    public static final Color seagreen;
    public static final Color seashell;
    public static final Color sienna;
    public static final Color silver;
    public static final Color skyblue;
    public static final Color slateblue;
    public static final Color slategray;
    public static final Color snow;
    public static final Color springgreen;
    public static final Color steelblue;
    public static final Color tan;
    public static final Color teal;
    public static final Color thistle;
    public static final Color tomato;
    public static final Color turquoise;
    public static final Color violet;
    public static final Color wheat;
    public static final Color white;
    public static final Color whitesmoke;
    public static final Color yellow;
    public static final Color yellowgreen;
    private static HashMap _colors;
    private static Object data[][];

    static 
    {
        aliceblue = new Color(240, 248, 255);
        antiquewhite = new Color(250, 235, 215);
        aqua = new Color(0, 255, 255);
        aquamarine = new Color(127, 255, 212);
        azure = new Color(240, 255, 255);
        beige = new Color(245, 245, 220);
        bisque = new Color(255, 228, 196);
        black = new Color(0, 0, 0);
        blanchedalmond = new Color(255, 255, 205);
        blue = new Color(0, 0, 255);
        blueviolet = new Color(138, 43, 226);
        brown = new Color(165, 42, 42);
        burlywood = new Color(222, 184, 135);
        cadetblue = new Color(95, 158, 160);
        chartreuse = new Color(127, 255, 0);
        chocolate = new Color(210, 105, 30);
        coral = new Color(255, 127, 80);
        cornflowerblue = new Color(100, 149, 237);
        cornsilk = new Color(255, 248, 220);
        crimson = new Color(220, 20, 60);
        cyan = new Color(0, 255, 255);
        darkblue = new Color(0, 0, 139);
        darkcyan = new Color(0, 139, 139);
        darkgoldenrod = new Color(184, 134, 11);
        darkgray = new Color(169, 169, 169);
        darkgreen = new Color(0, 100, 0);
        darkkhaki = new Color(189, 183, 107);
        darkmagenta = new Color(139, 0, 139);
        darkolivegreen = new Color(85, 107, 47);
        darkorange = new Color(255, 140, 0);
        darkorchid = new Color(153, 50, 204);
        darkred = new Color(139, 0, 0);
        darksalmon = new Color(233, 150, 122);
        darkseagreen = new Color(143, 188, 143);
        darkslateblue = new Color(72, 61, 139);
        darkslategray = new Color(47, 79, 79);
        darkturquoise = new Color(0, 206, 209);
        darkviolet = new Color(148, 0, 211);
        deeppink = new Color(255, 20, 147);
        deepskyblue = new Color(0, 191, 255);
        dimgray = new Color(105, 105, 105);
        dodgerblue = new Color(30, 144, 255);
        firebrick = new Color(178, 34, 34);
        floralwhite = new Color(255, 250, 240);
        forestgreen = new Color(34, 139, 34);
        fuchsia = new Color(255, 0, 255);
        gainsboro = new Color(220, 220, 220);
        ghostwhite = new Color(248, 248, 255);
        gold = new Color(255, 215, 0);
        goldenrod = new Color(218, 165, 32);
        gray = new Color(128, 128, 128);
        green = new Color(0, 128, 0);
        greenyellow = new Color(173, 255, 47);
        honeydew = new Color(240, 255, 240);
        hotpink = new Color(255, 105, 180);
        indianred = new Color(205, 92, 92);
        indigo = new Color(75, 0, 130);
        ivory = new Color(255, 240, 240);
        khaki = new Color(240, 230, 140);
        lavender = new Color(230, 230, 250);
        lavenderblush = new Color(255, 240, 245);
        lawngreen = new Color(124, 252, 0);
        lemonchiffon = new Color(255, 250, 205);
        lightblue = new Color(173, 216, 230);
        lightcoral = new Color(240, 128, 128);
        lightcyan = new Color(224, 255, 255);
        lightgoldenrodyellow = new Color(250, 250, 210);
        lightgreen = new Color(144, 238, 144);
        lightgrey = new Color(211, 211, 211);
        lightpink = new Color(255, 182, 193);
        lightsalmon = new Color(255, 160, 122);
        lightseagreen = new Color(32, 178, 170);
        lightskyblue = new Color(135, 206, 250);
        lightslategray = new Color(119, 136, 153);
        lightsteelblue = new Color(176, 196, 222);
        lightyellow = new Color(255, 255, 224);
        lime = new Color(0, 255, 0);
        limegreen = new Color(50, 205, 50);
        linen = new Color(250, 240, 230);
        magenta = new Color(255, 0, 255);
        maroon = new Color(128, 0, 0);
        mediumaquamarine = new Color(102, 205, 170);
        mediumblue = new Color(0, 0, 205);
        mediumorchid = new Color(186, 85, 211);
        mediumpurple = new Color(147, 112, 219);
        mediumseagreen = new Color(60, 179, 113);
        mediumslateblue = new Color(123, 104, 238);
        mediumspringgreen = new Color(0, 250, 154);
        mediumturquoise = new Color(72, 209, 204);
        mediumvioletred = new Color(199, 21, 133);
        midnightblue = new Color(25, 25, 112);
        mintcream = new Color(245, 255, 250);
        mistyrose = new Color(255, 228, 225);
        mocassin = new Color(255, 228, 181);
        navajowhite = new Color(255, 222, 173);
        navy = new Color(0, 0, 128);
        oldlace = new Color(253, 245, 230);
        olive = new Color(128, 128, 0);
        olivedrab = new Color(107, 142, 35);
        orange = new Color(255, 165, 0);
        orangered = new Color(255, 69, 0);
        orchid = new Color(218, 112, 214);
        palegoldenrod = new Color(238, 232, 170);
        palegreen = new Color(152, 251, 152);
        paleturquoise = new Color(175, 238, 238);
        palevioletred = new Color(219, 112, 147);
        papayawhip = new Color(255, 239, 213);
        peachpuff = new Color(255, 218, 185);
        peru = new Color(205, 133, 63);
        pink = new Color(255, 192, 203);
        plum = new Color(221, 160, 221);
        powderblue = new Color(176, 224, 230);
        purple = new Color(128, 0, 128);
        red = new Color(255, 0, 0);
        rosybrown = new Color(188, 143, 143);
        royalblue = new Color(65, 105, 225);
        saddlebrown = new Color(139, 69, 19);
        salmon = new Color(250, 128, 114);
        sandybrown = new Color(244, 164, 96);
        seagreen = new Color(46, 139, 87);
        seashell = new Color(255, 245, 238);
        sienna = new Color(160, 82, 45);
        silver = new Color(192, 192, 192);
        skyblue = new Color(135, 206, 235);
        slateblue = new Color(106, 90, 205);
        slategray = new Color(112, 128, 144);
        snow = new Color(255, 250, 250);
        springgreen = new Color(0, 255, 127);
        steelblue = new Color(70, 138, 180);
        tan = new Color(210, 180, 140);
        teal = new Color(0, 128, 128);
        thistle = new Color(216, 191, 216);
        tomato = new Color(253, 99, 71);
        turquoise = new Color(64, 224, 208);
        violet = new Color(238, 130, 238);
        wheat = new Color(245, 222, 179);
        white = new Color(255, 255, 255);
        whitesmoke = new Color(245, 245, 245);
        yellow = new Color(255, 255, 0);
        yellowgreen = new Color(154, 205, 50);
        data = (new Object[][] {
            new Object[] {
                "aliceblue", aliceblue
            }, new Object[] {
                "antiquewhite", antiquewhite
            }, new Object[] {
                "aqua", aqua
            }, new Object[] {
                "aquamarine", aquamarine
            }, new Object[] {
                "azure", azure
            }, new Object[] {
                "beige", beige
            }, new Object[] {
                "bisque", bisque
            }, new Object[] {
                "black", black
            }, new Object[] {
                "blanchedalmond", blanchedalmond
            }, new Object[] {
                "blue", blue
            }, new Object[] {
                "blueviolet", blueviolet
            }, new Object[] {
                "brown", brown
            }, new Object[] {
                "burlywood", burlywood
            }, new Object[] {
                "cadetblue", cadetblue
            }, new Object[] {
                "chartreuse", chartreuse
            }, new Object[] {
                "chocolate", chocolate
            }, new Object[] {
                "coral", coral
            }, new Object[] {
                "cornflowerblue", cornflowerblue
            }, new Object[] {
                "cornsilk", cornsilk
            }, new Object[] {
                "crimson", crimson
            }, new Object[] {
                "cyan", cyan
            }, new Object[] {
                "darkblue", darkblue
            }, new Object[] {
                "darkcyan", darkcyan
            }, new Object[] {
                "darkgoldenrod", darkgoldenrod
            }, new Object[] {
                "darkgray", darkgray
            }, new Object[] {
                "darkgreen", darkgreen
            }, new Object[] {
                "darkkhaki", darkkhaki
            }, new Object[] {
                "darkmagenta", darkmagenta
            }, new Object[] {
                "darkolivegreen", darkolivegreen
            }, new Object[] {
                "darkorange", darkorange
            }, new Object[] {
                "darkorchid", darkorchid
            }, new Object[] {
                "darkred", darkred
            }, new Object[] {
                "darksalmon", darksalmon
            }, new Object[] {
                "darkseagreen", darkseagreen
            }, new Object[] {
                "darkslateblue", darkslateblue
            }, new Object[] {
                "darkslategray", darkslategray
            }, new Object[] {
                "darkturquoise", darkturquoise
            }, new Object[] {
                "darkviolet", darkviolet
            }, new Object[] {
                "deeppink", deeppink
            }, new Object[] {
                "deepskyblue", deepskyblue
            }, new Object[] {
                "dimgray", dimgray
            }, new Object[] {
                "dodgerblue", dodgerblue
            }, new Object[] {
                "firebrick", firebrick
            }, new Object[] {
                "floralwhite", floralwhite
            }, new Object[] {
                "forestgreen", forestgreen
            }, new Object[] {
                "fuchsia", fuchsia
            }, new Object[] {
                "gainsboro", gainsboro
            }, new Object[] {
                "ghostwhite", ghostwhite
            }, new Object[] {
                "gold", gold
            }, new Object[] {
                "goldenrod", goldenrod
            }, new Object[] {
                "gray", gray
            }, new Object[] {
                "green", green
            }, new Object[] {
                "greenyellow", greenyellow
            }, new Object[] {
                "honeydew", honeydew
            }, new Object[] {
                "hotpink", hotpink
            }, new Object[] {
                "indianred", indianred
            }, new Object[] {
                "indigo", indigo
            }, new Object[] {
                "ivory", ivory
            }, new Object[] {
                "khaki", khaki
            }, new Object[] {
                "lavender", lavender
            }, new Object[] {
                "lavenderblush", lavenderblush
            }, new Object[] {
                "lawngreen", lawngreen
            }, new Object[] {
                "lemonchiffon", lemonchiffon
            }, new Object[] {
                "lightblue", lightblue
            }, new Object[] {
                "lightcoral", lightcoral
            }, new Object[] {
                "lightcyan", lightcyan
            }, new Object[] {
                "lightgoldenrodyellow", lightgoldenrodyellow
            }, new Object[] {
                "lightgreen", lightgreen
            }, new Object[] {
                "lightgrey", lightgrey
            }, new Object[] {
                "lightpink", lightpink
            }, new Object[] {
                "lightsalmon", lightsalmon
            }, new Object[] {
                "lightseagreen", lightseagreen
            }, new Object[] {
                "lightskyblue", lightskyblue
            }, new Object[] {
                "lightslategray", lightslategray
            }, new Object[] {
                "lightsteelblue", lightsteelblue
            }, new Object[] {
                "lightyellow", lightyellow
            }, new Object[] {
                "lime", lime
            }, new Object[] {
                "limegreen", limegreen
            }, new Object[] {
                "linen", linen
            }, new Object[] {
                "magenta", magenta
            }, new Object[] {
                "maroon", maroon
            }, new Object[] {
                "mediumaquamarine", mediumaquamarine
            }, new Object[] {
                "mediumblue", mediumblue
            }, new Object[] {
                "mediumorchid", mediumorchid
            }, new Object[] {
                "mediumpurple", mediumpurple
            }, new Object[] {
                "mediumseagreen", mediumseagreen
            }, new Object[] {
                "mediumslateblue", mediumslateblue
            }, new Object[] {
                "mediumspringgreen", mediumspringgreen
            }, new Object[] {
                "mediumturquoise", mediumturquoise
            }, new Object[] {
                "mediumvioletred", mediumvioletred
            }, new Object[] {
                "midnightblue", midnightblue
            }, new Object[] {
                "mintcream", mintcream
            }, new Object[] {
                "mistyrose", mistyrose
            }, new Object[] {
                "moccasin", mocassin
            }, new Object[] {
                "navajowhite", navajowhite
            }, new Object[] {
                "navy", navy
            }, new Object[] {
                "oldlace", oldlace
            }, new Object[] {
                "olive", olive
            }, new Object[] {
                "olivedrab", olivedrab
            }, new Object[] {
                "orange", orange
            }, new Object[] {
                "orangered", orangered
            }, new Object[] {
                "orchid", orchid
            }, new Object[] {
                "palegoldenrod", palegoldenrod
            }, new Object[] {
                "palegreen", palegreen
            }, new Object[] {
                "paleturquoise", paleturquoise
            }, new Object[] {
                "palevioletred", palevioletred
            }, new Object[] {
                "papayawhip", papayawhip
            }, new Object[] {
                "peachpuff", peachpuff
            }, new Object[] {
                "peru", peru
            }, new Object[] {
                "pink", pink
            }, new Object[] {
                "plum", plum
            }, new Object[] {
                "powderblue", powderblue
            }, new Object[] {
                "purple", purple
            }, new Object[] {
                "red", red
            }, new Object[] {
                "rosybrown", rosybrown
            }, new Object[] {
                "royalblue", royalblue
            }, new Object[] {
                "saddlebrown", saddlebrown
            }, new Object[] {
                "salmon", salmon
            }, new Object[] {
                "sandybrown", sandybrown
            }, new Object[] {
                "seagreen", seagreen
            }, new Object[] {
                "seashell", seashell
            }, new Object[] {
                "sienna", sienna
            }, new Object[] {
                "silver", silver
            }, new Object[] {
                "skyblue", skyblue
            }, new Object[] {
                "slateblue", slateblue
            }, new Object[] {
                "slategray", slategray
            }, new Object[] {
                "snow", snow
            }, new Object[] {
                "springgreen", springgreen
            }, new Object[] {
                "steelblue", steelblue
            }, new Object[] {
                "tan", tan
            }, new Object[] {
                "teal", teal
            }, new Object[] {
                "thistle", thistle
            }, new Object[] {
                "tomato", tomato
            }, new Object[] {
                "turquoise", turquoise
            }, new Object[] {
                "violet", violet
            }, new Object[] {
                "wheat", wheat
            }, new Object[] {
                "white", white
            }, new Object[] {
                "whitesmoke", whitesmoke
            }, new Object[] {
                "yellow", yellow
            }, new Object[] {
                "yellowgreen", yellowgreen
            }
        });
        _colors = new HashMap();
        for(int i = 0; i < data.length; i++)
        {
            Object row[] = data[i];
            _colors.put(row[0], row[1]);
        }

    }
}
