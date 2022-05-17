package com.example.onlineServiceProvider.entity.user;




import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import com.example.onlineServiceProvider.entity.base.User;


@Getter
@Setter
@Entity
@Accessors(chain = true)
@DiscriminatorValue("1")
public class Admin extends User {

}
