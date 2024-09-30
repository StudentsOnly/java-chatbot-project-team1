import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class BillingTopic implements Topic {
    private String topicName = "Billing Issues";
    private LinkedHashMap<String, String> questionsAndAnswers;

    public BillingTopic() {
        questionsAndAnswers = new LinkedHashMap<>();
        questionsAndAnswers.put("1. How do i update my payment method", "You can update your payment method in your account settings under 'Payment Options'.");
        questionsAndAnswers.put("2. Why was my card declined", "Please check with your bank for any issues, or try using a different payment method.");
        questionsAndAnswers.put("3. Can i get a copy of my invoice", "You can download a copy of your invoice from your order history page.");
    }

    @Override
    public String getTopicName() {
        return topicName;
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
