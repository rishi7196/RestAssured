package pojoclasses;

public class GetCourse {
	
	private String url;
	private String expertise;
	private Courses course;
	private String linkldn;	
	private String instructor;
	
	
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public Courses getCourse() {
		return course;
	}
	public void setCourse(Courses course) {
		this.course = course;
	}
	public String getLinkldn() {
		return linkldn;
	}
	public void setLinkldn(String linkldn) {
		this.linkldn = linkldn;
	}
	
	

}
