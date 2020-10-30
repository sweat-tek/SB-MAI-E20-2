/*
 * @(#)LinkToolBar.java  1.0  2009-04-17
 *
 * Copyright (c) 2009 by the original authors of JHotDraw
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
import javax.swing.border.*;
import org.jhotdraw.gui.*;
import org.jhotdraw.util.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.LabelUI;
import javax.swing.plaf.TextUI;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.DefaultFormatterFactory;
import org.jhotdraw.app.JHotDrawFeatures;
import org.jhotdraw.draw.*;
import org.jhotdraw.gui.plaf.palette.*;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.*;
import org.jhotdraw.samples.svg.gui.builder.Constraints;

/**
 * LinkToolBar.
 *
 * @author Werner Randelshofer
 * @version 1.0 2009-04-17 Created.
 */
public class LinkToolBar extends AbstractToolBar {

    private SelectionComponentDisplayer displayer;
    private ResourceBundleUtil labels;
    private JPanel jPanel;
    private JLabel jLabel;
    private JScrollPane jScrollPane;
    private JAttributeTextArea<String> jattrTextArea;
    private JAttributeTextField<String> jattrTextField;
    private GridBagConstraints gridBagConstraints;

    /**
     * Creates new instance.
     */
    public LinkToolBar() {
        labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");
        setName(labels.getString(getID() + ".toolbar"));
        setDisclosureStateCount(3);
    }

    // https://refactoring.guru/introduce-null-object
    @Override
    public void setEditor(DrawingEditor newValue) {
        DrawingEditor oldValue = getEditor();
        if (displayer != null) {
            displayer.dispose();
            displayer = new NullSelectionComponentDisplayer();
        }
        super.setEditor(newValue);
        if (newValue != null) {
            displayer = new SelectionComponentDisplayer(editor, this);
        }
    }

