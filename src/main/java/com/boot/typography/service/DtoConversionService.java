package com.boot.typography.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.stereotype.Service;

@Service
public class DtoConversionService extends GenericConversionService {

    public <S, D> List<D> convert(Collection<S> source, Class<D> clazz) {
        if (source == null) {
            return new ArrayList<>(0);
        }
        return source.stream()
                .map(e -> convert(e, clazz))
                .filter(Objects::nonNull)
                .toList();
    }

}
