package cn.homyit.website.exception;

import cn.homyit.website.entity.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//异常捕捉返回

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BizException.class)
    public Result<ExceptionCodeEnum> handleBizException(BizException e) {
        log.warn("错误: {}", e.getMessage(), e);
        // 一般只需返回泛化的错误信息，比如“参数错误”
        return Result.error(e.getError(),e.getError().getDesc() );
    }


    @ExceptionHandler(Exception.class)
    public Result<ExceptionCodeEnum> handleConstraintViolationException(Exception e) {
        log.warn("错误: {}", e.getMessage(), e);
        // 一般只需返回泛化的错误信息，比如“参数错误”
        return Result.error(ExceptionCodeEnum.ERROR_PARAM, e.getMessage());
    }

//    //散装
//    @ExceptionHandler(ConstraintViolationException.class)
//    public Result<ExceptionCodeEnum> handleConstraintViolationException(ConstraintViolationException e) {
////        log.warn("参数错误: {}", e.getMessage(), e);
//        // 一般只需返回泛化的错误信息，比如“参数错误”
//        return Result.error(ExceptionCodeEnum.ERROR_PARAM, e.getMessage());
//    }

//    /**
//     * BindException异常
//     *get
//     * @param e
//     * @return
//     */
//    @ExceptionHandler(BindException.class)
//    public Result<Map<String, String>> validationBindException(BindException e) {
//        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
//        String message = fieldErrors.stream()
//                .map(FieldError::getDefaultMessage)
//                .collect(Collectors.joining(" && "));
//        log.error("参数错误: {}", message, e);
//        return Result.error(ExceptionCodeEnum.ERROR_PARAM, message);
//    }
//
//    //post
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Result<Map<String, String>> validationMethodArgumentNotValidException(MethodArgumentNotValidException e) {
//        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
//        String message = fieldErrors.stream()
//                .map(FieldError::getDefaultMessage)
//                .collect(Collectors.joining(" && "));
//        log.error("参数错误: {}", message, e);
//        return Result.error(ExceptionCodeEnum.ERROR_PARAM, message);
//    }
}