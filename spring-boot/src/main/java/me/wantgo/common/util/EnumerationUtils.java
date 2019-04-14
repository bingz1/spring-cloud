package me.wantgo.common.util;

import org.springframework.util.CollectionUtils;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.function.Supplier;

/**
 *
 * @author zhaimi
 * @date 15/12/8
 */
public class EnumerationUtils {
    public static <T> Iterable<T> toIterable(Supplier<Enumeration<T>> enumerationSupplier) {
        return () -> CollectionUtils.toIterator(enumerationSupplier.get());
    }
}
