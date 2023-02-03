package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalWords {

    public List<String> words = new ArrayList<>(List.of("azul", "vermelho", "rosa", "verde"));

    public String confirmWord(String target) {
        int index = words.indexOf(target);

        if(index == -1) return null;

        return words.get(index);
    }

    public static void main(String[] args) {

        OptionalWords op = new OptionalWords();
        Optional<String> optionalWord = op.words.stream()
                .filter(w -> w.equals("roxo")).findFirst();

        String value = optionalWord.orElseThrow(RuntimeException::new);
        System.out.println(value);

    }

}
