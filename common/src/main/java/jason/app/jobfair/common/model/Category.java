package jason.app.jobfair.common.model;

import jason.app.jobfair.common.constant.CategoryType;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

public class Category {
    private Long id;
    private String name;
    @JsonIgnore
    private Category parent;
    private CategoryType type;
    private Integer subType;
    private boolean leaf;
    public boolean isLeaf() {
        return leaf;
    }
    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }
    @JsonIgnore
    private List<Category> children;
    public List<Category> getChildren() {
        return children;
    }
    public void setChildren(List<Category> children) {
        this.children = children;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setParent(Category parent) {
        this.parent = parent;
    }
    public void setType(CategoryType type) {
        this.type = type;
    }
    public void setSubType(Integer subType) {
        this.subType = subType;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Category getParent() {
        return parent;
    }
    public CategoryType getType() {
        return type;
    }
    public Integer getSubType() {
        return subType;
    }
}
