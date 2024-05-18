package com.zee.modulith.exception;

import org.springframework.http.HttpStatus;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 18 May, 2024
 */

public record Response(String message, HttpStatus status) {
}
