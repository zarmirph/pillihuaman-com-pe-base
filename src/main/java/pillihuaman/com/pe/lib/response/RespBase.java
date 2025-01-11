package pillihuaman.com.pe.lib.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonIgnoreProperties("hibernateLazyInitializer")
@Builder
@AllArgsConstructor
public class RespBase<T> {

    private Trace trace;
    private Status status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T payload;

    public RespBase(T data) {
        this.payload = data;
    }

    public T getData() {
        return payload;
    }

    public void setData(T data) {
        this.payload = data;
    }
    public Trace getTrace() {
        return trace;
    }

    public Status getStatus() {
        return status;
    }

    public T getPayload() {
        return payload;
    }

    public RespBase(RespEmployee respEmployee) {
    }

    public void setTrace(Trace trace) {
        this.trace = trace;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }


    public RespBase() {
        super();
        trace = new Trace();
        status = new Status();
    }

    @SuppressWarnings("unchecked")
    public RespBase<RespGetList<T>> okLista(List<T> lista) {
        RespGetList<T> respObtieneLista = new RespGetList<>(lista);
        @SuppressWarnings("rawtypes")
        RespBase<RespGetList<T>> respBase = new RespBase().ok(respObtieneLista);
        return respBase;
    }

    public RespBase<T> ok(T payload) {
        RespBase<T> response = new RespBase<>();
        response.setPayload(payload);
        response.getStatus().setSuccess(Boolean.TRUE);
        return response;
    }

    /**
     * Subclase plantilla para trazabilidad
     *
     * @author ttorres
     */
    //@Data
    @Builder
    @AllArgsConstructor
    public static class Trace {
        public Trace() {

        }

        private String traceId;

        public String getTraceId() {
            return traceId;
        }

        public void setTraceId(String traceId) {
            this.traceId = traceId;
        }
    }

    /**
     * Subclase plantilla para status
     *
     * @author ttorres
     */
    @Builder
    @AllArgsConstructor
    public static class Status {

        private Boolean success;
        private Error error;

        public Status() {
        }

        public Error getError() {
            return error;
        }

        public void setError(Error error) {
            this.error = error;
        }

        public Boolean getSuccess() {
            return success;
        }

        public void setSuccess(Boolean success) {
            this.success = success;
        }


        /**
         * Subclase plantilla para error
         *
         * @author ttorres
         */
        @Builder
        @AllArgsConstructor
        public static class Error {

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getHttpCode() {
                return httpCode;
            }

            public void setHttpCode(String httpCode) {
                this.httpCode = httpCode;
            }

            public List<String> getMessages() {
                return messages;
            }

            public void setMessages(List<String> messages) {
                this.messages = messages;
            }

            private String code;
            private String httpCode;
            private List<String> messages;

            public Error() {
                super();
                messages = new ArrayList<>();
            }
        }
    }
}
