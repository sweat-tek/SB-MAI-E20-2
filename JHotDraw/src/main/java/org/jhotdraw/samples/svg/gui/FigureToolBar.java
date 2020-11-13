/*
 * @(#)FigureToolBar.java  2.0  2009-04-17
 *
 * Copyright (c) 2007-2009 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 *
 * The copyright of this software is owned by the authors and  
 * contributors of the JHotDraw project ("the copyright holders").  
 * You may not use, copy or modify this software, except in  
 * accordance with the license agreement you entered into with  
 * the copyright holders. For details see accompanying license terms. 
 */
package org.jhotdraw.samples.svg.gui;

import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import org.jhotdraw.text.JavaNumberFormatter;
import javax.swing.border.*;
import org.jhotdraw.gui.*;
import org.jhotdraw.util.*;

import java.awt.*;
import javax.swing.*;
import static javax.swing.SwingConstants.SOUTH_EAST;
import javax.swing.plaf.SliderUI;
import org.jhotdraw.app.JHotDrawFeatures;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.action.*;
import org.jhotdraw.gui.plaf.palette.*;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.*;

/**
 * FigureToolBar.
 *
 * @author Werner Randelshofer
 * @version 2.0 2009-04-17 Moved hyperlink attributes out into LinkToolBar.
 * <br>1.2 2008-05-23 Hide the toolbar if nothing is selected, and no creation
 * tool is active.
 * <br>1.1 2008-03-26 Don't draw border.
 * <br>1.0 May 1, 2007 Created.
 */
public class FigureToolBar extends AbstractToolBar {

    private SelectionComponentDisplayer displayer;
    private ResourceBundleUtil labels;

    /**
     * Creates new instance.
     */
    public FigureToolBar() {
        labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");
        setName(labels.getString(getID() + ".toolbar"));
        setDisclosureStateCount(3);
    }

    @Override
    public void setEditor(DrawingEditor newValue) {
        DrawingEditor oldValue = getEditor();
        if (displayer != null) {
            displayer.dispose();
            displayer = null;
        }
        super.setEditor(newValue);
        if (newValue != null) {
            displayer = new SelectionComponentDisplayer(editor, this);
        }
    }

    private void setPanelLayout(JPanel p) {
        p.setOpaque(false);
        p.setLayout(new GridBagLayout());
        p.setBorder(new EmptyBorder(5, 5, 5, 8));
    }

    private void OpacityButtonConfig(JPopupButton opacityPopupButton) {

        labels.configureToolBarButton(opacityPopupButton, "attribute.figureOpacity");
        opacityPopupButton.setUI((PaletteButtonUI) PaletteButtonUI.createUI(opacityPopupButton));
        opacityPopupButton.setIcon(
                new SelectionOpacityIcon(editor, OPACITY, FILL_COLOR, STROKE_COLOR, getClass().getResource(labels.getString("attribute.figureOpacity.icon")),
                        new Rectangle(5, 5, 6, 6), new Rectangle(4, 4, 7, 7)));
        opacityPopupButton.setPopupAnchor(SOUTH_EAST);
    }

    private void addSliderToButton(JPopupButton opacityPopupButton, JAttributeSlider opacitySlider) {
        opacityPopupButton.add(opacitySlider);
    }

    private GridBagConstraints createGridBagConstraints(int gridx, int gridy, double weighty) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.weighty = weighty;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;

        return gbc;
    }

    private JAttributeTextField<Double> opacityFieldSetup() {
        JAttributeTextField<Double> opacityField = new JAttributeTextField<Double>();
        opacityField.setColumns(3);
        opacityField.setToolTipText(labels.getString("attribute.figureOpacity.toolTipText"));
        opacityField.setHorizontalAlignment(JAttributeTextField.RIGHT);
        opacityField.putClientProperty("Palette.Component.segmentPosition", "first");
        opacityField.setUI((PaletteFormattedTextFieldUI) PaletteFormattedTextFieldUI.createUI(opacityField));
        opacityField.setFormatterFactory(JavaNumberFormatter.createFormatterFactory(0d, 1d, 100d));
        opacityField.setHorizontalAlignment(JTextField.LEADING);
        new FigureAttributeEditorHandler<Double>(OPACITY, opacityField, editor);

        return opacityField;
    }

    @Override
    @FeatureEntryPoint(JHotDrawFeatures.FIGURE_PALETTE)
    protected JComponent createDisclosedComponent(int state) {
        JPanel p = null;

        if (state == 1 || state == 2) {

            p = new JPanel();
            setPanelLayout(p);

            // Creates opacity slider
            JPopupButton opacityPopupButton = new JPopupButton();
            JAttributeSlider opacitySlider = new JAttributeSlider(JSlider.VERTICAL, 0, 100, 100);
            addSliderToButton(opacityPopupButton, opacitySlider);
            OpacityButtonConfig(opacityPopupButton);
            new SelectionComponentRepainter(editor, opacityPopupButton);
            GridBagConstraints gbc = createGridBagConstraints(2, 0, 1);
            p.add(opacityPopupButton, gbc);
            opacitySlider.setUI((SliderUI) PaletteSliderUI.createUI(opacitySlider));
            opacitySlider.setScaleFactor(100d);
            new FigureAttributeEditorHandler<Double>(OPACITY, opacitySlider, editor);

            if (state == 2) {
                // Creates opacity field and adds it to the panel
                JAttributeTextField<Double> opacityField = opacityFieldSetup();
                gbc = createGridBagConstraints(1, 0, 1d);
                p.add(opacityField, gbc);
            }
        }
        return p;
    }

    @Override
    protected String getID() {
        return "figure";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
