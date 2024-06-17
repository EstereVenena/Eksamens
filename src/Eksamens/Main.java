package Eksamens;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StringFunctionsTestFX extends Application {

    private int currentQuestionIndex = 0;
    private int score = 0;
    private char[] userAnswers = new char[10];

    private String[] questions = {
            "Kas atgriež simbolu virknes garumu?",
            "Kas atgriež simbolu noteiktā pozīcijā?",
            "Kas atgriež apakšvirkni no sākuma indeksa līdz beigām indeksam?",
            "Kas atgriež pirmo norādītā simbolu virknes sastopamo vietu?",
            "Kas pārveido virkni uz mazajiem burtiem?",
            "Kas pārveido virkni uz lielajiem burtiem?",
            "Kas aizvieto visus norādītos vecos simbolus ar jauniem?",
            "Kas noņem liekās atstarpes no virknes sākuma un beigām?",
            "Kas pārbauda, vai virkne ir tukša?",
            "Kas savieno divas virknes?"
    };

    private String[][] options = {
            {"length()", "size()", "getLength()", "count()"},
            {"getChar()", "charAt()", "char()", "characterAt()"},
            {"substring()", "subString()", "substr()", "getSubstring()"},
            {"find()", "search()", "indexOf()", "locate()"},
            {"toLowerCase()", "lower()", "toSmallCase()", "small()"},
            {"toUpperCase()", "upper()", "toCapital()", "capital()"},
            {"replace()", "substitute()", "change()", "swap()"},
            {"trim()", "strip()", "cut()", "remove()"},
            {"isEmpty()", "isBlank()", "length() == 0", "isVoid()"},
            {"append()", "concat()", "join()", "merge()"}
    };

    private char[] answers = {'a', 'b', 'a', 'c', 'a', 'a', 'a', 'a', 'a', 'b'};

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("String Functions Test");

        VBox layout = new VBox(20);
        Text questionText = new Text(questions[currentQuestionIndex]);
        ImageView imageView = new ImageView(new Image("file:question" + (currentQuestionIndex + 1) + ".png"));
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(options[currentQuestionIndex]);

        Button nextButton = new Button("Next");
        nextButton.setOnAction(e -> {
            if (comboBox.getValue() != null) {
                userAnswers[currentQuestionIndex] = getAnswerChar(comboBox.getValue());
                if (userAnswers[currentQuestionIndex] == answers[currentQuestionIndex]) {
                    score++;
                }
                currentQuestionIndex++;
                if (currentQuestionIndex < questions.length) {
                    questionText.setText(questions[currentQuestionIndex]);
                    imageView.setImage(new Image("file:question" + (currentQuestionIndex + 1) + ".png"));
                    comboBox.getItems().setAll(options[currentQuestionIndex]);
                    comboBox.setValue(null);
                } else {
                    showResults(primaryStage);
                }
            }
        });

        layout.getChildren().addAll(questionText, imageView, comboBox, nextButton);
        Scene scene = new Scene(layout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private char getAnswerChar(String answer) {
        switch (answer) {
            case "length()":
            case "getChar()":
            case "substring()":
            case "find()":
            case "toLowerCase()":
            case "toUpperCase()":
            case "replace()":
            case "trim()":
            case "isEmpty()":
            case "append()":
                return 'a';
            case "charAt()":
            case "search()":
            case "subString()":
            case "lower()":
            case "upper()":
            case "substitute()":
            case "strip()":
            case "isBlank()":
            case "concat()":
                return 'b';
            case "char()":
            case "indexOf()":
            case "substr()":
            case "toSmallCase()":
            case "toCapital()":
            case "change()":
            case "cut()":
            case "length() == 0":
            case "join()":
                return 'c';
            case "characterAt()":
            case "locate()":
            case "getSubstring()":
            case "small()":
            case "capital()":
            case "swap()":
            case "remove()":
            case "isVoid()":
            case "merge()":
                return 'd';
            default:
                return ' ';
        }
    }

    private void showResults(Stage primaryStage) {
        VBox layout = new VBox(20);
        Text resultText = new Text("Jūs atbildējāt pareizi uz " + score + " jautājumiem no 10.");
        layout.getChildren().add(resultText);

        Text incorrectQuestionsText = new Text("Nepareizie jautājumi:");
        layout.getChildren().add(incorrectQuestionsText);
        for (int i = 0; i < questions.length; i++) {
            if (userAnswers[i] != answers[i]) {
                layout.getChildren().add(new Text(questions[i]));
            }
        }

        Scene resultScene = new Scene(layout, 600, 400);
        primaryStage.setScene(resultScene);
        primaryStage.show();
    }
}

