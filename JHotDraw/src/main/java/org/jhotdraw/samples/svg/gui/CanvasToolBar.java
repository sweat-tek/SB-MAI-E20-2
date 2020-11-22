/*
 * @(#)CanvasToolBar.java  1.0  2008-05-18
 *
 * Copyright (c) 2007-2008 by the original authors of JHotDraw
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
import org.jhotdraw.app.JHotDrawFeatures;
import org.jhotdraw.draw.action.ButtonFactory;
import org.jhotdraw.gui.DrawingAttributeEditorHandler;
import org.jhotdraw.gui.JAttributeSlider;
import org.jhotdraw.gui.JAttributeTextField;
import org.jhotdraw.gui.JPopupButton;
import org.jhotdraw.gui.plaf.palette.PaletteButtonUI;
import org.jhotdraw.gui.plaf.palette.PaletteFormattedTextFieldUI;
import org.jhotdraw.gui.plaf.palette.PaletteLabelUI;
import org.jhotdraw.gui.plaf.palette.PaletteSliderUI;
import org.jhotdraw.text.ColorFormatter;
import org.jhotdraw.text.JavaNumberFormatter;
import org.jhotdraw.util.ResourceBundleUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.LabelUI;
import javax.swing.plaf.SliderUI;
import javax.swing.plaf.TextUI;
import java.awt.*;

import static org.jhotdraw.samples.svg.SVGAttributeKeys.*;

/**
 * CanvasToolBar.
 *
 * @author Werner Randelshofer
 * @version 1.0 2008-05-18 Created.
 */
public class CanvasToolBar extends AbstractToolBar {

    /**
     * Creates new instance.
     */
    public CanvasToolBar() {
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");
        setName(labels.getString(getID() + ".toolbar"));
        setDisclosureStateCount(3);
    }

    @Override
    @FeatureEntryPoint(JHotDrawFeatures.CANVAS)
    protected JComponent createDisclosedComponent(int state) {
        switch (state) {
            case 0:
                return null; // Renders as hidden
            case 1:
                return buildPartialView();
            case 2:
                return buildFullView();
            default:
                throw new IllegalStateException("Unexpected state: " + state);
        }
    }

    private JPanel buildPartialView() {
        GridBagLayout layout = new GridBagLayout();
        JPanel p = buildPanel(layout);

        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");
        GridBagConstraints gbc;

        // Fill color
        gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        p.add(buildFillButton(labels), gbc);

        // Opacity slider
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(0, 3, 0, 0);
        p.add(buildOpacitySlider(labels), gbc);

        // Width and height fields
        addWidthAndHeightComponents(p, labels, false);
        return p;
    }

    private JPanel buildFullView() {
        GridBagLayout layout = new GridBagLayout();
        JPanel p = buildPanel(layout);

        JPanel p1 = new JPanel(new GridBagLayout());
        JPanel p2 = new JPanel(new GridBagLayout());
        JPanel p3 = new JPanel(new GridBagLayout());
        p1.setOpaque(false);
        p2.setOpaque(false);
        p3.setOpaque(false);

        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");
        GridBagConstraints gbc;

        // Fill color field with button
        JAttributeTextField<Color> colorField = new JAttributeTextField<>();
        colorField.setColumns(7);
        colorField.setToolTipText(labels.getString("attribute.canvasFillColor.toolTipText"));
        colorField.putClientProperty("Palette.Component.segmentPosition", "first");
        colorField.setUI((PaletteFormattedTextFieldUI) PaletteFormattedTextFieldUI.createUI(colorField));
        colorField.setFormatterFactory(ColorFormatter.createFormatterFactory());
        colorField.setHorizontalAlignment(JTextField.LEFT);
        new DrawingAttributeEditorHandler<>(CANVAS_FILL_COLOR, colorField, editor);
        gbc = new GridBagConstraints();
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        p1.add(colorField, gbc);
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        p1.add(buildFillButton(labels), gbc);

        // Opacity field with slider
        JAttributeTextField<Double> opacityField = new JAttributeTextField<>();
        opacityField.setColumns(3);
        opacityField.setToolTipText(labels.getString("attribute.figureOpacity.toolTipText"));
        opacityField.setHorizontalAlignment(JAttributeTextField.RIGHT);
        opacityField.putClientProperty("Palette.Component.segmentPosition", "first");
        opacityField.setUI((PaletteFormattedTextFieldUI) PaletteFormattedTextFieldUI.createUI(opacityField));
        opacityField.setFormatterFactory(JavaNumberFormatter.createFormatterFactory(0d, 100d, 100d, true, false));
        opacityField.setHorizontalAlignment(JTextField.LEADING);
        new DrawingAttributeEditorHandler<>(CANVAS_FILL_OPACITY, opacityField, editor);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(3, 0, 0, 0);
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        p1.add(opacityField, gbc);

        // Opacity slider
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(3, 0, 0, 0);
        p1.add(buildOpacitySlider(labels), gbc);

        // Width and height fields
        addWidthAndHeightComponents(p3, labels, true);

        // Add horizontal strips
        gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        p.add(p1, gbc);
        gbc = new GridBagConstraints();
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        p.add(p2, gbc);
        gbc = new GridBagConstraints();
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        p.add(p3, gbc);
        return p;
    }

