package StepDefinition;

import PageObject.LoginPage;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import java.time.Duration;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class LoginPageSteps extends LoginPage {
    @Дано("^открываем сайт учебного баг-трекера")
    public static  void openLink() {
        open("https://edujira.ifellow.ru/");
    }

    @Когда("^вводим логин \"([^\"]*)\"")
    public static void loginVal(String name) {
        loginJira.shouldBe(visible, Duration.ofSeconds(60)).click();
        loginJira.setValue(name);
    }

    @И("^пароль \"([^\"]*)\"")
    public static void passwordVal(String pass) {
        passwordJira.shouldBe(visible, Duration.ofSeconds(60)).click();
        passwordJira.setValue(pass);
    }

    @И("^нажимаем кнопку Войти")
    public static void clickButtonLogIn() {
        buttonLogIn.shouldBe(visible, Duration.ofSeconds(60)).click();
    }

    //Assert
    @Тогда("^успешная авторизация \"([^\"]*)\"")
    public static void authorizeAssertion(String authorize) {
        authorizeAssert.shouldBe(visible);
        authorizeAssert.shouldHave(attribute("alt", authorize));
    }
}
