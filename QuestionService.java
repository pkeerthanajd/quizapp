
import java.util.Scanner;

public class QuestionService {
    Question[] questions = new Question[5];
    String selection[] = new String[5];

    public QuestionService() {
        questions[0] = new Question(1, " What is the size of int?", "2", "6", "4", "8", "4");
        questions[1] = new Question(2, " What is the size of double?", "2", "6", "4", "8", "8");
        questions[2] = new Question(3, " What is the size of char?", "2", "6", "4", "8", "2");
        questions[3] = new Question(4, " What is the size of long?", "2", "6", "4", "8", "8");
        questions[4] = new Question(5, " What is the size of boolean?", "1", "2", "4", "8", "1");

    }

    public void playquiz() {
        int i = 0;
        for (Question q : questions) {
            System.out.print("Question No: " + q.getId());
            System.out.println(q.getQuestion());
            System.out.println("a. " + q.getOpt1());
            System.out.println("b. " + q.getOpt2());
            System.out.println("c. " + q.getOpt3());
            System.out.println("d. " + q.getOpt4());
            Scanner s = new Scanner(System.in);
            System.out.print("Enter your answer ");
            selection[i] = s.nextLine();// or i can pass this on i++ on [] hereitself
            i++;
        }
        System.out.println("-------------------------------------------------------------------------------");
        int count = 0;
        int validResponses = 0;
        // Count only non-empty responses
        for (String sc : selection) {
            if (sc != null && !sc.trim().isEmpty()) {
                validResponses++;
            }
        }
        System.out.print("Your responses: {");

        for (String sc : selection) {
            if (sc != null && !sc.trim().isEmpty()) {
                System.out.print(sc);
                count++;
                if (count < validResponses) {
                    System.out.print(", ");
                }
            }
        }

        System.out.println("}");

    }

    public void printscore() {
        int score = 0;
        for (int i = 0; i < questions.length; i++) {
            Question que = questions[i];
            String actualAnswer = que.getAnswer();
            String userAnswer = selection[i];
            if (actualAnswer.equals(userAnswer)) {
                score++;
            }
        }
        System.out.println("Your score is: " + score);
    }
}
