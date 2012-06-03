package org.jlib.core;

import java.text.MessageFormat;

public class VdekIllegalArgumentException
extends IllegalArgumentException {

    private static final long serialVersionUID = -523892342297445188L;

    public VdekIllegalArgumentException() {}

    public VdekIllegalArgumentException(String formattedMessage, Object... messageArguments) {
        super(MessageFormat.format(formattedMessage, messageArguments));
    }

    public VdekIllegalArgumentException(Throwable cause) {
        super(cause);
    }

    public VdekIllegalArgumentException(String formattedMessage, Throwable cause, Object... messageArguments) {
        super(MessageFormat.format(formattedMessage, messageArguments), cause);
    }
}
