public class StateRevenuePercentage {

    public static void main(String[] args) {
        // Revenue by state
        double sp = 67836.43;
        double rj = 36678.66;
        double mg = 29229.88;
        double es = 27165.48;
        double others = 19849.53;

        // Calculate the total revenue
        double total = sp + rj + mg + es + others;

        // Calculate the percentage for each state
        double spPercentage = (sp / total) * 100;
        double rjPercentage = (rj / total) * 100;
        double mgPercentage = (mg / total) * 100;
        double esPercentage = (es / total) * 100;
        double othersPercentage = (others / total) * 100;

        // Display the results
        System.out.printf("Percentage for SP: %.2f%%\n", spPercentage);
        System.out.printf("Percentage for RJ: %.2f%%\n", rjPercentage);
        System.out.printf("Percentage for MG: %.2f%%\n", mgPercentage);
        System.out.printf("Percentage for ES: %.2f%%\n", esPercentage);
        System.out.printf("Percentage for Others: %.2f%%\n", othersPercentage);
    }
}
