package org.example.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.example.dialog.InitForm;
import org.jetbrains.annotations.NotNull;

public class InItAction extends AnAction {

    @Override
    public void update(@NotNull AnActionEvent e) {
        e.getPresentation().setVisible(true);
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        InitForm initForm = new InitForm(e);
        initForm.setSize(600, 300);
        initForm.setVisible(true);
    }


}
