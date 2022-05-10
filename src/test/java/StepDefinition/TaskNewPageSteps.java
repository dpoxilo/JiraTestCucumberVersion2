package StepDefinition;

import PageObject.TaskNewPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class TaskNewPageSteps extends TaskNewPage {
    @Когда("^создаем новую задачу")
    public static void clickToCreateNewTask() {
        createNewTask.shouldBe(visible, Duration.ofSeconds(60)).click();
    }

    @И("^выбираем тип задачи \"([^\"]*)\"")
    public static void setIssueType(String type) {
        issueType.sendKeys(type);
        issueType.pressEnter();
    }

    @И("^заполняем заголовок задачи \"(.*)\"")
    public static void setErrorTheme(String theme) {
        errorTheme.shouldBe(visible, Duration.ofSeconds(60)).click();
        errorTheme.setValue(theme);
    }

    @И("^заполняем описание ошибки \"([^\"]*)\"")
    public static void setErrInfo(String info) {
        Selenide.switchTo().defaultContent();
        SelenideElement iframe = errorInfo;
        Selenide.switchTo().frame(iframe);
        $x("//body[@id='tinymce']/p").sendKeys(info);
        Selenide.switchTo().defaultContent();
    }

    @И("^выбираем исправить в каких версиях")
    public static void setFixInVersions() {
        fixInVersions.shouldBe(visible, Duration.ofSeconds(60)).doubleClick();
    }

    @И("^выбираем приоритет \"([^\"]*)\"")
    public static void setPriority(String priority) {
        prior.shouldBe(visible, Duration.ofSeconds(60)).click();
        prior.sendKeys(priority);
        prior.pressEnter();
    }

    @И("^заполняем тег \"([^\"]*)\"")
    public static void setHashTag(String tag) {
        hashTag.sendKeys(tag);
        hashTag.pressEnter();
    }

    @И("^заполняем окружение \"([^\"]*)\"")
    public static void setMoreInfo(String info) {
        Selenide.switchTo().defaultContent();
        SelenideElement iframe = moreInfo;
        Selenide.switchTo().frame(iframe);
        $x("//body[@id='tinymce']/p").sendKeys(info);
        Selenide.switchTo().defaultContent();
    }

    @И("^выбираем затронутые версии")
    public static void setVersionsAffected() {
        versionsAffected.shouldBe(visible, Duration.ofSeconds(60)).doubleClick();
    }

    @И("^нажимаем ссылку Назначить меня")
    public static void clickToAssignMe() {
        assignMe.shouldBe(visible, Duration.ofSeconds(60)).click();
    }

    @И("^нажимаем кнопку Создать")
    public static void clickSubmit() {
        submit.shouldBe(visible, Duration.ofSeconds(60)).click();
    }

    //Assert
    @Тогда("^успешное создание задачи")
    public static void taskNewPageAssertion() {
        newTaskAssert.shouldHave(Condition.visible);
    }
}

