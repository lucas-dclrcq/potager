package org.ldclrcq.domain.exception;

public class NotFoundException extends BusinessException {
    public NotFoundException(Class<?> entityType, String entityId) {
        super("Entity " + entityType.getName() + " with id " + entityId + " does not exist");
    }
}
