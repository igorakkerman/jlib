package org.jlib.core;

import java.text.MessageFormat;

public class VdekIllegalStateException
extends IllegalArgumentException {

    private static final long serialVersionUID = 2542006378896458426L;

    public VdekIllegalStateException() {}

    public VdekIllegalStateException(String formattedMessage, Object... messageArguments) {
        super(MessageFormat.format(formattedMessage, messageArguments));
    }

    public VdekIllegalStateException(Throwable cause) {
        super(cause);
    }

    public VdekIllegalStateException(String formattedMessage, Throwable cause, Object... messageArguments) {
        super(MessageFormat.format(formattedMessage, messageArguments), cause);
    }
}
