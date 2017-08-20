package com.travix.medusa.busyflights.domain.common;

import java.util.Objects;

/**
 * Holds an error message.
 *
 * @author Anna_Kovacshazi
 */
public class ErrorResponse {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorResponse that = (ErrorResponse) o;
        return Objects.equals(msg, that.msg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msg);
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
