package spring;

import java.io.Serializable;
import java.util.Set;


public class SubjectDTO implements Serializable{

	private long subjectId;
	
	private String subtitle;
	
	private int durationInHours;
	
	private Set<BookDTO> references;

	
	public SubjectDTO(long subjectId, String subtitle, int durationInHours, Set<BookDTO> references) {
		super();
		this.subjectId = subjectId;
		this.subtitle = subtitle;
		this.durationInHours = durationInHours;
		this.references = references;
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public int getDurationInHours() {
		return durationInHours;
	}

	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}

	public Set<BookDTO> getReferences() {
		return references;
	}

	public void setReferences(Set<BookDTO> references) {
		this.references = references;
	}

	
	
}
