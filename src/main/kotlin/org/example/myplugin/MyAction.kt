package org.example.myplugin

import ai.grazie.utils.mpp.URLEncoder
import com.intellij.ide.BrowserUtil
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys

class MyAction : AnAction() {
    override fun actionPerformed(event: AnActionEvent) {
        val editor = event.getData(PlatformDataKeys.EDITOR)
        val selectedText = editor?.selectionModel?.selectedText
        try {
            if (selectedText != null) {
                val encodedText = URLEncoder.encode(selectedText)
                val url = "https://translate.yandex.ru/?source_lang=en&target_lang=ru&text=$encodedText"
                BrowserUtil.browse(url)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

}