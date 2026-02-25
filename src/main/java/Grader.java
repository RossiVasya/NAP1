import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Grader {

    private static final Logger logger = LogManager.getLogger(Grader.class);

    public void evaluate(Student student) {

        logger.info("Оценка студента: {}", student.name);

        double avg = student.calculateAverage();
        logger.info("Средний балл: {}", avg);

        if (student.isPassed()) {
            System.out.println("Студент " + student.name + " сдал.");
            logger.info("Статус {} : Сдал", student.name);
        } else {
            System.out.println("Студент " + student.name + " не сдал.");
            logger.warn("Статус {}: Не сдал", student.name);
        }
    }
}