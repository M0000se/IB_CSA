package org.example.Quiz;

import java.util.Scanner;

public class QuizLogic {

    private Question[] questions = new Question[4];
    private Scanner in = new Scanner(System.in);

    QuizLogic(){
        questions[0] = new Question("What is the capital of France?", "Paris");
        questions[1] = new Question("Are apples edible", "yes");
        questions[2] = new Question("Whats bigger than 1", "any number from 2 to infinity");
        questions[3] = new Question("Is wood edible", "yes");
    }
    public void run()
    {
        int score = 0;
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i].getQuestion());
            String answer = in.nextLine();
            if (answer.equals(questions[i].getAnswer())) {
                score++;
            }
        }
        System.out.println("Your score is: " + score);
    }
}
