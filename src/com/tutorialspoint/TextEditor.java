package com.tutorialspoint;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class TextEditor {
    private SpellChecker spellChecker;

    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

    @Resource(name = "spellChecker")
    public void setSpellChecker(SpellChecker spellChecker) {
        System.out.println("TextEditor: Dentro de setSpellChecker");
        this.spellChecker = spellChecker;
    }

    public void spellCheck() {
        spellChecker.spellChecking();
    }
}
