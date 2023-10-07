import exception.WrongLoginException;
import exception.WrongPasswordException;

public class Validator {
    private static final String PATTERN = "^[a-zA-Z0-9_]{1,20}$";
    public static void isValid(Authorization authorization) throws WrongLoginException, WrongPasswordException {
        if (!authorization.getLogin().matches(PATTERN)) {
            throw new WrongLoginException("Неверный логин");
        } else if (!authorization.getPassword().matches(PATTERN)) {
            throw new WrongLoginException("Неверный пароль");
        } else if (!authorization.getPassword().equals(authorization.getConfirmPassword())) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }

    public static void checkRegistration(Authorization authorization) throws WrongLoginException, WrongPasswordException {
        try {
            isValid(authorization);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }
}
