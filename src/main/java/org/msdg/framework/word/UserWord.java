package org.msdg.framework.word;

public enum UserWord {
        PASSWORD_ERROR("用户名与密码不匹配");

        private String message;

        UserWord(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public String toString() {
            return this.message;
        }
    }