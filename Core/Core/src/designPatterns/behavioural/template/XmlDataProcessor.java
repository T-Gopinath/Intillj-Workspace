package designPatterns.behavioural.template;

class XmlDataProcessor extends DataProcessor {

    @Override
    protected void readData() {
        System.out.println("Reading data from XML file");
    }

    @Override
    protected void processData() {
        System.out.println("Processing XML data");
    }

    @Override
    protected void hook() {
        System.out.println("XML specific post-processing");
    }
}
