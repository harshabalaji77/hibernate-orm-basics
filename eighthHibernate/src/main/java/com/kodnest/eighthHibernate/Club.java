package com.kodnest.eighthHibernate;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Club {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name = "club_name")
	String clubName;
	
	@ManyToMany(mappedBy = "clubs")
	Set<Student> students;
	
	public Club() {
		
	}

	public Club(int id, String clubName, Set<Student> students) {
		super();
		this.id = id;
		this.clubName = clubName;
		this.students = students;
	}

	public Club(String clubName, Set<Student> students) {
		super();
		this.clubName = clubName;
		this.students = students;
	}

	public Club(String clubName) {
		super();
		this.clubName = clubName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Club [id=" + id + ", clubName=" + clubName + ", students=" + students + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(clubName, id, students);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Club other = (Club) obj;
		return Objects.equals(clubName, other.clubName) && id == other.id && Objects.equals(students, other.students);
	}
	
}