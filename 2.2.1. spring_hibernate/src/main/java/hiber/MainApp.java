package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("car1");
      car1.setSeries(123);
      Car car2 = new Car("car2");
      car2.setSeries(234);
      Car car3 = new Car("car3");
      car3.setSeries(345);
      Car car4 = new Car("car4");
      car4.setSeries(567);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", car1));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", car2));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", car3));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", car4));

       User foundUser = null;
       User foundUser2 = null;
       User foundUser3 = null;
       User foundUser4 = null;
       try {
           foundUser = userService.getUserByCar("car1", 123);
       } catch (Exception e) {
          System.out.println("Пользователь с такой серией машины не существует");
       }
       try {
           foundUser2 = userService.getUserByCar("car2", 234);
       } catch (Exception e) {
          System.out.println("Пользователь с такой серией машины не существует");
       }
       try {
           foundUser3 = userService.getUserByCar("car3", 345);
       } catch (Exception e) {
          System.out.println("Пользователь с такой серией машины не существует");
       }
       try {
           foundUser4 = userService.getUserByCar("car4", 567);
       } catch (Exception e) {
          System.out.println("Пользователь с такой серией машины не существует");
       }

       if (foundUser != null) {
           System.out.println(foundUser.getFirstName() + foundUser.getLastName());
       } else {
          System.out.println("Пользователь не найден");
       }

       if (foundUser2 != null) {
           System.out.println(foundUser2.getFirstName() + foundUser2.getLastName());
       } else {
          System.out.println("Пользователь не найден");
       }

       if (foundUser3 != null) {
           System.out.println(foundUser3.getFirstName() + foundUser3.getLastName());
       } else {
          System.out.println("Пользователь не найден");
       }

       if (foundUser4 != null) {
           System.out.println(foundUser4.getFirstName() + foundUser4.getLastName());
       } else {
          System.out.println("Пользователь не найден");
       }

       List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }

      context.close();
   }
}
