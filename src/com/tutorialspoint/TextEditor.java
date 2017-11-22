package com.tutorialspoint;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {
    private SpellChecker spellChecker;

    @Autowired
    public TextEditor(SpellChecker spellChecker) {
        System.out.println("TextEditor: Dentro del constructor");
        this.spellChecker = spellChecker;
    }

    public void spellCheck() {
        spellChecker.spellChecking();
    }
}
