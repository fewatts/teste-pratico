import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Billing {

    public static void main(String[] args) {
        String filePath = "assets/billing.json"; // Path to the JSON file

        try {
            // Read the JSON file
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray jsonArray = new JSONArray(content);

            // List to store billing values
            List<Double> billingValues = new ArrayList<>();

            // Populate the billing values list
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                double value = jsonObject.getDouble("value");
                if (value > 0) {
                    billingValues.add(value);
                }
            }

            if (billingValues.isEmpty()) {
                System.out.println("No billing data to process.");
                return;
            }

            // Calculate the smallest and largest billing values
            double minValue = billingValues.stream().min(Double::compare).orElse(0.0);
            double maxValue = billingValues.stream().max(Double::compare).orElse(0.0);

            // Calculate the monthly average
            double monthlyAverage = billingValues.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

            // Count the number of days with billing above the monthly average
            long daysAboveAverage = billingValues.stream().filter(value -> value > monthlyAverage).count();

            // Display results
            System.out.println("Smallest billing value: " + minValue);
            System.out.println("Largest billing value: " + maxValue);
            System.out.println("Number of days above the monthly average: " + daysAboveAverage);

        } catch (IOException e) {
            System.err.println("Error reading the JSON file: " + e.getMessage());
        }
    }
}
