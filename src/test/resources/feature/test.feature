#language: ru
@Test
Функция: Тестирование учебного баг-трекера jira

  Предыстория: Авторизация
    Дано открываем сайт учебного баг-трекера
    Когда вводим логин "dpohilo"
    И пароль "123Qwerty"
    И нажимаем кнопку Войти
    Тогда успешная авторизация "Пользовательский профиль для dpohilo"

  Сценарий: Проверка общего количества задач и поиск задачи TestSelenium с проверкой статуса, версии
    Когда нажимаем меню Проекты
    И выбираем проект TEST
    И нажимаем ссылку Все задачи
    Тогда в консоль выводится общий счетчик задач
    Когда ищем задачу TestSelenium
    И  проверяем ее статус
    И  ее версию
    Тогда статус и версия имеют верные значения "В РАБОТЕ", "Version 2.0"

  Сценарий: Создание новой задачи и полное заполнение всех ее полей
    Когда создаем новую задачу
    И выбираем тип задачи "Ошибка"
    И заполняем заголовок задачи "Ошибка jiratest "Похило""
    И заполняем описание ошибки "Описание бага jiratest"
    И выбираем исправить в каких версиях
    И выбираем приоритет "Low"
    И заполняем тег "jiratest"
    И заполняем окружение "Стандартное"
    И выбираем затронутые версии
    И нажимаем ссылку Назначить меня
    И нажимаем кнопку Создать
    Тогда успешное создание задачи

  Сценарий: Изменение статуса задачи
    Когда ищем задачу "Похило"
    И проверяем статус задачи "Сделать"
    И меняем статус задачи на Готово
    Тогда первая проверка успешного изменение статуса задачи на "ГОТОВО"
    И вторая проверка успешного изменение статуса задачи на "ГОТОВО"