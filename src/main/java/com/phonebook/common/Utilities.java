package com.phonebook.common;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class Utilities {
    private static ModelMapper modelMapper;

    /*
    This class holds all utilities that could be help with the operations.

    The model mapper helps with mapping from the entity class to the model class without the need to manually set
    each attribute.
     */
    public static ModelMapper getModelMapper() {
        if(modelMapper == null) {
            modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        }

        return modelMapper;
    }
}
