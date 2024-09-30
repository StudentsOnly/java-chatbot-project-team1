import java.util.HashMap;
import java.util.Map;

public class ProductInformationTopic implements Topic {
    private String topicName = "Product Information";
    private Map<String, String> questionsAndAnswers;

    public ProductInformationTopic() {
        questionsAndAnswers = new HashMap<>();
        questionsAndAnswers.put("what is the return policy", "You can return most items within 30 days of receipt for a full refund.");
        questionsAndAnswers.put("do you offer warranties", "Yes, many of our products come with a warranty. Please check the product details for more information.");
        questionsAndAnswers.put("how do i find product specifications", "You can find product specifications on the product detail page under 'Specifications'.");
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
