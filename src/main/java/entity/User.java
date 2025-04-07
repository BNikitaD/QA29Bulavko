package entity;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class User {
    private String name;
    private String surname;
    private String patronymic;
    private String phone;
    private String email;
    private String password;
    private String repeatPassword;
}
