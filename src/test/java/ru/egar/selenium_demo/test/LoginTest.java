package ru.egar.selenium_demo.test;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import ru.egar.selenium_demo.AbstractSpringBootTest;
import ru.egar.selenium_demo.pages.LoginPage;
import ru.egar.selenium_demo.pages.ProfilePage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoginTest extends AbstractSpringBootTest {

    @Autowired
    private WebDriver webDriver;

    @Autowired
    private ProfilePage profilePage;

    @Autowired
    private LoginPage loginPage;

    @Value("${auth.login}")
    private String login;

    @Value("${auth.password}")
    private String password;

    @Value("${loginpageUrl}")
    private String loginpageUrl;

    @Test
    public void loginTest() throws InterruptedException {
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        webDriver.get(loginpageUrl);
        //вводим логин
        loginPage.inputLogin(login);
        Thread.sleep(1500L);
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        //вводим пароль
        Thread.sleep(1500L);
        loginPage.inputPasswd(password);
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        Thread.sleep(2000L);
        //получаем отображаемый логин
        String user = profilePage.getUserName();
        //и сравниваем его с логином из файла настроек
        assertEquals(login.substring(0, login.indexOf("@")), user);
        profilePage.entryAccountMenu();
        Thread.sleep(2000L);
        profilePage.userLogout();
        Thread.sleep(2000L);
        webDriver.quit();
    }

}
