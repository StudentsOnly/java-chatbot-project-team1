import java.util.HashMap;
import java.util.Map;

public class BillingTopic implements Topic {
    private String topicName = "Billing Issues";
    private Map<String, String> questionsAndAnswers;

    public BillingTopic() {
        questionsAndAnswers = new HashMap<>();
        questionsAndAnswers.put("How do i update my payment method", "You can update your payment method in your account settings under 'Payment Options'.");
        questionsAndAnswers.put("Why was my card declined", "Please check with your bank for any issues, or try using a different payment method.");
        questionsAndAnswers.put("Can i get a copy of my invoice", "You can download a copy of your invoice from your order history page.");
    }

    @Override
    public String getTopicName() {
        return topicName;
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
