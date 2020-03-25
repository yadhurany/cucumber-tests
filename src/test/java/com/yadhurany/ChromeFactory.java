package com.yadhurany;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

public class ChromeFactory {

    private static WebDriver mDriver;

    public synchronized static WebDriver getCurrentDriver() {
        if (mDriver == null) {
            try {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
                ChromeDriver driver = new ChromeDriver();
                driver.manage().window().maximize();
                mDriver = driver;
            } finally {
                Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
            }
        }
        mDriver.get("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");
        return mDriver;
    }

    private static class BrowserCleanup implements Runnable {
        public void run() {
            System.out.println("Closing the browser");
            close();
        }
    }

    public static void close() {
        try {
            getCurrentDriver().quit();
            mDriver = null;
            System.out.println("closing the browser");
        } catch (UnreachableBrowserException e) {
            System.out.println("cannot close browser: unreachable browser");
        }
    }

}
