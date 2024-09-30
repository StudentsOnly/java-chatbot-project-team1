import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class OrderTrackingTopic implements Topic {
    private String topicName = "Order Tracking";
    private LinkedHashMap<String, String> questionsAndAnswers;

    public OrderTrackingTopic() {
        questionsAndAnswers = new LinkedHashMap<>();
        questionsAndAnswers.put("1. Where is my order", "Your order is currently being processed and will be delivered by next week.");
        questionsAndAnswers.put("2. How do i track my order", "You can track your order by logging into your account and checking the 'Orders' section.");
        questionsAndAnswers.put("3. Can i change my delivery address", "Unfortunately, once an order is dispatched, the delivery address cannot be changed.");
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

        for (Map.Entry<String, String> entry : questionsAndAnswers.entrySet()) {
            char number = query.charAt(0);
            if (number == entry.getKey().charAt(0)) {
                return entry.getValue();
            }
        }
        return "The answer is not found";

    }

    @Override
    public void showPredefinedQuestions() {
        questionsAndAnswers.keySet().forEach(System.out::println);

    }
}
