package com.phonebook.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.regex.Pattern;

import static com.phonebook.common.Constants.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "customer")
public class CustomerEntity {
    @Id
    private Integer id;
    private String name;
    private String phone;

    @Transient
    private boolean state;

    @PostLoad
    private void postLoad() {
        if(Pattern.matches(CAMEROON_NUMBER_REGEX + "|" + ETHIOPIA_NUMBER_REGEX + "|"
                + MOROCCO_NUMBER_REGEX + "|" + MOZAMBIQUE_NUMBER_REGEX + "|" + UGANDA_NUMBER_REGEX, this.phone)) {
            this.state = true;
        }
    }
}
