package com.example.springbootproject.converters;

import com.example.springbootproject.dto.AddressDto;
import com.example.springbootproject.entity.Address;

public class AddressConverter {

    public static AddressDto AddressToAddressDto(Address address) {
        return AddressDto.builder()
                .id(address.getId())
                .street(address.getStreet())
                .number(address.getNumber())
                .build();
    }

    public static Address AddressDtoToAddress(AddressDto addressDto) {
        return Address.builder()
                .id(addressDto.getId())
                .street(addressDto.getStreet())
                .number(addressDto.getNumber())
                .build();
    }
}
