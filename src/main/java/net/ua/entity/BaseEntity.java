package net.ua.entity;

import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass()
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = -4156938009387725129L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("%s(id=%d)", this.getClass().getSimpleName(), this.getId());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;

		if (o instanceof BaseEntity) {
			final BaseEntity other = (BaseEntity) o;
			return Objects.equal(getId(), other.getId());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}
}
