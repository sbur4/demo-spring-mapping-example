package org.example.mapper;

import org.example.dto.UserDto;
import org.example.model.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
//@Mapper
//@Mapper(componentModel = "spring")
//@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "email", target = "email", qualifiedByName = "addDomen")
//    @Mapping(source = "secret", target = "password")
    @Mapping(source = "secret", target = "password", defaultValue = "unknow")
    UserEntity toEntity(UserDto dto);

    @InheritInverseConfiguration
    UserDto fromEntity(UserEntity entity);

    @Named("addDomen")
    default String toKph(String email) {
        return email + "@epam.com";
    }
}