package psamolysov.demo.spring.jpaintegration.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MYENTITY")
public class MyEntity implements Serializable {

	private static final long serialVersionUID = -2822741506629760582L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "my-seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "my-seq", sequenceName = "MYENTITY_SEQ",
			allocationSize = 10, initialValue = 100)
	private String id;
	
	@Column(name = "NAME")
	private String name;

	MyEntity() {}
	
	public MyEntity(String name) {
		super();
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
