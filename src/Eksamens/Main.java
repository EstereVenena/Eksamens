package Eksamens;
import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Jautājumu un atbilžu inicializācija
        String[] questions = {
                "1. Kas tiks izvadīts ekrānā ja kods būs šāds: System.out.println(\"Hello\".charAt(1));",
                "2. Kāda ir metode, lai pievienotu virkni virknē?",
                "3. Kas ir `StringBuilder` klase?",
                "4. Kā izsaukt metodi, lai salīdzinātu divas virknes, ignorējot reģistru?",
                "5. Kāda metode pārveido simbolu virkni par lielajiem burtiem?",
                "6. Kā piekļūt simbolu virknes garumam?",
                "7. Kas tiks izvadīts ekrānā ja kods būs šāds: System.out.println(\"abc\".substring(1, 3));",
                "8. Kāda ir metode, lai pārbaudītu vai virkne sākas ar konkrētu apakšvirkni?",
                "9. Kas tiks izvadīts ekrānā ja kods būs šāds: System.out.println(\"abc\".indexOf('b'));",
                "10. Kā pievienot simbolu virknes virknei izmantojot `StringBuilder`?"
        };

        String[][] options = {
                {"H", "e", "l", "o"},
                {".append()", ".add()", ".concat()", ".merge()"},
                {"Neinstancējama klase", "Imutabla klase", "Maināma klase", "Pārdefinējama klase"},
                {".equalsIgnoreCase()", ".compareToIgnoreCase()", ".compareIgnoreCase()", ".equalsToIgnoreCase()"},
                {".toUpperCase()", ".toCapitalize()", ".toUpper()", ".capitalize()"},
                {".length()", ".size()", ".count()", ".getLength()"},
                {"a", "bc", "ab", "b"},
                {".startsWith()", ".beginsWith()", ".hasPrefix()", ".starts()"},
                {"0", "1", "2", "-1"},
                {".add()", ".append()", ".concat()", ".insert()"}
        };

        int[] correctAnswers = {1, 0, 2, 0, 0, 0, 1, 0, 1, 1};

        // Lietotāja atbildes
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
                // Ja lietotājs izvēlas "Iziet"
                JOptionPane.showMessageDialog(null, "Tests pārtraukts.", "Iziet", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }

            userAnswers[i] = response;
        }

        // Rezultātu apstrāde
        int correctCount = 0;
        for (int i = 0; i < questions.length; i++) {
            if (userAnswers[i] == correctAnswers[i]) {
                correctCount++;
            } else {
                incorrectQuestions.add(i);
            }
        }

        // Rezultātu paziņošana
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
