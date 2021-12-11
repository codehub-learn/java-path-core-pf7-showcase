package gr.codelearn.generics;

public class Process<T, S> {
	private T pid;
	private String pname;
	private int releasedYear;
	private S runningTime;

	public Process(T pid, String pname, int releasedYear, S runningTime) {
		this.pid = pid;
		this.pname = pname;
		this.releasedYear = releasedYear;
		this.runningTime = runningTime;
	}

	@Override
	public String toString() {
		return "Process{" + "pid=" + pid + ", pname='" + pname + '\'' + ", releasedYear=" + releasedYear +
				", runningTime=" + runningTime + '}';
	}
}
