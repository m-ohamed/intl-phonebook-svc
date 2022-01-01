package com.phonebook.common;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class Utilities {
    private static ModelMapper modelMapper;

    public static ModelMapper getModelMapper() {
        if(modelMapper == null) {
            modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        }

        return modelMapper;
    }
}
