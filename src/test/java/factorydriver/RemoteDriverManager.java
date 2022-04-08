package factorydriver;


import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RemoteDriverManager extends DriverManager{
    @Override
    public void createDriver() throws MalformedURLException {
        EdgeOptions browserOptions = new EdgeOptions();
        browserOptions.setCapability("platformName","Windows 10");
        browserOptions.setCapability("browserVersion","99");
        Map<String, Object> sauceOptions = new HashMap<>();
        browserOptions.setCapability("sauce:options", sauceOptions);
        driver = new RemoteWebDriver( new URL("https://Safronov21:637600c0-47d9-4306-ad38-b4801264246c@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), browserOptions);


    }
}
