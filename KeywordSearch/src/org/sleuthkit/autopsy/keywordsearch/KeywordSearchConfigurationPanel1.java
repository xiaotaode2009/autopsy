/*
 * Autopsy Forensic Browser
 * 
 * Copyright 2011 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * KeywordSearchConfigurationPanel1.java
 *
 * Created on Feb 28, 2012, 4:12:47 PM
 */
package org.sleuthkit.autopsy.keywordsearch;

import org.sleuthkit.autopsy.coreutils.Logger;
import org.sleuthkit.autopsy.corecomponents.OptionsPanel;

/**
 * Panel containing all other Keyword search Options panels.
 */
public class KeywordSearchConfigurationPanel1 extends javax.swing.JPanel implements OptionsPanel {

    KeywordSearchListsManagementPanel listsManagementPanel;
    KeywordSearchEditListPanel editListPanel;
    private static final Logger logger = Logger.getLogger(KeywordSearchConfigurationPanel1.class.getName());
    private static final String KEYWORD_CONFIG_NAME = org.openide.util.NbBundle.getMessage(KeywordSearchPanel.class, "ListBundleConfig");
    
    /** Creates new form KeywordSearchConfigurationPanel1 */
    KeywordSearchConfigurationPanel1() {
        this(new KeywordSearchConfigController());
    }
    
    KeywordSearchConfigurationPanel1(KeywordSearchConfigController controller) {
        initComponents();
        customizeComponents();
        setName(KEYWORD_CONFIG_NAME);
        setController(controller);
    }
    
    public final void setController(KeywordSearchConfigController controller) {
        listsManagementPanel.setController(controller);
        editListPanel.setController(controller);
    }

    private void customizeComponents() {
        listsManagementPanel = new KeywordSearchListsManagementPanel();
        editListPanel = new KeywordSearchEditListPanel();

        listsManagementPanel.addListSelectionListener(editListPanel);
        
        // the editListPanel needs a reference to the listsManagementPanel's
        // table model so that it can retrieve the name of the currently selected
        // list which it can use to get the list itself through the controller.
        editListPanel.setKeywordListTableModel(listsManagementPanel.getTableModel());
        
        mainSplitPane.setLeftComponent(listsManagementPanel);
        mainSplitPane.setRightComponent(editListPanel);
        mainSplitPane.revalidate();
        mainSplitPane.repaint();
    }
    
    @Override
    public void store() {
        listsManagementPanel.store();
        editListPanel.store();
    }
    
    @Override
    public void load() {
        listsManagementPanel.load();
        editListPanel.load();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainSplitPane = new javax.swing.JSplitPane();
        leftPanel = new javax.swing.JPanel();
        rightPanel = new javax.swing.JPanel();

        mainSplitPane.setBorder(null);
        mainSplitPane.setDividerLocation(275);

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );

        mainSplitPane.setLeftComponent(leftPanel);

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 318, Short.MAX_VALUE)
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );

        mainSplitPane.setRightComponent(rightPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainSplitPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainSplitPane)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel leftPanel;
    private javax.swing.JSplitPane mainSplitPane;
    private javax.swing.JPanel rightPanel;
    // End of variables declaration//GEN-END:variables
    
}
