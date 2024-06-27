package processManagementSystem;

public class Process {

	private int processId;
	private String processName;
	private String status;
	
	
	public Process(int processId, String processName, String status) {
		super();
		this.processId = processId;
		this.processName = processName;
		this.status = status;
	}
	
	public int getProcessId() {
		return processId;
	}
	public void setProcessId(int processId) {
		this.processId = processId;
	}
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Process [processId=" + processId + ", processName=" + processName + ", status=" + status + "]";
	}
	
	

}
