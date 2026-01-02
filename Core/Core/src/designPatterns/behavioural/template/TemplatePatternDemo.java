package designPatterns.behavioural.template;

public class TemplatePatternDemo {
    public static void main(String[] args) {

        DataProcessor csvProcessor = new CsvDataProcessor();
        csvProcessor.process();

        System.out.println("------------");

        DataProcessor xmlProcessor = new XmlDataProcessor();
        xmlProcessor.process();
    }
}

/**
 * 9. Real-World Examples
 *
 * Spring Framework (JdbcTemplate, RestTemplate)
 *
 * Servlet API (doGet, doPost)
 *
 * JUnit test lifecycle methods
 */