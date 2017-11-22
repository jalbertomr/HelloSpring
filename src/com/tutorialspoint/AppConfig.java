package com.tutorialspoint;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public TextEditor textEditor(){
        return new TextEditor(spellChecker());
    }

    @Bean
    public SpellChecker spellChecker(){
        return new SpellChecker();
    }

    @Bean
    public Bar bar(){
        return new Bar();
    }

    @Bean
    public Baz baz() {
        return new Baz();
    }

    @Bean
    public Foo foo() {
        return new Foo( bar(), baz() );
    }
/*
    @Bean
    @Qualifier("Foo2")
    public Foo fooYearName() {
        return new Foo( 2017, "fooYearName");
    }
*/
}
