package com.example.demo.constant;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/13 17:15
 * @Description
 */
@Data
@NoArgsConstructor
public class SysConstant {

    public static final String MANAGEMENT_AUTH = "management_auth";
    public static final String X_FORWARDED_FOR = "x_forwarded_for";
    public static final String TOKEN = "token";

    public static String PROJECT_PATH = System.getProperty("user.dir");

    public static String AVATOR_IMAGES_PATH = "file:" + PROJECT_PATH + "/img/avatorImages/";

    @NoArgsConstructor(access =  AccessLevel.PRIVATE)
    public static class DbColumnKey {
        public static final String USER_NAME = "user_name";
        public static final String PHONE_NUM = "phone_num";
        public static final String SONG_ID = "song_id";
        public static final String USER_ID = "user_id";
        public static final String SONG_LIST_ID = "song_list_id";
        public static final String SINGER_ID = "singer_id";
        public static final String STYLE = "style";
        public static final String TITLE = "title";
        public static final String CONSUMER_ID = "consumer_id";
        public static final String SCORE = "score";
        public static final String ID = "id";
        public static final String PASSWORD = "password";
        public static final String SONG_SHEET_ID = "song_sheet_id";
    }
}
