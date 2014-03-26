package org.javers.common.exception.exceptions;

import static org.javers.common.exception.exceptions.JaversException.BOOTSTRAP_ERROR;
import static org.javers.common.exception.exceptions.JaversException.RUNTIME_ERROR;

/**
 * Enums with all Javers errors codes
 *
 * @author Pawel Cierpiatka <pawel.cierpiatka@gmail.com>
 */
public enum  JaversExceptionCode {

    CLASS_EXTRACTION_ERROR(BOOTSTRAP_ERROR + "Don't know how to extract Class from type '%s'.") ,

    ENTITY_WITHOUT_ID (BOOTSTRAP_ERROR + "Class '%s' has no Id property. Use @Id annotation to mark unique Entity identifier"),
    ENTITY_INSTANCE_WITH_NULL_ID(RUNTIME_ERROR + "Found Entity instance of class '%s' with null id"),
    NOT_INSTANCE_OF(BOOTSTRAP_ERROR + "expected instance of '%s', got instance of '%s'"),

    UNDEFINED_PROPERTY(BOOTSTRAP_ERROR + "undefined mandatory property '%s'. Define it in your classpath:javers.properties"),

    MALFORMED_PROPERTY(BOOTSTRAP_ERROR + "unwrap '%s' is invalid for property '%s'. Fix it in your classpath:javers.properties"),

    CLASSPATH_RESOURCE_NOT_FOUND(BOOTSTRAP_ERROR + "classpath resource '%s' could not be found"),

    ALREADY_BUILT(BOOTSTRAP_ERROR + "instance already built, each AbstractJaversBuilder may produce only one target instance"),

    CONTAINER_NOT_READY(BOOTSTRAP_ERROR +"pico container is not ready"),

    NOT_IMPLEMENTED(RUNTIME_ERROR + "not implemented"),

    SNAPSHOT_STATE_VIOLATION(RUNTIME_ERROR + "snapshots are immutable"),

    PROPERTY_NOT_FOUND(RUNTIME_ERROR +"property '%s' not found in class '%s'");

    private final String message;

    private JaversExceptionCode(String message) {
        this.message = message;
    }

    /**
     * Error description and possibly solution hints.
     */
    public String getMessage() {
        return message;
    }
}
