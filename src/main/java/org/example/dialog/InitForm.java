package org.example.dialog;

import com.intellij.openapi.actionSystem.AnActionEvent;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitForm  extends JDialog {

    private AnActionEvent event;
    private JButton OKButton;
    private JButton cancelButton;
    private JTextField urlField1;
    private JPanel initPanel;

    public InitForm(AnActionEvent e) {
        this.event = e;
        this.setContentPane(initPanel);
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onOk();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });
    }

    public void onOk() {
        if (StringUtils.isEmpty(urlField1.getText())) {
            JOptionPane.showMessageDialog(null, "url is null!", "ERROR_MESSAGE", 0);
            dispose();
        }
    }

    public void onCancel() {
        dispose();
    }

}
