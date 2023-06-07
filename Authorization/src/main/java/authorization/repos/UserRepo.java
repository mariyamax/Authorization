package authorization.repos;

import authorization.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {

    //sql-инъекции лечатся PreparedStatment, который не используется
    //тк используется готовый jpa и ограничение на кол-во символов

    User findByUsername(String username);

    User findByID(Long id);
}
