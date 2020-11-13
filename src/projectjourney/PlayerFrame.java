package projectjourney;

import javax.swing.JFrame;

public class PlayerFrame extends javax.swing.JFrame {
    
    private MapCanvas MP;
    private ClockCanvas CC;
    private Narrator narrator;
    
    public PlayerFrame(Narrator n) {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        narrator = n;
        MP = new MapCanvas(this);
        mapPanel.add(MP);
        CC = new ClockCanvas();
        clockPanel.add(CC);
        clockPanel.revalidate();
        healthBar.setMaximum(1000);
        manaBar.setMaximum(1000);
        foodBar.setMaximum(1000);
        waterBar.setMaximum(1000);
        sleepBar.setMaximum(1000);
        energyBar.setMaximum(1000);
        update();
    }
    
    public void update() {
        MP.paint2(mapPanel.getGraphics(), narrator.getTime());
        
        nameLabel.setText(getPlayer().getName());
        healthBar.setValue((int)getPlayer().getHealth());
        manaBar.setValue((int)getPlayer().getMana());
        foodBar.setValue((int)getPlayer().getFood());
        waterBar.setValue((int)getPlayer().getWater());
        sleepBar.setValue((int)getPlayer().getSleep());
        energyBar.setValue((int)getPlayer().getEnergy());
        textLog.setText(getPlayer().getAdventureLog().toString());
        
        yearLabel.setText("Year: " + narrator.getTime().getYear());
        monthLabel.setText("Month: " + narrator.getTime().getMonthName());
        dayLabel.setText("Day: " + narrator.getTime().getDayM() + " (" + narrator.getTime().getDayWName() + ")");
        hourLabel.setText("Hour: " + narrator.getTime().getHour());
        minuteLabel.setText("Minute: " + narrator.getTime().getMinute());
        
        CC.paint(clockPanel.getGraphics(), narrator.getTime());
        Tile tile = getPlayer().getCurrentTile();
        tileTextArea.setText("                             " + tile.getName() +
                "\n\nHeight: " + Func.truncate(tile.getDepth(), 2) + 
                "\nHumidity: " + Func.truncate(getPlayer().getCurrentTile().getHumidity(), 2) + 
                "\nHigh Temperature: " + Func.truncate(tile.getTemperatureH(), 2) + 
                "\nLow Temperature: " + Func.truncate(tile.getTemperatureL(), 2) +
                "\nCurrent Temperature: " + Func.truncate(tile.getCurrentTemperature(), 2) + 
                "\nAccessible: " + tile.isAccessible());
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gameLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textLog = new javax.swing.JTextArea();
        mapPanel = new javax.swing.JPanel();
        updateButton = new javax.swing.JButton();
        chooseBox = new javax.swing.JComboBox();
        promptField = new javax.swing.JTextField();
        chooseButton = new javax.swing.JButton();
        leftButton = new javax.swing.JButton();
        downButton = new javax.swing.JButton();
        upButton = new javax.swing.JButton();
        rightButton = new javax.swing.JButton();
        buttonField = new javax.swing.JTextField();
        yearLabel = new javax.swing.JLabel();
        monthLabel = new javax.swing.JLabel();
        dayLabel = new javax.swing.JLabel();
        hourLabel = new javax.swing.JLabel();
        minuteLabel = new javax.swing.JLabel();
        clockPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tileTextArea = new javax.swing.JTextArea();
        nameLabel = new javax.swing.JLabel();
        healthLabel = new javax.swing.JLabel();
        healthBar = new javax.swing.JProgressBar();
        manaLabel = new javax.swing.JLabel();
        manaBar = new javax.swing.JProgressBar();
        foodBar = new javax.swing.JProgressBar();
        waterBar = new javax.swing.JProgressBar();
        waterLabel = new javax.swing.JLabel();
        inventoryChoice = new javax.swing.JComboBox();
        useButton = new javax.swing.JButton();
        checkButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        inventoryText = new javax.swing.JTextArea();
        energyBar = new javax.swing.JProgressBar();
        sleepBar = new javax.swing.JProgressBar();
        energyLabel = new javax.swing.JLabel();
        foodLabel = new javax.swing.JLabel();
        sleepLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        gameLabel.setFont(new java.awt.Font("Segoe Script", 3, 36)); // NOI18N
        gameLabel.setForeground(new java.awt.Color(0, 0, 255));
        gameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gameLabel.setText("Project Journey");

        textLog.setColumns(20);
        textLog.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        textLog.setLineWrap(true);
        textLog.setRows(5);
        textLog.setWrapStyleWord(true);
        jScrollPane1.setViewportView(textLog);

        mapPanel.setBackground(new java.awt.Color(0, 0, 0));
        mapPanel.setMaximumSize(new java.awt.Dimension(500, 500));
        mapPanel.setMinimumSize(new java.awt.Dimension(500, 500));

        javax.swing.GroupLayout mapPanelLayout = new javax.swing.GroupLayout(mapPanel);
        mapPanel.setLayout(mapPanelLayout);
        mapPanelLayout.setHorizontalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        mapPanelLayout.setVerticalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        promptField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                updatePromptField(evt);
            }
        });

        chooseButton.setText("choose");

        leftButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/arrow4.png"))); // NOI18N
        leftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftButtonActionPerformed(evt);
            }
        });

        downButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/arrow2.png"))); // NOI18N
        downButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downButtonActionPerformed(evt);
            }
        });

        upButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/arrow.png"))); // NOI18N
        upButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upButtonActionPerformed(evt);
            }
        });

        rightButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/arrow3.png"))); // NOI18N
        rightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightButtonActionPerformed(evt);
            }
        });

        yearLabel.setText("Year: 0");
        yearLabel.setFocusable(false);

        monthLabel.setText("Month: January");
        monthLabel.setFocusable(false);

        dayLabel.setText("Day: 1");
        dayLabel.setFocusable(false);

        hourLabel.setText("Hour: 6");
        hourLabel.setFocusable(false);

        minuteLabel.setText("Minute: 0");
        minuteLabel.setFocusable(false);

        clockPanel.setFocusable(false);

        javax.swing.GroupLayout clockPanelLayout = new javax.swing.GroupLayout(clockPanel);
        clockPanel.setLayout(clockPanelLayout);
        clockPanelLayout.setHorizontalGroup(
            clockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        clockPanelLayout.setVerticalGroup(
            clockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        tileTextArea.setBackground(new java.awt.Color(240, 240, 240));
        tileTextArea.setColumns(20);
        tileTextArea.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tileTextArea.setRows(5);
        tileTextArea.setFocusable(false);
        jScrollPane2.setViewportView(tileTextArea);

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setText("Name");

        healthLabel.setText("Health:");

        healthBar.setForeground(new java.awt.Color(0, 255, 0));

        manaLabel.setText("Mana:");

        manaBar.setForeground(new java.awt.Color(153, 0, 255));

        foodBar.setForeground(new java.awt.Color(255, 0, 0));

        waterBar.setForeground(new java.awt.Color(0, 0, 255));

        waterLabel.setText("Water:");

        useButton.setText("Use");

        checkButton.setText("Check");

        inventoryText.setColumns(20);
        inventoryText.setRows(5);
        jScrollPane3.setViewportView(inventoryText);

        energyLabel.setText("Energy:");

        foodLabel.setText("Food:");
        foodLabel.setMaximumSize(new java.awt.Dimension(35, 14));
        foodLabel.setMinimumSize(new java.awt.Dimension(35, 14));
        foodLabel.setPreferredSize(new java.awt.Dimension(35, 14));

        sleepLabel.setText("Sleep:");
        sleepLabel.setMaximumSize(new java.awt.Dimension(35, 14));
        sleepLabel.setMinimumSize(new java.awt.Dimension(35, 14));
        sleepLabel.setPreferredSize(new java.awt.Dimension(35, 14));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(updateButton)
                            .addComponent(mapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(promptField)
                            .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(healthLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(healthBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(manaLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(manaBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(sleepLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sleepBar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(inventoryChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(foodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(foodBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(useButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(checkButton))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(waterLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(waterBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(energyLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(energyBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chooseBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chooseButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(leftButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(upButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(downButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 60, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(minuteLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(hourLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dayLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(yearLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(monthLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(clockPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(yearLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(monthLabel))
                                            .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(dayLabel)
                                                .addComponent(healthLabel))
                                            .addComponent(manaBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(manaLabel)))
                                    .addComponent(healthBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(hourLabel)
                                    .addComponent(foodBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(waterBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(waterLabel)
                                    .addComponent(foodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(energyLabel)
                                    .addComponent(minuteLabel)
                                    .addComponent(energyBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sleepBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sleepLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inventoryChoice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(useButton)
                                        .addComponent(checkButton)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(clockPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(chooseBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chooseButton))
                                .addGap(18, 18, 18)
                                .addComponent(upButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(leftButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(downButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(mapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(promptField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(updateButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        update();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void upButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upButtonActionPerformed
        getPlayer().move(0, -1);
        update();
    }//GEN-LAST:event_upButtonActionPerformed

    private void leftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftButtonActionPerformed
        getPlayer().move(-1, 0);
        update();
    }//GEN-LAST:event_leftButtonActionPerformed

    private void rightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightButtonActionPerformed
        getPlayer().move(1, 0);
        update();
    }//GEN-LAST:event_rightButtonActionPerformed

    private void downButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downButtonActionPerformed
        getPlayer().move(0, 1);
        update();
    }//GEN-LAST:event_downButtonActionPerformed

    private void updatePromptField(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_updatePromptField
        //System.out.println(evt.getExtendedKeyCode());
        switch(evt.getExtendedKeyCode()) {
            case(10):
                narrator.pushAnswer(promptField.getText());
                promptField.setText("");
                break;
            case(37):
                leftButtonActionPerformed(null);
                break;
            case(38):
                upButtonActionPerformed(null);
                break;
            case(39):
                rightButtonActionPerformed(null);
                break;
            case(40):
                downButtonActionPerformed(null);
                break;
        }
    }//GEN-LAST:event_updatePromptField

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buttonField;
    private javax.swing.JButton checkButton;
    private javax.swing.JComboBox chooseBox;
    private javax.swing.JButton chooseButton;
    private javax.swing.JPanel clockPanel;
    private javax.swing.JLabel dayLabel;
    private javax.swing.JButton downButton;
    private javax.swing.JProgressBar energyBar;
    private javax.swing.JLabel energyLabel;
    private javax.swing.JProgressBar foodBar;
    private javax.swing.JLabel foodLabel;
    private javax.swing.JLabel gameLabel;
    private javax.swing.JProgressBar healthBar;
    private javax.swing.JLabel healthLabel;
    private javax.swing.JLabel hourLabel;
    private javax.swing.JComboBox inventoryChoice;
    private javax.swing.JTextArea inventoryText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton leftButton;
    private javax.swing.JProgressBar manaBar;
    private javax.swing.JLabel manaLabel;
    private javax.swing.JPanel mapPanel;
    private javax.swing.JLabel minuteLabel;
    private javax.swing.JLabel monthLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField promptField;
    private javax.swing.JButton rightButton;
    private javax.swing.JProgressBar sleepBar;
    private javax.swing.JLabel sleepLabel;
    public javax.swing.JTextArea textLog;
    private javax.swing.JTextArea tileTextArea;
    private javax.swing.JButton upButton;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton useButton;
    private javax.swing.JProgressBar waterBar;
    private javax.swing.JLabel waterLabel;
    private javax.swing.JLabel yearLabel;
    // End of variables declaration//GEN-END:variables

    public Narrator getNarrator() {
        return narrator;
    }
    public void setNarrator(Narrator narrator) {
        this.narrator = narrator;
    }
    
    public Player getPlayer() {return narrator.getPlayer();}
    public Map getMap() {return narrator.getPlayer().getCurrentMap();}
    
}