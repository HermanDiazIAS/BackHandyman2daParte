package com.ias.omega.BackHandyman.commons;

import java.text.ParseException;

public interface UseCase<Input,Output> {
    Output execute(Input input);
}
