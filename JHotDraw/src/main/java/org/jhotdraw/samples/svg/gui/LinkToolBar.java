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

/**
 * LinkToolBar.
 *
 * @author Werner Randelshofer
 * @version 1.0 2009-04-17 Created.
 */
public class LinkToolBar extends AbstractToolBar {

    private SelectionComponentDisplayer displayer;
    private ResourceBundleUtil labels;

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
        JPanel p = null;

        switch (state) {
            case 1: {
                p = buildJPanel(new GridBagLayout(), new EmptyBorder(5, 5, 5, 8), false);
                //p.setOpaque(false);
                //p.setLayout(new GridBagLayout());

                //AbstractButton btn;
                //p.setBorder(new EmptyBorder(5, 5, 5, 8));
                // Link field
                //JLabel linkLabel;
                JScrollPane scrollPane;
                JAttributeTextArea<String> linkField = new JAttributeTextArea<String>();

                JLabel linkLabel = buildJLabel(labels.getString(
                        "attribute.figureLink.toolTipText"),
                        labels.getString("attribute.figureLink.text"), PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"), linkField);
                //linkLabel.setUI((LabelUI) PaletteLabelUI.createUI(linkLabel));
                //linkLabel.setToolTipText(labels.getString("attribute.figureLink.toolTipText"));
                //linkLabel.setText(labels.getString("attribute.figureLink.text")); // NOI18N
                //linkLabel.setFont(PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"));

                //linkField = new JAttributeTextArea<String>();
                //linkLabel.setLabelFor(linkField);
                GridBagConstraints gbc = buildGridBagConstraints(0, 0, new Insets(-2, 0, -2, 0), 0, GridBagConstraints.REMAINDER, 0, 0, GridBagConstraints.SOUTHWEST);
                //gbc = new GridBagConstraints();
                //gbc.gridx = 0;
                //gbc.insets = new Insets(-2, 0, -2, 0);
                //gbc.anchor = GridBagConstraints.SOUTHWEST;
                //gbc.gridwidth = GridBagConstraints.REMAINDER;
                p.add(linkLabel, gbc);

                //scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                //scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                //scrollPane.putClientProperty("JComponent.sizeVariant", "small");
                //scrollPane.setBorder(PaletteLookAndFeel.getInstance().getBorder("ScrollPane.border"));
                linkField = buildTextArea(labels.getString("attribute.figureLink.toolTipText"), 8, true, 2, true, PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"), new DefaultFormatterFactory(new DefaultFormatter()));
                //linkField.setToolTipText(labels.getString("attribute.figureLink.toolTipText"));
                //linkField.setColumns(8);
                //linkField.setLineWrap(true);
                //linkField.setRows(2);
                //linkField.setWrapStyleWord(true);
                //linkField.setFont(PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"));
                //linkField.setFormatterFactory(new DefaultFormatterFactory(new DefaultFormatter()));
                new FigureAttributeEditorHandler<String>(LINK, linkField, editor, false);
                scrollPane = buildJScrollPane(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER,
                        ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, "JComponent.sizeVariant", "small",
                        PaletteLookAndFeel.getInstance().getBorder("ScrollPane.border"), linkField);
                //scrollPane.setViewportView(linkField);
                gbc = buildGridBagConstraints(0, 1, new Insets(3, 0, 0, 0), GridBagConstraints.BOTH, GridBagConstraints.REMAINDER, 1d, 1d, GridBagConstraints.CENTER);
                //gbc.gridx = 0;
                //gbc.gridy = 1;
                //gbc.insets = new Insets(3, 0, 0, 0);
                //gbc.fill = GridBagConstraints.BOTH;
                //gbc.gridwidth = GridBagConstraints.REMAINDER;
                //gbc.weightx = 1d;
                //gbc.weighty = 1d;
                p.add(scrollPane, gbc);

                // Target field
                JLabel targetLabel;
                JAttributeTextField<String> targetField = new JAttributeTextField<>();

                targetLabel = buildJLabel(labels.getString("attribute.figureLinkTarget.toolTipText"), labels.getString("attribute.figureLinkTarget.text"),
                        PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"), targetField);
                //targetLabel.setUI((LabelUI) PaletteLabelUI.createUI(targetLabel));
                //targetLabel.setToolTipText(labels.getString("attribute.figureLinkTarget.toolTipText"));
                //targetLabel.setText(labels.getString("attribute.figureLinkTarget.text")); // NOI18N
                //targetLabel.setFont(PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"));

                //targetLabel.setLabelFor(targetField);
                gbc = buildGridBagConstraints(0, 2, new Insets(3, 0, 0, 0), GridBagConstraints.BOTH, 0, 0, 0, GridBagConstraints.FIRST_LINE_START);
                //gbc.gridx = 0;
                //gbc.gridy = 2;
                //gbc.insets = new Insets(3, 0, 0, 0);
                //gbc.fill = GridBagConstraints.BOTH;
                //gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                p.add(targetLabel, gbc);
                targetField = buildTextField(labels.getString("attribute.figureLinkTarget.toolTipText"), 4, null, new DefaultFormatterFactory(new DefaultFormatter()), (TextUI) PaletteFormattedTextFieldUI.createUI(targetField));
                //targetField.setToolTipText(labels.getString("attribute.figureLinkTarget.toolTipText"));
                //targetField.setColumns(4);
                //targetField.setFont(PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"));
                //targetField.setFormatterFactory(new DefaultFormatterFactory(new DefaultFormatter()));
                //targetField.setUI((TextUI) PaletteFormattedTextFieldUI.createUI(targetField));
                new FigureAttributeEditorHandler<>(LINK_TARGET, targetField, editor, false);
                gbc = buildGridBagConstraints(1, 2, new Insets(3, 3, 0, 0),
                        GridBagConstraints.HORIZONTAL, GridBagConstraints.REMAINDER, 0, 0, GridBagConstraints.FIRST_LINE_START);
                //gbc.gridx = 1;
                //gbc.gridy = 2;
                //gbc.insets = new Insets(3, 3, 0, 0);
                //gbc.fill = GridBagConstraints.HORIZONTAL;
                //gbc.gridwidth = GridBagConstraints.REMAINDER;
                //gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                p.add(targetField, gbc);

            }
            break;

            case 2: {
                p = new JPanel();
                p.setOpaque(false);
                p.setLayout(new GridBagLayout());
                GridBagConstraints gbc;
                //AbstractButton btn;
                p.setBorder(new EmptyBorder(5, 5, 5, 8));

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
                p.add(scrollPane, gbc);

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
                p.add(targetLabel, gbc);

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
                p.add(targetField, gbc);

            }
            break;
        }
        return p;
    }

    private JPanel buildJPanel(GridBagLayout gridbaglayout,
            EmptyBorder emptyBorder, boolean setopaque) {

        JPanel jpanel = new JPanel();
        jpanel.setOpaque(setopaque);
        jpanel.setLayout(gridbaglayout);
        jpanel.setBorder(emptyBorder);

        return jpanel;
    }

    private JLabel buildJLabel(String tooltiptext,
            String text, Font font, Component component) {

        JLabel label = new JLabel();
        label.setUI((LabelUI) PaletteLabelUI.createUI(label));
        label.setToolTipText(tooltiptext);
        label.setText(text); // NOI18N
        label.setFont(PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"));
        label.setLabelFor(component);

        return label;

    }

    private JScrollPane buildJScrollPane(int horPaneConstantPolicy, int verPaneConstantPolicy,
            String clientPropertyKey, String clientPropertyValue, Border border, Component viewPortView) {
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(horPaneConstantPolicy);
        scrollPane.setVerticalScrollBarPolicy(verPaneConstantPolicy);
        scrollPane.putClientProperty(clientPropertyKey, clientPropertyValue);
        scrollPane.setBorder(border);
        scrollPane.setViewportView(viewPortView);

        return scrollPane;
    }

    private JAttributeTextArea<String> buildTextArea(String toolTipText, int columns,
            boolean lineWrap, int rows, boolean styleWordWrap, Font font,
            JFormattedTextField.AbstractFormatterFactory formatterFactory) {

        JAttributeTextArea<String> textArea = new JAttributeTextArea<>();
        textArea.setToolTipText(toolTipText);
        textArea.setColumns(columns);
        textArea.setLineWrap(lineWrap);
        textArea.setRows(rows);
        textArea.setWrapStyleWord(styleWordWrap);
        textArea.setFont(font);
        textArea.setFormatterFactory(formatterFactory);

        return textArea;
    }

    private JAttributeTextField<String> buildTextField(String tipText, int columns, Font font, JFormattedTextField.AbstractFormatterFactory formatterFactory, TextUI textui) {
        JAttributeTextField<String> textField = new JAttributeTextField<>();

        textField.setToolTipText(tipText);
        textField.setColumns(columns);
        textField.setFont(font);
        textField.setFormatterFactory(formatterFactory);
        textField.setUI(textui);

        return textField;
    }

    private GridBagConstraints buildGridBagConstraints(int gridx, int gridy,
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
