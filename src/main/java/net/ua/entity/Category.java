package net.ua.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "CategoryId")
    private int categoryId;

    @Column(name = "Title")
    private String title;

    @Column(name = "Type")
    private int type;

    @ManyToOne
    @JoinColumn(name = "ParentId", nullable = false)
    private Category parentCategory;

    @OneToMany(mappedBy="parentCategory", cascade = CascadeType.ALL)
    private Set<Category> subCategories;

    public Category() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public Set<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(Set<Category> subCategories) {
        this.subCategories = subCategories;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", parentCategory=" + parentCategory +
                ", subCategories=" + subCategories +
                '}';
    }
}
