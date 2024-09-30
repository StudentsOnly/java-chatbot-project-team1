import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CustomerSupportChatBot {
    private Map<String, Topic> topics;
    private Topic currentTopic;
    private Scanner scanner;
    private CustomerDB customers;
    private Order order;


    public CustomerSupportChatBot(Map<String, Topic> topics, CustomerDB customers) {
        this.topics = topics;
        this.customers = customers;
        this.currentTopic = null; // No topic selected initially
        this.scanner = new Scanner(System.in);
    }


    public void startChat() {
        displayMessage("ChatBot: Hello! How can I assist you today?");

        String name = "Rita";
        while (true) {
            displayMessage("ChatBot: Please provide your name or CustomerID:");
                String inputNameOrId = getUserInput().toLowerCase();
            Customer foundCustomer = isInteger(inputNameOrId) ?
                    customers.getCustomerById(Integer.parseInt(inputNameOrId)) :
                    customers.getCustomerByName(inputNameOrId);
            if (foundCustomer == null) {
                System.out.println("Customer not found.");
                break;
            }
            else
            { name = foundCustomer.getName();
            break;
            }
        }

        displayMessage("ChatBot: Hello " + name + "! How can I help you?");
        showTopics();

        while (true) {
            String input = getUserInput().toLowerCase();

            if (input.equals("exit")) {
                displayMessage("ChatBot: Thank you for chatting with us. Goodbye!");
                break;
            }

            if (currentTopic == null) {
                handleTopicSelection(input);
            } else {
                handleQuery(input);
                displayMessage("ChatBot: Do you have any other questions? (yes/no)");
                String answer = getUserInput().toLowerCase();
                if (answer.equalsIgnoreCase("yes")) {
                    currentTopic = null;
                    showTopics();
                }
                else {
                    displayMessage("ChatBot: Thank you for chatting with us. Goodbye!");
                }
            }
        }
    }

    private void displayMessage(String message) {
        System.out.println(message);
    }

    private String getUserInput() {
        return scanner.nextLine();
    }

    private void showTopics() {
        displayMessage("Please select a topic by typing the number:");
        for (String key : topics.keySet()) {
            displayMessage(key + ". " + topics.get(key).getTopicName());
        }
    }

    private void handleTopicSelection(String input) {
        Topic selectedTopic = topics.get(input);
        if (selectedTopic != null) {
            currentTopic = selectedTopic;
            displayMessage("ChatBot: You have selected " + currentTopic.getTopicName());
            currentTopic.showPredefinedQuestions();
            displayMessage("Please select your question or type 'back' to return to topic selection.");
        } else {
            displayMessage("ChatBot: Invalid topic. Please choose a valid topic:");
            showTopics();
        }
    }

    private void handleQuery(String input) {
        if (input.equalsIgnoreCase("back")) {
            currentTopic = null;
            showTopics();
            return;
        }

        String answer = currentTopic.getAnswer(input);
        if (answer != null) {
            displayMessage("ChatBot: " + answer);
        } else {
            displayMessage("ChatBot: I'm sorry, I don't understand your question. Would you like to contact customer support? (yes/no)");
            String contactSupport = getUserInput();
            if (contactSupport.equalsIgnoreCase("yes")) {
                displayMessage("ChatBot: Please contact our customer support at 1-800-123-4567.");
            }
        }
    }

    public static boolean isInteger(String str) {
        if (str == null || str.isEmpty()) {
            return false;  // null or empty strings are not integers
        }
        return str.matches("-?\\d+");  // matches optional "-" followed by digits
    }
}

