package com.PTravel.DDD.domain.model.valueobject;

import lombok.Data;

@Data
public class UserSearchCriteria {
    private final String username;
    private final String email;
    private final String phone;
    private final String fullName;

    private UserSearchCriteria(Builder builder) {
        this.username = builder.username;
        this.email = builder.email;
        this.phone = builder.phone;
        this.fullName = builder.fullName;
    }

    public static class Builder {
        private String username;
        private String email;
        private String phone;
        private String fullName;

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public UserSearchCriteria build() {
            return new UserSearchCriteria(this);
        }
    }
    }
