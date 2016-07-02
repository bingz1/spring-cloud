package me.wantgo.common.entity;

/**
 * Represents an error.
 */
public class ErrorResult {
    private int code;
    private String error;

    /**
     * Constructs an error by status code and error message.
     *
     * @param code  The HTTP status code.
     * @param error The error message
     */
    public ErrorResult(int code, String error) {
        this.code = code;
        this.error = error;
    }

    /**
     * Get the HTTP status code
     *
     * @return The HTTP status code
     */
    public int getCode() {
        return this.code;
    }

    /**
     * Set the HTTP status code.
     *
     * @param code The HTTP status code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Get the error message.
     *
     * @return The error message
     */
    public String getError() {
        return this.error;
    }

    /**
     * Set the error message.
     *
     * @param error The error message
     */
    public void setError(String error) {
        this.error = error;
    }
}
