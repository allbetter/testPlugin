package org.example.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.PsiFile;
import com.pnxtest.core.PnxTest;
import org.jetbrains.annotations.NotNull;

/**
 * @author xf
 * @version 1.0
 * @date 2021/x/xx
 */
public class KunTestAction4 extends AnAction {

    @Override
    public void update(@NotNull AnActionEvent e) {
        super.update(e);
        //获取当前在操作的工程上下文
        Project project = e.getData(PlatformDataKeys.PROJECT);

        //获取当前操作的类文件
        PsiFile psiFile = e.getData(CommonDataKeys.PSI_FILE);
        //获取当前类文件的名字
        String fileName = psiFile.getVirtualFile().getName();
        //判断是否可以显示菜单
        if (!fileName.endsWith("xml")) {
            e.getPresentation().setVisible(false);
        }
        e.getPresentation().setText("Run KunText '" + fileName + "'");
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        //获取当前在操作的工程上下文
        Project project = e.getData(PlatformDataKeys.PROJECT);

        //获取当前操作的类文件
        PsiFile psiFile = e.getData(CommonDataKeys.PSI_FILE);
        //获取当前类文件的路径
        String classPath = psiFile.getVirtualFile().getPath();

        String[] strs = new String[2];
        strs[0] = "-target";
        strs[1] = classPath;
        Class clazz = psiFile.getParent().getParent().getSubdirectories()[0].getSubdirectories()[0].getSubdirectories()[0].getSubdirectories()[0].getFiles().getClass();
        PnxTest.run(clazz.getClass(), strs);
        String a = "";
        // todo setupLogger -> PnxTest(560) debug不报错，安装插件运行报错

    }
}
