package ua.nure.indplan.entity;

import java.io.Serializable;

public class VMStudent implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String group;
	private String name;

	public VMStudent() {
	}

	public VMStudent(Student stud) {
		this.id = stud.getId();
		this.name = stud.getName();
		this.group = stud.getGroup();
	}
	
	public VMStudent(int id, String name, String group) {
		this.id = id;
		this.name = name;
		this.group = group;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroup() {
		return this.group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		VMStudent other = (VMStudent) obj;
		if (group == null) {
			if (other.group != null)
				return false;
		} else if (!group.equals(other.group))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("VMStudent [id=");
		sb.append(id);
		sb.append(", ");
		if (name != null) {
			sb.append("name=");
			sb.append(name);
		}
		if (group != null) {
			sb.append("group=");
			sb.append(group);
			sb.append(", ");
		}
		sb.append("]");
		return sb.toString();
	}

	public String toJSON() {
		StringBuffer sb = new StringBuffer();
		sb.append("{\"id\":\"");
		sb.append(id);
		sb.append("\"");
		if (name != null) {
			sb.append(",\"name\":\"");
			sb.append(name);
			sb.append("\"");
		}
		if (group != null) {
			sb.append(",\"group\":\"");
			sb.append(group);
			sb.append("\"");
		}
		sb.append("}");
		return sb.toString();
	}
}