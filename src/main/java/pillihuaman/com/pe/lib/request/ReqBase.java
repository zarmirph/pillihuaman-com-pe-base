package pillihuaman.com.pe.lib.request;

import pillihuaman.com.pe.lib.response.RespBase;

public class
ReqBase<T> {
	private RespBase.Trace trace;
	private T data;

	public ReqBase() {//NOSONAR
		super();

	}

	public RespBase.Trace getTrace() {
		return trace;
	}

	public void setTrace(RespBase.Trace trace) {
		this.trace = trace;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
