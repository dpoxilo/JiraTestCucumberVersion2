package StepDefinition;

import PageObject.MainPage;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class MainPageSteps extends MainPage {
    @Когда("^нажимаем меню Проекты")
    public static void clickToBrowse() {
        browseLink.shouldBe(visible, Duration.ofSeconds(60)).click();
    }

    @И("^выбираем проект TEST")
    public static void clickToMainProj() {
        mainProj.shouldBe(visible, Duration.ofSeconds(60)).click();
    }

    @И("^нажимаем ссылку Все задачи")
    public static void clickToAllTasks() {
        allTasks.shouldBe(visible, Duration.ofSeconds(60)).click();
    }

    //Assert
    @Тогда("^в консоль выводится общий счетчик задач")
    public static void findTotalNumberOfTasks() {
        findText.shouldHave(text("1"));
        System.out.println("Общее количество заведенных задач в проекте:" + " " + findText.getText());
    }

    @Когда("^ищем задачу TestSelenium")
    public static void findTaskTestSelenium() {
        enterTextElement.shouldBe(visible, Duration.ofSeconds(60)).click();
        enterTextElement.setValue("TestSelenium").pressEnter();
    }

    @И("^проверяем ее статус")
    public static void checkingStatus() {
        checkStatus.shouldBe(visible, Duration.ofSeconds(60));
        System.out.println("Задача TestSelenium имеет статус:" + " " + checkStatus.getText());
    }

    @И("^ее версию")
    public static void checkingVersion() {
        versionCheck.shouldBe(visible, Duration.ofSeconds(60));
        System.out.println("Задача TestSelenium имеет привязку в затронутой версии:" + " " + versionCheck.getText());
    }

    //Assert
    @Тогда("^статус и версия имеют верные значения \"(.*)\", \"(.*)\"")
    public static void mainPageAssertion(String status, String version) {
        findText.shouldBe(visible, Duration.ofSeconds(60));
        checkStatus.shouldHave(text(status));
        versionCheck.shouldHave(text(version));
    }
}
