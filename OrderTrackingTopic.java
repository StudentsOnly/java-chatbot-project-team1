import java.util.HashMap;
import java.util.Map;

public class OrderTrackingTopic implements Topic {
    private String topicName = "Order Tracking";
    private Map<String, String> questionsAndAnswers;

    public OrderTrackingTopic() {
        questionsAndAnswers = new HashMap<>();
        questionsAndAnswers.put("Where is my order", "Your order is currently being processed and will be delivered by next week.");
        questionsAndAnswers.put("How do i track my order", "You can track your order by logging into your account and checking the 'Orders' section.");
        questionsAndAnswers.put("Can i change my delivery address", "Unfortunately, once an order is dispatched, the delivery address cannot be changed.");
    }

    @Override
    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    @Override
    public String getAnswer(String query) {
        return questionsAndAnswers.get(query.toLowerCase());
    }

    @Override
    public void showPredefinedQuestions() {
        questionsAndAnswers.keySet().forEach(System.out::println);

    }
}
