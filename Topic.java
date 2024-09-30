import java.util.HashMap;
import java.util.Map;

public interface Topic {
    String getTopicName();
    String getAnswer(String query);
    void showPredefinedQuestions();
}