package processManagementSystem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProcessManager {
	
	private List<Process> processes;
	private List<Process> pendingProcessesHistory;
	private List<Process> completedProcessesHistory;

	
	public ProcessManager() {
		super();
		 this.processes = new ArrayList<>();
	     this.pendingProcessesHistory = new LinkedList<>();
	     this.completedProcessesHistory = new LinkedList<>();
	}

	public List<Process> getProcesses() {
		return processes;
	}

	public void setProcesses(List<Process> processes) {
		this.processes = processes;
	}

	public List<Process> getPendingProcessesHistory1() {
		return pendingProcessesHistory;
	}

	public void setPendingProcessesHistory(List<Process> pendingProcessesHistory) {
		pendingProcessesHistory = pendingProcessesHistory;
	}

	public List<Process> getCompletedProcessesHistory1() {
		return completedProcessesHistory;
	}

	public void setCompletedProcessesHistory(List<Process> completedProcessesHistory) {
		completedProcessesHistory = completedProcessesHistory;
	}

	
	 // Add Process
    public void addProcess(Process process) {
        processes.add(process);
        if ("Pending".equals(process.getStatus())) {
            addPendingProcess(process);
        } else if ("Completed".equals(process.getStatus())) {
            addCompletedProcess(process);
        }
    }

    // Remove Process
    public boolean removeProcess(int processId) {
        for (Process process : processes) {
            if (process.getProcessId() == processId) {
                processes.remove(process);
                return true;
            }
        }
        return false;
    }

    // Search for a Process
    public Process searchProcess(int processId) {
        for (Process process : processes) {
            if (process.getProcessId() == processId) {
                return process;
            }
        }
        return null;
    }

    // List All Processes
    public List<Process> listAllProcesses() {
        return new ArrayList<>(processes);
    }

    // Update Process Status
    public boolean updateProcessStatus(int processId, String newStatus) {
        for (Process process : processes) {
            if (process.getProcessId() == processId) {
                process.setStatus(newStatus);
                if ("Pending".equals(newStatus)) {
                    addPendingProcess(process);
                } else if ("Completed".equals(newStatus)) {
                    addCompletedProcess(process);
                }
                return true;
            }
        }
        return false;
    }

    // Pending and Completed Process History
    public void addPendingProcess(Process process) {
        pendingProcessesHistory.add(process);
    }

    public void addCompletedProcess(Process process) {
        completedProcessesHistory.add(process);
    }

    public List<Process> getPendingProcessesHistory() {
        return new ArrayList<>(pendingProcessesHistory);
    }

    public List<Process> getCompletedProcessesHistory() {
        return new ArrayList<>(completedProcessesHistory);
    }
    
    
 // Main method for testing
    public static void main(String[] args) {
        ProcessManager processManager = new ProcessManager();

        Process process1 = new Process(1, "Data Analysis", "Pending");
        Process process2 = new Process(2, "Report Generation", "Running");
        Process process3 = new Process(3, "Data Cleaning", "Completed");

        processManager.addProcess(process1);
        processManager.addProcess(process2);
        processManager.addProcess(process3);

        System.out.println("All Processes:");
        for (Process process : processManager.listAllProcesses()) {
            System.out.println(process);
        }

        System.out.println("\nRemove Process with ID 1:");
        processManager.removeProcess(1);
        for (Process process : processManager.listAllProcesses()) {
            System.out.println(process);
        }
        
        System.out.println("\nSeaching Process with ID 3:");
        System.out.println(processManager.searchProcess(3));
        
        System.out.println("\nUpdate Process Status for ID 2 to 'Completed':");
        boolean statusUpdated = processManager.updateProcessStatus(2, "Completed");
        System.out.println("Status Updated: " + statusUpdated);
        for (Process process : processManager.listAllProcesses()) {
            System.out.println(process);
        }

        // Listing pending process history
        System.out.println("\nPending Processes History:");
        for (Process process : processManager.getPendingProcessesHistory()) {
            System.out.println(process);
        }

        // Listing completed process history
        System.out.println("\nCompleted Processes History:");
        for (Process process : processManager.getCompletedProcessesHistory()) {
            System.out.println(process);
        }
        
    }
    

}
