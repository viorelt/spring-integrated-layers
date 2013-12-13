package ro.teamnet.hero.signup;

/**
 * UsernameAlreadyInUseException.java
 * <p/>
 * Copyright (c) 2013 Teamnet. All Rights Reserved.
 * <p/>
 * This source file may not be copied, modified or redistributed,
 * in whole or in part, in any form or for any reason, without the express
 * written consent of Teamnet.
 */

public class UsernameAlreadyInUseException extends RuntimeException{
    public UsernameAlreadyInUseException() {
    }

    public UsernameAlreadyInUseException(String message) {
        super(message);
    }
}
