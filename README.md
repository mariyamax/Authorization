# Авторизация
Написано на spring, но без использования spring-security

Cистема аутентификации и авторизации
Проверка для пароле на совпадение с паттерном - длина 8, 1 спец символ и не первая заглавная буква
Вохможность авто генерации пароля (также подъодит под паттерн)
Проверка на допустимости логига пароля (логин не занят, пороль из допустимых символов)

Защита от sql инъекции
Реализована в Spring Data, но дополнительно - пакет,
в котором показан пример использования PreparedStatment

База данных
Данные о пользователях хранятся в базе
Пароль в зашифрованном виде

Есть реализация Логгера