    private JPanel buildPanel(GridBagLayout layout) {
        JPanel p = new JPanel();
        p.setOpaque(false);

        p.removeAll();
        p.setBorder(new EmptyBorder(5, 5, 5, 8));
        p.setLayout(layout);
        return p;
    }

    private JPopupButton buildFillButton(ResourceBundleUtil labels) {
        JPopupButton btn = ButtonFactory.createDrawingColorButton(editor,
                CANVAS_FILL_COLOR, ButtonFactory.HSV_COLORS, ButtonFactory.HSV_COLORS_COLUMN_COUNT,
                "attribute.canvasFillColor", labels, null, new Rectangle(3, 3, 10, 10));
        btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
        new DrawingComponentRepainter(editor, btn);
        btn.setAction(null, null);
        return btn;
    }

    private JPopupButton buildOpacitySlider(ResourceBundleUtil labels) {
        JPopupButton opacityPopupButton = new JPopupButton();
        JAttributeSlider opacitySlider = new JAttributeSlider(JSlider.VERTICAL, 0, 100, 100);
        opacitySlider.setUI((SliderUI) PaletteSliderUI.createUI(opacitySlider));
        opacitySlider.setScaleFactor(100d);
        new DrawingAttributeEditorHandler<>(CANVAS_FILL_OPACITY, opacitySlider, editor);
        opacityPopupButton.add(opacitySlider);
        labels.configureToolBarButton(opacityPopupButton, "attribute.canvasFillOpacity");
        opacityPopupButton.setUI((PaletteButtonUI) PaletteButtonUI.createUI(opacityPopupButton));
        opacityPopupButton.setIcon(
                new DrawingOpacityIcon(editor, CANVAS_FILL_OPACITY, CANVAS_FILL_COLOR, null, getClass().getResource(labels.getString("attribute.canvasFillOpacity.icon")),
                        new Rectangle(5, 5, 6, 6), new Rectangle(4, 4, 7, 7)));
        new DrawingComponentRepainter(editor, opacityPopupButton);
        return opacityPopupButton;
    }

    private void addWidthAndHeightComponents(JPanel panel, ResourceBundleUtil labels, boolean isFullView) {
        GridBagConstraints gbc;
        JLabel widthLabel, heightLabel;
        JAttributeTextField<Double> widthField, heightField;

        widthLabel = new javax.swing.JLabel();
        heightLabel = new javax.swing.JLabel();
        widthField = new JAttributeTextField<>();
        heightField = new JAttributeTextField<>();

        widthLabel.setUI((LabelUI) PaletteLabelUI.createUI(widthLabel));
        widthLabel.setLabelFor(widthField);
        widthLabel.setToolTipText(labels.getString("attribute.canvasWidth.toolTipText"));
        widthLabel.setText(labels.getString("attribute.canvasWidth.text")); // NOI18N
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = isFullView ? 2 : 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(3, 0, 0, 0);
        panel.add(widthLabel, gbc);

        widthField.setUI((TextUI) PaletteFormattedTextFieldUI.createUI(widthField));
        widthField.setColumns(3);
        widthField.setToolTipText(labels.getString("attribute.canvasWidth.toolTipText"));
        widthField.setFormatterFactory(JavaNumberFormatter.createFormatterFactory(1d, 4096d, 1d, true, false));
        widthField.setHorizontalAlignment(JTextField.LEADING);
        new DrawingAttributeEditorHandler<>(CANVAS_WIDTH, widthField, editor);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = isFullView ? 2 : 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(3, 3, 0, 0);
        panel.add(widthField, gbc);

        heightLabel.setUI((LabelUI) PaletteLabelUI.createUI(heightLabel));
        heightLabel.setLabelFor(widthField);
        heightLabel.setToolTipText(labels.getString("attribute.canvasHeight.toolTipText"));
        heightLabel.setText(labels.getString("attribute.canvasHeight.text")); // NOI18N
        gbc = new GridBagConstraints();
        gbc.gridx = isFullView ? 3 : 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(3, isFullView ? 3 : 0, 0, 0);
        panel.add(heightLabel, gbc);

        heightField.setUI((TextUI) PaletteFormattedTextFieldUI.createUI(widthField));
        heightField.setColumns(3);
        heightField.setToolTipText(labels.getString("attribute.canvasHeight.toolTipText"));
        heightField.setFormatterFactory(JavaNumberFormatter.createFormatterFactory(1d, 4096d, 1d, true, false));
        heightField.setHorizontalAlignment(JTextField.LEADING);
        new DrawingAttributeEditorHandler<>(CANVAS_HEIGHT, heightField, editor);
        gbc = new GridBagConstraints();
        gbc.gridx = isFullView ? 4 : 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(3, 3, 0, 0);
        panel.add(heightField, gbc);
    }

    @Override
    protected String getID() {
        return "canvas";
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setOpaque(false);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
