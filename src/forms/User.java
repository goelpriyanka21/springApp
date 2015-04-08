package forms;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {



    private String username;
    private String password;
    
    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format(
                "User[ username='%s', password='%s']",
                 username, password);
    }

}
