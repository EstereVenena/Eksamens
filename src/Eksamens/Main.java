package Eksamens;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String[] questions = {
            "1. Kas atgriež simbolu virknes garumu?",
            "2. Kas atgriež simbolu noteiktā pozīcijā?",
            "3. Kas atgriež apakšvirkni no sākuma indeksa līdz beigām indeksam?",
            "4. Kas atgriež pirmo norādītā simbolu virknes sastopamo vietu?",
            "5. Kas pārveido virkni uz mazajiem burtiem?",
            "6. Kas pārveido virkni uz lielajiem burtiem?",
            "7. Kas aizvieto visus norādītos vecos simbolus ar jauniem?",
            "8. Kas noņem liekās atstarpes no virknes sākuma un beigām?",
            "9. Kas pārbauda, vai virkne ir tukša?",
            "10. Kas savieno divas virknes?"
        };

        String[][] options = {
            {"a) length()", "b) size()", "c) getLength()", "d) count()"},
            {"a) getChar()", "b) charAt()", "c) char()", "d) characterAt()"},
            {"a) substring()", "b) subString()", "c) substr()", "d) getSubstring()"},
            {"a) find()", "b) search()", "c) indexOf()", "d) locate()"},
            {"a) toLowerCase()", "b) lower()", "c) toSmallCase()", "d) small()"},
            {"a) toUpperCase()", "b) upper()", "c) toCapital()", "d) capital()"},
            {"a) replace()", "b) substitute()", "c) change()", "d) swap()"},
            {"a) trim()", "b) strip()", "c) cut()", "d) remove()"},
            {"a) isEmpty()", "b) isBlank()", "c) length() == 0", "d) isVoid()"},
            {"a) append()", "b) concat()", "c) join()", "d) merge()"}
        };

        char[] answers = {'a', 'b', 'a', 'c', 'a', 'a', 'a', 'a', 'a', 'b'};
        char[] userAnswers = new char[10];
        int score = 0;

        // Loop through the questions and get user input
        for (int i = 0; i < questions.length; i++) {
            StringBuilder question = new StringBuilder(questions[i] + "\n");
            for (String option : options[i]) {
                question.append(option).append("\n");
            }

            String answer = JOptionPane.showInputDialog(null, question.toString(), "Jautājums " + (i + 1), JOptionPane.QUESTION_MESSAGE);
            userAnswers[i] = answer.charAt(0);

            if (userAnswers[i] == answers[i]) {
                score++;
            }
        }

        // Print the result
        StringBuilder result = new StringBuilder("Jūs atbildējāt pareizi uz " + score + " jautājumiem no 10.\nNepareizie jautājumi:\n");

        for (int i = 0; i < questions.length; i++) {
            if (userAnswers[i] != answers[i]) {
                result.append(questions[i]).append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, result.toString(), "Rezultāti", JOptionPane.INFORMATION_MESSAGE);
    }
}
