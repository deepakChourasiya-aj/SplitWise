
package com.sw.splitwise.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="users")
public class User extends BaseModel{
      private String name;
      private String phoneNumber;
      private String email;
      private String password;
}
