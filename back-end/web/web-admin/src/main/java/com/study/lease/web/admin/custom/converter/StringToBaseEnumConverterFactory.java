package com.study.lease.web.admin.custom.converter;

import com.study.lease.model.enums.BaseEnum;
import com.study.lease.model.enums.ItemType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

/**
 * ClassName: StringToBaseEnumConverterFactory
 * Package: com.study.lease.web.admin.custom.converter
 * Description:
 *
 * @Author pupil
 * @Create 2025/4/27 17:36
 * @Version 1.0
 */
@Component
public class StringToBaseEnumConverterFactory implements ConverterFactory<String, BaseEnum> {
    @Override
    public <T extends BaseEnum> Converter<String, T> getConverter(Class<T> targetType) {
        return new Converter<String, T>() {
            @Override
            public T convert(String code) {
                for(T t :targetType.getEnumConstants()){
                    if(t.getCode().toString().equals(code)){
                        return t;
                    }
                }
                throw new IllegalArgumentException("code"+code+"非法");
            }
        };
    }
}
