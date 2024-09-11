package org.example.api.adapter.entrypoint.mapper;

public interface CustomMapper {
    <D> D map(Object source, Class<D> destinationType);
}
