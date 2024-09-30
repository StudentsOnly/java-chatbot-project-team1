import java.util.HashMap;
import java.util.Map;

public class ChatBotRunner {
    public static void main(String[] args) {
        // Initialize topics
        Map<String, Topic> topics = new HashMap<>();
        topics.put("1", new OrderTrackingTopic());
        topics.put("2", new ProductInformationTopic());
        topics.put("3", new BillingTopic());

        // Initialize and start chatbot
        CustomerSupportChatBot chatBot = new CustomerSupportChatBot(topics);
        chatBot.startChat();
    }
}
