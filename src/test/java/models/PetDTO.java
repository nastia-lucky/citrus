package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode
public class PetDTO {

@JsonProperty("id")
protected Integer id;

@JsonProperty("category")
protected PetCategory category;

@JsonProperty("name")
protected String name;

@JsonProperty("photoUrls")
protected List<String> photoUrls;

@JsonProperty("tags")
protected List<PetTag> tags;

@JsonProperty("status")
protected String status;

public PetDTO(Integer id, PetCategory category, String name, List<String> photoUrls, List<PetTag> tags, String status) {
	this.id = id;
	this.category = category;
	this.name = name;
	this.photoUrls = photoUrls;
	this.tags = tags;
	this.status = status;
}

public PetDTO() {
}
}
