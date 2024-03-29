package mmit.z2p.model.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Entity implementation class for Entity: Course
 *
 */
@Entity

@Table(name = "courses")
@NamedQuery(name = "getAllCourse", query = "SELECT c FROM Course c ORDER BY c.level.id")
@NamedQuery(name = "getCourseByLevelId" , query = "SELECT c FROM Course c WHERE c.level.id = :LevelId")
public class Course implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(columnDefinition = "TEXT")
	private String contents;
	
	
	@ManyToOne
	@JoinColumn(name = "Level_id")
	private Level level;
	
	@CreationTimestamp
	private LocalDate created_at;
	@UpdateTimestamp
	private LocalDate updated_at;
	
	public void setLevel(Level level) {
		this.level = level;
		if(!level.getCourses().contains(this)) {
			level.getCourses().add(this);
		}
	}
	public Course() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Level getLevel() {
		return level;
	}
//	public void setLevel(Level level) {
//		this.level = level;
//	}
	public LocalDate getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDate created_at) {
		this.created_at = created_at;
	}
	public LocalDate getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(LocalDate updated_at) {
		this.updated_at = updated_at;
	}
   
}
