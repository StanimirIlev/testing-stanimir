import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class MyClass{

    private static final Logger logger = Logger.getLogger(MyClass.class);

    public static void main(String argv[]) {
        BasicConfigurator.configure();
        logger.debug("Hello world.");
        logger.info("Business layer.");
        System.out.println("Business layer");
    }

}