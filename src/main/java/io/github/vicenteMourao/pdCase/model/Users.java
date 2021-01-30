package io.github.vicenteMourao.pdCase.model;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Users {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
    
	@Column(nullable=false,length = 15)
	private String username;
	
	@Column(nullable=false,length = 15)
	@NotNull
	private String password;
	
	@Column
	private boolean enabled;
	
	@Column(nullable=false,length = 15)
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDateTime register_date;
	
	@Column(nullable=false,length = 45)
	@NotNull
	private String name;
	
	@Column(nullable=false,length = 45)
	@NotNull
	private String surname;
	
	@Column(nullable=false,length = 45)
	@NotNull
	private String email;
	
	@Column(nullable=false,length = 15)
	@NotNull
	private String phone;
	
	

	
@PrePersist
public void beforeSave() {
	setRegister_date(LocalDateTime.now());
}
	
	

}
