package Task_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {
    private static int score = 0;
    private static int questionNumber = 0;
    private static List<QuizQuestion> questions;
    private static Timer timer;

    public static void main(String[] args) {
        initializeQuiz();

        Scanner scanner = new Scanner(System.in);

        for (QuizQuestion question : questions) {
            displayQuestion(question);
            startTimer(10); // Timer set to 10 seconds for each question

            int userAnswer = scanner.nextInt();

            if (userAnswer == question.correctOption) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect! The correct answer was option " + question.correctOption + "\n");
            }

            cancelTimer();
        }

        displayResult();
    }

    private static void initializeQuiz() {
        questions = new ArrayList<>();
        questions.add(new QuizQuestion("What is the capital of France?", Arrays.asList("A. Paris", "B. London", "C. Berlin", "D. Rome"), 1));
        questions.add(new QuizQuestion("Which planet is known as the Red Planet?", Arrays.asList("A. Venus", "B. Mars", "C. Jupiter", "D. Saturn"), 2));
        // Add more questions as needed
    }

    private static void displayQuestion(QuizQuestion question) {
        System.out.println("Question " + (questionNumber + 1) + ": " + question.question);
        for (String option : question.options) {
            System.out.println(option);
        }
        System.out.print("Enter your answer (1-" + question.options.size() + "): ");
    }

    private static void startTimer(int seconds) {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up! Moving to the next question.\n");
                cancelTimer();
            }
        }, seconds * 1000);
    }

    private static void cancelTimer() {
        if (timer != null) {
            timer.cancel();
            timer.purge();
        }
    }

    private static void displayResult() {
        System.out.println("Quiz completed!");
        System.out.println("Your final score: " + score + " out of " + questions.size());

        // Display a summary of correct and incorrect answers
        for (int i = 0; i < questions.size(); i++) {
            QuizQuestion question = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + (scoredCorrectly(question) ? "Correct" : "Incorrect"));
        }
    }

    private static boolean scoredCorrectly(QuizQuestion question) {
        return question.correctOption == 1; // Adjust the condition based on your correct answer criteria
    }
}

class QuizQuestion {
    public String question;
    public List<String> options;
    public int correctOption;

    public QuizQuestion(String question, List<String> options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }
}
