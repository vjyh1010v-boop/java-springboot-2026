package com.pknu26.webboard.entity;

import jakarta.persistence.GenerationType;

public @interface GenerateValue {

    GenerationType strategy();

}
