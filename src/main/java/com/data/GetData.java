package com.data;

public class GetData {

    public enum LOGIN_DATA {
//TODO buraya kişisel giriş bilgileri girilmeldir.
        EMAIL("USER@gmail.com"),
        PASSWORD("USERPASSWORD");

        public String value;

        LOGIN_DATA(String value) {

            this.value = value;
        }
    }


}


