package cn.homyit.website.exception;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 通用错误枚举（不同类型的错误也可以拆成不同的Enum细分）
 *
 */
@Getter
public enum ExceptionCodeEnum {


    SUCCESS(200, "成功"),

    /**
     * 用户登录
     */
    NEED_LOGIN(900, "用户未登录"),
    LOGIN_ERROR(901,"用户名或密码错误"),
    UPDATE_PWD_ERROR(902,"原密码输入错误"),
    NO_USER(903,"用户不存在"),
    USER_EXIST(802,"用户已存在"),
    /**
     * 参数校验
     */
    ERROR_PARAM(10000, "参数错误"),
    EMPTY_PARAM(10001, "参数为空"),
    ERROR_PARAM_LENGTH(10002, "参数长度错误");

    private final Integer code;
    private final String desc;

    ExceptionCodeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private static final Map<Integer, ExceptionCodeEnum> ENUM_CACHE = new HashMap<>();

    static {
        for (ExceptionCodeEnum exceptionCodeEnum : ExceptionCodeEnum.values()) {
            ENUM_CACHE.put(exceptionCodeEnum.code, exceptionCodeEnum);
        }
    }

    public static String getDesc(Integer code) {
        return Optional.ofNullable(ENUM_CACHE.get(code))
                .map(ExceptionCodeEnum::getDesc)
                .orElseThrow(() -> new IllegalArgumentException("invalid exception code!"));
    }

}