package com.tutorialspoint;

public class TextEditor {
    private SpellChecker spellChecker;

    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

    public void setSpellChecker(SpellChecker spellChecker) {
        System.out.println("TextEditor: Dentro de setSpellChecker");
        this.spellChecker = spellChecker;
    }

    public void spellCheck() {
        spellChecker.spellChecking();
    }
}
