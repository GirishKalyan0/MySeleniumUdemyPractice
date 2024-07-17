package HandlingAjaxMouseInteractions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverInvoke {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BrowserInvoke();

	}
	
	public static void BrowserInvoke() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\girishchandrac\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
	}

}
