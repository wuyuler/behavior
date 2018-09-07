package com.yjt.demo.enums;

public enum UserEnum {
    ID("id"),GENDER("gender"),BIRTHDAY("birthday"),EDU("edu"),JOB("job"),INCOME("income"),PROVINCE("province"),CITY("city"),IS_CITY("is_city");

    private String field;

    UserEnum(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
