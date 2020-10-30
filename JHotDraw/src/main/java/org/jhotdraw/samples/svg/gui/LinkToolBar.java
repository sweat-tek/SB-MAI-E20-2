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
            displayer = null;
        }
        super.setEditor(newValue);
        if (newValue != null) {
            displayer = new SelectionComponentDisplayer(editor, this);
        }
    }

    /**
     * Long Method (40) [F] Compose Method (123) Move Accumulation to Collecting
     * Parameter (313) Replace Conditional Dispatcher with Command (191) Move
     * Accumulation to Visitor (320) Replace Conditional Logic with Strategy
     * (129)
     *
     * Switch Statements (44) [F] Replace Conditional Dispatcher with Command
     * (191) Move Accumulation to Visitor (320)
     * https://refactoring.guru/refactoring/techniques/composing-methods
     */
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

                //jPanel = buildJPanel(new GridBagLayout(), new EmptyBorder(5, 5, 5, 8), false);
                buildJPanel(new GridBagLayout(), new EmptyBorder(5, 5, 5, 8), false);
                //p.setOpaque(false);
                //p.setLayout(new GridBagLayout());

                //AbstractButton btn;
                //p.setBorder(new EmptyBorder(5, 5, 5, 8));
                // Link field
                //JLabel linkLabel;
                //JScrollPane scrollPane;
                //JAttributeTextArea<String> linkField = new JAttributeTextArea<String>();
                buildJLabelView((LabelUI) PaletteLabelUI.createUI(jLabel), labels.getString("attribute.figureLink.toolTipText"), labels.getString("attribute.figureLink.text"), PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"));
                buildJLabelProperty(jattrTextArea);
                //buildJLabel(labels.getString("attribute.figureLink.toolTipText"), labels.getString("attribute.figureLink.text"), PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"), linkField);

//linkLabel.setUI((LabelUI) PaletteLabelUI.createUI(linkLabel));
                //linkLabel.setToolTipText(labels.getString("attribute.figureLink.toolTipText"));
                //linkLabel.setText(labels.getString("attribute.figureLink.text")); // NOI18N
                //linkLabel.setFont(PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"));
                //linkField = new JAttributeTextArea<String>();
                //linkLabel.setLabelFor(linkField);
                //GridBagConstraints gbc = buildGridBagConstraints(0, 0, new Insets(-2, 0, -2, 0), 0, GridBagConstraints.REMAINDER, 0, 0, GridBagConstraints.SOUTHWEST);
                Constraints gbc = new Constraints.Builder().setgbcObj(gridBagConstraints = new GridBagConstraints()).withgridx(0).withinsets(new Insets(-2, 0, -2, 0)).withanchor(GridBagConstraints.SOUTHWEST).withgridwidth(GridBagConstraints.REMAINDER).build();

                //gbc = new GridBagConstraints();
                //gbc.gridx = 0;
                //gbc.insets = new Insets(-2, 0, -2, 0);
                //gbc.anchor = GridBagConstraints.SOUTHWEST;
                //gbc.gridwidth = GridBagConstraints.REMAINDER;
                jPanel.add(this.jLabel, gbc.getGridBagConstraints());

                //scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                //scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                //scrollPane.putClientProperty("JComponent.sizeVariant", "small");
                //scrollPane.setBorder(PaletteLookAndFeel.getInstance().getBorder("ScrollPane.border"));
                //linkField = buildTextArea(labels.getString("attribute.figureLink.toolTipText"), 8, true, 2, true, PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"), new DefaultFormatterFactory(new DefaultFormatter()));
                buildTextAreaView(true, true, PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"));
                buildTextAreaProperty(labels.getString("attribute.figureLink.toolTipText"), 8, 2, new DefaultFormatterFactory(new DefaultFormatter()));
                //linkField.setToolTipText(labels.getString("attribute.figureLink.toolTipText"));
                //linkField.setColumns(8);
                //linkField.setLineWrap(true);
                //linkField.setRows(2);
                //linkField.setWrapStyleWord(true);
                //linkField.setFont(PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"));
                //linkField.setFormatterFactory(new DefaultFormatterFactory(new DefaultFormatter()));
                new FigureAttributeEditorHandler<String>(LINK, jattrTextArea, editor, false);
                buildJScrollPaneView(PaletteLookAndFeel.getInstance().getBorder("ScrollPane.border"), jattrTextArea);
                buildJScrollPaneProperty(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, "JComponent.sizeVariant", "small");
                //scrollPane = buildJScrollPane(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, "JComponent.sizeVariant", "small",PaletteLookAndFeel.getInstance().getBorder("ScrollPane.border"), linkField);
                //scrollPane.setViewportView(linkField);
                gbc = new Constraints.Builder().setgbcObj(gridBagConstraints = new GridBagConstraints()).withgridx(0).withgridy(1).withinsets(new Insets(3, 0, 0, 0)).withfill(GridBagConstraints.BOTH).withgridwidth(GridBagConstraints.REMAINDER).withweightx(1d).withweighty(1d).build();
                //gbc = buildGridBagConstraints(0, 1, new Insets(3, 0, 0, 0), GridBagConstraints.BOTH, GridBagConstraints.REMAINDER, 1d, 1d, GridBagConstraints.CENTER);
                //gbc.gridx = 0;
                //gbc.gridy = 1;
                //gbc.insets = new Insets(3, 0, 0, 0);
                //gbc.fill = GridBagConstraints.BOTH;
                //gbc.gridwidth = GridBagConstraints.REMAINDER;
                //gbc.weightx = 1d;
                //gbc.weighty = 1d;
                jPanel.add(this.jScrollPane, gbc.getGridBagConstraints());

                // Target field
                //JLabel targetLabel;
                //JAttributeTextField<String> targetField = new JAttributeTextField<>();
                //targetLabel = buildJLabel(labels.getString("attribute.figureLinkTarget.toolTipText"), labels.getString("attribute.figureLinkTarget.text"),
                //        PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"), targetField);
                this.jLabel = new JLabel();
                buildJLabelView((LabelUI) PaletteLabelUI.createUI(jLabel), labels.getString("attribute.figureLinkTarget.toolTipText"), labels.getString("attribute.figureLinkTarget.text"), PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"));

                //targetLabel.setUI((LabelUI) PaletteLabelUI.createUI(targetLabel));
                //targetLabel.setToolTipText(labels.getString("attribute.figureLinkTarget.toolTipText"));
                //targetLabel.setText(labels.getString("attribute.figureLinkTarget.text")); // NOI18N
                //targetLabel.setFont(PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"));
                //targetLabel.setLabelFor(targetField);
                //gbc = buildGridBagConstraints(0, 2, new Insets(3, 0, 0, 0), GridBagConstraints.BOTH, 0, 0, 0, GridBagConstraints.FIRST_LINE_START);
                gbc = new Constraints.Builder().setgbcObj(gridBagConstraints = new GridBagConstraints())
                        .withgridx(0).withgridy(2).withinsets(new Insets(3, 0, 0, 0)).withfill(GridBagConstraints.BOTH).withanchor(GridBagConstraints.FIRST_LINE_START)
                        .build();
                //gbc.gridx = 0;
                //gbc.gridy = 2;
                //gbc.insets = new Insets(3, 0, 0, 0);
                //gbc.fill = GridBagConstraints.BOTH;
                //gbc.anchor = GridBagConstraints.FIRST_LINE_START;

                jPanel.add(jLabel, gbc.getGridBagConstraints());
                //targetField = buildTextField(labels.getString("attribute.figureLinkTarget.toolTipText"), 4, null, new DefaultFormatterFactory(new DefaultFormatter()), (TextUI) PaletteFormattedTextFieldUI.createUI(targetField));
                buildTextFieldView(PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"), (TextUI) PaletteFormattedTextFieldUI.createUI(jattrTextField));

                //targetField.setToolTipText(labels.getString("attribute.figureLinkTarget.toolTipText"));
                //targetField.setColumns(4);
                //targetField.setFont(PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"));
                //targetField.setFormatterFactory(new DefaultFormatterFactory(new DefaultFormatter()));
                //targetField.setUI((TextUI) PaletteFormattedTextFieldUI.createUI(targetField));
                new FigureAttributeEditorHandler<>(LINK_TARGET, jattrTextField, editor, false);
                gbc = new Constraints.Builder().setgbcObj(gridBagConstraints = new GridBagConstraints()).withgridx(1).withgridy(2).withinsets(new Insets(3, 3, 0, 0)).withfill(GridBagConstraints.HORIZONTAL).withgridwidth(GridBagConstraints.REMAINDER).withanchor(GridBagConstraints.FIRST_LINE_START).build();
                // gbc = buildGridBagConstraints(1, 2, new Insets(3, 3, 0, 0),
                //        GridBagConstraints.HORIZONTAL, GridBagConstraints.REMAINDER, 0, 0, GridBagConstraints.FIRST_LINE_START);
                //gbc.gridx = 1;
                //gbc.gridy = 2;
                //gbc.insets = new Insets(3, 3, 0, 0);
                //gbc.fill = GridBagConstraints.HORIZONTAL;
                //gbc.gridwidth = GridBagConstraints.REMAINDER;
                //gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                jPanel.add(jattrTextField, gbc.getGridBagConstraints());

            }
            break;

            case 2: {
                jPanel = new JPanel();
                jPanel.setOpaque(false);
                jPanel.setLayout(new GridBagLayout());
                GridBagConstraints gbc;
                //AbstractButton btn;
                jPanel.setBorder(new EmptyBorder(5, 5, 5, 8));

                // Link field
                JScrollPane scrollPane;
                JAttributeTextArea<String> linkField;

                scrollPane = new javax.swing.JScrollPane();
                linkField = new JAttributeTextArea<String>();

                scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                scrollPane.putClientProperty("JComponent.sizeVariant", "small");
                scrollPane.setBorder(PaletteLookAndFeel.getInstance().getBorder("ScrollPane.border"));
                linkField.setToolTipText(labels.getString("attribute.figureLink.toolTipText"));
                linkField.setColumns(12);
                linkField.setLineWrap(true);
                linkField.setRows(2);

                linkField.setWrapStyleWord(true);
                linkField.setFont(PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"));
                linkField.setFormatterFactory(new DefaultFormatterFactory(new DefaultFormatter()));
                FigureAttributeEditorHandler<String> figureAttributeEditorHandler = new FigureAttributeEditorHandler<>(LINK, linkField, editor, false);

                scrollPane.setViewportView(linkField);
                gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 1;
                gbc.insets = new Insets(0, 0, 0, 0);
                gbc.fill = GridBagConstraints.BOTH;
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                gbc.weightx = 1d;
                gbc.weighty = 1d;
                jPanel.add(scrollPane, gbc);

                // Target field
                JLabel targetLabel;
                JAttributeTextField<String> targetField;

                targetLabel = new javax.swing.JLabel();
                targetLabel.setUI((LabelUI) PaletteLabelUI.createUI(targetLabel));
                targetLabel.setToolTipText(labels.getString("attribute.figureLinkTarget.toolTipText"));
                targetLabel.setText(labels.getString("attribute.figureLinkTarget.text")); // NOI18N
                //targetLabel.setFont(PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"));

                targetField = new JAttributeTextField<String>();

                targetLabel.setLabelFor(targetField);
                gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 2;
                gbc.insets = new Insets(3, 0, 0, 0);
                gbc.fill = GridBagConstraints.BOTH;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                jPanel.add(targetLabel, gbc);

                targetField.setToolTipText(labels.getString("attribute.figureLinkTarget.toolTipText"));
                targetField.setColumns(7);
                //targetField.setFont(PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"));
                targetField.setFormatterFactory(new DefaultFormatterFactory(new DefaultFormatter()));
                targetField.setUI((TextUI) PaletteFormattedTextFieldUI.createUI(targetField));
                new FigureAttributeEditorHandler<>(LINK_TARGET, targetField, editor, true);
                gbc = new GridBagConstraints();
                gbc.gridx = 1;
                gbc.gridy = 2;
                gbc.insets = new Insets(3, 3, 0, 0);
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                jPanel.add(targetField, gbc);

            }
            break;
        }
        return jPanel;
    }

    private void buildJPanel(GridBagLayout gridbaglayout, EmptyBorder emptyBorder, boolean setopaque) {
        this.jPanel.setOpaque(setopaque);
        this.jPanel.setLayout(gridbaglayout);
        this.jPanel.setBorder(emptyBorder);
    }

    private void buildJLabelView(LabelUI ui, String tooltiptext, String text, Font font) {
        this.jLabel.setUI(ui);
        this.jLabel.setToolTipText(tooltiptext);
        this.jLabel.setText(text); // NOI18N
        this.jLabel.setFont(font);
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

    private void buildTextFieldView(Font font, TextUI textui) {
        this.jattrTextField.setFont(font);
        this.jattrTextField.setUI(textui);
    }

    private void buildTextFieldProperty(String tipText, int columns, JFormattedTextField.AbstractFormatterFactory formatterFactory) {
        this.jattrTextField.setToolTipText(tipText);
        this.jattrTextField.setColumns(columns);
        this.jattrTextField.setFormatterFactory(formatterFactory);
    }

    /*private GridBagConstraints buildGridBagConstraints(int gridx, int gridy,
            Insets insets, int fill, int gridwidth, double weightx,
            double weighty, int anchor) {

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.insets = insets;
        gbc.fill = fill;
        gbc.gridwidth = gridwidth;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        gbc.anchor = anchor;

        return gbc;
    }*/
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
