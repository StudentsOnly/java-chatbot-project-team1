import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ProductInformationTopic implements Topic {
    private String topicName = "Product Information";
    private LinkedHashMap<String, String> questionsAndAnswers;

    public ProductInformationTopic() {
        questionsAndAnswers = new LinkedHashMap<>();
        questionsAndAnswers.put("1. What is the return policy", "You can return most items within 30 days of receipt for a full refund.");
        questionsAndAnswers.put("2. Do you offer warranties", "Yes, many of our products come with a warranty. Please check the product details for more information.");
        questionsAndAnswers.put("3. How do i find product specifications", "You can find product specifications on the product detail page under 'Specifications'.");
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
