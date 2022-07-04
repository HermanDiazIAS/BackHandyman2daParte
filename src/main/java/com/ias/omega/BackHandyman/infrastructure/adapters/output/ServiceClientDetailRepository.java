package com.ias.omega.BackHandyman.infrastructure.adapters.output;

import com.ias.omega.BackHandyman.servicesdetail.aplication.models.ServicesDetail;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
@Repository
public class ServiceClientDetailRepository implements JpaRepository<ServicesDetail,Long> {
    @Override
    public List<ServicesDetail> findAll() {
        return null;
    }

    @Override
    public List<ServicesDetail> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<ServicesDetail> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<ServicesDetail> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(ServicesDetail entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends ServicesDetail> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends ServicesDetail> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ServicesDetail> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ServicesDetail> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends ServicesDetail> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends ServicesDetail> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<ServicesDetail> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public ServicesDetail getOne(Long aLong) {
        return null;
    }

    @Override
    public ServicesDetail getById(Long aLong) {
        return null;
    }

    @Override
    public ServicesDetail getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends ServicesDetail> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ServicesDetail> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends ServicesDetail> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends ServicesDetail> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ServicesDetail> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ServicesDetail> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends ServicesDetail, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
