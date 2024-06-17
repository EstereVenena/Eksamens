package Eksamens;
import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
    	String[] questions = {
    	            "1. Kas atgriež simbolu virknes garumu?",
    	            "2. Kā piekļūt pirmajam simbolam virknē?",
    	            "3. Kas pārveido virkni uz lielajiem burtiem?",
    	            "4. Kā pārveidot simbolu virkni uz mazajiem burtiem?",
    	            "5. Kā pārbaudīt, vai simbols ir burts?",
    	            "6. Kā pārbaudīt, vai simbols ir cipars?",
    	            "7. Kā pārveidot simbolu par lielo burtu?",
    	            "8. Kā pārveidot simbolu par mazo burtu?",
    	            "9. Kā pārbaudīt, vai simbols ir atstarpe, tabs vai citas tukšās zīmes?",
    	            "10. Kā apvienot divas virknes vienā?"
    	    };

    	     String[][] options = {
    	            {"length()", "size()", "count()", "getLength()"},
    	            {"firstChar()", "charAt(0)", "getChar(0)", "firstCharacter()"},
    	            {"toUpperCase()", "upperCase()", "toBigLetters()", "toCapital()"},
    	            {"toLowerCase()", "lowerCase()", "toSmallLetters()", "toTiny()"},
    	            {"Character.isLetter(ch)", "Character.checkLetter(ch)", "Character.detectLetter(ch)", "Character.verifyLetter(ch)"},
    	            {"Character.isDigit(ch)", "Character.checkDigit(ch)", "Character.detectDigit(ch)", "Character.verifyDigit(ch)"},
    	            {"Character.toUpperCase(ch)", "Character.makeUpperCase(ch)", "Character.toUpper(ch)", "Character.convertToUpperCase(ch)"},
    	            {"Character.toLowerCase(ch)", "Character.makeLowerCase(ch)", "Character.toLower(ch)", "Character.convertToLowerCase(ch)"},
    	            {"Character.isWhitespace(ch)", "Character.checkWhitespace(ch)", "Character.detectEmpty(ch)", "Character.isSpace(ch)"},
    	            {"concat()", "combine()", "append()", "merge()"}
    	    };

    	     int[] correctAnswers = {0, 1, 0, 0, 0, 0, 2, 2, 0, 0};

      
        int[] userAnswers = new int[questions.length];
        ArrayList<Integer> incorrectQuestions = new ArrayList<>();

        for (int i = 0; i < questions.length; i++) {
            ImageIcon icon = new ImageIcon("images/question" + (i + 1) + ".png");
            Object[] optionsWithExit = new Object[options[i].length + 1];
            System.arraycopy(options[i], 0, optionsWithExit, 0, options[i].length);
            optionsWithExit[options[i].length] = "Iziet";

            int response = JOptionPane.showOptionDialog(null, questions[i], "Jautājums " + (i + 1),
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, optionsWithExit, optionsWithExit[0]);
            if (response == options[i].length) {
             JOptionPane.showMessageDialog(null, "Tests pārtraukts.", "Iziet", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            userAnswers[i] = response;
        }
            int correctCount = 0;
        for (int i = 0; i < questions.length; i++) {
            if (userAnswers[i] == correctAnswers[i]) {
                correctCount++;
            } else {
                incorrectQuestions.add(i);
            }
        }

            StringBuilder resultMessage = new StringBuilder();
        resultMessage.append("Pareizi atbildēti jautājumi: ").append(correctCount).append(" no ").append(questions.length).append("\n");

        if (!incorrectQuestions.isEmpty()) {
            resultMessage.append("Nepareizi atbildēti jautājumi:\n");
            for (int index : incorrectQuestions) {
                resultMessage.append("Jautājums ").append(index + 1).append(": ").append(questions[index]).append("\n");
                resultMessage.append("Pareizā atbilde: ").append(options[index][correctAnswers[index]]).append("\n\n");
            }
        }
        JOptionPane.showMessageDialog(null, resultMessage.toString(), "Rezultāti", JOptionPane.INFORMATION_MESSAGE);
    }
}
