package ua.nure.indplan.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String description;
	private int perrate;
	private String perunit;
	private String report;
	private int timerate;
	private String timeunit;
	private String title;
	private Category category;
	private List<Category> categories;
	private List<Work> works;

	public Category() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Lob
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public int getPerrate() {
		return this.perrate;
	}

	public void setPerrate(int perrate) {
		this.perrate = perrate;
	}


	public String getPerunit() {
		return this.perunit;
	}

	public void setPerunit(String perunit) {
		this.perunit = perunit;
	}


	public String getReport() {
		return this.report;
	}

	public void setReport(String report) {
		this.report = report;
	}


	public int getTimerate() {
		return this.timerate;
	}

	public void setTimerate(int timerate) {
		this.timerate = timerate;
	}


	public String getTimeunit() {
		return this.timeunit;
	}

	public void setTimeunit(String timeunit) {
		this.timeunit = timeunit;
	}


	@Column(unique=true, nullable=false, length=255)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="parent_id")
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


	//bi-directional many-to-one association to Category
	@OneToMany(mappedBy="category")
	public List<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Category addCategory(Category category) {
		getCategories().add(category);
		category.setCategory(this);

		return category;
	}

	public Category removeCategory(Category category) {
		getCategories().remove(category);
		category.setCategory(null);

		return category;
	}


	//bi-directional many-to-many association to Work
	@ManyToMany
	@JoinTable(
		name="work_has_category"
		, joinColumns={
			@JoinColumn(name="category_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="work_id")
			}
		)
	public List<Work> getWorks() {
		return this.works;
	}

	public void setWorks(List<Work> works) {
		this.works = works;
	}

}