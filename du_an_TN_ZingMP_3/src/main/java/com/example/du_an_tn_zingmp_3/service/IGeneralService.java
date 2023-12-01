package com.example.du_an_tn_zingmp_3.service;

import java.util.Optional;

public interface IGeneralService <T> {
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    void deleteById(Long id);
    void save(T t);
}
