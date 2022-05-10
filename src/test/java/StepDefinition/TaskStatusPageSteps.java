package StepDefinition;

import PageObject.TaskStatusPage;
import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class TaskStatusPageSteps extends TaskStatusPage {
    @Когда("^ищем задачу \"([^\"]*)\"")
    public static void clickToFindTask(String task) {
        findTask.shouldBe(visible, Duration.ofSeconds(60)).click();
        findTask.setValue(task).pressEnter();
    }

    @И("^проверяем статус задачи \"([^\"]*)\"")
    public static void clickToCheckStatus(String status) {
        statusCheck.shouldBe(visible, Duration.ofSeconds(60)).click();
        statusCheck.shouldHave(Condition.text(status));
    }

    @И("^меняем статус задачи на Готово")
    public static void clickToSetReady() {
        setReady.shouldBe(visible, Duration.ofSeconds(60)).click();
        $x("//span[text()='Выполнено']").click();
    }

    //Assert
    @Тогда("^первая проверка успешного изменение статуса задачи на \"([^\"]*)\"")
    public static void checkFinalStatus1(String checkStatus) {
        while (!taskStatusCheck.getText().equals(checkStatus)) {
            taskStatusCheck.getText();
        }
        Assert.assertEquals("Статус задачи не верный", checkStatus, taskStatusCheck.getText());
    }

    @И("^вторая проверка успешного изменение статуса задачи на \"([^\"]*)\"")
    public static void checkFinalStatus2(String checkStatus) {
        taskStatusCheck.shouldHave(Condition.text(checkStatus));
    }
}
