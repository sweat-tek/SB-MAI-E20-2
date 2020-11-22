/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import java.awt.geom.RoundRectangle2D;


public class SVGRectFigureBuilder {

    private double x = 0;
    private double y = 0;
    private double width = 0;
    private double height = 0;
    private double rx = 0;
    private double ry = 0;

    public SVGRectFigureBuilder() {
    }

    public SVGRectFigureBuilder setX(double x) {
        this.x = x;
        return this;
    }

    public SVGRectFigureBuilder setY(double y) {
        this.y = y;
        return this;
    }

    public SVGRectFigureBuilder setWidth(double width) {
        this.width = width;
        return this;
    }

    public SVGRectFigureBuilder setHeight(double height) {
        this.height = height;
        return this;
    }

    public SVGRectFigureBuilder setRx(double rx) {
        this.rx = rx;
        return this;
    }

    public SVGRectFigureBuilder setRy(double ry) {
        this.ry = ry;
        return this;
    }

    public RoundRectangle2D.Double createSVGRectFigure() {
        return new RoundRectangle2D.Double(x, y, width, height, rx, ry);
    }
    
}
