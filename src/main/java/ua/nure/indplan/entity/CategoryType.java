package ua.nure.indplan.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the categorytype database table.
 * 
 */
@Entity
@Table(name="categorytype")
@NamedQuery(name="CategoryType.findAll", query="SELECT c FROM CategoryType c")
public class CategoryType implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private boolean deleted;
	private String title;
	private Set<Category> categories;

	public CategoryType() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Column(nullable=false, columnDefinition="tinyint(1) default 0")
	public boolean getDeleted() {
		return this.deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}


	@Column(nullable=false, length=255, unique=true)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	//bi-directional many-to-one association to Category
	@OneToMany(mappedBy="type", fetch=FetchType.EAGER)
	@OrderBy
	public Set<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Category addCategory(Category category) {
		getCategories().add(category);
		category.setType(this);

		return category;
	}

	public Category removeCategory(Category category) {
		getCategories().remove(category);
		category.setType(null);

		return category;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (deleted ? 1231 : 1237);
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CategoryType))
			return false;
		CategoryType other = (CategoryType) obj;
		if (deleted != other.deleted)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return title;
	}

}