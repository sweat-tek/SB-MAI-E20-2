/*
 * @(#)SVGConstants.java  1.0  November 28, 2006
 *
 * Copyright (c) 1996-2007 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 *
 * The copyright of this software is owned by the authors and  
 * contributors of the JHotDraw project ("the copyright holders").  
 * You may not use, copy or modify this software, except in  
 * accordance with the license agreement you entered into with  
 * the copyright holders. For details see accompanying license terms. 
 */
package org.jhotdraw.samples.svg;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import javax.swing.*;
import org.jhotdraw.draw.*;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.*;

/**
 * SVGConstants.
 *
 * @author Daniel S
 * @version 1.1 November 20, 2020 Created.
 */
public class SVGConstants {

    public final static String SVG_NAMESPACE = "http://www.w3.org/2000/svg";
    public final static String SVG_MIMETYPE = "image/svg+xml";
    public final static Map<String, Color> SVG_COLORS;

    private static String[] colors = {"SVG1.2_TinyColors.txt", "SVG1.1_Colors.txt"};
    private static String[] sysColor = {"SVG1.2_TinySystemColors.txt"};
    
     private static LinkedHashMap<String, Color> map;
static {
        map = new LinkedHashMap<String, Color>();

        readColorsFromFile();
        readSysColors();

        SVG_COLORS = Collections.unmodifiableMap(map);
    }

    private static void readColorsFromFile() {

        for (int i = 0; i < 2; i++) {
            try {
                File myObj = new File(colors[i]);
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String[] line = data.split(",");
                    map.put(line[0], new Color(Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3])));
                }
                myReader.close();

            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }

    private static void readSysColors() {
        try {
            File myObj = new File(sysColor[0]);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] line = data.split(",");
                map.put(line[0], UIManager.getColor(line[1]));
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public final static Map<String, WindingRule> SVG_FILL_RULES;

    static {
        HashMap<String, WindingRule> m = new HashMap<String, WindingRule>();
        m.put("nonzero", WindingRule.NON_ZERO);
        m.put("evenodd", WindingRule.EVEN_ODD);
        SVG_FILL_RULES = Collections.unmodifiableMap(m);
    }
    public final static Map<String, Integer> SVG_STROKE_LINECAPS;

    static {
        HashMap<String, Integer> m = new HashMap<String, Integer>();
        m.put("butt", BasicStroke.CAP_BUTT);
        m.put("round", BasicStroke.CAP_ROUND);
        m.put("square", BasicStroke.CAP_SQUARE);
        SVG_STROKE_LINECAPS = Collections.unmodifiableMap(m);
    }
    public final static Map<String, Integer> SVG_STROKE_LINEJOINS;

    static {
        HashMap<String, Integer> m = new HashMap<String, Integer>();
        m.put("miter", BasicStroke.JOIN_MITER);
        m.put("round", BasicStroke.JOIN_ROUND);
        m.put("bevel", BasicStroke.JOIN_BEVEL);
        SVG_STROKE_LINEJOINS = Collections.unmodifiableMap(m);
    }
    public final static Map<String, Double> SVG_ABSOLUTE_FONT_SIZES;

    static {
        HashMap<String, Double> m = new HashMap<String, Double>();
        m.put("xx-small", 6.944444);
        m.put("x-small", 8.3333333);
        m.put("small", 10d);
        m.put("medium", 12d);
        m.put("large", 14.4);
        m.put("x-large", 17.28);
        m.put("xx-large", 20.736);
        SVG_ABSOLUTE_FONT_SIZES = Collections.unmodifiableMap(m);
    }
    public final static Map<String, Double> SVG_RELATIVE_FONT_SIZES;

    static {
        HashMap<String, Double> m = new HashMap<String, Double>();
        m.put("larger", 1.2);
        m.put("smaller", 0.83333333);
        SVG_RELATIVE_FONT_SIZES = Collections.unmodifiableMap(m);
    }
    public final static Map<String, TextAnchor> SVG_TEXT_ANCHORS;

    static {
        HashMap<String, TextAnchor> m = new HashMap<String, TextAnchor>();
        m.put("start", TextAnchor.START);
        m.put("middle", TextAnchor.MIDDLE);
        m.put("end", TextAnchor.END);
        SVG_TEXT_ANCHORS = Collections.unmodifiableMap(m);
    }
    public final static Map<String, TextAlign> SVG_TEXT_ALIGNS;

    static {
        HashMap<String, TextAlign> m = new HashMap<String, TextAlign>();
        m.put("start", TextAlign.START);
        m.put("center", TextAlign.CENTER);
        m.put("end", TextAlign.END);
        SVG_TEXT_ALIGNS = Collections.unmodifiableMap(m);
    }

    /**
     * Prevents instance creation.
     */
    private SVGConstants() {
    }

}
