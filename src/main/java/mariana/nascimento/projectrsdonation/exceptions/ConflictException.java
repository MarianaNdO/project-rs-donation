package mariana.nascimento.projectrsdonation.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class ConflictException extends Exception{
    public ConflictException(String message) {
        super(message);
    }
}
