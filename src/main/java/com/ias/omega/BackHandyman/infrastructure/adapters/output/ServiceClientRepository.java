package com.ias.omega.BackHandyman.infrastructure.adapters.output;

import com.ias.omega.BackHandyman.services.aplication.models.ServicesClient;
import com.ias.omega.BackHandyman.services.aplication.ports.output.ServicesRespository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ServiceClientRepository implements JpaRepository<ServicesClient,Long> {


    @Override
    public List<ServicesClient> findAll() {
        return null;
    }

    @Override
    public List<ServicesClient> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<ServicesClient> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<ServicesClient> findAllById(Iterable<Long> longs) {
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
    public void delete(ServicesClient entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends ServicesClient> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends ServicesClient> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ServicesClient> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ServicesClient> findById(Long aLong) {
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
    public <S extends ServicesClient> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends ServicesClient> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<ServicesClient> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public ServicesClient getOne(Long aLong) {
        return null;
    }

    @Override
    public ServicesClient getById(Long aLong) {
        return null;
    }

    @Override
    public ServicesClient getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends ServicesClient> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ServicesClient> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends ServicesClient> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends ServicesClient> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ServicesClient> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ServicesClient> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends ServicesClient, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
