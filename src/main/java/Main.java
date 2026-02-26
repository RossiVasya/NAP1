import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        logger.info("Программа запущена");

        try {
            System.out.print("Введите имя студента: ");
            String name = scanner.nextLine();
            logger.info("Имя студента: {}", name);

            System.out.print("Введите количество предметов: ");
            int count = scanner.nextInt();
            logger.debug("Количество предметов: {}", count);

            if (count <= 0) {
                throw new IllegalArgumentException("Количество предметов должно быть > 0");
            }

            Student student = new Student(name, count);

            for (int i = 0; i < count; i++) {
                System.out.print("Оценка по предмету (0-10) " + (i + 1) + ": ");
                int grade = scanner.nextInt();

                if (grade < 0 || grade > 10) {
                    throw new IllegalArgumentException("Оценка должна быть от 0 до 10");
                }

                logger.debug("Оценка {}: {}", i + 1, grade);
                student.setGrade(i, grade);
            }

            Grader grader = new Grader();
            grader.evaluate(student);

        } catch (Exception e) {

            System.out.println("Ошибка: " + e.getMessage());

            logger.error("Произошло исключение", e);

        } finally {
            logger.info("Программа завершена");
            scanner.close();
        }
    }
}