    @Override
    @FeatureEntryPoint(JHotDrawFeatures.LINK_PALETTE)
    protected JComponent createDisclosedComponent(int state) {
        jPanel = new JPanel();
        jLabel = new JLabel();
        jScrollPane = new JScrollPane();
        jattrTextArea = new JAttributeTextArea<>();
        jattrTextField = new JAttributeTextField<>();
        gridBagConstraints = new GridBagConstraints();
        switch (state) {
            case 1: {
                buildJPanel(new GridBagLayout(), new EmptyBorder(5, 5, 5, 8), false);
                buildJLabelView((LabelUI) PaletteLabelUI.createUI(jLabel), labels.getString("attribute.figureLink.toolTipText"), labels.getString("attribute.figureLink.text"), PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"));
                buildJLabelProperty(jattrTextArea);
                Constraints gbc = new Constraints.Builder().setgbcObj(gridBagConstraints = new GridBagConstraints())
                        .withgridx(0).withinsets(new Insets(-2, 0, -2, 0)).withanchor(GridBagConstraints.SOUTHWEST).withgridwidth(GridBagConstraints.REMAINDER)
                        .build();
                jPanel.add(this.jLabel, gbc.getGridBagConstraints());
                buildTextAreaView(true, true, PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"));
                buildTextAreaProperty(labels.getString("attribute.figureLink.toolTipText"), 8, 2, new DefaultFormatterFactory(new DefaultFormatter()));
                new FigureAttributeEditorHandler<String>(LINK, jattrTextArea, editor, false);
                buildJScrollPaneView(PaletteLookAndFeel.getInstance().getBorder("ScrollPane.border"), jattrTextArea);
                buildJScrollPaneProperty(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, "JComponent.sizeVariant", "small");
                gbc = new Constraints.Builder().setgbcObj(gridBagConstraints = new GridBagConstraints())
                        .withgridx(0).withgridy(1).withinsets(new Insets(3, 0, 0, 0)).withfill(GridBagConstraints.BOTH).withgridwidth(GridBagConstraints.REMAINDER).withweightx(1d).withweighty(1d)
                        .build();
                jPanel.add(this.jScrollPane, gbc.getGridBagConstraints());
                this.jLabel = new JLabel();
                buildJLabelView((LabelUI) PaletteLabelUI.createUI(jLabel), labels.getString("attribute.figureLinkTarget.toolTipText"), labels.getString("attribute.figureLinkTarget.text"));
                gbc = new Constraints.Builder().setgbcObj(gridBagConstraints = new GridBagConstraints())
                        .withgridx(0).withgridy(2).withinsets(new Insets(3, 0, 0, 0)).withfill(GridBagConstraints.BOTH).withanchor(GridBagConstraints.FIRST_LINE_START)
                        .build();
                jPanel.add(jLabel, gbc.getGridBagConstraints());
                buildTextFieldView((TextUI) PaletteFormattedTextFieldUI.createUI(jattrTextField));
                new FigureAttributeEditorHandler<>(LINK_TARGET, jattrTextField, editor, false);
                gbc = new Constraints.Builder().setgbcObj(gridBagConstraints = new GridBagConstraints())
                        .withgridx(1).withgridy(2).withinsets(new Insets(3, 3, 0, 0)).withfill(GridBagConstraints.HORIZONTAL).withgridwidth(GridBagConstraints.REMAINDER).withanchor(GridBagConstraints.FIRST_LINE_START)
                        .build();
                jPanel.add(jattrTextField, gbc.getGridBagConstraints());
            }
            break;
            case 2: {
                buildJPanel(new GridBagLayout(), new EmptyBorder(5, 5, 5, 8), false);
                new FigureAttributeEditorHandler<>(LINK, jattrTextArea, editor, false);
                buildTextAreaView(true, true, PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"));
                buildTextAreaProperty(labels.getString("attribute.figureLink.toolTipText"), 12, 2, new DefaultFormatterFactory(new DefaultFormatter()));
                buildJScrollPaneView(PaletteLookAndFeel.getInstance().getBorder("ScrollPane.border"), jattrTextArea);
                buildJScrollPaneProperty(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, "JComponent.sizeVariant", "small");
                Constraints gbc = new Constraints.Builder().setgbcObj(gridBagConstraints = new GridBagConstraints())
                        .withgridx(0).withgridy(1).withinsets(new Insets(0, 0, 0, 0)).withfill(GridBagConstraints.BOTH).withgridwidth(GridBagConstraints.REMAINDER).withweightx(1d).withweighty(1d)
                        .build();
                jPanel.add(jScrollPane, gbc.getGridBagConstraints());
                buildJLabelView((LabelUI) PaletteLabelUI.createUI(jLabel), labels.getString("attribute.figureLinkTarget.toolTipText"), labels.getString("attribute.figureLinkTarget.text"));
                buildJLabelProperty(jattrTextArea);
                gbc = new Constraints.Builder().setgbcObj(gridBagConstraints = new GridBagConstraints())
                        .withgridx(0).withgridy(2).withinsets(new Insets(3, 0, 0, 0)).withfill(GridBagConstraints.BOTH).withanchor(GridBagConstraints.FIRST_LINE_START)
                        .build();
                jPanel.add(jLabel, gbc.getGridBagConstraints());
                buildTextFieldView((TextUI) PaletteFormattedTextFieldUI.createUI(jattrTextField));
                buildTextFieldProperty(labels.getString("attribute.figureLinkTarget.toolTipText"), 7, new DefaultFormatterFactory(new DefaultFormatter()));
                new FigureAttributeEditorHandler<>(LINK_TARGET, jattrTextField, editor, true);
                gbc = new Constraints.Builder().setgbcObj(gridBagConstraints = new GridBagConstraints())
                        .withgridx(1).withgridy(2).withinsets(new Insets(3, 3, 0, 0)).withfill(GridBagConstraints.HORIZONTAL).withgridwidth(GridBagConstraints.REMAINDER).withanchor(GridBagConstraints.FIRST_LINE_START)
                        .build();
                jPanel.add(jattrTextField, gbc.getGridBagConstraints());
            }
            break;
        }
        return jPanel;
    }

    private void buildJPanel(GridBagLayout gridbaglayout, EmptyBorder emptyBorder, boolean setopaque) {
        this.jPanel.setLayout(gridbaglayout);
        this.jPanel.setBorder(emptyBorder);
        this.jPanel.setOpaque(setopaque);

    }

    private void buildJLabelView(LabelUI ui, String tooltiptext, String text, Font font) {
        this.jLabel.setUI(ui);
        this.jLabel.setToolTipText(tooltiptext);
        this.jLabel.setText(text); // NOI18N
        this.jLabel.setFont(font);
    }

    private void buildJLabelView(LabelUI ui, String tooltiptext, String text) {
        this.jLabel.setUI(ui);
        this.jLabel.setToolTipText(tooltiptext);
        this.jLabel.setText(text); // NOI18N
    }

    private void buildJLabelProperty(Component component) {
        jLabel.setLabelFor(component);
    }

    private void buildJScrollPaneView(Border border, Component viewPortView) {
        this.jScrollPane.setBorder(border);
        this.jScrollPane.setViewportView(viewPortView);
    }

    private void buildJScrollPaneProperty(int horPaneConstantPolicy, int verPaneConstantPolicy, String clientPropertyKey, String clientPropertyValue) {
        this.jScrollPane.setHorizontalScrollBarPolicy(horPaneConstantPolicy);
        this.jScrollPane.setVerticalScrollBarPolicy(verPaneConstantPolicy);
        this.jScrollPane.putClientProperty(clientPropertyKey, clientPropertyValue);
    }

    private void buildTextAreaView(boolean lineWrap, boolean styleWordWrap, Font font) {
        this.jattrTextArea.setLineWrap(lineWrap);
        this.jattrTextArea.setWrapStyleWord(styleWordWrap);
        this.jattrTextArea.setFont(font);
    }

    private void buildTextAreaProperty(String toolTipText, int columns, int rows, JFormattedTextField.AbstractFormatterFactory formatterFactory) {
        this.jattrTextArea.setToolTipText(toolTipText);
        this.jattrTextArea.setColumns(columns);
        this.jattrTextArea.setRows(rows);
        this.jattrTextArea.setFormatterFactory(formatterFactory);
    }

    private void buildTextFieldView(TextUI textui) {
        this.jattrTextField.setUI(textui);
    }

    private void buildTextFieldView(Font font, TextUI textui) {
        this.jattrTextField.setFont(font);
        this.jattrTextField.setUI(textui);
    }

    private void buildTextFieldProperty(String tipText, int columns, JFormattedTextField.AbstractFormatterFactory formatterFactory) {
        this.jattrTextField.setToolTipText(tipText);
        this.jattrTextField.setColumns(columns);
        this.jattrTextField.setFormatterFactory(formatterFactory);
    }

    public SelectionComponentDisplayer getDisplayer() {
        return displayer;
    }

    public void setDisplayer(SelectionComponentDisplayer displayer) {
        this.displayer = displayer;
    }

    public ResourceBundleUtil getLabels() {
        return labels;
    }

    public void setLabels(ResourceBundleUtil labels) {
        this.labels = labels;
    }

    public JPanel getjPanel() {
        return jPanel;
    }

    public void setjPanel(JPanel jPanel) {
        this.jPanel = jPanel;
    }

    public JLabel getjLabel() {
        return jLabel;
    }

    public void setjLabel(JLabel jLabel) {
        this.jLabel = jLabel;
    }

    public JScrollPane getjScrollPane() {
        return jScrollPane;
    }

    public void setjScrollPane(JScrollPane jScrollPane) {
        this.jScrollPane = jScrollPane;
    }

    public JAttributeTextArea<String> getJattrTextArea() {
        return jattrTextArea;
    }

    public void setJattrTextArea(JAttributeTextArea<String> jattrTextArea) {
        this.jattrTextArea = jattrTextArea;
    }

    public JAttributeTextField<String> getJattrTextField() {
        return jattrTextField;
    }

    public void setJattrTextField(JAttributeTextField<String> jattrTextField) {
        this.jattrTextField = jattrTextField;
    }

    public GridBagConstraints getGridBagConstraints() {
        return gridBagConstraints;
    }

    public void setGridBagConstraints(GridBagConstraints gridBagConstraints) {
        this.gridBagConstraints = gridBagConstraints;
    }

    @Override
    protected String getID() {
        return "link";
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
