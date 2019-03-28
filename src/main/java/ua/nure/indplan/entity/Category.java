package ua.nure.indplan.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@Table(name="category")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private boolean deleted;
	private String description;
	private Integer perrate;
	private String perunit;
	private String report;
	private Integer timerate;
	private String timeunit;
	private String title;
	private Set<Work> works;
	private CategoryType type;

	public Category() {
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


	@Lob
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Integer getPerrate() {
		return this.perrate;
	}

	public void setPerrate(Integer perrate) {
		this.perrate = perrate;
	}


	@Column(length=64)
	public String getPerunit() {
		return this.perunit;
	}

	public void setPerunit(String perunit) {
		this.perunit = perunit;
	}


	@Column(length=255)
	public String getReport() {
		return this.report;
	}

	public void setReport(String report) {
		this.report = report;
	}


	public Integer getTimerate() {
		return this.timerate;
	}

	public void setTimerate(Integer timerate) {
		this.timerate = timerate;
	}


	@Column(length=64)
	public String getTimeunit() {
		return this.timeunit;
	}

	public void setTimeunit(String timeunit) {
		this.timeunit = timeunit;
	}


	@Column(nullable=false, length=255, unique=true)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	//bi-directional many-to-one association to Work
	@OneToMany(mappedBy="category", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	public Set<Work> getWorks() {
		return this.works;
	}

	public void setWorks(Set<Work> works) {
		this.works = works;
	}

	public Work addWork(Work work) {
		getWorks().add(work);
		work.setCategory(this);

		return work;
	}

	public Work removeWork(Work work) {
		getWorks().remove(work);
		work.setCategory(null);

		return work;
	}


	//bi-directional many-to-one association to CategoryType
	@ManyToOne
	@JoinColumn(name="type_id", nullable=false)
	public CategoryType getType() {
		return this.type;
	}

	public void setType(CategoryType type) {
		this.type = type;
	}
	
	public String rates() {
		if (timerate == null) {
			return "";
		}
		StringBuilder builder = new StringBuilder();
		builder.append(timerate);
		builder.append(" ");
		builder.append(timeunit);
		builder.append(" на ");
		builder.append(perrate);
		builder.append(" ");
		builder.append(perunit);
		return builder.toString();
		
	}
	
	@Transient
	public String getShortTitle(int width) {
		if (width >= title.length()) {
			return title;
		} else {
			String b = title.substring(0, width / 2 - 3);
			String e = title.substring(title.length() - width / 2, title.length());
			return b + "..." + e;
		}
//		return width <= title.length() ? title : title.substring(0, width / 2 - 3) + "..." + title.substring(width / 2, title.length());
	}

//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + deleted;
//		result = prime * result + ((description == null) ? 0 : description.hashCode());
//		result = prime * result + ((perrate == null) ? 0 : perrate.hashCode());
//		result = prime * result + ((perunit == null) ? 0 : perunit.hashCode());
//		result = prime * result + ((report == null) ? 0 : report.hashCode());
//		result = prime * result + ((timerate == null) ? 0 : timerate.hashCode());
//		result = prime * result + ((timeunit == null) ? 0 : timeunit.hashCode());
//		result = prime * result + ((title == null) ? 0 : title.hashCode());
//		return result;
//	}
//
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (!(obj instanceof Category))
//			return false;
//		Category other = (Category) obj;
//		if (deleted != other.deleted)
//			return false;
//		if (description == null) {
//			if (other.description != null)
//				return false;
//		} else if (!description.equals(other.description))
//			return false;
//		if (perrate == null) {
//			if (other.perrate != null)
//				return false;
//		} else if (!perrate.equals(other.perrate))
//			return false;
//		if (perunit == null) {
//			if (other.perunit != null)
//				return false;
//		} else if (!perunit.equals(other.perunit))
//			return false;
//		if (report == null) {
//			if (other.report != null)
//				return false;
//		} else if (!report.equals(other.report))
//			return false;
//		if (timerate == null) {
//			if (other.timerate != null)
//				return false;
//		} else if (!timerate.equals(other.timerate))
//			return false;
//		if (timeunit == null) {
//			if (other.timeunit != null)
//				return false;
//		} else if (!timeunit.equals(other.timeunit))
//			return false;
//		if (title == null) {
//			if (other.title != null)
//				return false;
//		} else if (!title.equals(other.title))
//			return false;
//		return true;
//	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(title);
		builder.append(", ");
		builder.append(timerate);
		builder.append(" ");
		builder.append(timeunit);
		builder.append(" на ");
		builder.append(perrate);
		builder.append(" ");
		builder.append(perunit);
		builder.append(", report=");
		builder.append(report);
		builder.append(", description=");
		builder.append(description);
		return builder.toString();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (deleted ? 1231 : 1237);
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((perrate == null) ? 0 : perrate.hashCode());
		result = prime * result + ((perunit == null) ? 0 : perunit.hashCode());
		result = prime * result + ((report == null) ? 0 : report.hashCode());
		result = prime * result + ((timerate == null) ? 0 : timerate.hashCode());
		result = prime * result + ((timeunit == null) ? 0 : timeunit.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (deleted != other.deleted)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (perrate == null) {
			if (other.perrate != null)
				return false;
		} else if (!perrate.equals(other.perrate))
			return false;
		if (perunit == null) {
			if (other.perunit != null)
				return false;
		} else if (!perunit.equals(other.perunit))
			return false;
		if (report == null) {
			if (other.report != null)
				return false;
		} else if (!report.equals(other.report))
			return false;
		if (timerate == null) {
			if (other.timerate != null)
				return false;
		} else if (!timerate.equals(other.timerate))
			return false;
		if (timeunit == null) {
			if (other.timeunit != null)
				return false;
		} else if (!timeunit.equals(other.timeunit))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}